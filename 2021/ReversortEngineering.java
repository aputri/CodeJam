import java.util.*;
import java.io.*;

public class ReversortEngineering {
    public static String getList(int N, int C){
        int[] nums = new int[N];
        for(int i=0; i<N; i++){
            nums[i] = i+1;
        }
        List<List<Integer>> permutations = permute(nums);
        for(int p=0; p<permutations.size(); p++){
            List<Integer> copy = new ArrayList<>(permutations.get(p));
            int cost = reverseSort(permutations.get(p));
            if(cost == C){
                StringBuilder list = new StringBuilder();
                for(int q=0; q<copy.size(); q++){
                    list.append(copy.get(q));
                    if (q < copy.size()-1){
                        list.append(" ");
                    }
                }
                return list.toString();
            }
        }
        return "IMPOSSIBLE";

    }
    public static void backtrack(int n, ArrayList<Integer> nums, List<List<Integer>> output, int first) {
        // if all integers are used up
        if (first == n)
            output.add(new ArrayList<Integer>(nums));
        for (int i = first; i < n; i++) {
            // place i-th integer first
            // in the current permutation
            Collections.swap(nums, first, i);
            // use next integers to complete the permutations
            backtrack(n, nums, output, first + 1);
            // backtrack
            Collections.swap(nums, first, i);
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        // init output list
        List<List<Integer>> output = new LinkedList();

        // convert nums into list since the output is a list of lists
        ArrayList<Integer> nums_lst = new ArrayList<Integer>();
        for (int num : nums)
            nums_lst.add(num);

        int n = nums.length;
        backtrack(n, nums_lst, output, 0);
        return output;
    }
    public static int reverseSort(List<Integer> L){
        int cost = 0;
        for(int i=0; i<L.size(); i++){
            int minValue = L.get(i);
            int minPos = i;
            for(int j=i+1; j<L.size(); j++){
                if(L.get(j) < minValue){
                    minValue = L.get(j);
                    minPos = j;
                }
            }
            if(i < minPos){
                reverse(i, minPos, L);
                cost += minPos-i+1;
            }
            if(i == minPos && i != L.size() - 1){
                cost += 1;
            }
        }
        return cost;
    }
    public static void reverse(int i, int minPos, List<Integer> L){
        List<Integer> subL = L.subList(i, minPos+1);
        Collections.reverse(subL);
        for(int k=0; k<subL.size(); k++){
            L.set(i+k, subL.get(k));
        }
    }
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int c = in.nextInt();
            System.out.println("Case #" + i + ": " + getList(n, c));
        }
    }
}
