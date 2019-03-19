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
	
	// Ŭ���̾�Ʈ ���α׷� ���� �޼ҵ�
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
						System.out.println("[���� ���� ����]");
						Platform.exit();
					}
				}
			}
		};
		thread.start();
	}
	
	// Ŭ���̾�Ʈ ���α׷� ���� �޼ҵ�
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
	
	// �����κ��� �޼����� ���޹޴� �޼ҵ�
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
	
	// ������ �޼����� �����ϴ� �޼ҵ�
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
					out.flush(); // byte�� �ִ� ������ ���ڿ� �� ä������������ ���������ʴµ�, �װ��� ������ �����ش�.
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
//       send(nick + "���� �����ϼ̽��ϴ�.");
//   }
 
    public void removeClient(String nick) 
    {
        send(nick + "���� �����̽��ϴ�.");
    }
    
	// ������ ���α׷��� ���۽�Ű�� �޼ҵ�
	@Override
	public void start(Stage primaryStage) 
	{
		
		BorderPane root = new BorderPane(); // Layout
		root.setPadding(new Insets(5));  // root�� 5ũ�⸸ŭ ���
		
		HBox hbox = new HBox(); // BorderPane ���� Layout �߰�
		hbox.setSpacing(5); // hbox�� 5 ũ�⸸ŭ ����
		
		//�г��� �Էºκ�
		TextField userName = new TextField();
		userName.setPrefWidth(50); // userName ���� 150px �Ҵ�
		userName.setPromptText("�г����� �Է��ϼ���"); // textfield hint text
		
		HBox.setHgrow(userName, Priority.ALWAYS); //HBOX ���ο��� �ش� textfield�� �ش�ǰ�
		
//		TextField IPText = new TextField("192.168.0.28"); // IPText�� ���� �⺻ ip�ּ�
//		TextField portText = new TextField("9999"); // portText �⺻ ��Ʈ��ȣ

//		portText.setPrefWidth(80);
		
		hbox.getChildren().addAll(userName);
		root.setTop(hbox);
		
		//ȭ�� â
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
		
		Button sendButton = new Button("������");
		sendButton.setDisable(true);
		
		sendButton.setOnAction(event -> {
			send(userName.getText() + ": " + input.getText() + "\n");
			input.setText("");
			input.requestFocus();
		});

		String nick = userName.getText();
		Button connectionButton = new Button("�����ϱ�");
		connectionButton.setOnAction(event -> {
			
			if(connectionButton.getText().equals("�����ϱ�")) 
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
					textArea.appendText("[ä�ù� ����]\n");
					send(userName.getText() + "���� �����Ͽ����ϴ�.\n");   // �α׿� �߻� ��
				});
				
				connectionButton.setText("�����ϱ�");
				input.setDisable(false);
				sendButton.setDisable(false);
				input.requestFocus();	
			}
			else
			{
				send(nick + "���� �����Ͽ����ϴ�./n");
				//removeClient(nick);
				stopClient();
				Platform.runLater(() -> {
					textArea.appendText("[ä�ù� ����]\n");
				});
				connectionButton.setText("�����ϱ�");
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
		primaryStage.setTitle("[ ä�� Ŭ���̾�Ʈ]");
		primaryStage.setScene(scene);
		primaryStage.setOnCloseRequest(event -> stopClient());
		primaryStage.show();
		
		connectionButton.requestFocus();
	}

	
	// ���α׷��� ������
	/*
	public static void main(String[] args) {
        launch(args);
    }*/
}
