package echoserver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer 
{

	private BufferedReader bufferR;
	private BufferedWriter bufferW;
	private InputStream is;
	private OutputStream os;
	private ServerSocket serverS;

	public EchoServer(int port) 
	{
		try 
		{
			serverS = new ServerSocket(port);
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
			System.exit(0);
		}

		while (true) 
		{
			try 
			{
				System.out.println("Ŭ���̾�Ʈ ��û�� ��ٸ��� ��");
				Socket tcpSocket = serverS.accept();

				System.out.println("Ŭ���̾�Ʈ�� IP �ּ� : " + tcpSocket.getInetAddress().getHostAddress());

				is = tcpSocket.getInputStream();
				os = tcpSocket.getOutputStream();
				bufferR = new BufferedReader(new InputStreamReader(is));
				bufferW = new BufferedWriter(new OutputStreamWriter(os));

				String message = bufferR.readLine();
				System.out.println("���Ÿ޼��� : " + message);
				message = message + System.getProperty("line.separator");
				bufferW.write(message);
				bufferW.flush();
				bufferR.close();
				bufferW.close();

			}
			catch (Exception ioe) 
			{
				ioe.printStackTrace();
			}
		}
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		new EchoServer(3000);
	}

}
