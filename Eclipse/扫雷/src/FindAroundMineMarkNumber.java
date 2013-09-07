public class FindAroundMineMarkNumber
{
  public FindAroundMineMarkNumber()
   {
   }
  public int 获取周围雷标记的数目(int i,int j,Block block[][],int 行数, int 列数)
   {
     int 雷标记数=0;
     for(int k=Math.max(i-1,1);k<=Math.min(i+1,行数);k++)
        { 
          for(int t=Math.max(j-1,1);t<=Math.min(j+1,列数);t++)
            { 
             if(block[k][t].获取探雷标记()==0&&block[k][t].isOpaque())
               雷标记数++; 
            }
        }
     return 雷标记数; 
   }
} 
