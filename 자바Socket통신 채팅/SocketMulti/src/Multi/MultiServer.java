package Multi;

import java.io.*;
import java.net.*;
import java.util.*;

public class MultiServer {
	private ArrayList<MultiServerThread> list;
	private Socket socket;
	public MultiServer()throws IOException{
		list = new ArrayList<MultiServerThread>();
		ServerSocket serverSocket = new ServerSocket(5000);
		MultiServerThread mst = null;
		boolean isStop = false;
		
		while(!isStop){
			System.out.println("Server ready...");
			socket = serverSocket.accept();  // �������ϰ� Ŭ���̾�Ʈ������ ������ ���
			mst = new MultiServerThread(this);
			list.add(mst);  // ����ɶ����� MultiServerThread�� ArrayList�� �߰�
			Thread t = new Thread(mst);  // �����忡 MultiServerThread ����
			t.start();
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
