package Multi;

import java.net.*;
import java.io.*;
public class MultiServerThread implements Runnable{
    private Socket socket;
    private MultiServer ms;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    
    public MultiServerThread(MultiServer ms){
        this.ms = ms;
    }
    public synchronized void run(){
        boolean isStop = false;
        try{
            socket = ms.getSocket();
            ois = new ObjectInputStream(socket.getInputStream());  // Ŭ���̾�Ʈ ����ڰ� ������ �����ִ� ä�ó����� �Է� �޴� �Է½�Ʈ�� ��ü
            oos = new ObjectOutputStream(socket.getOutputStream());  // �������� Ŭ���̾�Ʈ ����ڿ��� ä�ó����� ������ ��½�Ʈ�� ��ü
            String message = null;  // �ʱ�ȭ
            while(!isStop){
                message = (String)ois.readObject();  // message�� �Է�  �Է¹��� ��ü�� �ִ´�
                String[] str = message.split("#");  // str�迭�� #�� �������� �����ؼ� �ִ´�
                if(str[1].equals("exit")){
                    broadCasting(message);
                    isStop = true;
                }else{
                    broadCasting(message);  // 
                }
            }
            ms.getList().remove(this);  // while���� ������ ���������������ϰ� Ŭ���̾�Ʈ �������
            System.out.println(socket.getInetAddress()+
                    "���������� �����ϼ̽��ϴ�");
            System.out.println("list size : "+ms.getList().size());
        }catch(Exception e){
            ms.getList().remove(this);  // ���ܰ� �������� ���������尴ü����
            System.out.println(socket.getInetAddress()+
                    "������������ �����ϼ̽��ϴ�");
            System.out.println("list size : "+ms.getList().size());
        }
    }
    public void broadCasting(String message)throws IOException{
        for(MultiServerThread ct : ms.getList()){
           ct.send(message);
        }
    }
    public void send(String message)throws IOException{
        oos.writeObject(message);  // ������ �ٽ� ����ȭ�� ( �ٽ� ������ �غ� )
    }
}
