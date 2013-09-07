import java.awt.Color;
import javax.swing.Icon;
import javax.swing.ImageIcon;
public class FindAroundMineNumber
{
  Icon 周围无雷的图标;
  public FindAroundMineNumber()
   {
    周围无雷的图标=new ImageIcon("无雷.gif");
   }
  public void 设置周围的雷数(int i,int j,Block block[][],int 行数, int 列数)
   {
     int 雷数=0;
     if(block[i][j].判断是否是雷()==false)
        { 
           for(int k=Math.max(i-1,1);k<=Math.min(i+1,行数);k++)
              { for(int t=Math.max(j-1,1);t<=Math.min(j+1,列数);t++)
                  {
                    if(block[k][t].判断是否是雷()==true)
                       雷数++; 
                  }
              }
           if(雷数>0)
              { block[i][j].周围无雷=false;
                block[i][j].设置周围有雷时的名字(""+雷数);
                block[i][j].设置周围的雷数(雷数); 
                if(雷数==1)
                    block[i][j].label.setForeground(Color.blue);
                if(雷数==2)
                    block[i][j].label.setForeground(new Color(0,100,0));
                if(雷数==3)
                    block[i][j].label.setForeground(Color.red);
                if(雷数>=4)
                    block[i][j].label.setForeground(new Color(0,0,100));
                  }
           else
              {  
                block[i][j].周围无雷=true;
                block[i][j].设置周围有雷时的名字("");
                block[i][j].设置周围的雷数(0); 
                block[i][j].设置周围无雷时的图标(周围无雷的图标);
              }
          
        }
  }  
} 
