import java.math.BigInteger;


public class BuyukFaktoriyel {

	public static void main(String[] args) {

		int n = 1000;
		/*
		int fakt = 1;
		
		for (int i =1; i<=0; i++)
		{
			fakt *=i;
			System.out.println(fakt);
			*/
		BigInteger fakt = BigInteger.ONE;
		for (int i = 1; i<= n; i++)
		{
			fakt=fakt.multiply(BigInteger.valueOf(i));
		}
		System.out.println(fakt);
	}

}
