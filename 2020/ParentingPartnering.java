import java.util.*;
import java.io.*;

public class ParentingPartnering {

	public static String assignSchedule(int[][] intervals) {
	    
		int[][] sortedIntervals = intervals.clone();
		sortByStartTime(sortedIntervals);
		
		int pointer = 0;
		
		HashMap<Character, Integer> currentTask = new HashMap<>();    
		HashMap<ArrayList<Integer>, String> finalSchedule = new HashMap<>();
		
		while (pointer < intervals.length) {
		  if (currentTask.get('C') != null) {
			  if (sortedIntervals[pointer][0] >= currentTask.get('C')) {
				  currentTask.remove('C');
			  }
		  }
		  if (currentTask.get('J') != null) {
			  if (sortedIntervals[pointer][0] >= currentTask.get('J')){
				  currentTask.remove('J');  
			  }
			  
		  }
		
		  if(!currentTask.containsKey('C')) {
			  currentTask.put('C', sortedIntervals[pointer][1]);
			  
			  ArrayList<Integer> time = new ArrayList<Integer>();
			  time.add(sortedIntervals[pointer][0]);
			  time.add(sortedIntervals[pointer][1]);
			  
			  finalSchedule.put(time, "C");
			  
		  }
		  else if(!currentTask.containsKey('J')) {
			  currentTask.put('J', sortedIntervals[pointer][1]);
		  }
		  else {
			  return "IMPOSSIBLE";
		  }
		  
		  pointer += 1;
		
		}
		
		String parentSchedule = "";
		
		for(int j=0; j<intervals.length; j++) {
			ArrayList<Integer> time = new ArrayList<Integer>();
			time.add(intervals[j][0]);
			time.add(intervals[j][1]);
			
			if(finalSchedule.get(time) != null) {
				parentSchedule += 'C';
				finalSchedule.remove(time);
			}
			else {
				parentSchedule += 'J';
			}
		}
		
		return parentSchedule;
	}
    
    public static void sortByStartTime(int arr[][]) 
    { 
		Arrays.sort(arr, new Comparator<int[]>() { 
			public int compare(final int[] entry1, final int[] entry2) { 
				if (entry1[0] > entry2[0]) 
					return 1; 
				else
					return -1; 
			} 
		});
    } 

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); 
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			int[][] matrix = new int[n][2];
			for(int j=0; j<n; j++) {
				for(int k=0; k<2; k++) {
					matrix[j][k] = in.nextInt();
				}
			}
		  
			String schedule = assignSchedule(matrix);
			  
			System.out.println("Case #" + i + ": " + schedule);
		}

	}

}
