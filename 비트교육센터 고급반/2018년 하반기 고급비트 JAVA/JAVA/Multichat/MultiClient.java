package Multichat;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class MultiClient implements ActionListener {
   
	//field
	private Socket socket;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private JFrame jframe;
    private JTextField jtf;
    private JTextArea jta;
    private JLabel jlb1, jlb2;
    private JPanel jp1, jp2;
    private String ip;
    private String id;
    private JButton jbtn;
    
    //Constructor
    public MultiClient(String argIp, String argId) {
        ip = argIp;
        id = argId;
        jframe = new JFrame("Multi Chatting");
        jtf = new JTextField(30);
        jta = new JTextArea("", 10, 50);
        jlb1 = new JLabel("Usage ID : [[ " + id + "]]");
        jlb2 = new JLabel("IP : " + ip);
        jbtn = new JButton("종료");
        jp1 = new JPanel();
        jp2 = new JPanel();
        jlb1.setBackground(Color.yellow);
        jlb2.setBackground(Color.green);
        jta.setBackground(Color.pink);
        jp1.setLayout(new BorderLayout());
        jp2.setLayout(new BorderLayout());

        jp1.add(jbtn, BorderLayout.EAST);
        jp1.add(jtf, BorderLayout.CENTER);
        jp2.add(jlb1, BorderLayout.CENTER);
        jp2.add(jlb2, BorderLayout.EAST);

        jframe.add(jp1, BorderLayout.SOUTH);
        jframe.add(jp2, BorderLayout.NORTH);
        JScrollPane jsp = new JScrollPane(jta,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jframe.add(jsp, BorderLayout.CENTER);

        jtf.addActionListener(this);
        jbtn.addActionListener(this);
    
        jframe.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                try {
                    oos.writeObject(id+"#exit"); // 종료되었다고 적는다. 
                } catch (IOException ee) {
                    ee.printStackTrace();
                }
                System.exit(0);
            }
            public void windowOpened(WindowEvent e) {
                jtf.requestFocus();
            }
        });
        
        jta.setEditable(false);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        int screenHeight = d.height;
        int screenWidth = d.width;
        jframe.pack();
        jframe.setLocation(
                (screenWidth - jframe.getWidth()) / 2,
                (screenHeight - jframe.getHeight()) / 2);
        jframe.setResizable(false);
        jframe.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();       
        String msg = jtf.getText();
        
        if (obj == jtf) {
            if (msg == null || msg.length()==0) {
                JOptionPane.showMessageDialog(jframe, 
                        "글을쓰세요", "경고",
                        JOptionPane.WARNING_MESSAGE);
            } else {
                try {
                    oos.writeObject(id+"#"+msg);
                    //
                } catch (IOException ee) {
                    ee.printStackTrace();
                }
                jtf.setText("");
            }
        } else if (obj == jbtn) {
            try {
                oos.writeObject(id+"#exit");
            } catch (IOException ee) {
                ee.printStackTrace();
            }
            System.exit(0);
        }
    }
    public void exit(){
        System.exit(0);
    }
 
    public void init() throws IOException {
        socket = new Socket(ip, 8907); // client socket에  ip,port를  서버에게 보내 연결이 되게 만든다.
        System.out.println("connected...");
        oos = new ObjectOutputStream(socket.getOutputStream()); //client socket을 통해 서버에게 자신이 작성한 정보나 ip,port를 보내준다.
        ois = new ObjectInputStream(socket.getInputStream()); // 서버로 부터 온 정보를 client에게 정보를 준다.
        MultiClientThread ct = new MultiClientThread(this); // MultiClientThread에게 자신을 보내준다. 왜냐한면 지속적으로 쓰레드를 생성하게 만들기 위해서 이다.
        Thread t = new Thread(ct); // 쓰레드 객체를 생성하여 지속적으로 발생하는 client를 담을 수 있게 한다. 
        t.start(); // run메소드 호출
    }

    public static void main(String args[]) throws IOException {
        JFrame.setDefaultLookAndFeelDecorated(true);
        MultiClient cc = new MultiClient("127.0.0.1","SORA");
        //생성자로부터 ip와  id값을 보낸다 
        cc.init();
        //초기화
    }
    public ObjectInputStream getOis(){
        return ois;
    }
    public JTextArea getJta(){
        return jta;
    }
    public String getId(){
        return id;
    }
}
