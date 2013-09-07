package mine_model.Strategy;

import data_structure.MineMatrix;

/**
 * ��Ϸģʽ�е��м�
 */
public class IntermediateLevel implements MineMatrixSettable {
	/**
	 * ��MineMatrix��ģʽ�������� ��Ϊ16����Ϊ16������Ϊ40
	 */
	@Override
	public void setMineMatrix(MineMatrix m) {
		m.setMatrixInfo(16, 16, 40);
	}

}
