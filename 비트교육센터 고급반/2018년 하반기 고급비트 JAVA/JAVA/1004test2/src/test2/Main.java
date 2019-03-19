package test2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


public class Main extends Frame implements ActionListener {
	
	/*
	CardLayout card;
	Panel first_panel, second_panel, third_panel;
	
	public Main() {
		super("CardLayout �׽�Ʈ");
		card = new CardLayout();
		setLayout(card);
		
		first_panel = new Panel();
		first_panel.add(new Button("1"));
		first_panel.add(new Button("2"));
		
		second_panel = new Panel();
		second_panel.add(new Button("3"));
		second_panel.add(new Button("4"));
		
		third_panel = new Panel();
		third_panel.add(new Button("5"));
		third_panel.add(new Button("6"));
		
		add("1", first_panel);
		add("2", second_panel);
		add("3", third_panel);
		
	}
	
	public void rotate() {
		for(int i = 0; i < 2; i++)
		{
			try {
				Thread.sleep(3000);
			} catch(Exception e) {
				e.printStackTrace();
			}
			card.next(this);
		}
	}
	*/
	
	Panel p;
	Button input, exit;
	TextArea ta;
	
	public Main()
	{
		super("ActionEvent Test");
		p = new Panel();
		
		input = new Button("�Է�");
		exit = new Button("����");
		ta = new TextArea();
		
		input.addActionListener(this);
		exit.addActionListener(this);
		
		p.add(input);
		p.add(exit);
		
		add(p, BorderLayout.NORTH);
		add(ta, BorderLayout.CENTER);
		
		setBounds(300, 300, 300, 200);
		setVisible(true);
		
		addWindowListener((WindowListener) this); // Label���� X������ ����
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		String name;
		name = ae.getActionCommand();
		
		if(name.equals("�Է�"))
		{
			ta.append("��ư�� �ԷµǾ����ϴ�.\n");
		}
		else
		{
			ta.append("���α׷��� �����մϴ�.\n");
			try {
				Thread.sleep(2000);
			} catch(Exception e) {}
			System.exit(0);
		}
	}

	
	
	public void windowClosing(WindowEvent e) // Label���� X������ ����
	{
		System.exit(0);
	}
	
	public void windowActivated(WindowEvent e) {} // WindowListener�� �������̽��� �޼ҵ带 ����ؼ� �̺�Ʈ ��밡��
	public void windowClosed(WindowEvent e) {} // WindowListener�� �������̽��� �޼ҵ带 ����ؼ� �̺�Ʈ ��밡��
	public void windowDeactivated(WindowEvent e) {} // WindowListener�� �������̽��� �޼ҵ带 ����ؼ� �̺�Ʈ ��밡��
	public void windowDeiconified(WindowEvent e) {} // WindowListener�� �������̽��� �޼ҵ带 ����ؼ� �̺�Ʈ ��밡��
	public void windowIconfied(WindowEvent e) {} // WindowListener�� �������̽��� �޼ҵ带 ����ؼ� �̺�Ʈ ��밡��
	public void windowOpened(WindowEvent e) {} // WindowListener�� �������̽��� �޼ҵ带 ����ؼ� �̺�Ʈ ��밡��
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	
/*		
		Frame f = new Frame();
		
		f.setTitle("Frame Test");
		
		f.setSize(300, 300);
		f.setVisible(true);
		
*/
/*
		Frame f = new Frame("��ư �׽�Ʈ");
		
		Panel p = new Panel();
		
		Button b1 = new Button();	
		Button b2 = new Button("���");
		Button b3 = new Button("����");
		Button b4 = new Button("����");
		
		b1.setLabel("�Է�");
		
		p.add(b1);
		p.add(b2);
		p.add(b3);
		p.add(b4);
		
		f.add(p);
		
		f.setLocation(300, 300);
		f.setSize(300, 300);
		f.setVisible(true);
*/
	/*
		Frame f = new Frame("�ؽ�Ʈ�ʵ� �׽�Ʈ");
		Panel p = new Panel();
		
		TextField tf1 = new TextField("���̵� �Է�", 12);
		TextField tf2 = new TextField("��ȣ �Է�", 10);
		
		tf1.selectAll();
		tf2.selectAll();
		
		tf2.setEchoChar('*');
		
		p.add(tf1);
		p.add(tf2);
		
		f.add(p);
		
		f.setSize(300, 100);
		f.setVisible(true);
	*/
	/*		
 		Main clt = new Main();
		
		clt.setBounds(200, 200, 200, 100);
		clt.setVisible(true);
		
		clt.rotate();
*/	
	}
	
	
}
