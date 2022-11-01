// Java program to demonstrate how
// to use gcd method of BigInteger class

import java.math.BigInteger;

class Test {
	public static int gcd(int a, int b)
	{
		BigInteger b1 = BigInteger.valueOf(a);
		BigInteger b2 = BigInteger.valueOf(b);
		BigInteger gcd = b1.gcd(b2);
		return gcd.intValue();
	}

	public static long gcd(long a, long b)
	{
		BigInteger b1 = BigInteger.valueOf(a);
		BigInteger b2 = BigInteger.valueOf(b);
		BigInteger gcd = b1.gcd(b2);
		return gcd.longValue();
	}

	// Driver method
	public static void main(String[] args)
	{
		System.out.println(gcd(3, 5));
		System.out.println(gcd(10000000000L, 600000000L));
	}
}
