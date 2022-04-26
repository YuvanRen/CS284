package Hw4;

import static org.junit.jupiter.api.Assertions.assertFalse;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
public class JUnit {

	@Test
	public void test1() {
		Treap<Integer> testTree = new Treap<Integer>();
		assertTrue(testTree.add(4,19)); 
		assertTrue(testTree.add(2,31));
		assertTrue(testTree.add(6,70)); 
		assertTrue(testTree.add(1,84));
		assertTrue(testTree.add(3,12)); 
		assertTrue(testTree.add(5,83));
		assertTrue(testTree.add(7,26));
		
		assertTrue(testTree.find(1));
		assertFalse(testTree.find(123));
		assertTrue(testTree.delete(3));
		assertFalse(testTree.delete(534));
	}
	@Test
	public void test2() {
		Treap<Character> o = new Treap<Character>();
		assertTrue(o.add('A',12)); 
		assertTrue(o.add('B',95));
		assertTrue(o.add('C',7)); 
		assertTrue(o.add('D',84));
		assertTrue(o.add('E',3)); 
		assertTrue(o.add('F',81));
		assertTrue(o.add('G',268));		
		assertTrue(o.find('A'));
		assertFalse(o.find('Z'));
		assertTrue(o.delete('F'));
		assertFalse(o.delete('K'));
		assertFalse(o.find('R'));
	}
	

}
