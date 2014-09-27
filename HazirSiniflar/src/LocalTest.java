import java.io.ObjectInputStream.GetField;
import java.util.Locale;


public class LocalTest {

	public static void main(String[] args) {

		Locale[] locales =  Locale.getAvailableLocales();
		for (int i=0; i<locales.length; i++)
		{
			Locale l = locales[i];
			System.out.println(l.getLanguage()+"-"+l.getCountry()+"-"+l.getVariant());
		}
		
	}

}
