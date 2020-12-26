package com.technogies.test;

import static org.junit.Assert.assertEquals;

import java.util.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.technogies.org.Utility;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OperationsTest {
	
	ArrayList<Integer> arrList = new ArrayList<Integer>(
		Arrays.asList(12,13,56,0,32));
	
	@Test
	@Order(1)
	public void PerformOprTest_1() {
		
		String input = "13 7 20 DUP - +";
		int result = Utility.performOperation(input);
		assertEquals(7, result);

	}
	
	@Test
	@Order(2)
	public void PerformOprTest_2() {
		
		String input = "13 20 12 7 - +";
		int result = Utility.performOperation(input);
		assertEquals(-1, result);		
	}
	
	@Test
	@Order(3)
	public void PerformOprTest_3() {
		
		String input = "13 20 7 12 - +";
		int result = Utility.performOperation(input);
		assertEquals(25, result);		
	}
	
	@Test
	@Order(4)
	public void PerformOprTest_4() {
		
		String input = "12 POP DUP";
		int result = Utility.performOperation(input);
		assertEquals(-1, result);		
	}
	
	@Test
	@Order(5)
	public void PerformOprTest_5() {
		
		String input = "12 +";
		int result = Utility.performOperation(input);
		assertEquals(-1, result);		
	}
	
	@Test
	@Order(6)
	public void PerformOprTest_6() {
		
		String input = "";
		int result = Utility.performOperation(input);
		assertEquals(-1, result);
	}
	
	@Test
	@Order(7)
	public void DuplicateElementTest() {
		
		int result = Utility.duplicateElement(arrList);
		assertEquals(32, result);
	}
	
	@Test
	@Order(8)
	public void RemoveElementTest() {
		
		int result = Utility.removeElement(arrList);
		assertEquals(0, result);
	}
	
	@Test
	@Order(9)
	public void AdditionOperationTest() {
		
		int result = Utility.addOperation(arrList);
		assertEquals(32, result);
	}
	
	@Test
	@Order(10)
	public void subtractOperationTest() {
		
		int result = Utility.subOperation(arrList);
		assertEquals(32, result);
	}

}
