package Multichat;

import java.net.*;
import java.io.*;
public class MultiServerThread implements Runnable{
    private Socket socket;
    private MultiServer ms;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    public MultiServerThread(MultiServer ms){
        this.ms = ms; 
        //MultiServer���� ���� ��Ʈ�� �ּҸ� ����������
    }
    public synchronized void run(){
        boolean isStop = false;
        try{
            socket = ms.getSocket();
            
            ois = new ObjectInputStream(socket.getInputStream());
            //
            oos = new ObjectOutputStream(socket.getOutputStream());
            //Ŭ���̾�Ʈ�κ��� �޾ƿ� ������ �����͸� ���ִ� ��ü ����
            String message = null;
            while(!isStop){
            	message = (String)ois.readObject();
            	//Ŭ���̾�Ʈ�� ���� �о�� �����͸� �޼��� �����ȿ� �־���     
            	//��ü�� ������ȭ �Ͽ� String���� ����ĳ����
            	
                String[] str = message.split("#");
                //Ŭ���̾�Ʈ�� 'id#�޼���' ������ ����Ÿ�� ������ ������ #�� �������� �߶��־� �޼����� string Ÿ������ �������ش�.

                if(str[1].equals("exit")){
                	
                    broadCasting(message);
                    // broadCasting�� ���� Ip�ּҸ� �������ִ� Client�鿡�� �޼��� ������� �����Ѵ�.
                    //exit�� �Է����� �� ����.
                    
                    isStop = true;
                    //while�� Ż��
                }else{
                    broadCasting(message);
                }
            }
            ms.getList().remove(this);
            //while�� ������ ���������尡 �������ִ� Ŭ���̾�Ʈ�� �������
            System.out.println(socket.getInetAddress()+
                    "���������� �����ϼ̽��ϴ�");
            System.out.println("list size : "+ms.getList().size());
        }catch(Exception e){
        	//������������ ����������  ���������尡 �������ִ� Ŭ���̾�Ʈ�� �������
            ms.getList().remove(this);
            System.out.println(socket.getInetAddress()+
                    "������������ �����ϼ̽��ϴ�");
            System.out.println("list size : "+ms.getList().size());
        }
    }
    public void broadCasting(String message)throws IOException{
        for(MultiServerThread ct : ms.getList()){
           ct.send(message);
         //send�޼���� ObjectOutputStream�� ����Ͽ� ������ ��ü�� message �� ����Ѵ�
        }
    }
    public void send(String message)throws IOException{
        oos.writeObject(message);        
    }
}
