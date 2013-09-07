import javax.swing.*;
import java.awt.*;
public class CountMine 
{
  int number;
  JTextField textShowMine;
  public CountMine(int number)
  {
    this.number=number;
    textShowMine=new JTextField(5);
    textShowMine.setFont(new Font("Plaint",Font.BOLD,24)); 
  }
  public void countMineSub()
  {
    number--;
    if(number<=0) number=0;
    textShowMine.setText(""+number);
  }
  public void countMineAdd()
  {
    number++;
    textShowMine.setText(""+number);
  }
}
