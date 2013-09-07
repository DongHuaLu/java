import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class Record extends JDialog implements ActionListener
{
  int time=0;
  String grade=null;
  String key=null;
  String message=null;
  Hashtable hashtable=null;
  JTextField textName; 
  JLabel label=null; 
  JButton ȷ��,ȡ��;
  public Record(JFrame frame,Hashtable h)
  {
    super(frame,"��¼��ĳɼ�");
    this.time=time; 
    this.grade=grade;
    hashtable=h;
    setBounds(100,100,240,160);
    setResizable(false);
    setVisible(false);
    setModal(true); 
    ȷ��=new JButton("ȷ��");
    ȡ��=new JButton("ȡ��");
    textName=new JTextField(8);
    textName.setText("����");
    ȷ��.addActionListener(this);
    ȡ��.addActionListener(this);
    Container con=getContentPane();
    con.setLayout(new GridLayout(2,1));
    label=new JLabel("��������...����,�������Ĵ����ϰ�");
    con.add(label);
    JPanel p=new JPanel();
    p.add(textName);
    p.add(ȷ��);
    p.add(ȡ��);
    con.add(p);
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
  public void setGrade(String grade)
  {
    this.grade=grade;
    label.setText("��������"+grade+"����,�������Ĵ����ϰ�");
  }
  public void setTime(int time)
  {
    this.time=time;
  }
  public void actionPerformed(ActionEvent e)
  { 
    if(e.getSource()==ȷ��)
     {
       message=grade+"#"+time+"#"+" "+textName.getText();
       key=grade;
       writeRecord(key,message);
       setVisible(false);
       dispose();
     }
    if(e.getSource()==ȡ��)
     {
       setVisible(false);
       dispose();
     }  
  }
  public void  writeRecord(String key,String message)
  {
     File f=new File("Ӣ�۰�.txt");
     try{
          FileInputStream in=new FileInputStream(f);
          ObjectInputStream object_in=new ObjectInputStream(in);
          hashtable=(Hashtable)object_in.readObject();
          object_in.close();
          in.close(); 
          String temp=(String)hashtable.get(key);
          StringTokenizer fenxi=new StringTokenizer(temp,"#");
          fenxi.nextToken();
          int n=Integer.parseInt(fenxi.nextToken());
          if(time<n) 
              {
                hashtable.put(key,message);
                FileOutputStream out=new FileOutputStream(f);
                ObjectOutputStream object_out=new ObjectOutputStream(out);
                object_out.writeObject(hashtable);
                object_out.close();
                out.close();
              }
         }
     catch(Exception e) 
         {
            System.out.println(e);
         }
   }
}
