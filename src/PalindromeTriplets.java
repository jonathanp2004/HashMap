import java.util.ArrayList;

public class PalindromeTriplets {

public ArrayList<int[]> palindromeTriplets(String[] words){

    ArrayList<int[]> results = new ArrayList<>();

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

public boolean isPalindrome(String s){
    String reverse = new StringBuilder(s).reverse().toString();

    return s.equals(reverse);

}









}
