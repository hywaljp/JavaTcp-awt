import java.io.Serializable;
import java.util.Vector;

public class Message implements Serializable {

	private static final long serialVersionUID = -3831507106408529855L;

	/**
	 * �û����߶���
	 */
	public Vector userOnLine;

	/**
	 * ������Ϣ��
	 */

	public Vector chat;

	/**
	 * ����
	 */

	public String serverMessage;

}