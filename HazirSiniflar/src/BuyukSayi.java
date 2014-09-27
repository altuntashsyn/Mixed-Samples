import java.math.BigInteger;


public class BuyukSayi {

	public static void main(String[] args) {
		
		BigInteger big1 = new BigInteger("123456789123456789123456789");
		BigInteger big2 = new BigInteger("123456789123456789123456789");
		BigInteger toplam = big1.add(big2);
		BigInteger carpim = big1.multiply(big2);
		System.out.println(toplam);
		System.out.println(carpim);
	}

}
