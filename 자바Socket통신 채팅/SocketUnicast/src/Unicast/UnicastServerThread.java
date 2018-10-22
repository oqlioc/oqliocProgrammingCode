package Unicast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class UnicastServerThread implements Runnable {  // Runnable �������̽��� ���������
	private Socket socket;  // ���� ����
	private BufferedReader bufferR;  // Ŭ���̾�Ʈ ����ڰ� ������ �����ִ� ä�ó����� �Է� �޴� ����
	private BufferedWriter bufferW;  // �������� Ŭ���̾�Ʈ ����ڿ��� ���� ä�ó����� ��� ����
	private InputStream is;  // ������ ����ϴ� �Է� ��Ʈ��
	private OutputStream os;  // ������ ����ϴ� ��� ��Ʈ��
	private String message;  // ä�� ���� ��°�

	public UnicastServerThread(Socket socket) {  // UnicastServerThread ������
		this.socket = socket;
	}

	public void run() {
		boolean isStop = false;
		try {
			is = socket.getInputStream();  // ���Ͽ� �Է½�Ʈ�� ����
			bufferR = new BufferedReader(new InputStreamReader(is));  // ������ �Է½�Ʈ�� ���� bufferR�� ����
			os = socket.getOutputStream();  // ���Ͽ� ��½�Ʈ�� ����
			bufferW = new BufferedWriter(new OutputStreamWriter(os));  // ������ ��½�Ʈ�� ���� bufferW�� ����
		} catch (IOException ioe) {
			isStop = true;
		}
		try {
			while (!isStop) {
				String message = bufferR.readLine();  // Ŭ���̾�Ʈ ����ڰ� �����ִ� ������ String message�� �ִ´�
				if (message.equals("exit")) isStop = true;  // Ŭ���̾�Ʈ ����ڰ� �����ִ³����� exit�� �����Ѵ�
				System.out.println("received message : " + message);  // Ŭ���̾�Ʈ ����ڰ� �����ִ� ���� ���
				message += System.getProperty("line.separator");  // write�� ������ ǥ��
				bufferW.write(message);
				bufferW.flush();  // flush()�� ���� ���ۿ� ����Ǿ� �ִ� ������ Ŭ���̾�Ʈ�� �����ϰ� ���۸� ����
			}
		} catch (IOException ioe) {
			System.out.println("Ŭ���̾�Ʈ�� ������" + "����Ǿ����ϴ�.");
			isStop = true;
		} finally {
			try {
				if (bufferR != null)  // if (message.equals("exit"))���⼭ �ɷ���  bufferW.flush();�̰��� ����ȵ� �׷��� �ȿ� "exit"���� �����ִ�
					bufferR.close();  // bufferR�� �ݴ´�
				if (bufferW != null)  // flush()�� ����ȵ� �׷��⿡ �ȿ� ������ ���� 1
					bufferW.close();  // bufferW�� �ݴ´� 1
				if (socket != null)  // ���Ͽ� ��Ʈ���� �ִ�
					socket.close();  // ������ ����� �ݴ´�
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}

	}

}