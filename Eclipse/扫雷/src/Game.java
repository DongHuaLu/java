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
   JMenuItem ����,�м�,�߼�,ɨ��Ӣ�۰�;
   int grade=2;
   MineSquare ����;
   JButton buttonPerson;
   Container con;
   JPanel box;
   File Ӣ�۰�=new File("Ӣ�۰�.txt");
   Hashtable hashtable=null;
   Record ��¼�Ի���=null;
   ShowRecord ��ʾӢ�۰�Ի���=null;
   Game()
   {
    buttonPerson=new JButton(new ImageIcon("΢Ц��.gif"));
    ����=new MineSquare("�м�",40,16,16,buttonPerson,��¼�Ի���);
    buttonPerson.addActionListener(this);
    con=getContentPane();
    con.add(����,BorderLayout.CENTER);
    box=new JPanel();
    box.setLayout(new GridLayout(1,3));
    box.add(����.count.textShowMine);
    box.add(buttonPerson);
    box.add(����.time.textShowTime); 
    con.add(box,BorderLayout.NORTH); 
    setVisible(true);
   
    addWindowListener(new WindowAdapter()
      { public void windowClosing(WindowEvent e)
        { System.exit(0);
      	}
      });
    setBounds(100,50,360,380);
    
    bar=new JMenuBar();
    fileMenu=new JMenu("��Ϸ");
    ����=new JMenuItem("����");
    �м�=new JMenuItem("�м�");
    �߼�=new JMenuItem("�߼�");
    fileMenu.setMnemonic('G');
    ����.setMnemonic('B');
    �м�.setMnemonic('I');
    �߼�.setMnemonic('E');
    ɨ��Ӣ�۰�=new JMenuItem("ɨ��Ӣ�۰�");  
    ����.setMnemonic('T');
    fileMenu.add(����);
    fileMenu.add(�м�);
    fileMenu.add(�߼�);
    fileMenu.add(ɨ��Ӣ�۰�);
    bar.add(fileMenu);
    setJMenuBar(bar);
    ����.addActionListener(this);
    �м�.addActionListener(this);
    �߼�.addActionListener(this);
    ɨ��Ӣ�۰�.addActionListener(this);
    hashtable=new Hashtable();
    hashtable.put("����","����#"+999+"#����"); 
    hashtable.put("�м�","�м�#"+999+"#����");
    hashtable.put("�߼�","�߼�#"+999+"#����");
    ��¼�Ի���=new Record(this,hashtable);
    ��¼�Ի���.setGrade("�߼�");
    if(!Ӣ�۰�.exists())
     {
      try{
          FileOutputStream out=new FileOutputStream(Ӣ�۰�);
          ObjectOutputStream object_out=new ObjectOutputStream(out);
          object_out.writeObject(hashtable);
          object_out.close();
          out.close();
         }
      catch(IOException e)
         {
         }
     } 
    ��ʾӢ�۰�Ի���=new ShowRecord(this,hashtable);
    validate();
   }
  public void newGame(String grade,int number,int rows,int cols,int w,int h)
   {
     buttonPerson.setIcon(new ImageIcon("΢Ц��.gif"));
     ��¼�Ի���.setGrade(grade);
     ����=new MineSquare(grade,number,rows,cols,buttonPerson,��¼�Ի���);
     con.removeAll();
     box.removeAll();
     box.add(����.count.textShowMine);
     box.add(buttonPerson);
     box.add(����.time.textShowTime); 
     con.add(box,BorderLayout.NORTH);  
     con.add(����,BorderLayout.CENTER);
     setBounds(10,10,w,h);
     
     validate();
   }
  public void actionPerformed(ActionEvent e)
   {
     
     if(e.getSource()==����) 
       {  
          grade=1;
          newGame("����",10,8,8,180,220);
       }
     if(e.getSource()==�м�) 
       {
          grade=2;
          newGame("�м�",40,16,16,360,380);
       }
      if(e.getSource()==�߼�) 
       {  
          grade=3;
          newGame("�߼�",99,22,22,500,520);
       }
       if(e.getSource()==ɨ��Ӣ�۰�) 
       {  
         ��ʾӢ�۰�Ի���.��ʾ��¼();
         ��ʾӢ�۰�Ի���.setVisible(true);
         
       }
      if(e.getSource()==buttonPerson)
       {
         if(grade==1)
           {
             newGame("����",10,8,8,180,220);
           }
         if(grade==2)
           {
             newGame("�м�",40,16,16,360,380);
           }
         if(grade==3)
           {
             newGame("�߼�",99,22,22,500,520);
           }
       }
   }
 
  public static void main(String args[])
   { new Game();
   }
}
