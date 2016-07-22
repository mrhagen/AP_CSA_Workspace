/*
 * John Hagen
 * This class works with a player in the ASCIland game.
 * 7/18/2016
 */

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Player {
	private int location;
	private String name;
	
	public Player (String n) {
		location = 0;
		name = n;
	}
	
	public int getLocation() {
		return location;
	}
	
	public void setLocation(int s) {
		location = s;
	}
	
    public void move(int r)
    {
    	if (r == 4 || r ==6) {
    		location -= r;
    	}
    	else {
    		location += r;
    	}
    	
    	if (location < 0) {
    		location = 0;
    	}
    }
    
    public boolean collision(Player other) {
    	return getLocation() == other.getLocation();
    }
    
    public String toString() {
    	String str = new String();
    	str = name + " = ";

    	if (getLocation() == 0) {
    		str += "START";
    	}
    	else if (getLocation() >= 40) {
    		str += "END";
    	}
    	else {
    		str += getLocation();
    	}
    	
    	return str;
    }
}
