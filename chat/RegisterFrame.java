import javax.swing.*;



import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;

/*<p>Title:HappyChat聊天系统用户注册程序</p>  只负责注册并与服务器确认是否注册成功无储存功能	
 *@version 1.0
 */

public class RegisterFrame extends JFrame  implements ActionListener
{
	private JComboBox comboBox;
	private static final long serialVersionUID = 9019746127517522180L;
	JPanel  pnlRegister;
	JLabel  lblUserName,lblGender,lblAge;
	JLabel  lblPassword,lblConfirmPass,lblEmail,logoPosition;
	JTextField  txtUserName,txtAge,txtEmail;
	JPasswordField  pwdUserPassword,pwdConfirmPass;
	JRadioButton  rbtnMale,rbtnFemale;
	ButtonGroup  btngGender;
    JButton  btnOk,btnCancel,btnClear;
	String  strServerIp;
	final JLabel headLabel = new JLabel();
    //用于将窗口用于定位
	Dimension scrnsize;
    Toolkit toolkit=Toolkit.getDefaultToolkit();
    //构造方法
	public RegisterFrame(String ip)
	{
		super("聊天APP注册");
		strServerIp=ip;
		pnlRegister=new JPanel();
		pnlRegister.setSize(800, 800);
		this.getContentPane().add(pnlRegister);
		lblUserName=new JLabel("用 户 名:");
		lblGender=new JLabel("性    别:");
		lblAge=new JLabel("年    龄:");
		lblPassword=new JLabel("口    令:");
		lblConfirmPass=new JLabel("确认口令:");
		lblEmail=new JLabel("电子邮件:");
		txtUserName=new JTextField(30);
		txtEmail=new JTextField(30);
		txtAge=new JTextField(10);
		pwdUserPassword=new JPasswordField(30);
		pwdConfirmPass=new JPasswordField(30);
		rbtnMale=new JRadioButton("男",true);
		rbtnFemale=new JRadioButton("女");
	    btngGender=new ButtonGroup();
	    btnOk=new JButton("立即注册(O)");
	    btnOk.setMnemonic('O');
	    btnOk.setToolTipText("保存注册信息");
		btnCancel=new JButton("返回");
		btnCancel.setMnemonic('B');
		btnCancel.setToolTipText("返回登录窗口");
		btnClear=new JButton("清空");
		btnClear.setMnemonic('L');
		btnClear.setToolTipText("清空注册信息");
		
		/*  该布局采用手动布局           *
		 *　setBounds设置组件位置        *
		 *  setFont设置字体、字型、字号  *
		 *　setForeground设置文字的颜色  *
		 *  setBackground设置背景色      *
		 *  setOpaque将背景设置为透明    */
		pnlRegister.setLayout(null);    //组件用手动布局
		pnlRegister.setBackground(new Color(176,196,222));

		lblUserName.setBounds(50,200,200,60);
		txtUserName.setBounds(130,205,240,40);
		lblPassword.setBounds(50,270,200,60);
		pwdUserPassword.setBounds(130,275,240,40);
		lblConfirmPass.setBounds(50,366,200,60);
		pwdConfirmPass.setBounds(130,371,240,40);
		
		lblGender.setBounds(50,421,200,60);
		rbtnMale.setBounds(130,426,120,40);
		rbtnFemale.setBounds(190,426,120,40);
		lblAge.setBounds(50,496,200,60);
		txtAge.setBounds(130,501,240,40);
		lblEmail.setBounds(50,571,200,60);
		txtEmail.setBounds(130,576,240,40);

	    btnOk.setBounds(30,700,160,50);	
	    btnCancel.setBounds(200,700,100,50);
	    btnClear.setBounds(350,700,100,50);
	
		Font fontstr=new Font("宋体",Font.PLAIN,18);	
		lblUserName.setFont(fontstr);
	    lblGender.setFont(fontstr);
		lblPassword.setFont(fontstr);
		lblConfirmPass.setFont(fontstr);
		lblAge.setFont(fontstr);
		lblEmail.setFont(fontstr);
        rbtnMale.setFont(fontstr);
		rbtnFemale.setFont(fontstr);
		txtUserName.setFont(fontstr);
		txtEmail.setFont(fontstr);	
		btnOk.setFont(fontstr);
		btnCancel.setFont(fontstr);
		btnClear.setFont(fontstr);
						
		lblUserName.setForeground(Color.BLACK);
		lblGender.setForeground(Color.BLACK);
		lblPassword.setForeground(Color.BLACK);
		lblAge.setForeground(Color.BLACK);
		lblConfirmPass .setForeground(Color.BLACK);
		lblEmail.setForeground(Color.BLACK);
		rbtnMale.setForeground(Color.BLACK);
		rbtnFemale.setForeground(Color.BLACK);
		rbtnMale.setBackground(Color.white);
		rbtnFemale.setBackground(Color.white);
		btnOk.setBackground(Color.ORANGE);	
	    btnCancel.setBackground(Color.ORANGE);
	    btnClear.setBackground(Color.ORANGE);
		rbtnMale.setOpaque(false);   
		rbtnFemale.setOpaque(false);
		
		pnlRegister.add(lblUserName);
		pnlRegister.add(lblGender);
		pnlRegister.add(lblPassword);
		pnlRegister.add(lblConfirmPass);
		pnlRegister.add(lblEmail);
		pnlRegister.add(lblAge);
		pnlRegister.add(txtAge);
		pnlRegister.add(txtUserName);
		pnlRegister.add(txtEmail);
		pnlRegister.add(pwdUserPassword);
		pnlRegister.add(pwdConfirmPass);
		pnlRegister.add(btnOk);
		pnlRegister.add(btnCancel);
		pnlRegister.add(btnClear);
		pnlRegister.add(rbtnMale);
		pnlRegister.add(rbtnFemale);
		btngGender.add(rbtnMale);
	    btngGender.add(rbtnFemale);
	    
	    //设置背景图片
	    Icon logo = new ImageIcon("images\\loginlogo.png");
	 	logoPosition = new JLabel(logo);
		logoPosition.setBounds(455, 0, 327,760);
		pnlRegister.add(logoPosition);
	    
	    this.setSize(800,800);
		this.setVisible(true);
		
		//将窗口定位在屏幕中央
    	scrnsize=toolkit.getScreenSize();
    	this.setLocation(scrnsize.width/2-this.getWidth()/2,
    	                 scrnsize.height/2-this.getHeight()/2);
	//	Image img=toolkit.getImage("images\\appico.jpg");
   //     this.setIconImage(img);
		//三个按钮注册监听
		btnOk    .addActionListener(this);
		btnCancel.addActionListener(this);
		btnClear   .addActionListener(this);

		final JLabel label = new JLabel();
		label.setText("头    像:");
		label.setFont(fontstr);
		label.setBounds(30,100, 240, 60);
		pnlRegister.add(label);
         this.repaint();
		comboBox = new JComboBox();
		comboBox.setAutoscrolls(true);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3","4","5"}));
		comboBox.setBounds(150, 100, 90, 40);
		comboBox.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent arg0) {
				Icon logo = new ImageIcon("face\\"+comboBox.getSelectedItem().toString()+".jpg");
				headLabel.setIcon(logo);
			}
		});
		
		
		pnlRegister.add(comboBox);
		

		
		headLabel.setHorizontalAlignment(SwingConstants.CENTER);
		headLabel.setIcon(new ImageIcon("face//5.JPG"));
		headLabel.setBounds(270, 30, 150, 150);
		pnlRegister.add(headLabel);
		
		int i=19;
		while(i-->0)this.repaint();
		
		
		
	}  //构造方法结束
	
	//按钮监听响应
	public void actionPerformed(ActionEvent ae)
	{
		Object source=new Object();
	    source=ae.getSource();
	    if (source.equals(btnOk))      //"确定"按钮
	    {
	        register();
	    }
	    if (source.equals(btnCancel))  //"返回"按钮
	    {
	    	new Login();
	    	this.dispose();
	    }
	    if (source.equals(btnClear))     //"清空"按钮
	    {
	        txtUserName.setText("");
	        pwdUserPassword.setText("");
	        pwdConfirmPass.setText("");
	        txtAge.setText("");
	        txtEmail.setText("");	
	    }
	}  //actionPerformed()结束
	
	//////////"确定"按钮事件响应//////////
	@SuppressWarnings({ "deprecation", "static-access" })
	public void register()
	{
		//接受客户的详细资料
		Register_Customer data=new Register_Customer();
	    data.custName     = txtUserName.getText();
		data.custPassword = pwdUserPassword.getText();
		data.age          = txtAge.getText();
		data.sex          = rbtnMale.isSelected()?"男":"女";
		data.email        = txtEmail.getText();
		//chenmin
		data.head		  = comboBox.getSelectedItem().toString();
		//验证用户名是否为空
		if(data.custName.length()==0)
		{
		    JOptionPane.showMessageDialog(null,"用户名不能为空");	
            return;	
		}
		//验证密码是否为空
		if(data.custPassword.length()==0)
		{
		    JOptionPane.showMessageDialog(null,"密码不能为空");	
            return;	
		}
		
		//验证密码的一致性
		if(!data.custPassword.equals(pwdConfirmPass.getText()))
		{
		    JOptionPane.showMessageDialog(null,"密码两次输入不一致，请重新输入");	
            return;
		}
		
		//验证年龄是否为空
		if(data.age.length()==0)
		{
		    JOptionPane.showMessageDialog(null,"年龄不能为空");	
            return;	
		}
		//验证年龄的合法性
		int age=Integer.parseInt(txtAge.getText());
		if (age<=0||age>100){
			JOptionPane.showMessageDialog(null,"年龄输入不合法");
			return;
		}
		//验证Email的正确性
		int Found_flag=0;    //判断标志
		for (int i=0;i<data.email.length();i++)
		{
		    if(data.email.charAt(i)=='@')
		    {
		        Found_flag++;	
		    }	
		}
		if(Found_flag!=1)
		{
		    JOptionPane.showMessageDialog(null,"电子邮箱格式不正确，请重新输入");	
            return;	
		}
		
		try
		{
		    //连接到服务器
		    Socket toServer;
  		    toServer = new Socket(strServerIp,1001);
		    ObjectOutputStream streamToServer=new ObjectOutputStream (toServer.getOutputStream());					
		    //写客户详细资料到服务器socket
		    streamToServer.writeObject((Register_Customer)data);
            //读来自服务器socket的登陆状态
            BufferedReader fromServer=new BufferedReader(new InputStreamReader(toServer.getInputStream()));
            String status=fromServer.readLine();
            //显示成功消息
            JOptionPane op=new JOptionPane();
            op.showMessageDialog(null,status);
            if(status.equals(data.custName+"注册成功"))
            {
                txtUserName.setText("");
                pwdUserPassword.setText("");
                pwdConfirmPass.setText("");
                txtAge.setText("");
                txtEmail.setText("");
            }
            
            //关闭流对象
		    streamToServer.close();
            fromServer.close();
         }
		 catch(InvalidClassException e1)
		 {
		    JOptionPane.showMessageDialog(null,"类错误!");
		 }
		 catch(NotSerializableException e2)
		 {
			JOptionPane.showMessageDialog(null,"对象未序列化!");
		 }
		 catch(IOException e3)
		 {
		 	JOptionPane.showMessageDialog(null,"不能写入到指定服务器!");
		 }
		
	}  //方法register()结束
	public static void main(String args[])
	{
		new RegisterFrame("127.0.0.1");
	}

}  //class Register 结束
