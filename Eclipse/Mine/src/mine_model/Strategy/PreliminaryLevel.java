package mine_model.Strategy;

import data_structure.MineMatrix;

/**
 * ��Ϸģʽ�еĳ���
 */
public class PreliminaryLevel implements MineMatrixSettable {
	/**
	 * ��MineMatrix��ģʽ�������� ��Ϊ9����Ϊ9������Ϊ10
	 */
	@Override
	public void setMineMatrix(MineMatrix m) {
		m.setMatrixInfo(9, 9, 10);
	}

}
