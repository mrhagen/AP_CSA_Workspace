/*
 * John Hagen
 * This program runs ASCLland
 * 7/18/2016
 */

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class ASCLlandClientRunner {

	public static void main(String[] args) throws IOException
	{
		Scanner inFile = new Scanner(new File("SampleRolls.txt"));
		
		int roll;
		Player playerA;
		Player playerB;
		boolean done;
		
		//Play game
		for (int game = 1; game <= 5; game++) {
			playerA = new Player("Walter");
			playerB = new Player("Ellen");
			done = false;
			
			while (!done) {
				// PlayerA
				roll = inFile.nextInt();
				if (roll == 0) {
					done = true;
				}
				if (!done) {
					playerA.move(roll);
					if (playerA.getLocation() >= 40) {
						done = true;
						inFile.nextLine();
					}
					else if (playerA.collision(playerB)) {
						playerB.setLocation(0);
					}
				}
				
				// PlayerB
				if (!done) {
					roll = inFile.nextInt();					
				}
				if (roll == 0) {
					done = true;
				}
				if (!done) {
					playerB.move(roll);
					if (playerB.getLocation() >= 40) {
						done = true;
						inFile.nextLine();
					}
					else if (playerB.collision(playerB)) {
						playerA.setLocation(0);
					}					
				}
			}
			System.out.println(playerA + " " + playerB);
		}
		
		inFile.close();
	};

}
