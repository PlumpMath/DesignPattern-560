package designpatterns.chainofresponsibility;

/**
 * @author idiot
 * @version 1.0
 * @date 2015��12��7�� ����12:01:38
 */
public abstract class Chain {
	public static int One = 1;
	public static int Two = 2;
	public static int Three = 3;
	protected int Threshold;

	protected Chain next;

	public void setNext(Chain chain) {
		next = chain;
	}

	public void message(String msg, int priority) {
		// if the priority is less than Threshold it is handled
		if (priority <= Threshold) {
			writeMessage(msg);
		}

		if (next != null) {
			next.message(msg, priority);
		}
	}

	abstract protected void writeMessage(String msg);
}