package GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Finger.Finger;

public class FingerGuessGameGUI {
	JButton stone, scissors, cloth;
	JLabel playerFinger, computerFinger,result;

	public static void main(String[] args) {
		new FingerGuessGameGUI().start();
	}

	private MouseListener blockMouseListener;

	public void start() {
		BtuActionListener bal = new BtuActionListener();
		JFrame jf = new JFrame();
		JPanel jp = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();

		stone = new JButton("石头");
		scissors = new JButton("剪刀");
		cloth = new JButton("布");

		JLabel vs = new JLabel();
		computerFinger = new JLabel();
		playerFinger = new JLabel();
		result=new JLabel();

		jf.setLayout(new GridLayout(3, 1));
		stone.setSize(130, 130);
		cloth.setSize(130, 130);
		scissors.setSize(130, 130);
		stone.addActionListener(bal);
		cloth.addActionListener(bal);
		scissors.addActionListener(bal);
		stone.setIcon(new ImageIcon("./image/石头.jpg"));
		cloth.setIcon(new ImageIcon("./image/布.jpg"));
		scissors.setIcon(new ImageIcon("./image/剪刀.jpg"));
		vs.setIcon(new ImageIcon("./image/vs.jpg"));

		jp.setLayout(new GridLayout(1, 3));
		jp.add("West", stone);
		jp.add("East", scissors);
		jp.add("South", cloth);

		jp2.add(playerFinger);
		jp2.add(vs);
		jp2.add(computerFinger);
		
		
		jp3.add(result);

		stone.addMouseListener(this.blockMouseListener);
		cloth.addMouseListener(this.blockMouseListener);
		scissors.addMouseListener(this.blockMouseListener);
		jf.add(jp);
		jf.add(jp2);
		jf.add(jp3);

		jf.setVisible(true);
		jf.setSize(400, 400);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private class BtuActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int playerFingern = 0;
			Finger f = new Finger();
			f.setFinger((int) (Math.random() * ((2 - 0) + 1)));
			int computerFingern = f.getFinger();
			if (computerFingern == 0) {
				computerFinger.setIcon(new ImageIcon("./image/石头.jpg"));
			} else if (computerFingern == 1) {
				computerFinger.setIcon(new ImageIcon("./image/剪刀.jpg"));
			} else if (computerFingern == 2) {
				computerFinger.setIcon(new ImageIcon("./image/布.jpg"));
			}

			if (e.getSource() == stone) {
				playerFingern = 0;
				playerFinger.setIcon(new ImageIcon("./image/石头.jpg"));
			} else if (e.getSource() == cloth) {
				playerFingern = 2;
				playerFinger.setIcon(new ImageIcon("./image/布.jpg"));
			} else if (e.getSource() == scissors) {
				playerFingern = 1;
				playerFinger.setIcon(new ImageIcon("./image/剪刀.jpg"));
			}
			if (playerFingern == 0) {
				if (computerFingern == 0) {
					result.setIcon(new ImageIcon("./image/平局.jpg"));
				} else if (computerFingern == 1) {
					result.setIcon(new ImageIcon("./image/赢.jpg"));
				} else if (computerFingern == 2) {
					result.setIcon(new ImageIcon("./image/输.jpg"));
				}

			} else if (playerFingern == 1) {
				if (computerFingern == 0) {
					result.setIcon(new ImageIcon("./image/输.jpg"));
				} else if (computerFingern == 1) {
					result.setIcon(new ImageIcon("./image/平局.jpg"));
				} else if (computerFingern == 2) {
					result.setIcon(new ImageIcon("./image/赢.jpg"));
				}
			} else if (playerFingern == 2) {
				if (computerFingern == 0) {
					result.setIcon(new ImageIcon("./image/赢.jpg"));
				} else if (computerFingern == 1) {
					result.setIcon(new ImageIcon("./image/输.jpg"));
				} else if (computerFingern == 2) {
					result.setIcon(new ImageIcon("./image/平局.jpg"));
				}
			}
		}

	}

}
