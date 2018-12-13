import java.io.*;
import java.net.*;
import java.util.*;

/**
 * ����ϵͳ����������
 */
public class ChatServer extends Thread
{
	private ServerSocket serverSocket;

	private ChatServerFrame sFrame;

	private static Vector userOnline = new Vector(1, 1);
	
	private static Vector v = new Vector(1, 1);

	/**
	 * ���������� �����������1001�˿�
	 */
	public ChatServer()
	{
		sFrame = new ChatServerFrame();
		try
		{
			serverSocket = new ServerSocket(1001);
			InetAddress address = InetAddress.getLocalHost();
			sFrame.txtServerName.setText(address.getHostName());
			sFrame.txtIP.setText(address.getHostAddress());
			sFrame.txtPort.setText("1001");
		} catch (IOException e)
		{
			fail(e, "������������");
		}
		sFrame.txtStatus.setText("");
		sFrame.txtNumber.setText("TCP");
		this.start(); // �����߳�
	}

	/**
	 * �˳�������
	 * 
	 * @param e
	 *                �쳣
	 * @param str
	 *                �˳���Ϣ
	 */
	public static void fail(Exception e, String str)
	{
		System.out.println(str + " ��" + e);
	}

	/**
	 * �����ͻ������󣬵����û�����ʱ���� Connection�߳�
	 */
	public void run()
	{
		try
		{
			while (true)
			{
				Socket client = serverSocket.accept();
				new Connection(sFrame, client, userOnline, v); // ֧�ֶ��߳�
			}
		} catch (IOException e)
		{
			fail(e, "���ܼ�����");
		}
	}

	/** 
	 * ����������
	 */
	public static void main(String args[])
	{
		new ChatServer();
	}
}
