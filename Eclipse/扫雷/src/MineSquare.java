import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
public class MineSquare extends JPanel implements MouseListener
{ 
  int rows=10,cols=10,����=10;
  JButton buttonFace=null;
  Block block[][];             
  TimeCount time;              
  CountMine count;            
  String grade=null;          
  RandomSetMine ���������;
  FindAroundMineNumber ȷ����Χ������;
  FindSafeArea  �ҳ�������ͨ����;
  DetermineDigArea ��Ƭ�ڿ���;
  DetermineMineMarkIsRightOrWrong ȷ���ױ���Ƿ���ȷ��;
  FindAroundMineMarkNumber ȷ����Χ�ױ���Ŀ��;
  DecideWinner �ж��Ƿ�ʤ����; 
  Record ��¼�Ի���=null;
  public MineSquare(String grade,int mineNumber,int rows, int cols,JButton b,JDialog dialog)
   { 
     this.grade=grade;
     this.rows=rows;
     this.cols=cols;
     ����=mineNumber;
     �ж��Ƿ�ʤ����=new DecideWinner();
     ��¼�Ի���=(Record)dialog;
     block=new Block[rows+1][cols+1];
     buttonFace=b;
     time=new TimeCount();
     count=new CountMine(����);
     count.textShowMine.setText(""+����);
     setLayout(new GridLayout(rows,cols));
     for(int i=1;i<=rows;i++)
       {for(int j=1;j<=cols;j++)
         { 
           block[i][j]=new Block();
           block[i][j].�����������е�λ��(i,j);
         }
       }
     for(int i=1;i<=rows;i++)
       {for(int j=1;j<=cols;j++)
         { 
           add(block[i][j].label);
           block[i][j].addMouseListener(this);
         }
       }
     ���������=new RandomSetMine();
     ���������.�������(����,block,rows,cols);
     ȷ����Χ������=new FindAroundMineNumber();
     for(int i=1;i<=rows;i++)
       {for(int j=1;j<=cols;j++)
          {        
           ȷ����Χ������.������Χ������(i,j,block,rows,cols);
          }
       }
   }
 public void gameOver()
  {
      time.interrupt();
      buttonFace.setIcon(new ImageIcon("����.gif"));
      for(int i=1;i<=rows;i++)
       { for(int j=1;j<=cols;j++)
          {
            block[i][j].removeMouseListener(this);
            if(block[i][j].�ж��Ƿ�����()&&block[i][j].isOpaque()&&block[i][j].̽�ױ��!=0)
               { 
                  block[i][j].requestFocus();
                  block[i][j].setOpaque(false);  
               }
            if(block[i][j].̽�ױ��==0&&!block[i][j].�ж��Ƿ�����())
               { 
                 block[i][j].requestFocus();
                 block[i][j].̽�ױ��=-1;   
                 block[i][j].repaint();
                 block[i][j].setIcon(new ImageIcon("̽�״���.gif")); 
               }
          }
       }
  } 
 public void mousePressed(MouseEvent e)
  { 
    boolean left=SwingUtilities.isLeftMouseButton(e);
    boolean right=SwingUtilities.isRightMouseButton(e);
    Block blockSource=(Block)e.getSource();
    boolean ��=blockSource.�ж��Ƿ�����();
   if(left==true&&blockSource.isOpaque()==true&&blockSource.��ȡ̽�ױ��()!=0)
   {   
       try{time.start();  
       }                  
       catch(Exception ee){   
       }
       if(��==true)
          {  
           blockSource.requestFocus();
           blockSource.setOpaque(false);   
           blockSource.̽�ױ��=-1;
           blockSource.repaint();
           blockSource.setIcon(new ImageIcon("����.gif"));
           gameOver();                    
          }
       else
          {  
            buttonFace.setIcon(new ImageIcon("΢Ц��.gif"));
            if(blockSource.��Χ����==false&&blockSource.��ȡ̽�ױ��()!=0)  
              {
               blockSource.setOpaque(false);  
               blockSource.̽�ױ��=-1;
               blockSource.repaint();
              }
           
            if(blockSource.��Χ����==true&&blockSource.isOpaque())
              { 
               blockSource.setOpaque(false);     
               Point blockPoint=(Point)blockSource.��ȡ�������е�λ��();
               int i=blockPoint.x;
               int j=blockPoint.y;
               �ҳ�������ͨ����=new FindSafeArea();
               Vector tree=�ҳ�������ͨ����.ȷ��������ͨ��(i,j,block,rows,cols);
               for(int index=0;index<tree.size();index++)
                 {  
                  Point p=(Point)tree.elementAt(index);
                  int m=p.x,n=p.y;
                  for(int k=Math.max(m-1,1);k<=Math.min(m+1,rows);k++)
                    { 
                      for(int t=Math.max(n-1,1);t<=Math.min(n+1,cols);t++)
                      {
                        if(block[k][t].̽�ױ��==0)
                            {  
                               gameOver();
                            }
                        else{  
                             block[k][t].requestFocus();
                             block[k][t].setOpaque(false);  
                             block[k][t].̽�ױ��=-1;
                             block[k][t].repaint();
                            }
                      } 
                    }
                 }
               tree.removeAllElements();                   
              }
          }
    }
   if(right)
    { 
      if(blockSource.̽�ױ��==0&&blockSource.isOpaque())
         {                                             
           count.countMineSub();                      
         }
      if(blockSource.̽�ױ��==1&&blockSource.isOpaque())
         {                                           
           count.countMineAdd();                    
         }
    }
 }
 public void mouseEntered(MouseEvent e)
  {}
 public void mouseReleased(MouseEvent e)
  { 
    boolean success=�ж��Ƿ�ʤ����.�ж��Ƿ�ɹ�(����,block,rows,cols);
    if(success==true)
    { 
           time.interrupt();                        
           ��¼�Ի���.setGrade(grade);             
           int spendTime=Integer.parseInt(time.textShowTime.getText());  
           ��¼�Ի���.setTime(spendTime);
          
           File f=new File("Ӣ�۰�.txt");
           try{
                FileInputStream in=new FileInputStream(f);
                ObjectInputStream object_in=new ObjectInputStream(in);
                Hashtable hashtable=(Hashtable)object_in.readObject();  
                object_in.close();
                in.close(); 
                String temp=(String)hashtable.get(grade);            
                StringTokenizer fenxi=new StringTokenizer(temp,"#"); 
                fenxi.nextToken();
                int recordTime=Integer.parseInt(fenxi.nextToken());  
                 if(spendTime<recordTime)                           
                   ��¼�Ի���.setVisible(true);                     
               }
            catch(Exception eee)
               {
               }
    } 
  }
 public void mouseExited(MouseEvent e)
  {}
 public void mouseClicked(MouseEvent e)
  {  
    if(SwingUtilities.isRightMouseButton(e)) 
    { Block blockSource=(Block)e.getSource();
      Point blockPoint=(Point)blockSource.��ȡ�������е�λ��();
               int i=blockPoint.x;
               int j=blockPoint.y;
      ȷ����Χ�ױ���Ŀ��=new FindAroundMineMarkNumber();
      int ��Χ�ױ���=ȷ����Χ�ױ���Ŀ��.��ȡ��Χ�ױ�ǵ���Ŀ(i,j,block,rows,cols);
      int ��Χ����=blockSource.��ȡ��Χ������();
      ȷ���ױ���Ƿ���ȷ��=new DetermineMineMarkIsRightOrWrong();
      boolean correct=ȷ���ױ���Ƿ���ȷ��.�ж��ױ���Ƿ���ȷ(i,j,block,rows,cols);
      if(blockSource.isOpaque()==false&&��Χ����>0&&correct)
       {  
          ��Ƭ�ڿ���=new DetermineDigArea();
          Vector tree=��Ƭ�ڿ���.ȷ����Ƭ�ڿ�����(i,j,block,rows,cols);
          for(int index=0;index<tree.size();index++)
             {
                Point p=(Point)tree.elementAt(index);
                int m=p.x,n=p.y;
                for(int k=Math.max(m-1,1);k<=Math.min(m+1,rows);k++)
                   {
                    
                     for(int t=Math.max(n-1,1);t<=Math.min(n+1,cols);t++)
                      { 
                         if(block[k][t].isOpaque()&&!block[k][t].�ж��Ƿ�����()&&
                            block[k][t].̽�ױ��!=0)
                          {
                            block[k][t].requestFocus();
                            block[k][t].setOpaque(false);  
                            block[k][t].̽�ױ��=-1;
                            block[k][t].repaint();
                          }
                        repaint();
                      } 
                    }
              }
           tree.removeAllElements();
       } 
       if(blockSource.isOpaque()==false&&��Χ�ױ���==��Χ����&&!correct)
       { 
         gameOver();                  
       }
      if((blockSource.isOpaque())==false&&(��Χ�ױ���!=��Χ����))
       {
       }
   }
  }
}
