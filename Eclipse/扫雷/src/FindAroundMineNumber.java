import java.awt.Color;
import javax.swing.Icon;
import javax.swing.ImageIcon;
public class FindAroundMineNumber
{
  Icon ��Χ���׵�ͼ��;
  public FindAroundMineNumber()
   {
    ��Χ���׵�ͼ��=new ImageIcon("����.gif");
   }
  public void ������Χ������(int i,int j,Block block[][],int ����, int ����)
   {
     int ����=0;
     if(block[i][j].�ж��Ƿ�����()==false)
        { 
           for(int k=Math.max(i-1,1);k<=Math.min(i+1,����);k++)
              { for(int t=Math.max(j-1,1);t<=Math.min(j+1,����);t++)
                  {
                    if(block[k][t].�ж��Ƿ�����()==true)
                       ����++; 
                  }
              }
           if(����>0)
              { block[i][j].��Χ����=false;
                block[i][j].������Χ����ʱ������(""+����);
                block[i][j].������Χ������(����); 
                if(����==1)
                    block[i][j].label.setForeground(Color.blue);
                if(����==2)
                    block[i][j].label.setForeground(new Color(0,100,0));
                if(����==3)
                    block[i][j].label.setForeground(Color.red);
                if(����>=4)
                    block[i][j].label.setForeground(new Color(0,0,100));
                  }
           else
              {  
                block[i][j].��Χ����=true;
                block[i][j].������Χ����ʱ������("");
                block[i][j].������Χ������(0); 
                block[i][j].������Χ����ʱ��ͼ��(��Χ���׵�ͼ��);
              }
          
        }
  }  
} 
