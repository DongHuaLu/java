import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class Block extends JButton implements MouseListener
{ 
  boolean ��=false,
          ��Χ����=true;
  int ��Χ������=0;
  int ̽�ױ��=-1;
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
  public void �����Ƿ�����(boolean b)
  { 
    ��=b;
  }
  public boolean �ж��Ƿ�����()
  {
    return ��;
  }      
  public void ��������ʱ��ͼ��(Icon icon)
  {
    label.setIcon(icon);
  }
  public void ������Χ����ʱ��ͼ��(Icon icon)
  { 
   label.setIcon(icon);
  }
  public void ������Χ����ʱ������(String name)
  { 
    label.setText(name);
  }
  public String ��ȡ����()
  { 
    return label.getText();
  }
  public void ������Χ������(int n)
  {
     ��Χ������=n;
  }
  public int ��ȡ��Χ������()
  {
    return ��Χ������;
  }
  public void �����������е�λ��(int i,int j)
  {
    p=new Point(i,j);
  }
 public Point ��ȡ�������е�λ��()
  {
    return p; 
  }
 public int ��ȡ̽�ױ��()
  {
   return ̽�ױ��;
  }
 public void mousePressed(MouseEvent e)
  { 
    boolean right=SwingUtilities.isRightMouseButton(e);
   
    if((right==true)&&(this.isOpaque()==true))
    { 
      
      ̽�ױ��=(̽�ױ��+1)%3;
      repaint();
    }  
  }
 public void paintComponent(Graphics g)
  {
      super.paintComponent(g);
      if(̽�ױ��==0)
       {
         g.setColor(Color.red);
         g.fillRect(6,4,8,6);
         g.drawLine(13,10,14,18); 
       }
      if(̽�ױ��==1)
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
