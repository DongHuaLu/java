import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;
import java.io.*;
public class Game extends JFrame implements ActionListener
{ 
   JMenuBar bar;
   JMenu fileMenu;
   JMenuItem 初级,中级,高级,扫雷英雄榜;
   int grade=2;
   MineSquare 雷阵;
   JButton buttonPerson;
   Container con;
   JPanel box;
   File 英雄榜=new File("英雄榜.txt");
   Hashtable hashtable=null;
   Record 记录对话框=null;
   ShowRecord 显示英雄榜对话框=null;
   Game()
   {
    buttonPerson=new JButton(new ImageIcon("微笑脸.gif"));
    雷阵=new MineSquare("中级",40,16,16,buttonPerson,记录对话框);
    buttonPerson.addActionListener(this);
    con=getContentPane();
    con.add(雷阵,BorderLayout.CENTER);
    box=new JPanel();
    box.setLayout(new GridLayout(1,3));
    box.add(雷阵.count.textShowMine);
    box.add(buttonPerson);
    box.add(雷阵.time.textShowTime); 
    con.add(box,BorderLayout.NORTH); 
    setVisible(true);
   
    addWindowListener(new WindowAdapter()
      { public void windowClosing(WindowEvent e)
        { System.exit(0);
      	}
      });
    setBounds(100,50,360,380);
    
    bar=new JMenuBar();
    fileMenu=new JMenu("游戏");
    初级=new JMenuItem("初级");
    中级=new JMenuItem("中级");
    高级=new JMenuItem("高级");
    fileMenu.setMnemonic('G');
    初级.setMnemonic('B');
    中级.setMnemonic('I');
    高级.setMnemonic('E');
    扫雷英雄榜=new JMenuItem("扫雷英雄榜");  
    初级.setMnemonic('T');
    fileMenu.add(初级);
    fileMenu.add(中级);
    fileMenu.add(高级);
    fileMenu.add(扫雷英雄榜);
    bar.add(fileMenu);
    setJMenuBar(bar);
    初级.addActionListener(this);
    中级.addActionListener(this);
    高级.addActionListener(this);
    扫雷英雄榜.addActionListener(this);
    hashtable=new Hashtable();
    hashtable.put("初级","初级#"+999+"#匿名"); 
    hashtable.put("中级","中级#"+999+"#匿名");
    hashtable.put("高级","高级#"+999+"#匿名");
    记录对话框=new Record(this,hashtable);
    记录对话框.setGrade("高级");
    if(!英雄榜.exists())
     {
      try{
          FileOutputStream out=new FileOutputStream(英雄榜);
          ObjectOutputStream object_out=new ObjectOutputStream(out);
          object_out.writeObject(hashtable);
          object_out.close();
          out.close();
         }
      catch(IOException e)
         {
         }
     } 
    显示英雄榜对话框=new ShowRecord(this,hashtable);
    validate();
   }
  public void newGame(String grade,int number,int rows,int cols,int w,int h)
   {
     buttonPerson.setIcon(new ImageIcon("微笑脸.gif"));
     记录对话框.setGrade(grade);
     雷阵=new MineSquare(grade,number,rows,cols,buttonPerson,记录对话框);
     con.removeAll();
     box.removeAll();
     box.add(雷阵.count.textShowMine);
     box.add(buttonPerson);
     box.add(雷阵.time.textShowTime); 
     con.add(box,BorderLayout.NORTH);  
     con.add(雷阵,BorderLayout.CENTER);
     setBounds(10,10,w,h);
     
     validate();
   }
  public void actionPerformed(ActionEvent e)
   {
     
     if(e.getSource()==初级) 
       {  
          grade=1;
          newGame("初级",10,8,8,180,220);
       }
     if(e.getSource()==中级) 
       {
          grade=2;
          newGame("中级",40,16,16,360,380);
       }
      if(e.getSource()==高级) 
       {  
          grade=3;
          newGame("高级",99,22,22,500,520);
       }
       if(e.getSource()==扫雷英雄榜) 
       {  
         显示英雄榜对话框.显示记录();
         显示英雄榜对话框.setVisible(true);
         
       }
      if(e.getSource()==buttonPerson)
       {
         if(grade==1)
           {
             newGame("初级",10,8,8,180,220);
           }
         if(grade==2)
           {
             newGame("中级",40,16,16,360,380);
           }
         if(grade==3)
           {
             newGame("高级",99,22,22,500,520);
           }
       }
   }
 
  public static void main(String args[])
   { new Game();
   }
}
