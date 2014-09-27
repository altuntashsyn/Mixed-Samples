import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;


public class Tarih {

	public static void main(String[] args) {

		Date d = new Date();
		System.out.println(d);
		//Formatlama
		DateFormat df1= DateFormat.getDateInstance(DateFormat.FULL, Locale.FRANCE);
		DateFormat df2= DateFormat.getDateTimeInstance();

		String fm = df1.format(d);
		System.out.println(fm);
		
	}

}
