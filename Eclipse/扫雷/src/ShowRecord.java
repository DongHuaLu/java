import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class ShowRecord extends JDialog implements ActionListener
{ 
  File f=new File("Ӣ�۰�.txt");
  String name=null;
  Hashtable hashtable=null;
  JButton ȷ��,���¼Ƿ�;
  JLabel label����[],label�м�[],label�߼�[];
  public ShowRecord(JFrame frame,Hashtable h)
  {
    super(frame,"ɨ��Ӣ�۰�");
    hashtable=h;
    setBounds(100,100,320,185);
    setResizable(false);
    setVisible(false);
    setModal(true); 
    label����=new JLabel[3];
    label�м�=new JLabel[3];
    label�߼�=new JLabel[3];
    for(int i=0;i<3;i++)
     {
      label����[i]=new JLabel();
      label����[i].setBorder(null);
      label�м�[i]=new JLabel();
      label�м�[i].setBorder(null);
      label�߼�[i]=new JLabel();
      label�߼�[i].setBorder(null);
     } 
    label����[0].setText("����");
    label����[1].setText(""+999); 
    label����[1].setText("����");  
    label�м�[0].setText("�м�");
    label�м�[1].setText(""+999); 
    label�м�[1].setText("����");
    label�߼�[0].setText("�߼�");
    label�߼�[1].setText(""+999); 
    label�߼�[1].setText("����"); 
    JPanel pCenter=new JPanel();
    pCenter.setLayout(new GridLayout(3,3)); 
    for(int i=0;i<3;i++)
     {
      pCenter.add(label����[i]);
     } 
    for(int i=0;i<3;i++)
     {
      pCenter.add(label�м�[i]);
     }
    for(int i=0;i<3;i++)
     {
      pCenter.add(label�߼�[i]);
     }
    pCenter.setBorder(BorderFactory.createTitledBorder("ɨ��Ӣ�۰�"));           
    ȷ��=new JButton("ȷ��");
    ���¼Ƿ�=new JButton("���¼Ƿ�");
    ȷ��.addActionListener(this);
    ���¼Ƿ�.addActionListener(this);
    JPanel pSouth=new JPanel();
    pSouth.setLayout(new FlowLayout(FlowLayout.RIGHT));
    pSouth.add(���¼Ƿ�);
    pSouth.add(ȷ��);
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
 public void ��ʾ��¼()
   {
      try{
          FileInputStream in=new FileInputStream(f);
          ObjectInputStream object_in=new ObjectInputStream(in);
          hashtable=(Hashtable)object_in.readObject();
          object_in.close();
          in.close(); 
          String temp=(String)hashtable.get("����");
          StringTokenizer fenxi=new StringTokenizer(temp,"#");
          label����[0].setText(fenxi.nextToken());
          label����[1].setText(fenxi.nextToken());
          label����[2].setText(fenxi.nextToken());  
          temp=(String)hashtable.get("�м�");
          fenxi=new StringTokenizer(temp,"#");
          label�м�[0].setText(fenxi.nextToken());
          label�м�[1].setText(fenxi.nextToken());
          label�м�[2].setText(fenxi.nextToken());  
          temp=(String)hashtable.get("�߼�");
          fenxi=new StringTokenizer(temp,"#");
          label�߼�[0].setText(fenxi.nextToken());
          label�߼�[1].setText(fenxi.nextToken());
          label�߼�[2].setText(fenxi.nextToken()); 
        }
     catch(Exception e)
        {
           System.out.println(e);
        }
  }
  public void actionPerformed(ActionEvent e)
  { 
    if(e.getSource()==���¼Ƿ�)
     {
       hashtable.put("����","����#"+999+"#����"); 
       hashtable.put("�м�","�м�#"+999+"#����");
       hashtable.put("�߼�","�߼�#"+999+"#����");
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
    if(e.getSource()==ȷ��)
     {
       setVisible(false);
       dispose();
     }  
  }
}
