package TestDate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate02 {
	public static void main(String[] args) {

		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String enddate="2012-8-11 00:00:00";
		try {
			Date d=new Date();
			long times=d.getTime();
			Date enddates=sdf.parse(enddate);

			long st=enddates.getTime()-times;
			System.out.println(st);
			long day=(st/((long)1000*60*60*24));
			System.out.println(day);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
	
	}
}
