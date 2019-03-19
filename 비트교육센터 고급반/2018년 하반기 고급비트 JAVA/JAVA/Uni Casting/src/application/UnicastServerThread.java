package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class UnicastServerThread {

	private Socket socket;
	private BufferedReader bufferR;
	private BufferedWriter bufferW;
	private InputStream is;
	private OutputStream os;
	private String message;
	
	public UnicastServerThread(Socket socket)
	{
		this.socket = socket;
	}
	
	public void run()
	{
		boolean isStop = false;
		try
		{
			is = socket.getInputStream();
			bufferR = new BufferedReader(new InputStreamReader(is));
			os = socket.getOutputStream();
			bufferW = new BufferedWriter(new OutputStreamWriter(os));
		}
		catch (Exception e)
		{
			isStop = true;
		}
		
		try
		{
			while (!isStop)
			{
				String mesaage = bufferR.readLine();
				if(message.equals("exit")) isStop = true;
				System.out.println("received message : " + message);
				message += System.getProperty("line.separator");
				bufferW.write(mesaage);
				bufferW.flush();
			}
		}
		catch (Exception e)
		{
			System.out.println("클라이언트가 강제로" + " 종료되었습니다.");
			isStop = true;
		}
		finally
		{
			try
			{
				if(bufferR != null) bufferR.close();
				if(bufferW != null) bufferW.close();
				if(socket != null) socket.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}//finally end
	}//run end
}
