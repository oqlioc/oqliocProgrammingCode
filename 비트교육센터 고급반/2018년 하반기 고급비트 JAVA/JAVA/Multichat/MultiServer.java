package Multichat;
import java.io.*;
import java.net.*;
import java.util.*;

public class MultiServer {
	private ArrayList<MultiServerThread> list;
	private Socket socket;
	public MultiServer()throws IOException{
		list = new ArrayList<MultiServerThread>();
		//client와 연결된 서버를 좀 더 효율적으로 관리하기 위해서 제네릭을 썼다
		ServerSocket serverSocket = new ServerSocket(8907);
		//클라이언트가 보낸 포트번호를 받기위해서 서버소켓 객체를 생성
		
		MultiServerThread mst = null;
		//초기화
		
		boolean isStop = false;
		
		while(!isStop){
			System.out.println("Server ready...");
			socket = serverSocket.accept();
			//만약에 서버소켓이 닫혀있지않다면 서버소켓이 클라이언트로 부터 받은 포트번호를 소켓에게 보낸다. 소켓과 클라이언트를 연결해줌.
			mst = new MultiServerThread(this);//this는 server가 가지고있는 socket
			list.add(mst); //소켓을 계속 생성생성생성해서 리스트에 차곡차곡 담는다
			Thread t = new Thread(mst); //쓰레드 객체 생성			
			t.start(); //run 메소드 호출
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
