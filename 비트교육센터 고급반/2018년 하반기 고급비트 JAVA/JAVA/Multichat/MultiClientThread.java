package Multichat;

public class MultiClientThread extends Thread{
    private MultiClient mc;
    public MultiClientThread(MultiClient mc){
        this.mc = mc; // MultiClient로 부터 오는 데이터를  MultiClientThread의 변수로 받는다.
    }
    public void run(){
        String message = null;
        String[] receivedMsg = null;
        boolean isStop = false;
        while(!isStop){
            try{
                message = (String)mc.getOis().readObject(); // 클라이언트의 데이터를 읽고 그 내용을 메세지에 담는다.
                receivedMsg = message.split("#"); // #을 기준으로 메세지의 내용을 자른다.
            }catch(Exception e){
                e.printStackTrace();
                isStop = true; // 예외가 발생했을 때, 멈추고 while문을 넘어간다.
            }
            System.out.println(receivedMsg[0]+","+receivedMsg[1]);
            if(receivedMsg[1].equals("exit")){
                if(receivedMsg[0].equals(mc.getId())){
                    mc.exit();
                }else{
                    mc.getJta().append(
                    receivedMsg[0] +"님이 종료 하셨습니다."+
                    System.getProperty("line.separator"));
                    mc.getJta().setCaretPosition(
                    mc.getJta().getDocument().getLength());
                }
            }else{               
                mc.getJta().append(
                receivedMsg[0] +" : "+receivedMsg[1]+
                System.getProperty("line.separator"));
                mc.getJta().setCaretPosition(
                    mc.getJta().getDocument().getLength());
                
            }
        }
    }
}