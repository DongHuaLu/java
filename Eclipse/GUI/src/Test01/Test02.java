package Test01;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Test02 {
	public static void main(String[] args) {
		new Test02().strat();

	}
	
	public void strat(){
		JFrame jf=new JFrame();
		JPanel jp=new JPanel();
		JTextField jt1=new JTextField("",20);
		JTextArea jt2=new JTextArea();
		JButton jb=new JButton("Ã·Ωª");
		jb.addActionListener(new ButtonOnClicked());
		jf.setLayout(new GridLayout(2,1));
		jf.setSize(400,400);
		jt1.getDocument().addDocumentListener(new TextFieldChange());
		
		jf.add(jp);
		jf.add(jt2);
		
		jp.add(jt1);
		jp.add(jb);
		jf.setVisible(true);		
		
	}
	
	private class TextFieldChange extends JTextField implements DocumentListener{
		
		

		@Override
		public void changedUpdate(DocumentEvent e) {
			 System.out.println("Attribute Changed"+e); 
		}

		@Override
		public void insertUpdate(DocumentEvent e) {
			JTextField tf1=(JTextField) e.getDocument();
			System.out.println("Text Inserted:"+tf1.getText()); 
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			JTextField tf1=(JTextField) e.getDocument();
			System.out.println("Text Removed:"+tf1.getText()); 
		}
		
	}
	
	
	private class ButtonOnClicked extends JFrame implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton jb=(JButton) e.getSource();
		}
		
	}
	
		
	
	
	
}
