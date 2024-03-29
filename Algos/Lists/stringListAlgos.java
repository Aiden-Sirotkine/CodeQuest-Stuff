package Algos.Lists;

import java.util.Arrays;
import java.util.List;

/**
 * input = ArrayList of items that you want all permutations of
 * output = String[][] of all possible permutations of your input
 * WARNING: don't use too big of lists or your computer will explode
 *
 *
 * how to use:
 * stringListAlgos stringPerms = new stringListAlgos(stringList.size());
 *
 * stringPerms.permutations(stringList, new ArrayList<String>());
 *
 * String[][] allStringPerms = stringPerms.getAllPerms();
*/



public static class stringListAlgos 
{
    int number;
    String[][] allPerms;
    int size;



        //input = integer n
        //output = n!

    public static int factorial(int n)
    {
        int result = n;
        for (int i = n-1; i>0; i--)
            {
            result *= i;
            }
        return result;
    }



    public stringListAlgos(int size)
    {
        this.size = size;
        allPerms = new String[factorial(size)][];
    }
        // Generates all permutations -- EXAMPLE IN listAlgoTesting.java
    public void permutations(List<String> items, List<String> permutation) 
    {

            /* permutation stack has become equal to size that we require */
        if(permutation.size() == size) 
        {
                /* print the permutation */
//                System.out.println(Arrays.toString(permutation.toArray(new String[0])));
            allPerms[number] = permutation.toArray(new String[0]);
            number++;
        }

            /* items available for permutation */
        String[] availableItems = items.toArray(new String[0]);
        for(String s : availableItems) 
        {
                /* add current item */
            permutation.add(s);

                /* remove item from available item set */
            items.remove(s);

                /* pass it on for next permutation */
            permutations(items, permutation);

                /* pop and put the removed item back */
            items.add(permutation.remove(permutation.size() - 1));
        }
    }

    public String[][] getAllPerms()
    {
        return allPerms;
    }
}
