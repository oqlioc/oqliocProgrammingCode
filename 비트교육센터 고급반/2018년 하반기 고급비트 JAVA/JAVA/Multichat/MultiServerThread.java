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
        //MultiServer에서 받은 포트의 주소를 가지고있음
    }
    public synchronized void run(){
        boolean isStop = false;
        try{
            socket = ms.getSocket();
            
            ois = new ObjectInputStream(socket.getInputStream());
            //
            oos = new ObjectOutputStream(socket.getOutputStream());
            //클라이언트로부터 받아온 소켓이 데이터를 써주는 객체 생성
            String message = null;
            while(!isStop){
            	message = (String)ois.readObject();
            	//클라이언트로 부터 읽어온 데이터를 메세지 변수안에 넣어줌     
            	//객체를 역직렬화 하여 String으로 강제캐스팅
            	
                String[] str = message.split("#");
                //클라이언트는 'id#메세지' 형태의 데이타를 보내기 때문에 #을 기준으로 잘라주어 메세지만 string 타입으로 전송해준다.

                if(str[1].equals("exit")){
                	
                    broadCasting(message);
                    // broadCasting은 같은 Ip주소를 가지고있는 Client들에게 메세지 내용들을 전달한다.
                    //exit을 입력했을 때 종료.
                    
                    isStop = true;
                    //while문 탈출
                }else{
                    broadCasting(message);
                }
            }
            ms.getList().remove(this);
            //while문 끝나고 서버쓰레드가 가지고있는 클라이언트와 연결끊음
            System.out.println(socket.getInetAddress()+
                    "정상적으로 종료하셨습니다");
            System.out.println("list size : "+ms.getList().size());
        }catch(Exception e){
        	//비정상적으로 종료했을때  서버쓰레드가 가지고있는 클라이언트와 연결끊음
            ms.getList().remove(this);
            System.out.println(socket.getInetAddress()+
                    "비정상적으로 종료하셨습니다");
            System.out.println("list size : "+ms.getList().size());
        }
    }
    public void broadCasting(String message)throws IOException{
        for(MultiServerThread ct : ms.getList()){
           ct.send(message);
         //send메서드는 ObjectOutputStream을 사용하여 현재의 객체에 message 를 기록한다
        }
    }
    public void send(String message)throws IOException{
        oos.writeObject(message);        
    }
}
