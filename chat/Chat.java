import java.io.Serializable;

public class Chat implements Serializable
{

	private static final long serialVersionUID = 4058485121419391969L;
	/**
	 * �������û���
	 */
	public String chatUser;
	/**
	 * ��������
	 */
	public String chatMessage;
	/**
	 * ���ܶ����û���
	 */
	public String chatToUser;
	/**
	 * �Ƿ�˽��
	 */
	public boolean whisper;
}