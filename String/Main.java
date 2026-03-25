package Hexaware.String;

import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {

//        StringTokenizer st = new StringTokenizer("we will play sports");
//        while (st.hasMoreElements()) {
//            System.out.println(st.nextToken());
//        }

        String str = "we will play sports";
        String[] arr = str.split(" ");

        for (String s : arr){
            System.out.println("Word: " + s + ", Length: " + s.length() + ", Vowel Count: " + countVowel(s));
        }
    }

    public static int countVowel(String s){

        int count = 0;
        for (char c : s.toCharArray()){
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') count++;
        }
        return count;
    }
}
