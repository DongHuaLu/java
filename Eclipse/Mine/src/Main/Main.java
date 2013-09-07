package Main;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import mineGUI.JMineSweeperFrame;
/**
 * 程序的入口 设置了皮肤扫雷界面的显示位置
*/
public class Main {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());//选择Systemlook
		JFrame jf = new JMineSweeperFrame();
		jf.setVisible(true);
		jf.setLocationRelativeTo(null);//location:中间
	}
}