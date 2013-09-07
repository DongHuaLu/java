import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class Block extends JButton implements MouseListener
{ 
  boolean 雷=false,
          周围无雷=true;
  int 周围的雷数=0;
  int 探雷标记=-1;
  JLabel label;
  Point p;
  public Block()
  { 
    label=new JLabel(); 
    setBorder(BorderFactory.createMatteBorder(1,
                                              1,
                                              0,
                                              0,
                                            Color.lightGray));
   label.setBorder(BorderFactory.createMatteBorder(1,
                                              1,
                                              0,
                                              0,
                                            Color.lightGray));
    label.setHorizontalAlignment(JLabel.CENTER);
    label.setLayout(new BorderLayout());
    label.add(this,BorderLayout.CENTER);
    p=new Point(0,0);
    addMouseListener(this);
   
  } 
  public void 设置是否是雷(boolean b)
  { 
    雷=b;
  }
  public boolean 判断是否是雷()
  {
    return 雷;
  }      
  public void 设置是雷时的图标(Icon icon)
  {
    label.setIcon(icon);
  }
  public void 设置周围无雷时的图标(Icon icon)
  { 
   label.setIcon(icon);
  }
  public void 设置周围有雷时的名字(String name)
  { 
    label.setText(name);
  }
  public String 获取名字()
  { 
    return label.getText();
  }
  public void 设置周围的雷数(int n)
  {
     周围的雷数=n;
  }
  public int 获取周围的雷数()
  {
    return 周围的雷数;
  }
  public void 设置在雷区中的位置(int i,int j)
  {
    p=new Point(i,j);
  }
 public Point 获取在雷区中的位置()
  {
    return p; 
  }
 public int 获取探雷标记()
  {
   return 探雷标记;
  }
 public void mousePressed(MouseEvent e)
  { 
    boolean right=SwingUtilities.isRightMouseButton(e);
   
    if((right==true)&&(this.isOpaque()==true))
    { 
      
      探雷标记=(探雷标记+1)%3;
      repaint();
    }  
  }
 public void paintComponent(Graphics g)
  {
      super.paintComponent(g);
      if(探雷标记==0)
       {
         g.setColor(Color.red);
         g.fillRect(6,4,8,6);
         g.drawLine(13,10,14,18); 
       }
      if(探雷标记==1)
       {
        g.setColor(Color.blue);
        g.drawString("?",6,15);
       }
   }
 public void mouseEntered(MouseEvent e)
  {}
 public void mouseReleased(MouseEvent e)
  {}
 public void mouseExited(MouseEvent e)
  {}
 public void mouseClicked(MouseEvent e)
  {}
}
