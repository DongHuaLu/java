import java.awt.Point;
import java.util.Vector;
public class FindSafeArea
{
  public FindSafeArea()
  {
  }
 public Vector ȷ��������ͨ��(int i,int j,Block block[][],int ����, int ����)
  {
         Vector  area=new Vector();
         if(block[i][j].��Χ����==true)
            {
              area.add(new Point(i,j));
            }
         for(int index=0;index<area.size();index++) 
             {
              Point p=(Point)area.get(index);
              int m=p.x;
              int n=p.y;
              for(int k=Math.max(m-1,1);k<=Math.min(m+1,����);k++)
               { for(int t=Math.max(n-1,1);t<=Math.min(n+1,����);t++)
                 { 
                   if(block[k][t].��Χ����==true&&block[k][t].��ȡ̽�ױ��()!=0)
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
