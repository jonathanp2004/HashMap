import java.util.ArrayList;
import java.util.Arrays;

public class PalindromeTriplets {

public ArrayList<int[]> palindromeTriplets(String[] words){

    //O(1)
    ArrayList<int[]> results = new ArrayList<>();


    /*
   Time complexity is O((n^3)*s) where the n is the length of the words array and s is the length of the longest String.
   This is because their exist a triple nested loop which all run n times, and the innermost uses the isPalindrome
   function which has a time complexity O(s) , hence this calls for multiplication,
   O(n*n*n*s) = O(n^3 * s)

   The Space complexity would be
     */

    for (int i = 0; i < words.length; i++) {
        for (int j = 0; j < words.length; j++) {
            for (int k = 0; k < words.length; k++) {
                if( j != i && k != i && k != j){
                String s = words[i] + words[j] +words[k];
                if(isPalindrome(s) == true) {

                    results.add(new int[]{i, j, k});
                }

                }

            }

        }

    }
    return results;


}


/*
The time complexity of isPalindrome is O(s) where the s is the length of the longest string because .toLowerCase works by
creating a new array of chars , and therefore new string of size s. Also, the StringBuilder method must
process all char in the StringBuilder to reverse AND needs to process all the char to make it into a String.
 */
public boolean isPalindrome(String s){

    s = s.toLowerCase();//O(s) where the s is the length of the longest string
    String reverse = new StringBuilder(s).reverse().toString();//O(s) ^ same reason
    return s.equals(reverse);//O(s)

    }

    public static void main(String[] args){

    PalindromeTriplets main = new PalindromeTriplets();

    String[] words =  {"race", "car", "ecar", ""};

    ArrayList<int[]> results = main.palindromeTriplets(words);

        for (int i = 0; i < results.size(); i++) {

            System.out.println(Arrays.toString(results.get(i)));
        }
    }

}
