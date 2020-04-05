import java.util.*;
import java.io.*;

public class NestingDepths {
	
	public static void addBrackets(Stack<Character> parenthesis, char num, int diff) {
		int n = Character.getNumericValue(num);
		for(int i = 0; i<diff; i++) {
			parenthesis.add('(');
		}
		parenthesis.add(num);
		for(int i = 0; i<n; i++) {
			parenthesis.add(')');
		}
	}
	
	public static void insertDigit(Stack<Character> parenthesis, char num) {
		int n = Character.getNumericValue(num);
		for(int i=0; i<n; i++) {
			parenthesis.pop();
		}
		parenthesis.add(num);
		for(int i=0; i<n; i++) {
			parenthesis.add(')');
		}
	}
	
	public static void printStack(Stack<Character> parenthesis) {  
		if (parenthesis.isEmpty())  
			return;  

		char top = parenthesis.peek();  
		parenthesis.pop();  

		printStack(parenthesis);  
		System.out.print(top);  
		parenthesis.push(top);  
	}  
	
	

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for (int i = 1; i <= t; ++i) {
			String nums = in.next();
			Stack<Character> parenthesis = new Stack<>();
			int depth = 0;
			for(int j = 0; j < nums.length(); j++) {
				char n = nums.charAt(j);
				int num = Character.getNumericValue(n);
				if(depth < num) {
					int diff = num-depth;
					if (parenthesis.isEmpty()) {
						addBrackets(parenthesis, n, diff);
					}
					else {
						char top = parenthesis.peek(); 
						while(top == ')') {
							parenthesis.pop();  
							top = parenthesis.peek(); 
						}
						addBrackets(parenthesis, n, diff);
					}
				}
				else {
					insertDigit(parenthesis, n);
				}
				depth = num;
			}
			System.out.print("Case #" + i + ": ");
			printStack(parenthesis);
			System.out.println();
		}
	}

}
