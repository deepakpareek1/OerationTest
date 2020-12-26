/**
 * 
 */
package com.technogies.org;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author deepak
 *
 */
public class MainClass {

	/**
	 * 
	 */
	public MainClass() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		   
		String input = Utility.readInput();
		
		int result = Utility.performOperation(input);
		
		System.out.println("Output: "+result);
	}
	
	
	
}
