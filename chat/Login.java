import javax.swing.*;



import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;


/**
 * ����ϵͳ��¼����
 */
public class Login extends JFrame implements ActionListener {

	private static final long serialVersionUID = -8965773902056088264L;

	private JPanel pnlLogin;

	private JButton btnLogin, btnRegister, btnExit;

	private JLabel lblServer, lblUserName, lblPassword, lblLogo;

	private JTextField txtUserName, txtServer;

	private JPasswordField pwdPassword;

	private String strServerIp;

	// ���ڽ����ڶ�λ
	private Dimension scrnsize;

	private Toolkit toolkit = Toolkit.getDefaultToolkit();

	
	/**
	 * �����½����
	 */
	public Login() {
		super("��¼������");
		pnlLogin = new JPanel();
		this.getContentPane().add(pnlLogin);

		lblServer = new JLabel("������:");
		lblUserName = new JLabel("�û���:");
		lblPassword = new JLabel("��  ��:");
		txtServer = new JTextField(20);
		txtServer.setText("127.0.0.1");
		txtUserName = new JTextField(20);
		pwdPassword = new JPasswordField(20);
		btnLogin = new JButton("��¼");
		btnLogin.setToolTipText("��¼��������");
		btnLogin.setMnemonic('L');
		btnRegister = new JButton("ע��");
		btnRegister.setToolTipText("ע�����û�");
		btnRegister.setMnemonic('R');
		btnExit = new JButton("�˳�");
		btnExit.setToolTipText("�˳�ϵͳ");
		btnExit.setMnemonic('X');
		/***********************************************************************
		 * �ò��ֲ����ֶ����� setBounds�������λ�� * setFont�������塢���͡��ֺ� * setForeground�������ֵ���ɫ *
		 * setBackground���ñ���ɫ * setOpaque����������Ϊ͸��
		 */
		pnlLogin.setLayout(null); // ������ֶ�����
		pnlLogin.setBackground(new Color(52, 130, 203));

		lblServer.setBounds(50, 100, 100, 30);
		txtServer.setBounds(150, 100, 120, 25);
		lblUserName.setBounds(50, 130, 100, 30);
		txtUserName.setBounds(150, 130, 120, 25);
		lblPassword.setBounds(50, 160, 100, 30);
		pwdPassword.setBounds(150, 160, 120, 25);
		btnLogin.setBounds(50, 200, 80, 25);
		btnRegister.setBounds(130, 200, 80, 25);
		btnExit.setBounds(210, 200, 80, 25);

		Font fontstr = new Font("����", Font.PLAIN, 12);
		lblServer.setFont(fontstr);
		txtServer.setFont(fontstr);
		lblUserName.setFont(fontstr);
		txtUserName.setFont(fontstr);
		lblPassword.setFont(fontstr);
		pwdPassword.setFont(fontstr);
		btnLogin.setFont(fontstr);
		btnRegister.setFont(fontstr);
		btnExit.setFont(fontstr);

		lblUserName.setForeground(Color.BLACK);
		lblPassword.setForeground(Color.BLACK);
		btnLogin.setBackground(Color.ORANGE);
		btnRegister.setBackground(Color.ORANGE);
		btnExit.setBackground(Color.ORANGE);

		pnlLogin.add(lblServer);
		pnlLogin.add(txtServer);
		pnlLogin.add(lblUserName);
		pnlLogin.add(txtUserName);
		pnlLogin.add(lblPassword);
		pnlLogin.add(pwdPassword);
		pnlLogin.add(btnLogin);
		pnlLogin.add(btnRegister);
		pnlLogin.add(btnExit);

		// ���ñ���ͼƬ
		Icon logo1 = new ImageIcon("images\\loginlogo.jpg");
		lblLogo = new JLabel(logo1);
		lblLogo.setBounds(0, 0, 340, 66);
		pnlLogin.add(lblLogo);
		// ���õ�¼����
		setResizable(false);
		setSize(340, 260);
		setVisible(true);
		scrnsize = toolkit.getScreenSize();
		setLocation(scrnsize.width / 2 - this.getWidth() / 2, scrnsize.height
				/ 2 - this.getHeight() / 2);
		Image img = toolkit.getImage("images\\appico.jpg");
		setIconImage(img);

		// ������ťע�����
		btnLogin.addActionListener(this);
		btnRegister.addActionListener(this);
		btnExit.addActionListener(this);

	} // ���췽������

	/**
	 * ��ť������Ӧ
	 */
	@SuppressWarnings({ "deprecation", "static-access" })
	public void actionPerformed(ActionEvent ae) {
		Object source = ae.getSource();
		if (source.equals(btnLogin)) {
			// �ж��û����������Ƿ�Ϊ��
			if (txtUserName.getText().equals("")
					|| pwdPassword.getText().equals("")) {
				JOptionPane op1 = new JOptionPane();
				op1.showMessageDialog(null, "�û��������벻��Ϊ��");
			} else {
				strServerIp = txtServer.getText();
				login();
			}
		}
		if (source.equals(btnRegister)) {
			strServerIp = txtServer.getText();
			this.dispose();
			new Register(strServerIp);
		}
		if (source == btnExit) {
			System.exit(0);
		}
	} // actionPerformed()����

	/** 
	 * ��¼�¼���Ӧ����
	 */
	@SuppressWarnings("deprecation")
	public void login() {
		// ���ܿͻ�����ϸ����
		Customer data = new Customer();
		data.custName = txtUserName.getText();
		data.custPassword = pwdPassword.getText();
		try {
			// ���ӵ�������
			Socket toServer;
			toServer = new Socket(strServerIp, 1001);
			ObjectOutputStream streamToServer = new ObjectOutputStream(toServer
					.getOutputStream());
			// д�ͻ���ϸ���ϵ�������socket
			streamToServer.writeObject((Customer) data);
			// �����Է�����socket�ĵ�¼״̬
			BufferedReader fromServer = new BufferedReader(
					new InputStreamReader(toServer.getInputStream()));
			String status = fromServer.readLine();
			if (status.equals("��¼�ɹ�")) {
				new ChatRoom((String) data.custName, strServerIp);
				this.dispose();
				// �ر�������
				streamToServer.close();
				fromServer.close();
				toServer.close();
			} else {
				JOptionPane.showMessageDialog(null, status);
				// �ر�������
				streamToServer.close();
				fromServer.close();
				toServer.close();
			}
		} catch (ConnectException e1) {
			JOptionPane.showMessageDialog(null, "δ�ܽ�����ָ��������������!");
		} catch (InvalidClassException e2) {
			JOptionPane.showMessageDialog(null, "�����!");
		} catch (NotSerializableException e3) {
			JOptionPane.showMessageDialog(null, "����δ���л�!");
		} catch (IOException e4) {
			JOptionPane.showMessageDialog(null, "����д�뵽ָ��������!");
		}
	} // login()����

	/**
	 * ������½����
	 * @param args
	 */
	public static void main(String args[]) {
		new Login();
	}

} // Class Login����
