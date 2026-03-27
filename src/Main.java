import java.util.ArrayList;
public class Main {

    public void RadixSort(ArrayList<String> list){

        //find max length of string array
        int maxlength = 0;
        for (int i = 0; i < list.size(); i++) {
            if(maxlength <list.get(i).length() ){
                maxlength = list.get(i).length();
            }
            // if not keep iterating
        }

        for(int j = maxlength -1; j >= 0; j--){
            int[] count = new int[27];
            ArrayList<String> output = new ArrayList<>();
            int sizeOfList = list.size()-1;

            while(sizeOfList > -1) {
                String string = list.get(sizeOfList);

                if(string.length()-1 < j){
                    count[0] = count[0] +1;
                }else {
                    int c = string.charAt(j) - 'a' + 1;

                    //does an empty char return something less than zero?
                    count[c] = count[c] + 1;

                    // we make maxlength passes through string
                    //starting right to left <--
                }
                sizeOfList--;
            }
        }
    }


}
