package ngoni.training.leet;

import java.util.ArrayList;
import java.util.List;

/*
 * You are given two non-empty linked lists representing two non-negative integers.
 *  The digits are stored in reverse order and each of their nodes contain a single digit. 
 *  Add the two numbers and return it as a linked list.
 *  You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */


public class ListNodeAddTwoNumbers {
/*
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		List<ListNode> nodes = new ArrayList<ListNode>();
		
		int l1Size=getListSize(l1);
		int l2Size=getListSize(l2);
		int counter=0;
		int carry = 0;
		while(l1 != null || l2 != null) {
			ListNode tempNode;
			
			if(l1Size > l2Size && (counter >= l2Size )) {
				tempNode= new ListNode((l1.val + carry) % 10);	
				if(l1.val + carry >= 10) {
					carry = 1;
				}else {
					carry=0;
				}
				l1 = l1.next;
			}else if(l2Size > l1Size && (counter >= l1Size )) {
				tempNode= new ListNode((l2.val + carry) % 10);	
				if(carry + l2.val >= 10) {
					carry = 1;
				}else {
					carry=0;
				}
				l2 = l2.next;
			}else {
				tempNode= new ListNode((l1.val + l2.val + carry) % 10);
				if(l1.val + l2.val + carry >= 10) {
					carry = 1;
				}else {
					carry=0;
				}
				l1 = l1.next;
				l2 = l2.next;
			}
			
			if(l1Size >= l2Size && carry==1 && l1 == null) {
				l1 = new ListNode(0);
				l1Size++;
			} else if(l2Size > l1Size && carry==1 && l2 == null) {
				l2 = new ListNode(0);
				l2Size++;
			}
			
			nodes.add(tempNode);
			if(counter != 0) {
				nodes.get(counter - 1).next = nodes.get(counter);
			}
			
			counter++;
		}
		
		return nodes.get(0);  
    }
	
	private int getListSize(ListNode l) {
		int size = 0;
		while(l != null) {
			l = l.next;
			size++;
		}
		return size;
	}
	
	public static void main(String args[]) {
		ListNodeAddTwoNumbers soln = new ListNodeAddTwoNumbers();
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);

		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		
		ListNode l3 = soln.addTwoNumbers(l1, l2);
		System.out.println(l3);
	}
	*/
}
