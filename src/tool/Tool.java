package tool;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Tool {

    public static String addMonth(String pBaseDate,int pAdd) throws ParseException{
	    SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
	    Date baseDate = format.parse(pBaseDate);
	    Calendar cal= Calendar.getInstance();
	    cal.setTime(baseDate);
	    cal.add(Calendar.MONTH, pAdd);
	    return format.format(cal.getTime());
    }
    
}
