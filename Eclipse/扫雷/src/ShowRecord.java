import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class ShowRecord extends JDialog implements ActionListener
{ 
  File f=new File("英雄榜.txt");
  String name=null;
  Hashtable hashtable=null;
  JButton 确定,重新记分;
  JLabel label初级[],label中级[],label高级[];
  public ShowRecord(JFrame frame,Hashtable h)
  {
    super(frame,"扫雷英雄榜");
    hashtable=h;
    setBounds(100,100,320,185);
    setResizable(false);
    setVisible(false);
    setModal(true); 
    label初级=new JLabel[3];
    label中级=new JLabel[3];
    label高级=new JLabel[3];
    for(int i=0;i<3;i++)
     {
      label初级[i]=new JLabel();
      label初级[i].setBorder(null);
      label中级[i]=new JLabel();
      label中级[i].setBorder(null);
      label高级[i]=new JLabel();
      label高级[i].setBorder(null);
     } 
    label初级[0].setText("初级");
    label初级[1].setText(""+999); 
    label初级[1].setText("匿名");  
    label中级[0].setText("中级");
    label中级[1].setText(""+999); 
    label中级[1].setText("匿名");
    label高级[0].setText("高级");
    label高级[1].setText(""+999); 
    label高级[1].setText("匿名"); 
    JPanel pCenter=new JPanel();
    pCenter.setLayout(new GridLayout(3,3)); 
    for(int i=0;i<3;i++)
     {
      pCenter.add(label初级[i]);
     } 
    for(int i=0;i<3;i++)
     {
      pCenter.add(label中级[i]);
     }
    for(int i=0;i<3;i++)
     {
      pCenter.add(label高级[i]);
     }
    pCenter.setBorder(BorderFactory.createTitledBorder("扫雷英雄榜"));           
    确定=new JButton("确定");
    重新记分=new JButton("重新记分");
    确定.addActionListener(this);
    重新记分.addActionListener(this);
    JPanel pSouth=new JPanel();
    pSouth.setLayout(new FlowLayout(FlowLayout.RIGHT));
    pSouth.add(重新记分);
    pSouth.add(确定);
    Container con=getContentPane();
    con.add(pCenter,BorderLayout.CENTER);
    con.add(pSouth,BorderLayout.SOUTH) ;
    addWindowListener(new WindowAdapter()
                        {
                          public void windwoClosing(WindowEvent e)
                            {
                              setVisible(false);
                              dispose();
                            }
                        }
                     ); 
   }
 public void 显示记录()
   {
      try{
          FileInputStream in=new FileInputStream(f);
          ObjectInputStream object_in=new ObjectInputStream(in);
          hashtable=(Hashtable)object_in.readObject();
          object_in.close();
          in.close(); 
          String temp=(String)hashtable.get("初级");
          StringTokenizer fenxi=new StringTokenizer(temp,"#");
          label初级[0].setText(fenxi.nextToken());
          label初级[1].setText(fenxi.nextToken());
          label初级[2].setText(fenxi.nextToken());  
          temp=(String)hashtable.get("中级");
          fenxi=new StringTokenizer(temp,"#");
          label中级[0].setText(fenxi.nextToken());
          label中级[1].setText(fenxi.nextToken());
          label中级[2].setText(fenxi.nextToken());  
          temp=(String)hashtable.get("高级");
          fenxi=new StringTokenizer(temp,"#");
          label高级[0].setText(fenxi.nextToken());
          label高级[1].setText(fenxi.nextToken());
          label高级[2].setText(fenxi.nextToken()); 
        }
     catch(Exception e)
        {
           System.out.println(e);
        }
  }
  public void actionPerformed(ActionEvent e)
  { 
    if(e.getSource()==重新记分)
     {
       hashtable.put("初级","初级#"+999+"#匿名"); 
       hashtable.put("中级","中级#"+999+"#匿名");
       hashtable.put("高级","高级#"+999+"#匿名");
       try{
           FileOutputStream out=new FileOutputStream(f);
           ObjectOutputStream object_out=new ObjectOutputStream(out);
           object_out.writeObject(hashtable);
           object_out.close();
           out.close();
         }
       catch(IOException event)
         {
         }
       setVisible(false);
       dispose();
     }
    if(e.getSource()==确定)
     {
       setVisible(false);
       dispose();
     }  
  }
}
