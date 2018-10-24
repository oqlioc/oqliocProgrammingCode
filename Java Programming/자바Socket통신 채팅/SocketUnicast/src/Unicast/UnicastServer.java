package Unicast;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class UnicastServer {
	private ServerSocket serverS;  // Ŭ���̾�Ʈ���Ͽ��� ����Ǵ� ��������

	public UnicastServer(int port) {  // UnicastServer�� �޼ҵ�
		try {
			serverS = new ServerSocket(port);  // ���������� ��Ʈ��ȣ ����
		} catch (IOException ioe) {
			ioe.printStackTrace();
			System.exit(0);
		}
		UnicastServerThread ust = null;  // ���Ͻ����� �ϳ� ����
		while (true) {  // ���ѷ���
			System.out.println("Ŭ���̾�Ʈ �����");
			Socket s = null;
			try {
				s = serverS.accept();  // �������ϰ� Ŭ���̾�Ʈ������ ������ ���
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
			System.out.println("client ip :" + s.getInetAddress().getHostAddress());  // Socket s�� IP�ּ� ���

			ust = new UnicastServerThread(s);
			Thread t = new Thread(ust);  // Ŭ���̾�Ʈ���� ���� ������ �����忡 �־���
			t.start();  // �����带 ����
		}
	}

	public static void main(String[] args) {
		new UnicastServer(3000);  // ������ ��Ʈ��ȣ�� 3000
	}

}