import java.awt.Point;
import java.util.Vector;
import javax.swing.Icon;
import javax.swing.ImageIcon;
public class RandomSetMine
{
   Vector v=null;
   Icon 雷的图标;  
   public RandomSetMine()
    {
      雷的图标=new ImageIcon("地雷.gif");
    }
   public void 随机布雷(int number,Block block[][],int 行数, int 列数)
   {
       v=new Vector();
       int length=1,i=0,j=0;
       int leiNumber=0;
       for(i=1;i<=行数;i++)
         {
            for(j=1;j<=列数;j++)
              v.add(new Point(i,j));
         }
       while(leiNumber<number) 
         {  length=v.size();
            int n=(int)(Math.random()*length);
            Point p=(Point)v.elementAt(n);
            i=(int)p.getX();
            j=(int)p.getY();
            block[i][j].设置是否是雷(true);
            block[i][j].设置是雷时的图标(雷的图标);
            leiNumber=leiNumber+1;
            v.remove(n);
         }  
       v.removeAllElements();
       v=null; 
   }
}
