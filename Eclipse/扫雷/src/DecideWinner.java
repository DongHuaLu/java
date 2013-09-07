public class DecideWinner
{
 public boolean 判断是否成功(int 雷数,Block block[][],int rows,int cols)
  {
    boolean b=true;
    int number=0; 
    for(int i=1;i<=rows;i++)
      {
        for(int j=1;j<=cols;j++)
          {  
             
             boolean b1=block[i][j].判断是否是雷();
             int b2=block[i][j].获取探雷标记();
             boolean b3=block[i][j].isOpaque();
             if(b1==true&&b2==0&&b3==true)
               { 
                 number++;
               }
             if(block[i][j].isOpaque()&&block[i][j].获取探雷标记()!=0)
               {
                 b=false;
               }
          }
      }
    if(number==雷数&&b)
         return true;
    else
        return false; 
  }
}
