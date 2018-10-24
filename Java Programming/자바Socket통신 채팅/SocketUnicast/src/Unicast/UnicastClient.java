package Unicast;

import java.io.*;
import java.net.*;

public class UnicastClient {
	private String ip;
	private int port;
	private String message;
	private BufferedReader file = null;
	private BufferedWriter bufferW = null;  // Ŭ���̾�Ʈ ����ڰ� ������ �����ִ� ä�ó����� �Է� �޴� ����
	private BufferedReader bufferR = null;  // �������� Ŭ���̾�Ʈ ����ڿ��� ���� ä�ó����� ��� ����

	public UnicastClient(String ip, int port) throws IOException {
		this.ip = ip;  // ������ IP
		this.port = port;  // ������ ���� ��Ʈ��ȣ
		boolean isStop = false;
		Socket tcpSocket = getSocket();  // ������ �����ϰ� ������ ���� �־��ش�
		OutputStream os = tcpSocket.getOutputStream();  // ���Ͽ� ��½�Ʈ���� ����
		InputStream is = tcpSocket.getInputStream();  // ���Ͽ� �Է½�Ʈ���� ����
		bufferW = new BufferedWriter(new OutputStreamWriter(os));  // ������ ��½�Ʈ���� ���� bufferW�� �־��ش�
		bufferR = new BufferedReader(new InputStreamReader(is));  // ������ �Է½�Ʈ���� ���� bufferR�� �־��ش�
		while (!isStop) {
			System.out.print("message : ");
			file = new BufferedReader(new InputStreamReader(System.in));
			// System.in�� Ű������ �� �ƽ�Ű�ڵ带 InputStreamReader�� ���ڷ� ��ȯ�Ѱ��� BufferedReader�̰��� file���ۿ� �־��ش�
			message = file.readLine();  // file ������ ���� message�� ���پ� �־��ش�
			message += System.getProperty("line.separator");  // message�� �ٹٲ��� �־��ش�
			bufferW.write(message);  // line.separator�� �������� message�� ���� �־��ش�
			bufferW.flush();  // bufferW�� ���ۿ� ���� ������ �����ְ� ������ ���� ����ش�

			message = bufferR.readLine();  // �������� ���� ä�ó����� message�� �־��ش�
			if (message.equals("exit")) {  // message�� ���� ��
				isStop = true;
				System.out.println("����Ǿ����ϴ�.");
			} else {
				System.out.println("Received message : " + message);
			}

		}
		tcpSocket.close();  // ������ �ݴ´�
		bufferW.close();  // bufferW�� �ݴ´�
		bufferR.close();  // bufferR�� �ݴ´�
		file.close();  // file�� �ݴ´�
	}

	public Socket getSocket() {
		Socket tcpSocket = null; //���� �������� null
		try {
			tcpSocket = new Socket(ip, port);  // ���Ͽ� IP�� port�� �־��ش�
		} catch (IOException ioe) {
			ioe.printStackTrace();
			System.exit(0);
		}
		return tcpSocket;
	}

	public static void main(String[] args) throws IOException {
		new UnicastClient("localhost", 3000);  // ������ IP�� ��Ʈ��
	}
}