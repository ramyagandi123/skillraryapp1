package genericLibraries;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * This class contain reusability of java
 * @author ramya
 *
 */
public class JavaUtility {
	/**
	 * This method generate random number within the specified limit
	 * @param limit
	 * @return
	 */
public int generateRandomNum(int limit) {
	  Random random = new Random();
	  return random.nextInt(limit);
   }
/**
 * This method generates current time
 */
public String geytCurrentTime() {
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yy_hh_mm_ss");
	return sdf.format(date);
    }
}
