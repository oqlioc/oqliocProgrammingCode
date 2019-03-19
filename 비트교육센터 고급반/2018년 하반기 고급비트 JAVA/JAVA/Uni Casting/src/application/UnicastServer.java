package application;

import java.net.ServerSocket;
import java.net.Socket;

public class UnicastServer {

	private ServerSocket serverS;
	
	public UnicastServer(int port)
	{
		try
		{
			serverS = new ServerSocket(port);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.exit(0);
		}
		UniCastServerThread ust = null;
		while(true)
		{
			System.out.println("클라이언트 대기중");
			Socket s = null;
			try
			{
				s = serverS.accept();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			System.out.println("Client ip : " + s.getInetAddress().getHostAddress());
			
			ust = new UnicastServerThread(s);
			Thread t = new Thread(ust);
			t.start();
		}
	}
	public static void main(String[] args) {
		new UnicastServer(3000);
	}
}
