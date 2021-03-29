import java.util.*;
import java.io.*;

public class MoonsAndUmbrellas {
    public static int calculateCost(String s, int CJ, int JC){
        String cj = "CJ";
        String jc = "JC";

        if(allQuestionMarks(s) == true){
            return 0;
        }

        String str = switchLetter(s);

        int countCJ = countMatches(str, cj);
        int countJC = countMatches(str, jc);

        int totalCost = (CJ * countCJ) + (JC * countJC);

        return totalCost;
    }

    public static int countMatches(String text, String str) {
        int index = 0, count = 0;
        while (true) {
            index = text.indexOf(str, index);
            if (index != -1) {
                count ++;
                index += str.length();
            } else {
                break;
            }
        }

        return count;
    }
    public static boolean allQuestionMarks(String s){
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) != '?'){
                return false;
            }
        }
        return true;
    }
    public static String switchLetter(String s){
        StringBuilder str = new StringBuilder(s);
        search: for(int i=0; i<str.length()-1; i++){
            if(str.charAt(i) == '?'){
                for (int j=i+1; j<str.length(); j++){
                    if(str.charAt(j) != '?'){
                        for(int k=i; k<j; k++){
                            str.setCharAt(k, str.charAt(j));
                        }
                        continue search;
                    }
                    if(j==str.length()-1 && str.charAt(j) == '?'){
                        for(int l=i; l<j; l++){
                            str.setCharAt(l, str.charAt(i-1));
                        }
                    }
                }
            }
        }
        if(str.charAt(str.length()-1) == '?'){
            str.setCharAt(str.length()-1, str.charAt(str.length()-2));
        }
        return str.toString();
    }

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int CJ = in.nextInt();
            int JC = in.nextInt();
            String s = in.nextLine();
            System.out.println("Case #" + i + ": " + calculateCost(s, CJ, JC));
        }

    }
}
