package mine_model.Strategy;

import data_structure.MineMatrix;
/**
 * ��Ϸģʽ�еĸ߼�
 */
public class AdvancedLevel implements MineMatrixSettable {
/**
 * ��MineMatrix��ģʽ�������� ��Ϊ16����Ϊ30������Ϊ90
 */
	@Override
	public void setMineMatrix(MineMatrix m) {
		m.setMatrixInfo(16, 30, 90);
	}

}
