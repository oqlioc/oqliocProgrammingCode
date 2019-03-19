package application;
	
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;


public class Main extends Application {
	
	Socket socket;
	TextArea textArea;
	
	public Label lblStatus;
	public TextField logUserName;
	public TextField logPassWord;


	public void Login(ActionEvent event)// throws Exception
	{
		if(logUserName.getText().equals("user") && logPassWord.getText().equals("pass"))
		{
			lblStatus.setText("Login Succes");
//			startClient("192.168.0.28", 9999);
        }
		else
        {
            lblStatus.setText("Login Failed");
        }
	}
	
	// 클라이언트 프로그램 동작 메소드
	public void startClient(String IP, int port)
	{
		Thread thread = new Thread()
		{
			public void run()
			{
				try
				{
					socket = new Socket(IP, port);
					receive();
				}
				catch (Exception e)
				{
					if(!socket.isClosed())
					{
						stopClient();
						System.out.println("[서버 접속 실패]");
						Platform.exit();
					}
				}
			}
		};
		thread.start();
	}
	
	// 클라이언트 프로그램 종료 메소드
	public void stopClient()
	{
		try
		{
			if(socket != null && !socket.isClosed())
			{
				socket.close();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	// 서버로부터 메세지를 전달받는 메소드
	public void receive()
	{
		while(true)
		{
			try
			{
				InputStream in = socket.getInputStream();
				byte[] buffer = new byte[512];
				
				int length = in.read(buffer);
				if(length == -1) throw new IOException();
				
				String message = new String(buffer, 0, length, "UTF-8");
				Platform.runLater(()->{
					textArea.appendText(message);
				});
			}
			catch (Exception e)
			{
				stopClient();
				break;
			}
		}
	}
	
	// 서버로 메세지를 전송하는 메소드
	public void send(String message)
	{
		Thread thread = new Thread()
		{
			public void run()
			{
				try
				{
					OutputStream out = socket.getOutputStream();
					byte[] buffer = message.getBytes("UTF-8");
					out.write(buffer);
					out.flush(); // byte에 있는 공간이 문자에 다 채워지지않으면 보내지지않는데, 그것을 강제로 보내준다.
				}
				catch (Exception e)
				{
					stopClient();
				}
			}
		};
		thread.start();
	}
	
//	public void addClient(String nick, DataOutputStream out) throws IOException 
//	{
//       send(nick + "님이 접속하셨습니다.");
//   }
 
    public void removeClient(String nick) 
    {
        send(nick + "님이 나가셨습니다.");
    }
    
	// 실제로 프로그램을 동작시키는 메소드
	@Override
	public void start(Stage primaryStage) 
	{
		
		BorderPane root = new BorderPane(); // Layout
		root.setPadding(new Insets(5));  // root에 5크기만큼 페딩
		
		HBox hbox = new HBox(); // BorderPane 위에 Layout 추가
		hbox.setSpacing(5); // hbox에 5 크기만큼 여백
		
		//닉네임 입력부분
		TextField userName = new TextField();
		userName.setPrefWidth(50); // userName 넓이 150px 할당
		userName.setPromptText("닉네임을 입력하세요"); // textfield hint text
		
		HBox.setHgrow(userName, Priority.ALWAYS); //HBOX 내부에서 해당 textfield가 해당되게
		
//		TextField IPText = new TextField("192.168.0.28"); // IPText에 본인 기본 ip주소
//		TextField portText = new TextField("9999"); // portText 기본 포트번호

//		portText.setPrefWidth(80);
		
		hbox.getChildren().addAll(userName);
		root.setTop(hbox);
		
		//화면 창
		textArea = new TextArea();
		textArea.setEditable(false);
		root.setCenter(textArea);
		
		TextField input = new TextField();
		input.setPrefWidth(Double.MAX_VALUE);
		input.setDisable(true);
		
		input.setOnAction(event -> {
			send(userName.getText() + ": " + input.getText() + "\n");
			input.setText("");
			input.requestFocus();
		});
		
		Button sendButton = new Button("보내기");
		sendButton.setDisable(true);
		
		sendButton.setOnAction(event -> {
			send(userName.getText() + ": " + input.getText() + "\n");
			input.setText("");
			input.requestFocus();
		});

		String nick = userName.getText();
		Button connectionButton = new Button("접속하기");
		connectionButton.setOnAction(event -> {
			
			if(connectionButton.getText().equals("접속하기")) 
			{
				/*
				int port = 9999;
				try
				{
					port = Integer.parseInt(portText.getText());
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
				*/
				startClient("192.168.0.28", 9999);
				Platform.runLater(() -> {
					textArea.appendText("[채팅방 접속]\n");
					send(userName.getText() + "님이 접속하였습니다.\n");   // 로그온 발생 부
				});
				
				connectionButton.setText("종료하기");
				input.setDisable(false);
				sendButton.setDisable(false);
				input.requestFocus();	
			}
			else
			{
				send(nick + "님이 퇴장하였습니다./n");
				//removeClient(nick);
				stopClient();
				Platform.runLater(() -> {
					textArea.appendText("[채팅방 퇴장]\n");
				});
				connectionButton.setText("접속하기");
				input.setDisable(true);
				sendButton.setDisable(true);
				
			}
		});
		BorderPane pane = new BorderPane();
		pane.setLeft(connectionButton);
		pane.setCenter(input);
		pane.setRight(sendButton);
		
		root.setBottom(pane);
		Scene scene = new Scene(root, 400, 400);
		primaryStage.setTitle("[ 채팅 클라이언트]");
		primaryStage.setScene(scene);
		primaryStage.setOnCloseRequest(event -> stopClient());
		primaryStage.show();
		
		connectionButton.requestFocus();
	}

	
	// 프로그램의 진입점
	/*
	public static void main(String[] args) {
        launch(args);
    }*/
}
