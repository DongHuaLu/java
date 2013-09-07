package mine_model.Strategy;

import data_structure.MineMatrix;

/**
 * 游戏模式中的中级
 */
public class IntermediateLevel implements MineMatrixSettable {
	/**
	 * 对MineMatrix的模式进行设置 行为16，列为16，雷数为40
	 */
	@Override
	public void setMineMatrix(MineMatrix m) {
		m.setMatrixInfo(16, 16, 40);
	}

}
