package Hw4;
// Yuvan Rengifo
// I pledge my honor that I have abided by the Stevens Honor System
import java.util.Random;
import java.util.Stack;

public class Treap<E extends Comparable<E>>{

	private static class Node<E>{	
		
		// Node Data Fields
		public E data; 				// key for the search
		public int priority; 		// random heap priority
		public Node <E> left;
		public Node <E> right;
		
		
		// Node Constructor
		public Node(E data, int priority) {
			if(data ==null) {
				throw new IllegalArgumentException();
			}
			this.data =data;
			this.priority = priority;
			this.left = null;
			this.right = null;
		}
		/*
		 * Right rotation.
		 * updating the data, priority and pointers.
		 * Returning the reference to the root.
		 */
		public Node <E> rotateRight () {   
			Node<E> root = this.left;
			Node<E> leaf = root.right;
			root.right = this;
			this.left = leaf;
			return root;
		}
		/*
		 * Left rotation.
		 * updating the data, priority and pointers.
		 * Returning the reference to the root.
		 */
		public Node <E> rotateLeft () {
			Node<E> root = this.right;
			Node<E> leaf = root.left;
			root.left = this;
			this.right = leaf;
			return root;
		}
		
    }
		

		// Data Fields for Treap Class
	
		private Random priorityGenerator;
		private Node <E> root;
		
		
		/*
		 *  Constructors
		 *  
		 *  Initializes priorityGenerator.
		 *  Creates empty treap.
		 */
		public Treap() {
			this.priorityGenerator = new Random();
			this.root = null;
		}
		public Treap(long seed) {
			this.priorityGenerator = new Random(seed);
			this.root = null;
		}
		
		// add helper
		public void reheap(Node<E> temp, Stack<Node<E>> n) {
			while (!n.isEmpty()) {
				Node<E> parent = n.pop();
				if (parent.priority < temp.priority){
					if (parent.data.compareTo(temp.data) > 0) {
						temp = parent.rotateRight();
					} else {
						temp = parent.rotateLeft();
					}
					if (!n.isEmpty()) {
						if (n.peek().left == parent) {
							n.peek().left = temp;
						} else {
							n.peek().right = temp;
						}
					} else { 
						this.root = temp;
					} 
				}else {
					break;
				}
			}
		}
		
		// Methods
		
		boolean add(E key) {
			return add(key,priorityGenerator.nextInt());
		}
		
		
		boolean add(E key , int priority) {
			if (root == null) {
				root = new Node<E>(key, priority);
				return true;
				
			} else {
				
			Node<E> temp = new Node<E>(key, priority);
			
			Stack<Node<E>> stackTemp = new Stack<Node<E>>();
			
			Node<E> current = root;
			
			while (current != null) {
				int comparison = current.data.compareTo(key);
				if (comparison == 0) {
					return false;
					
				} else {
					if (comparison < 0) {
						stackTemp.push(current);
						if (current.right == null) {
							current.right = temp;
							reheap(temp, stackTemp);
							return true;	
						} else {
							current = current.right;
						}
						
					} else {
						stackTemp.push(current);
						if (current.left == null) {
							current.left = temp;
							reheap(temp, stackTemp);
							return true;
						} else {
							current = current.left;
					}
				}
			}
		}
				return false;
		}
		}
		private Node<E> delete(E key, Node<E> r){
			if (r == null) {
				return r;
			} else {
				if (r.data.compareTo(key) < 0) {
					r.right = delete(key, r.right);
			} else {
				if (r.data.compareTo(key) > 0) {
					r.left = delete(key, r.left);
			} else {
				if (r.right == null) {
					r = r.left;
			} else if (r.left == null) {
						r = r.right;
			} else {
				if (r.right.priority < r.left.priority) {
					r = r.rotateRight();
					r.right = delete(key, r.right);
			} else {
					r = r.rotateLeft();
					r.left = delete(key, r.left);
			}
				}
			}
			}
		}
			return r;
		}
	
		public boolean delete(E key) {
			if (root == null || find(key) == false) {
				return false;
			} else {
				root = delete(key, root);
				return true;
			}
		}

		private boolean find(Node <E> root , E key) {
			boolean found = false;
		if(root.data == key) {
			return true;
		}else {
			if (root.left != null) {
				found= find(root.left, key);			
			}
			if(root.right != null && found==false) {
				found = find(root.right, key);
			}
		}
			return found;
		}
		public boolean find(E key) {
			return find(root,key);
			
		}
		
		// toString Helper
		private String toString(Node<E> node, int depth){
		StringBuilder s = new StringBuilder();
			for(int i = 1; i < depth; i++) {
				s.append(" ");
			}
			if(node == null) {
				s.append("null\n");
			}
			else {
				s.append('(' + "key= " + node.data +" , priority=" + node.priority +')');;
				s.append("\n");
				s.append(toString(node.left, depth + 1));
				s.append(toString(node.right, depth + 1)); 
			}
			return s.toString();
		}
		
		public String toString () {
			return toString(root, 0);
		}
