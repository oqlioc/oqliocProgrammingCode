package Multichat;

public class MultiClientThread extends Thread{
    private MultiClient mc;
    public MultiClientThread(MultiClient mc){
        this.mc = mc; // MultiClient�� ���� ���� �����͸�  MultiClientThread�� ������ �޴´�.
    }
    public void run(){
        String message = null;
        String[] receivedMsg = null;
        boolean isStop = false;
        while(!isStop){
            try{
                message = (String)mc.getOis().readObject(); // Ŭ���̾�Ʈ�� �����͸� �а� �� ������ �޼����� ��´�.
                receivedMsg = message.split("#"); // #�� �������� �޼����� ������ �ڸ���.
            }catch(Exception e){
                e.printStackTrace();
                isStop = true; // ���ܰ� �߻����� ��, ���߰� while���� �Ѿ��.
            }
            System.out.println(receivedMsg[0]+","+receivedMsg[1]);
            if(receivedMsg[1].equals("exit")){
                if(receivedMsg[0].equals(mc.getId())){
                    mc.exit();
                }else{
                    mc.getJta().append(
                    receivedMsg[0] +"���� ���� �ϼ̽��ϴ�."+
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