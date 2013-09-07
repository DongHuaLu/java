public class DetermineMineMarkIsRightOrWrong
{
    FindAroundMineMarkNumber  确定周围雷标数目者=new FindAroundMineMarkNumber();
      int 周围雷标数=0;
      int 周围雷数=0;

  public DetermineMineMarkIsRightOrWrong()
   {
   }
  public boolean 判断雷标记是否正确(int i,int j,Block block[][],int 行数, int 列数)
  {  
     int 错误=0;
     boolean correct=false;
     周围雷标数=确定周围雷标数目者.获取周围雷标记的数目(i,j,block,行数,列数);
     周围雷数=block[i][j].获取周围的雷数();
     for(int k=Math.max(i-1,1);k<=Math.min(i+1,行数);k++)
                  { for(int t=Math.max(j-1,1);t<=Math.min(j+1,列数);t++)
                      { if(block[k][t].获取探雷标记()==0&&block[k][t].判断是否是雷()==false)
                        错误++; 
                      }
                  }
     if(错误>0)
         {
            correct=false;
         }
    else if(错误==0&&周围雷标数==周围雷数)
         { 
            correct=true;
         }
    return correct;
  } 
}
