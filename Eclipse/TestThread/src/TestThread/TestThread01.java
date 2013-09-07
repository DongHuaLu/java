package TestThread;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class TestThread01 extends JFrame {
	
	private JPanel jp2;
	private MyPanel jp1;
	private JButton jb1;
	private JButton jb2;
	private Thread mt;
	
	
	public static void main(String[] args) {
		new TestThread01();
	}
	
	
	public TestThread01(){
		this.setTitle("Ð¡Çò");
		this.setSize(500,500);
		this.setLocation(100, 100);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		jb1=new JButton("ÒÆ¶¯Ð¡Çò");
		jb1.addActionListener(new BtnClickEvent());
		jb2=new JButton("Í£Ö¹");
		jb2.addActionListener(new BtnClickEvent());
		
		jp2=new JPanel();
		jp2.add(jb1);
		jp2.add(jb2);
		
		this.add(jp2,BorderLayout.NORTH);
		
		
		
		
		jp1=new MyPanel(40,40);
		this.add(jp1);
		mt=new Thread(jp1);
		
		this.setVisible(true);
	}
	
	class BtnClickEvent implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==jb1){
				mt.start();
			}
			if(e.getSource()==jb2){
				jp1.stop123();
			}
		}
		
	}
	
	class MyPanel extends JPanel implements Runnable {
		int x,y;
		private boolean flag=false;
		@Override
		public void run() {
			try {
			for(int i=0;i<200;i++){
				if(!flag){
				jp1.x+=2;
				jp1.repaint();
				Thread.sleep(30);
				}
			}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		public MyPanel(int x,int y){
			this.x=x;
			this.y=y;
		}

		
		public void paint(Graphics g){
			super.paint(g);
			g.setColor(Color.GREEN);
			g.fillOval(x, y, 50, 50);
		}
		
		
		public void stop123(){
			flag=true;
		}




	}
	
	
}


