package chap10;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import javax.management.Query;

public class StackCollection {

	public static void main(String[] args) {
		// Stack : LIFO구조
		
		Stack<String> stack = new Stack<String>();
		
		stack.push("홍길동");
		stack.push("길순이");
		stack.push("이순신");
		
		System.out.println(stack);
		System.out.println(stack.size());
		
		// 비어 있는지 있으면 true
		System.out.println( stack.isEmpty());
		while( !stack.isEmpty()) { // 비어 있지 않으면 처리
			System.out.println(stack.pop());
		}
 		
		System.out.println("---- Queue:큐 => FIFO ");
		Queue<String> q = new LinkedList<String>();
		q.add("홍길동");
		q.add("길순이");
		q.add("김갑돌");
		System.out.println(q);
		
		q.poll();q.poll();
		System.out.println(q);
		
		
		
	}

}
