import java.util.ArrayList;
import java.util.List;

public class fram {
	public static void main(String[] args) {
		ArrayList<Sheep> totalSheep = new ArrayList<Sheep>();
		Sheep sheep = new Sheep();
		sheep.setAge(1);
		totalSheep.add(sheep);
		fram f=new fram();
		for (int i = 0; i < 15; i++) {
			f.newSheep(totalSheep);
			f.aYear(totalSheep);
		}
		System.out.println(totalSheep.size());

	}

	public List<Sheep> newSheep(ArrayList<Sheep> totalSheep) {
		for (int i=0;i<totalSheep.size();i++)
		{
			if (totalSheep.get(i).getAge() > 4) {
				Sheep sheep = new Sheep();
				sheep.setAge(1);
				totalSheep.add(sheep);
			}
		}
		return totalSheep;
	}

	public List<Sheep> aYear(List<Sheep> totalSheep) {
		for (Sheep s : totalSheep) {
			s.setAge(s.getAge() + 1);
		}
		return totalSheep;
	}
	
	
	protected  int method1(int a,int b){
		return 0;
	}
	
}
