import java.awt.Point;
import java.util.Vector;
public class FindSafeArea
{
  public FindSafeArea()
  {
  }
 public Vector 确定无雷连通区(int i,int j,Block block[][],int 行数, int 列数)
  {
         Vector  area=new Vector();
         if(block[i][j].周围无雷==true)
            {
              area.add(new Point(i,j));
            }
         for(int index=0;index<area.size();index++) 
             {
              Point p=(Point)area.get(index);
              int m=p.x;
              int n=p.y;
              for(int k=Math.max(m-1,1);k<=Math.min(m+1,行数);k++)
               { for(int t=Math.max(n-1,1);t<=Math.min(n+1,列数);t++)
                 { 
                   if(block[k][t].周围无雷==true&&block[k][t].获取探雷标记()!=0)
                     {
                       Point addPoint=new Point(k,t);
                       if(!(area.contains(addPoint)))
                         {
                           area.add(addPoint);
                         }
                     }
                 }
                
               }
            } 
        return area;
  }
} 
