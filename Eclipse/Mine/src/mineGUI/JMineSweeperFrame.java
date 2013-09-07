package mineGUI;

import java.awt.BorderLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import data_structure.MineMatrix;
import mineGUI.dialog.JEnterNameDialog;
import mineGUI.menu.JMineMenuBar;
import mine_model.Strategy.MineMatrixSettable;
import mine_model.Strategy.PreliminaryLevel;
import record.Rank;

public class JMineSweeperFrame extends JFrame implements WindowListener {
	JMineMenuBar menuBar = new JMineMenuBar();
	JStatusPanel statusPanel = new JStatusPanel();
	JMineMatrixPanel jMineMatrixPanel = new JMineMatrixPanel();
	public List<Rank> preliminaryLevelRanks = new LinkedList<Rank>();//����
	public List<Rank> intermediateLevelRanks = new LinkedList<Rank>();//����
	public List<Rank> advancedLevelRanks = new LinkedList<Rank>();//����

	/**
	 * ���췽�� ��ɨ�׽�����г�ʼ�����ȼ�Ϊ��������ʼ���˵�����ӱ�����ͼ�꣬�Ȳ���
	 */
	public JMineSweeperFrame() {
		// this.setResizable(false);
		this.setIconImage(new ImageIcon("./image/icon.gif").getImage());//ͼ��
		this.setTitle("ɨ��");//title:ɨ��
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�رշ�ʽ
		this.setJMenuBar(menuBar);//���ô���Ĳ˵���
		this.add(statusPanel, BorderLayout.NORTH);//���״̬Panel
		this.add(jMineMatrixPanel);//���matrixPanel
	
		jMineMatrixPanel.addMineSweeperFrame(this);
		statusPanel.addMineSweeperFrame(this);
		setGameMode(new PreliminaryLevel());//������ϷģʽΪ����
		this.addWindowListener(this);
		menuBar.setMineSweeperFrame(this);
		this.setResizable(false);//�����û����ɵ������ڴ�С
		this.pack();//�����˴��ڵĴ�С�����ʺ������������ѡ��С�Ͳ���
	}

	/**
	 * �����Ƿ�ʼ��Ϸ ���ڱ�ʾ��Ϸ�Ŀ�ʼ״̬
	 * 
	 * @param b
	 *            ��Ϸ��ʼ״̬
	 */
	public void setIsFirstDig(boolean b) {
		isFirstDig = b;
	}

	/**
	 * �õ���ǰ��Ϸģʽ�е��׵ĸ���
	 * 
	 * @return ��ǰ��Ϸģʽ���׵ĸ���
	 */
	public int getMineCount() {
		return this.jMineMatrixPanel.getMineCount();
	}

	/**
	 * �õ���ǰ��Ϸģʽ�е�����
	 * 
	 * @return ��ǰ��Ϸģʽ�е�����
	 */
	public int getRowCount() {
		return this.jMineMatrixPanel.getRowCount();
	}

	/**
	 * �õ���ǰ��Ϸģʽ�е�����
	 * 
	 * @return ��ǰ��Ϸģʽ�е�����
	 */
	public int getColumnCount() {
		return this.jMineMatrixPanel.getColumnCount();
	}

	private boolean isFirstDig = true;
	private boolean button1Pressed;
	private boolean button3Pressed;
	private JMineBlock currentMineBlock;

	private JMineBlock[][] jMineMatrix;

	private MineMatrix mineMatrix = new MineMatrix();

	/**
	 * ��Ϸ��ʼ ����״̬���ļ�ʱ��
	 */
	public void gameCommences() {
		// ��ʼ��ʱ
		this.statusPanel.startsTimer();
	}

	/**
	 * ��Ϸʧ�� ֹͣ״̬���ļ�ʱ��������������Ϊ����
	 */
	public void gameOver() {// ��Ϸ����
		// ��ֹ��Ϸ ����Ц������Ϊ����
		this.statusPanel.stopTimer();
		this.statusPanel.setFaceCry();
	}

	/**
	 * ��Ϸ��� ˢ���������棬ȫ�����Ϻ��죬ֹͣ����������״̬������������Ϊ0���������������Ի��򣬲����������ȼ���ʱ���¼�����Ͽ����
	 */
	public void gameComplete() {// �����Ϸ
		// ��ֹ��Ϸ ����Ц������Ϊ����
		jMineMatrixPanel.refreshMineMatrixPanel();
		this.statusPanel.stopTimer();
		this.statusPanel.setLEDMineCountLeft(0);
		this.statusPanel.setFaceHappy();
		// �ж����ĸ��ȼ���
		int time = this.statusPanel.getLEDTime();// �õ���ʱ���ϵ�ʱ�䡣

		// �����Ի������������

		if (getGameModeName().equals("PreliminaryLevel")) {// �������ɳ���
			String name = getHeorName();
			preliminaryLevelRanks.add(new Rank("����", time, name));
		} else if (getGameModeName().equals("IntermediateLevel")) {// ���������м�
			String name = getHeorName();
			intermediateLevelRanks.add(new Rank("�м�", time, name));
		} else if (getGameModeName().equals("AdvancedLevel")) {// �������ɸ߼�
			String name = getHeorName();
			advancedLevelRanks.add(new Rank("�߼�", time, name));
		}

	}

	/**
	 * ����һ���Ի�����ʾ����Ӣ����
	 * 
	 * @return ���������
	 */
	private String getHeorName() {
		JEnterNameDialog d = new JEnterNameDialog();
		d.showDialog(this);
		return d.getHeroName();
	}

	/**
	 * �õ���ǰ��Ϸģʽ������
	 * ֻ������PreliminaryLevel,IntermediateLevel,AdvancedLevel,SelfDefinedLevel
	 * 
	 * @return ģʽ�����ַ���
	 */
	private String getGameModeName() {
		String str[] = this.getGameMode().split("[.]");
		return str[str.length - 1];
	}

	/**
	 * �������ϰ�������Ĳ�������״̬��Ϊ����
	 */
	public void leftButtonPressedOnMineBlock() {
		this.statusPanel.setFaceSurprised();
	}

	/**
	 * �õ���Ϸģʽ�����ص�����Ϸģʽ�İ���������
	 */
	private String getGameMode() {
		return this.jMineMatrixPanel.getGameMode();
	}

	/**
	 * ����������Ϸſ� ��������ΪЦ��
	 */
	public void leftButtonReleasedOnMineBlock() {
		// �ڱ����Ϸ������ζ��������Ϸ �������������ζ������ ���ǰ�״̬����ı�����΢Ц
		this.statusPanel.setFaceSmile();
	}

	/**
	 * ������Ϸģʽ
	 * 
	 * @param s
	 *            ��Ϸģʽ����
	 */
	public void setGameMode(MineMatrixSettable s) {// ������Ϸģʽ
		// ����Ϸģʽ���ĺ�Frame�Ĺ��캯���ж�������������
		// ����������
		this.statusPanel.setFaceSmile();
		this.jMineMatrixPanel.setMineMatrix(s);
		// ��״̬������
		// int mineCount = this.jMineMatrixPanel.getMineCount();
		// // ��ʼ��ʣ������
		// statusPanel.setLEDMineCountLeft(mineCount);
		// // ֹͣ��ʱ��
		// statusPanel.stopTimer();

		resetGame();

	}

	/**
	 * ����״̬����ʣ��������ֵ
	 * 
	 * @param count
	 *            ʣ������
	 */
	public void setLEDMineCountLeft(int count) {
		this.statusPanel.setLEDMineCountLeft(count);
	}

	/**
	 * ������Ϸ �����ü�ʱ��������ʣ��������ֵ������������ΪЦ��������������ˢ�½���
	 */
	public void resetGame() {// ������Ϸ ��״̬�����׽�������
		// ˢ��ɨ�׽���
		this.jMineMatrixPanel.resetGame();// ����ò�������� ��ʵû���� ������û�м�pack���.
		this.statusPanel.setLEDMineCountLeft(this.jMineMatrixPanel
				.getMineCount());//��jMinematrixpanel�е�count����statusPanel��led
		this.statusPanel.setFaceSmile();
		this.statusPanel.resetTimer();// ���ü�ʱ��
		this.jMineMatrixPanel.refreshMineMatrixPanel();
		this.pack();
	}




	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * ���ڴ���С���лָ�������������ʱ��
	 */
	@Override
	public void windowDeiconified(WindowEvent e) {
		this.statusPanel.setTimerStart();
	}

	/**
	 * ������С��ʱ��ֹͣ��ʱ��
	 */
	@Override
	public void windowIconified(WindowEvent e) {
		this.statusPanel.setTimerStop();
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * ���ÿɷ���
	 * 
	 * @param b
	 *            ���ֵ
	 */
	public void setMarkable(boolean b) {
		this.jMineMatrixPanel.setMarkable(b);
	}
}
