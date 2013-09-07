package mine_model.Strategy;

import data_structure.MineMatrix;

/**
 * 游戏模式中的初级
 */
public class PreliminaryLevel implements MineMatrixSettable {
	/**
	 * 对MineMatrix的模式进行设置 行为9，列为9，雷数为10
	 */
	@Override
	public void setMineMatrix(MineMatrix m) {
		m.setMatrixInfo(9, 9, 10);
	}

}
