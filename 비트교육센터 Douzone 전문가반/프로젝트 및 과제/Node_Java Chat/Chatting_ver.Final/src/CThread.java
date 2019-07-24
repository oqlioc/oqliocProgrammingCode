import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class CThread {
	// 서버와의 통신을 위한 소켓
	private Socket socket;
	private BufferedWriter bw;
	private BufferedReader br;
	private String ip;
	private int port;
	private MChatting model;
	private VChatting view;
	private Object[] receiveData;

	public CThread(String ip, int port, MChatting model, VChatting view) {
		this.ip = ip;
		this.port = port;
		this.model = model;
		this.view = view;
	}

	// 소켓 설정을 위한 세터
	// 이제 프레임도 소켓의 정보를 가지게 되었다
	public boolean setSocket() {
		try {
			socket = new Socket(ip, port);

			OutputStream out = socket.getOutputStream();
			bw = new BufferedWriter(new OutputStreamWriter(out));

			boolean connected = (socket.isConnected() == true ? true : false);

			if (connected) {
				System.out.println("Socket 연결 성공!");
			} else {
				System.out.println("Socket 연결 실패!");
			}

			return connected;
		} catch (Exception e) {
			e.printStackTrace();

			return false;
		}
	}

	public void closeSocket() {
		try {
			System.out.println("Socket 연결이 종료되었습니다.");
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void sendMsg(String sendMessage) {
		try {
			bw.write(sendMessage + "\n");
			bw.flush();
		} catch (IOException e1) {
			e1.printStackTrace();
		} // 한문장이 끝났다는 것을 알리기 위해서 bufferedWriter에 "\n"을 붙인다
	}

	public void tcpThread() {

		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					while (true) {
						String msg = br.readLine();// 메세지 한줄 읽어오기
						model.addData(msg);
					}
				} catch (Exception e) {
					System.out.println("연결이 종료되었습니다.");
					view.setError();
					System.exit(0);
				} finally {
					try {
						if (socket != null && !socket.isClosed()) {
							socket.close();// 다 쓴 소켓 닫기
						}
					} catch (Exception e2) {

					}
				}
			}
		}).start();
	}
}
