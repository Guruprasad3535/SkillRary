package genericLibraries;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/*
 * This class contains reusable methods to perform java related actions
 * @author gpss
 */

public class JavaUtility {

    /*
     * This method generates random number within the limit specified 
     * @param limit
     * @return
     */
	public int generateRandomNum(int limit) {
		
		Random random=new Random();
		return random.nextInt(limit);
	}
	
	/*
	 * This method generates currents time
	 * @return
	 */
	public String getCurrentTime() {
		
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd_MM_yy_hh_mm_sss");
		return sdf.format(date);
	}
	
}
