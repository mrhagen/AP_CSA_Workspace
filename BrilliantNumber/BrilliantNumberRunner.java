/*
 * John Hagen
 * This program runs the BrilliantNumber class
 * 7/18/2016
 */

import java.util.Scanner;
import java.io.File;
import java.io.IOException;


public class BrilliantNumberRunner {

	public static void main(String[] args) throws IOException
	{
		Scanner inFile = new Scanner(new File("BrilliantNumberCandidates.txt"));

		BrilliantNumber brilliantNumber;
		long curLong;

		for (int curNumber = 1; curNumber <=5; curNumber++) {
			curLong = inFile.nextLong();
			brilliantNumber = new BrilliantNumber(curLong);

			System.out.println(curLong);
			System.out.println(brilliantNumber.isBrilliant());
			System.out.println();			
		}
		
		inFile.close();
	}

};
