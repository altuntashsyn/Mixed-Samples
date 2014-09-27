import java.text.NumberFormat;
import java.util.Locale;


public class FormatTest {

	public static void main(String[] args) {

		double d = 232323.2323423423;
		Locale turkce = new Locale("tr");
		Locale turkiye = new Locale("tr", "TR");
		//Hersey Turkce olsun
		Locale.setDefault(turkiye);
		
		
		NumberFormat nf1 = NumberFormat.getInstance();
		NumberFormat nf2 = NumberFormat.getNumberInstance();
		NumberFormat nf3 = NumberFormat.getCurrencyInstance();

		System.out.println(nf1.format(d));
		System.out.println(nf2.format(d));
		System.out.println(nf3.format(d));

	}

}
