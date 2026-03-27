import java.util.ArrayList;
public class RadixSort {

    public void radixSort(ArrayList<String> list){

        //find max length of string array
        int maxlength = 0;


        /*O(n) where n is the size of the input list because we do one pass through the list which contains n elements
         ,and we do a constant amount of work, which includes comparing and assigning (O(1) because an array) */
        for (int i = 0; i < list.size(); i++) {
            if(maxlength <list.get(i).length() ){
                maxlength = list.get(i).length();
            }
        }

        /*
        This outer loop is O(s) where is the length of the longest string in the array since this runs for maxlength which is
        the length of the longest string in teh given array
         */
        //count array O(n* (s+n+n))
        for(int j = maxlength -1; j >= 0; j--){
            int[] count = new int[27];


            /*
            O(1) work done because we just create a variable array with length of size of the input list, this does however affect space complexity since
            the length of the array depends on the size of the input so this this is O(n) space complexity.
            Also note that the size of the output stays consistently n no matter the iteration
             */
            String[] output = new String[list.size()];

            int sizeOfList = list.size()-1;

            /*
            This inner while loop runs for the O(n) where n is the amount of strings in our arraylist, because we have do a constant amount per iteration.
            Note : that this is a nested loop! -> O(n) * O(s) -> O(n*s)
             */
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

            /*
            This loop runs for a constant length of 27 indices O(1)
             */
            for (int i = 1; i < count.length; i++) {
                count[i] = count[i] + count[i-1];
            }

            /*
            The time complexity of this for loop is O(n) where n is size of list, this is becasue we do a constant amount of
            work per iteration , and loop iterates n times,
             */
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

            /*
            this would be O(n) where the n is the size of the list as stated before becasue we do a constant amount of work n times.
             */
            //copy back
            for (int k = 0; k < list.size(); k++) {
                list.set(k,  output[k]);

            }

        }
        //end of outermost loop

        //Time complexity is O(s) * O(n+n+n) => O(s * 3n) => O(s*n)

        //Space complexity is O(n)


    }


}
