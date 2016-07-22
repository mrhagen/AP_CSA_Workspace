/*
 * John Hagen
 * This special "brilliant number" holds its two prime number and
 * determines if it is brilliant.
 * 7/18/2016
 */

// import java.util.Scanner;
// import java.io.File;
// import java.io.IOException;

public class BrilliantNumber {
	private long brilliantNumber;
	private long prime1;
	private long prime2;
	private boolean primesExist;
	private boolean brillianceConfirmed;

	public BrilliantNumber(long iLong) {
		brilliantNumber = iLong;
		primesExist = false;
		brillianceConfirmed = false;
	}
	
	private void constructPrimes() {
		prime1 = getFirstPrime();
		if (prime1 > 0) {
			if (brilliantNumber % prime1 == 0) {
				prime2 = brilliantNumber / prime1;
				if (isPrime(prime2)) {
					primesExist = true;
				}
				else {
					prime2 = -1;
				}
			}
			else {
				prime2 = -1;
			}
		}
		else {
			prime2 = -1;
		}
	}
	
	private long getFirstPrime() {
		long retLong = -1;

		if (brilliantNumber % 2 == 0) {
			retLong = 2;
		}
		else {
			for (long n = 3; n < 999999; n += 2) {
				if (brilliantNumber % n == 0) {
					retLong = n;
					break;
				}
			}
		}

		return retLong;
	}

	private boolean isPrime(long iLong) {
		boolean retBool = true;

		if (iLong % 2 == 0) {
			retBool = false;
		}
		else {
			for (long n = 3; n < iLong; n += 2) {
				if (iLong % n == 0) {
					retBool = false;
					break;
				}
			}
		}
		
		return retBool;
	}

	private boolean primesHaveEqualChars() {
		return (numDigits(prime1) == numDigits(prime2));
	}

	private int numDigits(long numLong)
	{
		int len = 0;

		while (numLong >= 10)
		{
			numLong = numLong/10;
			len++;
		}

		return len;
	}

	public boolean isBrilliant() {
		constructPrimes();
		if (primesExist) {
			return (primesHaveEqualChars());
		}
		else {
			return false;
		}
	}

}
