import java.awt.Point;
import java.util.Vector;
public class DetermineDigArea
{
 
  DetermineMineMarkIsRightOrWrong ȷ���ױ���Ƿ���ȷ��=null;
  public DetermineDigArea()
  {
    ȷ���ױ���Ƿ���ȷ��=new DetermineMineMarkIsRightOrWrong();
  }
  public Vector ȷ����Ƭ�ڿ�����(int i,int j,Block block[][],int ����, int ����)
  { 
         
         Vector  area=new Vector();
         area.add(new Point(i,j));
         for(int index=0;index<area.size();index++) 
           {
              Point p=(Point)area.get(index);
              int m=p.x,n=p.y;
              for(int k=Math.max(m-1,1);k<=Math.min(m+1,����);k++)
               { for(int t=Math.max(n-1,1);t<=Math.min(n+1,����);t++)
                 { 
                   boolean correct=ȷ���ױ���Ƿ���ȷ��.�ж��ױ���Ƿ���ȷ(k,t,block,����,����);
                   if(block[k][t].��Χ����==true&&block[k][t].isOpaque()&&!block[k][t].�ж��Ƿ�����()
                      &&block[k][t].��ȡ̽�ױ��()!=0)
                     {
                       Point addPoint=new Point(k,t);
                       if(!(area.contains(addPoint)))
                         {
                           area.add(addPoint);
                         }
                     }
                   if(!block[k][t].�ж��Ƿ�����()&&correct&&block[k][t].isOpaque()
                       &&block[k][t].��ȡ̽�ױ��()!=0)
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
