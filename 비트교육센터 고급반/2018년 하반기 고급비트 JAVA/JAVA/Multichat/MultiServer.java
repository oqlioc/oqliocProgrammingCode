package Multichat;
import java.io.*;
import java.net.*;
import java.util.*;

public class MultiServer {
	private ArrayList<MultiServerThread> list;
	private Socket socket;
	public MultiServer()throws IOException{
		list = new ArrayList<MultiServerThread>();
		//client�� ����� ������ �� �� ȿ�������� �����ϱ� ���ؼ� ���׸��� ���
		ServerSocket serverSocket = new ServerSocket(8907);
		//Ŭ���̾�Ʈ�� ���� ��Ʈ��ȣ�� �ޱ����ؼ� �������� ��ü�� ����
		
		MultiServerThread mst = null;
		//�ʱ�ȭ
		
		boolean isStop = false;
		
		while(!isStop){
			System.out.println("Server ready...");
			socket = serverSocket.accept();
			//���࿡ ���������� ���������ʴٸ� ���������� Ŭ���̾�Ʈ�� ���� ���� ��Ʈ��ȣ�� ���Ͽ��� ������. ���ϰ� Ŭ���̾�Ʈ�� ��������.
			mst = new MultiServerThread(this);//this�� server�� �������ִ� socket
			list.add(mst); //������ ��� �������������ؼ� ����Ʈ�� �������� ��´�
			Thread t = new Thread(mst); //������ ��ü ����			
			t.start(); //run �޼ҵ� ȣ��
		}
	}
	public ArrayList<MultiServerThread>getList(){
		return list;
	}
	public Socket getSocket()
	{
		return socket;
	}
	public static void main(String arg[])throws IOException{
		new MultiServer();
	}
}
