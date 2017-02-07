package tool;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
    
    /**
     * 对象序列化
     * @param obj
     * @return
     */
    public static byte[] serialize(Object obj){
    	ByteArrayOutputStream bos = new ByteArrayOutputStream();
    	try {
    		ObjectOutputStream oos = new ObjectOutputStream(bos);
			oos.writeObject(obj);
			byte[] bytes = bos.toByteArray();
			return bytes;
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	return null;
    }
    /**
     * 反序列化对象
     * @param bytes
     * @return
     */
    public static Object deserialize(byte[] bytes){
    	ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
    	ObjectInputStream ois;
		try {
			ois = new ObjectInputStream(bis);
			return ois.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    	return null;
    }
    
}
