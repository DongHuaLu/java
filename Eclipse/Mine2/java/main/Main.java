package main;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import mineGUI.JMineSweeperFrame;

/**
 * �������� ������Ƥ��ɨ�׽������ʾλ��
 * @author Administrator
 * @download:http://www.codefans.net
 */
public class Main {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());//ѡ��Systemlook
		JFrame jf = new JMineSweeperFrame();
		jf.setVisible(true);
		jf.setLocationRelativeTo(null);//location:�м�
	}
}