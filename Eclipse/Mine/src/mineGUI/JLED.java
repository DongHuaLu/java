package mineGUI;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;

import exceptions.LEDException;
import res.image.ImageIconFactory;

/**
 * LED������ ����������ͼ�����
 */
public class JLED extends Box {
	private JLabel integerPlace[] = new JLabel[3];//����label����
	private int second;

	/**
	 * ���캯�� ���г�ʼ������ new jLabel ��ͼƬ0��ʼ�� ����
	 */
	public JLED() {

		super(BoxLayout.X_AXIS);
		for (int i = 0; i < integerPlace.length; i++) {
			integerPlace[i] = new JLabel(new ImageIcon("./image/d0.gif"));
			this.add(integerPlace[i]);
		}
		this.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));//���µı߿�
	}

	/**
	 * ������ʾ������
	 * 
	 * @param second
	 *            ���ֵ�ֵ ֻ����-999��999֮��
	 */
	public void setNumber(int second) {
		if (second > 999 || second < -999) {
			throw new LEDException("���ֳ�����Χ");
		}
		this.second = second;
		showNumber(second);
	}

	/**
	 * ��ʾ����
	 * 
	 * @param number
	 */
	private void showNumber(int number) {
		if (number > 999 || number < -999) {
			throw new LEDException("���ֳ�����Χ");
		}

		int digit = 2;
		resetDisplay();// ȫ����0 ����0��LED����Ϊ��Ӧ������
		StringBuffer str = new StringBuffer(String.valueOf(Math.abs(number)));//��numberת����string����str
		if (number < 0) {
			integerPlace[0].setIcon(ImageIconFactory.getLedMinus());//number<0 ����"-"
			if (number < -99)
				str.deleteCharAt(0);
		}

		for (int i = str.length(); i > 0; i--) {
			// this.integerPlace[digit].setIcon(new ImageIcon("./image/d"
			// + Integer.parseInt(str.charAt(i - 1) + "") + ".gif"));
			this.integerPlace[digit].setIcon(ImageIconFactory.getLed(Integer
					.parseInt(str.charAt(i - 1) + "")));
			digit--;
		}
	}

	/**
	 * ������ͼƬ����Ϊ����0
	 */
	private void resetDisplay() {
		for (int i = 0; i < 3; i++)
			this.integerPlace[i].setIcon(new ImageIcon("./image/d0.gif"));
	}

	/**
	 * �õ�����ͼƬ��ʾ������
	 * 
	 * @return ����ͼƬ��ʾ������
	 */
	public int getNumber() {
		return this.second;
	}
}