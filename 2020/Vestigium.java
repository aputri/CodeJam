import java.util.*;
import java.io.*;

public class Vestigium {

	public static int trace(int[][] matrix) {
		int traceSum = 0;
		for(int i=0; i<matrix.length; i++) {
			traceSum += matrix[i][i];
		}
		return traceSum;
	}
	
	public static int repeatedRows(int[][] matrix) {
		int count = 0;
		for(int i=0; i<matrix.length; i++) {
			HashSet<Integer> nums = new HashSet<>();
			for(int j=0; j<matrix.length; j++) {
				if(nums.contains(matrix[i][j])) {
					count++;
					break;
				}
				else {
					nums.add(matrix[i][j]);
				}
			}
		}
		return count;
	}
	
	public static int repeatedColumns(int[][] matrix) {
		int count = 0;
		for(int i=0; i<matrix.length; i++) {
			HashSet<Integer> nums = new HashSet<>();
			for(int j=0; j<matrix.length; j++) {
				if(nums.contains(matrix[j][i])) {
					count++;
					break;
				}
				else {
					nums.add(matrix[j][i]);
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); 
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			int[][] matrix = new int[n][n];
			for(int j=0; j<n; j++) {
				for(int k=0; k<n; k++) {
					matrix[j][k] = in.nextInt();
				}
			}
			
	      
			int traceSum = trace(matrix);
			int repeatedRows = repeatedRows(matrix);
			int repeatedColumns = repeatedColumns(matrix);
			  
			System.out.println("Case #" + i + ": " + traceSum + " " + repeatedRows + " " + repeatedColumns);
		}

	}

}
