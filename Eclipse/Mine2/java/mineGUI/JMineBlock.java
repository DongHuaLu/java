package mineGUI;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import res.image.ImageIconFactory;


/**
 * ���̳���JLabel����ÿ���׿����ʾ�ؼ� 
 */
public class JMineBlock extends JLabel {
	private int row;
	private int column;

	/**
	 * ���췽��
	 */
	public JMineBlock() {
		super();
	}

	/**
	 * ����icon�����Ĺ��췽������ͼ������Ϊicon
	 */
	public JMineBlock(ImageIcon icon) {
		this.setIcon(icon);
	}

	/**
	 * ��������׿���к�
	 */
	public void setRow(int row) {
		this.row = row;
	}

	/**
	 * ��������׿��ͼ��Ϊ��
	 */
	public void setMine() {
		this.setIcon(ImageIconFactory.getMine());
	}

	/**
	 * ��������׿��ͼ��Ϊ����
	 */
	public void setRedMine() {
		this.setIcon(ImageIconFactory.getRedMine());
	}

	/**
	 * ��������׿��ͼ��Ϊ�ʺ�
	 */
	public void setAsk() {
		this.setIcon(ImageIconFactory.getAsk());
	}

	/**
	 * ��������׿��ͼ��Ϊ���µ��ʺ�
	 */
	public void setAskPressed() {
		this.setIcon(ImageIconFactory.getAskPressed());
	}

	/**
	 * ��������׿��ͼ��Ϊ��������
	 */
	public void setWrongMine() {
		this.setIcon(ImageIconFactory.getWrongMine());
	}

	/**
	 * ��������׿��ͼ��Ϊ��
	 */

	public void setFlag() {
		this.setIcon(ImageIconFactory.getFlag());
	}

	/**
	 * ��������׿��ͼ��Ϊ���µı��
	 */
	public void setMarkPressed() {
		this.setIcon(ImageIconFactory.getAskPressed());
	}

	/**
	 * ��������׿���к�
	 */
	public void setColumn(int column) {
		this.column = column;
	}

	/**
	 * �õ�����׿���к�
	 */
	public int getRow() {
		return this.row;
	}

	/**
	 * �õ�����׿���к�
	 */
	public int getColumn() {
		return this.column;
	}

	/**
	 * ���õ�ǰ��ʾ��ͼ��
	 */
	public Icon getIcon() {
		return super.getIcon();
	}

	/**
	 * ��������׿��ͼ��Ϊ��
	 */
	public void setBlank() {
		this.setIcon(ImageIconFactory.getBlank());
	}

	/**
	 * ��������׿�Ϊ��ͼ��Ϊ���µĿհ�
	 */
	public void setBlankPressed() {
		this.setIcon(ImageIconFactory.getBlankPressed());
	}

	/**
	 * ��������׿�Ϊ��ͼ��Ϊָ��������
	 */
	public void setNumber(int num) {
		this.setIcon(ImageIconFactory.getNumber(num));
	}

	/**
	 * ���ø��׿��ͼ��Ϊ��
	 */
	public void setDot() {
		this.setIcon(ImageIconFactory.getDot());
	}

}
