import java.util.*;
import java.io.*;

public class Reversort {
    public static int reverseSort(ArrayList<Integer> L){
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
    public static void reverse(int i, int minPos, ArrayList<Integer> L){
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
            ArrayList<Integer> L = new ArrayList<Integer>();
            for(int j=0; j<n; j++) {
                L.add(in.nextInt());
            }
            System.out.println("Case #" + i + ": " + reverseSort(L));
        }
    }
}
