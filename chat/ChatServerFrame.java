import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;

import javax.swing.*;

//////////*������������*///////////////
public class ChatServerFrame extends JFrame implements ActionListener {
	public  JList list;
	/**
	 * 
	 */
	private static final long serialVersionUID = -8936397327038098620L;

	// ��������Ϣ���
	JPanel pnlServer, pnlServerInfo;

	JLabel lblStatus, lblNumber, lblMax, lblServerName, lblProtocol, lblIP,
			lblPort, lblLog;

	public JTextField txtStatus, txtNumber, txtMax, txtServerName, txtProtocol, txtIP,
			txtPort;

	JButton btnStop, btnSaveLog;

	public JTextArea taLog;

	JTabbedPane tpServer;

	public TextArea taMessage;

	// �û���Ϣ���
	JPanel pnlUser;

	public JLabel lblMessage, lblUser, lblNotice, lblUserCount;

	JList lstUser;

	JScrollPane spUser;

	JTextField txtNotice;

	JButton btnSend, btnKick;
	
	public String serverMessage ="";

	public ChatServerFrame() {
		// ����������
		super("���������");
		setSize(700, 650);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		Dimension scr = Toolkit.getDefaultToolkit().getScreenSize();// ����Ļ������ʾ
		Dimension fra = this.getSize();
		if (fra.width > scr.width) {
			fra.width = scr.width;
		}
		if (fra.height > scr.height) {
			fra.height = scr.height;
		}
		this.setLocation((scr.width - fra.width) / 2,
				(scr.height - fra.height) / 2);

		// ==========��������Ϣ���=========================
		pnlServer = new JPanel();
		pnlServer.setLayout(null);
		pnlServer.setBackground(new Color(176, 196, 222));

		pnlServerInfo = new JPanel();
		pnlServerInfo.setBackground(new Color(176, 196, 222));
		pnlServerInfo.setFont(new Font("����", 0, 12));
		pnlServerInfo.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder(""), BorderFactory
						.createEmptyBorder(1, 1, 1, 1)));
		
		lblIP = new JLabel("������IP:");
		lblIP.setForeground(Color.YELLOW);
		lblIP.setFont(new Font("����", 0, 12));
		txtIP = new JTextField(10);
		txtIP.setBackground(Color.decode("#d6f4f2"));
		txtIP.setFont(new Font("����", 0, 12));
		txtIP.setEditable(false);

		lblStatus = new JLabel("");
		//lblStatus.setForeground(Color.YELLOW);
		//lblStatus.setFont(new Font("����", 0, 12));
		txtStatus = new JTextField(0);
		//txtStatus.setBackground(Color.decode("#d6f4f2"));
		//txtStatus.setFont(new Font("����", 0, 12));
		txtStatus.setEditable(false);

		lblNumber = new JLabel("�����");
		lblNumber.setForeground(Color.YELLOW);
		lblNumber.setFont(new Font("����", 0, 12));
		txtNumber = new JTextField("");
		txtNumber.setBackground(Color.decode("#d6f4f2"));
		txtNumber.setFont(new Font("����", 0, 12));
		txtNumber.setEditable(false);
		

		lblMax = new JLabel("�����������:");
		lblMax.setForeground(Color.YELLOW);
		lblMax.setFont(new Font("����", 0, 12));
		txtMax = new JTextField("50 ��", 10);
		txtMax.setBackground(Color.decode("#d6f4f2"));
		txtMax.setFont(new Font("����", 0, 12));
		txtMax.setEditable(false);

		lblServerName = new JLabel("����������:");
		lblServerName.setForeground(Color.YELLOW);
		lblServerName.setFont(new Font("����", 0, 12));
		txtServerName = new JTextField(10);
		txtServerName.setBackground(Color.decode("#d6f4f2"));
		txtServerName.setFont(new Font("����", 0, 12));
		txtServerName.setEditable(false);

		lblProtocol = new JLabel("����Э��:");
		lblProtocol.setForeground(Color.YELLOW);
		lblProtocol.setFont(new Font("����", 0, 12));
		txtProtocol = new JTextField("HTTP", 10);
		txtProtocol.setBackground(Color.decode("#d6f4f2"));
		txtProtocol.setFont(new Font("����", 0, 12));
		txtProtocol.setEditable(false);

		

		lblPort = new JLabel("�������˿�:");
		lblPort.setForeground(Color.YELLOW);
		lblPort.setFont(new Font("����", 0, 12));
		txtPort = new JTextField("8000", 10);
		txtPort.setBackground(Color.decode("#d6f4f2"));
		txtPort.setFont(new Font("����", 0, 12));
		txtPort.setEditable(false);

		btnStop = new JButton("�رշ�����(C)");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				closeServer();
			}
		});
		btnStop.setBackground(Color.ORANGE);
		btnStop.setFont(new Font("����", 0, 12));

		lblLog = new JLabel("[��������־]");
		lblLog.setForeground(Color.YELLOW);
		lblLog.setFont(new Font("����", 0, 12));

		taLog = new JTextArea(20, 50);
		taLog.setFont(new Font("����", 0, 18));
		taLog.setText("������ʦ����־��          ���ߣ����      ѧ�ţ�3117005034     �༶��17�����繤��һ��");
		taLog.setLineWrap(true);
		
		btnSaveLog = new JButton("������־(S)");
		
		btnSaveLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				saveLog();
			}
		});
		btnSaveLog.setBackground(Color.ORANGE);
		btnSaveLog.setFont(new Font("����", 0, 12));
       // pnlServerInfo.add(lblIP);
      //  pnlServerInfo.add(txtIP);
     //   pnlServerInfo.add(lblPort);
	//	  pnlServerInfo.add(txtPort);
	//	pnlServerInfo.add(lblStatus);
	//	pnlServerInfo.add(txtStatus);
	//	pnlServerInfo.add(lblNumber);
	//	pnlServerInfo.add(txtNumber);
	//	pnlServerInfo.add(lblMax);
	//	pnlServerInfo.add(txtMax);
	//	pnlServerInfo.add(lblServerName);
	//	pnlServerInfo.add(txtServerName);
	//	pnlServerInfo.add(lblProtocol);
	//	pnlServerInfo.add(txtProtocol);	
		

		pnlServerInfo.setBounds(0, 0, 100, 500);
		lblLog.setBounds(110, 5, 100, 30);
		taLog.setBounds(10,10,660, 500);
		btnStop.setBounds(200, 410, 120, 30);
		btnSaveLog.setBounds(550, 530, 120, 50);
	//	pnlServer.add(pnlServerInfo);
	//	pnlServer.add(lblLog);
		pnlServer.add(taLog);
		//pnlServer.add(btnStop);
		//pnlServer.add(btnSaveLog);
		// ===========�����û����====================
		pnlUser = new JPanel();
		pnlUser.setLayout(null);
		pnlUser.setBackground(new Color(176, 196 ,222));
		pnlUser.setFont(new Font("����", 0, 12));
		lblMessage = new JLabel("[�û���Ϣ]");
		lblMessage.setFont(new Font("����", 0, 16));
		lblMessage.setForeground(Color.YELLOW);
		taMessage = new TextArea(20, 20);
		taMessage.setFont(new Font("����", 0, 16));
		lblNotice = new JLabel("֪ͨ��");
		lblNotice.setFont(new Font("����", 0, 16));
		txtNotice = new JTextField(20);
		txtNotice.setFont(new Font("����", 0, 16));
		btnSend = new JButton("����");
		btnSend.setBackground(Color.ORANGE);
		btnSend.setFont(new Font("����", 0, 16));
		btnSend.setEnabled(true);
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				serverMessage();
			}
		});

		

		lblUser = new JLabel("[�����û��б�]");
		lblUser.setFont(new Font("����", 0, 16));
		lblUser.setForeground(Color.YELLOW);

		lstUser = new JList();
		lstUser.setFont(new Font("����", 0, 16));
		lstUser.setVisibleRowCount(17);
		lstUser.setFixedCellWidth(180);
		lstUser.setFixedCellHeight(18);

		spUser = new JScrollPane();
		spUser.setBackground(Color.decode("#d6f4f2"));
		spUser.setFont(new Font("����", 0, 16));
		spUser.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		spUser.getViewport().setView(lstUser);

		lblMessage.setBounds(5, 5, 100, 25);
		taMessage.setBounds(5, 35, 400, 460);
		
		lblUser.setBounds(310, 5, 300, 25);
		spUser.setBounds(410, 35, 320, 460);
		
		lblNotice.setBounds(10, 530, 120, 50);
		txtNotice.setBounds(50, 530, 320,50);
		btnSend.setBounds(410, 530, 120, 50);
		
        
		pnlUser.add(lblMessage);
		pnlUser.add(taMessage);
		pnlUser.add(lblUser);
		pnlUser.add(spUser);

		list = new JList();
		list.setListData(new String[] { "" });
		spUser.setViewportView(list);
		pnlUser.add(lblNotice);
		pnlUser.add(txtNotice);
		pnlUser.add(btnSend);
		
		pnlUser.add(btnSaveLog);

		// ============����ǩ���========================

		tpServer = new JTabbedPane(JTabbedPane.TOP);
		tpServer.setBackground(Color.decode("#d6f4f2"));
		tpServer.setFont(new Font("����", 0, 12));
		tpServer.add("����", pnlServer);
		tpServer.add("�û�����", pnlUser);
		this.getContentPane().add(tpServer);
		setVisible(true);
	}

	protected void serverMessage() {
		this.serverMessage = txtNotice.getText();
		txtNotice.setText("");
	}

	protected void closeServer() {
		this.dispose();
	}

	protected void saveLog() {
		try {
			FileOutputStream fileoutput = new FileOutputStream("log.txt",
					true);
			String temp = taMessage.getText();
			fileoutput.write(temp.getBytes());
			fileoutput.close();
			JOptionPane.showMessageDialog(null, "��־��¼������loged.txt");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void log(String string) {
		String newta = taMessage.getText();
		newta += ("\n"+string);
		taMessage.setText(newta);
	}

	public void actionPerformed(ActionEvent evt) {

	}

	public static void main(String args[]) {
		new ChatServerFrame();
	}
}