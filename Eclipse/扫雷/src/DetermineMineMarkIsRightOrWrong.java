public class DetermineMineMarkIsRightOrWrong
{
    FindAroundMineMarkNumber  ȷ����Χ�ױ���Ŀ��=new FindAroundMineMarkNumber();
      int ��Χ�ױ���=0;
      int ��Χ����=0;

  public DetermineMineMarkIsRightOrWrong()
   {
   }
  public boolean �ж��ױ���Ƿ���ȷ(int i,int j,Block block[][],int ����, int ����)
  {  
     int ����=0;
     boolean correct=false;
     ��Χ�ױ���=ȷ����Χ�ױ���Ŀ��.��ȡ��Χ�ױ�ǵ���Ŀ(i,j,block,����,����);
     ��Χ����=block[i][j].��ȡ��Χ������();
     for(int k=Math.max(i-1,1);k<=Math.min(i+1,����);k++)
                  { for(int t=Math.max(j-1,1);t<=Math.min(j+1,����);t++)
                      { if(block[k][t].��ȡ̽�ױ��()==0&&block[k][t].�ж��Ƿ�����()==false)
                        ����++; 
                      }
                  }
     if(����>0)
         {
            correct=false;
         }
    else if(����==0&&��Χ�ױ���==��Χ����)
         { 
            correct=true;
         }
    return correct;
  } 
}
