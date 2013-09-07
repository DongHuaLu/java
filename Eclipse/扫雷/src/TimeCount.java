import java.awt.*;
import javax.swing.*;
public class TimeCount extends Thread
{
  JTextField textShowTime;
  int i=0;
  public TimeCount()
  {
    textShowTime=new JTextField(5);
    textShowTime.setEditable(false);
    textShowTime.setFont(new Font("Plaint",Font.BOLD,24)); 
    textShowTime.setHorizontalAlignment(JTextField.RIGHT);
  }
  public void run()
  { i=0;
    while(i<=999)
    {
      textShowTime.setText(""+i);
      i++;
      try{
         sleep(1000);
       }
      catch(InterruptedException e){
         break;
       }
    }
  } 
}
