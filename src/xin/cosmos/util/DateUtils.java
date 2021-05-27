package xin.cosmos.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * commons utils
 * @author ian
 *
 */
public class DateUtils {
	
	/**
	 * get current datetime with pattern yyyy-MM-dd HH:mm:ss
	 * 
	 * @author ian
	 * @return String
	 */
	public static String getCurdate() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(Calendar.getInstance().getTime());
	}

}
