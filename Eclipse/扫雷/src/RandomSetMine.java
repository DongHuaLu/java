import java.awt.Point;
import java.util.Vector;
import javax.swing.Icon;
import javax.swing.ImageIcon;
public class RandomSetMine
{
   Vector v=null;
   Icon �׵�ͼ��;  
   public RandomSetMine()
    {
      �׵�ͼ��=new ImageIcon("����.gif");
    }
   public void �������(int number,Block block[][],int ����, int ����)
   {
       v=new Vector();
       int length=1,i=0,j=0;
       int leiNumber=0;
       for(i=1;i<=����;i++)
         {
            for(j=1;j<=����;j++)
              v.add(new Point(i,j));
         }
       while(leiNumber<number) 
         {  length=v.size();
            int n=(int)(Math.random()*length);
            Point p=(Point)v.elementAt(n);
            i=(int)p.getX();
            j=(int)p.getY();
            block[i][j].�����Ƿ�����(true);
            block[i][j].��������ʱ��ͼ��(�׵�ͼ��);
            leiNumber=leiNumber+1;
            v.remove(n);
         }  
       v.removeAllElements();
       v=null; 
   }
}
