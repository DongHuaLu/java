public class DecideWinner
{
 public boolean �ж��Ƿ�ɹ�(int ����,Block block[][],int rows,int cols)
  {
    boolean b=true;
    int number=0; 
    for(int i=1;i<=rows;i++)
      {
        for(int j=1;j<=cols;j++)
          {  
             
             boolean b1=block[i][j].�ж��Ƿ�����();
             int b2=block[i][j].��ȡ̽�ױ��();
             boolean b3=block[i][j].isOpaque();
             if(b1==true&&b2==0&&b3==true)
               { 
                 number++;
               }
             if(block[i][j].isOpaque()&&block[i][j].��ȡ̽�ױ��()!=0)
               {
                 b=false;
               }
          }
      }
    if(number==����&&b)
         return true;
    else
        return false; 
  }
}
