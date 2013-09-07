import java.awt.Point;
import java.util.Vector;
public class DetermineDigArea
{
 
  DetermineMineMarkIsRightOrWrong 确定雷标记是否正确者=null;
  public DetermineDigArea()
  {
    确定雷标记是否正确者=new DetermineMineMarkIsRightOrWrong();
  }
  public Vector 确定成片挖开区域(int i,int j,Block block[][],int 行数, int 列数)
  { 
         
         Vector  area=new Vector();
         area.add(new Point(i,j));
         for(int index=0;index<area.size();index++) 
           {
              Point p=(Point)area.get(index);
              int m=p.x,n=p.y;
              for(int k=Math.max(m-1,1);k<=Math.min(m+1,行数);k++)
               { for(int t=Math.max(n-1,1);t<=Math.min(n+1,列数);t++)
                 { 
                   boolean correct=确定雷标记是否正确者.判断雷标记是否正确(k,t,block,行数,列数);
                   if(block[k][t].周围无雷==true&&block[k][t].isOpaque()&&!block[k][t].判断是否是雷()
                      &&block[k][t].获取探雷标记()!=0)
                     {
                       Point addPoint=new Point(k,t);
                       if(!(area.contains(addPoint)))
                         {
                           area.add(addPoint);
                         }
                     }
                   if(!block[k][t].判断是否是雷()&&correct&&block[k][t].isOpaque()
                       &&block[k][t].获取探雷标记()!=0)
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
