package com.technogies.org;

import java.lang.*; 
import java.util.*; 

public class Utility {

	public Utility() {
		
	}
	
	public static String readInput() {
		String str = "";
		Scanner sc= new Scanner(System.in); //System.in is a standard input stream
		try {
			System.out.println("Input: ");
			str= sc.nextLine(); //reads string
			sc.close();
		} catch (Exception ex) {
			System.out.println("Erro in reading input: " + ex.getMessage());
		} finally {
			sc.close();
		}
		return str;
	}
	
	public static int performOperation(String input) {
		int result = -1;
		
		ArrayList<Integer> numberStack = Utility.getNumberStack(input);
		ArrayList<String> operationStack = Utility.getOperationStack(input);
		
		if (numberStack.size() == 0 || operationStack.size() == 0) {
			return result;
		}
		
		for(String opr: operationStack) {
			
			switch(opr) {
				case "DUP":
					result = Utility.duplicateElement(numberStack);
					break;
				case "POP":
					result = Utility.removeElement(numberStack);
					break;
				case "+":
					result = Utility.addOperation(numberStack);
					break;
				case "-":
					result = Utility.subOperation(numberStack);
					break;
				default:
			}
			
			if (result == -1)
				return result;
		}
		
		return result;
	}
	
	public static boolean isStringInt(String s)
	{
	    try
	    {
	        Integer.parseInt(s);
	        return true;
	    } catch (NumberFormatException ex)
	    {
	        return false;
	    }
	}
	
	public static ArrayList<Integer> getNumberStack(String input) {
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		try {
			ArrayList<String> strList = new ArrayList<String>(Arrays.asList(input.split(" ")));
			for(String str : strList) {
				if (Utility.isStringInt(str)) {
					arrList.add(Integer.parseInt(str));
				}
				else {
					break;
				}
			}
		} catch (Exception ex) {
			System.out.println("Erro in preapring stack from input(integers) string: " + ex.getMessage());
		}
		return arrList;
	}
	
	public static ArrayList<String> getOperationStack(String input) {
		ArrayList<String> arrList = new ArrayList<String>();
		try {
			ArrayList<String> strList = new ArrayList<String>(Arrays.asList(input.split(" ")));
			for(String str : strList) {
				if (!Utility.isStringInt(str)) {
					arrList.add(str);
				}
				else if (arrList.size() > 0) {
					// Incorrect Input
					arrList.clear();
					break;
				}
			}
		} catch (Exception ex) {
			System.out.println("Erro in preapring stack from input(operations) string: " + ex.getMessage());
		}
		return arrList;
	}
	
	public static int duplicateElement(ArrayList<Integer> numberStack) {
		int result = -1;
		if (numberStack.size() > 0) {
			numberStack.add(numberStack.get(numberStack.size() - 1));
			result = numberStack.get(numberStack.size() - 1);
		}
		return result;
	}
	
	public static int removeElement(ArrayList<Integer> numberStack) {
		int result = -1;
		if (numberStack.size() > 0) {
			numberStack.remove(numberStack.size() - 1);
			result = numberStack.size() > 0 ? numberStack.get(numberStack.size() - 1) : -1;
		}
		return result;
	}
	
	public static int addOperation(ArrayList<Integer> numberStack) {
		int result = -1;
		if (numberStack.size() > 1) {
			int val1 = numberStack.get(numberStack.size() - 1);
			int val2 = numberStack.get(numberStack.size() - 2);
			numberStack.remove(numberStack.size() - 1);
			numberStack.remove(numberStack.size() - 1);
			numberStack.add(val1 + val2);
			result = numberStack.get(numberStack.size() - 1);
		}
		return result;
	}
	
	public static int subOperation(ArrayList<Integer> numberStack) {
		int result = -1;
		if (numberStack.size() > 1) {
			int val1 = numberStack.get(numberStack.size() - 1);
			int val2 = numberStack.get(numberStack.size() - 2);
			if (val1 >= val2) {
				numberStack.remove(numberStack.size() - 1);
				numberStack.remove(numberStack.size() - 1);
				numberStack.add(val1 - val2);
				result = numberStack.get(numberStack.size() - 1);
			}
		}
		return result;
	}

}
