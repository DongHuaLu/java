package mine_model.Strategy;

import data_structure.MineMatrix;

/**
 * ��Ϸģʽ�е��Զ��弶
 */

public class SelfDefinedLevel implements MineMatrixSettable {
	private int row;
	private int column;
	private int mineCount;

	/**
	 * ���췽��
	 * 
	 * @param row
	 *            �Զ���ģʽ������
	 * @param column
	 *            �Զ���ģʽ������
	 * @param mineCount
	 *            �Զ���ģʽ������
	 */
	public SelfDefinedLevel(int row, int column, int mineCount) {
		super();
		this.row = row;
		this.column = column;
		this.mineCount = mineCount;
	}

	/**
	 * ��MineMatrix��ģʽ�������� �У��У�������Ϊ�Զ���
	 */
	@Override
	public void setMineMatrix(MineMatrix m) {
		m.setMatrixInfo(row, column, mineCount);
	}

}