import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
public class MineSquare extends JPanel implements MouseListener
{ 
  int rows=10,cols=10,雷数=10;
  JButton buttonFace=null;
  Block block[][];             
  TimeCount time;              
  CountMine count;            
  String grade=null;          
  RandomSetMine 随机布雷者;
  FindAroundMineNumber 确定周围雷数者;
  FindSafeArea  找出无雷连通区者;
  DetermineDigArea 成片挖开者;
  DetermineMineMarkIsRightOrWrong 确定雷标记是否正确者;
  FindAroundMineMarkNumber 确定周围雷标数目者;
  DecideWinner 判断是否胜利者; 
  Record 记录对话框=null;
  public MineSquare(String grade,int mineNumber,int rows, int cols,JButton b,JDialog dialog)
   { 
     this.grade=grade;
     this.rows=rows;
     this.cols=cols;
     雷数=mineNumber;
     判断是否胜利者=new DecideWinner();
     记录对话框=(Record)dialog;
     block=new Block[rows+1][cols+1];
     buttonFace=b;
     time=new TimeCount();
     count=new CountMine(雷数);
     count.textShowMine.setText(""+雷数);
     setLayout(new GridLayout(rows,cols));
     for(int i=1;i<=rows;i++)
       {for(int j=1;j<=cols;j++)
         { 
           block[i][j]=new Block();
           block[i][j].设置在雷区中的位置(i,j);
         }
       }
     for(int i=1;i<=rows;i++)
       {for(int j=1;j<=cols;j++)
         { 
           add(block[i][j].label);
           block[i][j].addMouseListener(this);
         }
       }
     随机布雷者=new RandomSetMine();
     随机布雷者.随机布雷(雷数,block,rows,cols);
     确定周围雷数者=new FindAroundMineNumber();
     for(int i=1;i<=rows;i++)
       {for(int j=1;j<=cols;j++)
          {        
           确定周围雷数者.设置周围的雷数(i,j,block,rows,cols);
          }
       }
   }
 public void gameOver()
  {
      time.interrupt();
      buttonFace.setIcon(new ImageIcon("哭脸.gif"));
      for(int i=1;i<=rows;i++)
       { for(int j=1;j<=cols;j++)
          {
            block[i][j].removeMouseListener(this);
            if(block[i][j].判断是否是雷()&&block[i][j].isOpaque()&&block[i][j].探雷标记!=0)
               { 
                  block[i][j].requestFocus();
                  block[i][j].setOpaque(false);  
               }
            if(block[i][j].探雷标记==0&&!block[i][j].判断是否是雷())
               { 
                 block[i][j].requestFocus();
                 block[i][j].探雷标记=-1;   
                 block[i][j].repaint();
                 block[i][j].setIcon(new ImageIcon("探雷错误.gif")); 
               }
          }
       }
  } 
 public void mousePressed(MouseEvent e)
  { 
    boolean left=SwingUtilities.isLeftMouseButton(e);
    boolean right=SwingUtilities.isRightMouseButton(e);
    Block blockSource=(Block)e.getSource();
    boolean 雷=blockSource.判断是否是雷();
   if(left==true&&blockSource.isOpaque()==true&&blockSource.获取探雷标记()!=0)
   {   
       try{time.start();  
       }                  
       catch(Exception ee){   
       }
       if(雷==true)
          {  
           blockSource.requestFocus();
           blockSource.setOpaque(false);   
           blockSource.探雷标记=-1;
           blockSource.repaint();
           blockSource.setIcon(new ImageIcon("触雷.gif"));
           gameOver();                    
          }
       else
          {  
            buttonFace.setIcon(new ImageIcon("微笑脸.gif"));
            if(blockSource.周围无雷==false&&blockSource.获取探雷标记()!=0)  
              {
               blockSource.setOpaque(false);  
               blockSource.探雷标记=-1;
               blockSource.repaint();
              }
           
            if(blockSource.周围无雷==true&&blockSource.isOpaque())
              { 
               blockSource.setOpaque(false);     
               Point blockPoint=(Point)blockSource.获取在雷区中的位置();
               int i=blockPoint.x;
               int j=blockPoint.y;
               找出无雷连通区者=new FindSafeArea();
               Vector tree=找出无雷连通区者.确定无雷连通区(i,j,block,rows,cols);
               for(int index=0;index<tree.size();index++)
                 {  
                  Point p=(Point)tree.elementAt(index);
                  int m=p.x,n=p.y;
                  for(int k=Math.max(m-1,1);k<=Math.min(m+1,rows);k++)
                    { 
                      for(int t=Math.max(n-1,1);t<=Math.min(n+1,cols);t++)
                      {
                        if(block[k][t].探雷标记==0)
                            {  
                               gameOver();
                            }
                        else{  
                             block[k][t].requestFocus();
                             block[k][t].setOpaque(false);  
                             block[k][t].探雷标记=-1;
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
      if(blockSource.探雷标记==0&&blockSource.isOpaque())
         {                                             
           count.countMineSub();                      
         }
      if(blockSource.探雷标记==1&&blockSource.isOpaque())
         {                                           
           count.countMineAdd();                    
         }
    }
 }
 public void mouseEntered(MouseEvent e)
  {}
 public void mouseReleased(MouseEvent e)
  { 
    boolean success=判断是否胜利者.判断是否成功(雷数,block,rows,cols);
    if(success==true)
    { 
           time.interrupt();                        
           记录对话框.setGrade(grade);             
           int spendTime=Integer.parseInt(time.textShowTime.getText());  
           记录对话框.setTime(spendTime);
          
           File f=new File("英雄榜.txt");
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
                   记录对话框.setVisible(true);                     
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
      Point blockPoint=(Point)blockSource.获取在雷区中的位置();
               int i=blockPoint.x;
               int j=blockPoint.y;
      确定周围雷标数目者=new FindAroundMineMarkNumber();
      int 周围雷标数=确定周围雷标数目者.获取周围雷标记的数目(i,j,block,rows,cols);
      int 周围雷数=blockSource.获取周围的雷数();
      确定雷标记是否正确者=new DetermineMineMarkIsRightOrWrong();
      boolean correct=确定雷标记是否正确者.判断雷标记是否正确(i,j,block,rows,cols);
      if(blockSource.isOpaque()==false&&周围雷数>0&&correct)
       {  
          成片挖开者=new DetermineDigArea();
          Vector tree=成片挖开者.确定成片挖开区域(i,j,block,rows,cols);
          for(int index=0;index<tree.size();index++)
             {
                Point p=(Point)tree.elementAt(index);
                int m=p.x,n=p.y;
                for(int k=Math.max(m-1,1);k<=Math.min(m+1,rows);k++)
                   {
                    
                     for(int t=Math.max(n-1,1);t<=Math.min(n+1,cols);t++)
                      { 
                         if(block[k][t].isOpaque()&&!block[k][t].判断是否是雷()&&
                            block[k][t].探雷标记!=0)
                          {
                            block[k][t].requestFocus();
                            block[k][t].setOpaque(false);  
                            block[k][t].探雷标记=-1;
                            block[k][t].repaint();
                          }
                        repaint();
                      } 
                    }
              }
           tree.removeAllElements();
       } 
       if(blockSource.isOpaque()==false&&周围雷标数==周围雷数&&!correct)
       { 
         gameOver();                  
       }
      if((blockSource.isOpaque())==false&&(周围雷标数!=周围雷数))
       {
       }
   }
  }
}
