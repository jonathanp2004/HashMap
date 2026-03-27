import java.util.ArrayList;
public class RadixSort {

    public void radixSort(ArrayList<String> list){

        //find max length of string array
        int maxlength = 0;

        for (int i = 0; i < list.size(); i++) {
            if(maxlength <list.get(i).length() ){
                maxlength = list.get(i).length();
            }
        }
        //count array
        for(int j = maxlength -1; j >= 0; j--){
            int[] count = new int[27];

            String[] output = new String[list.size()];

            int sizeOfList = list.size()-1;

            while(sizeOfList > -1) {
                String string = list.get(sizeOfList);

                if(string.length()-1 < j){
                    count[0] = count[0] +1;

                }else {
                    int c = string.charAt(j) - 'a' + 1;

                    count[c] = count[c] + 1;

                }
                sizeOfList--;
            }

            //Make each index a running cumulative sum

            for (int i = 1; i < count.length; i++) {
                count[i] = count[i] + count[i-1];
            }

            for (int i = list.size()-1; i > -1; i--) {

                int c = 0;
                String s = list.get(i);

                if (s.length() - 1 < j) {
                    c = 0;

                } else {
                    c = s.charAt(j) - 'a' + 1;
                }

                //THENNNN populate string array
                output[count[c] - 1] = s;
                count[c] = count[c] - 1;
            }

            //copy back
            for (int k = 0; k < list.size(); k++) {
                list.set(k,  output[k]);

            }

        }


    }


}
