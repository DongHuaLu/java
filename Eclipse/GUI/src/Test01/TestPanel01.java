package Test01;

import java.awt.GridLayout;

import javax.swing.*;

public class TestPanel01 {
	public static void main(String[] args) {
	JFrame jf=new JFrame();
	JPanel jp=new JPanel();
	JPanel[] jp1=new JPanel[4];
	jp.setLayout(new GridLayout(7,1));
	jf.setSize(400, 400);
	
	JButton[] jb1=new JButton[4];
	JButton[] jb2=new JButton[4];
	JButton[] jb3=new JButton[4];
	JButton[] jb4=new JButton[4];
	for(int i=0;i<4;i++){
		jp1[i]=new JPanel();
		jp1[i].setLayout(new GridLayout(1,4));
		
		jb1[i]=new JButton();
		jb2[i]=new JButton();
		jb3[i]=new JButton();
		jb4[i]=new JButton();
		jp1[i].add(jb1[i]);
		jp1[i].add(jb2[i]);
		jp1[i].add(jb3[i]);
		jp1[i].add(jb4[i]);
		jp.add(jp1[i]);
	}
	jf.add(jp);
	jf.setVisible(true);
	}


}
