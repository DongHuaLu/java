public class FindAroundMineMarkNumber
{
  public FindAroundMineMarkNumber()
   {
   }
  public int ��ȡ��Χ�ױ�ǵ���Ŀ(int i,int j,Block block[][],int ����, int ����)
   {
     int �ױ����=0;
     for(int k=Math.max(i-1,1);k<=Math.min(i+1,����);k++)
        { 
          for(int t=Math.max(j-1,1);t<=Math.min(j+1,����);t++)
            { 
             if(block[k][t].��ȡ̽�ױ��()==0&&block[k][t].isOpaque())
               �ױ����++; 
            }
        }
     return �ױ����; 
   }
} 
