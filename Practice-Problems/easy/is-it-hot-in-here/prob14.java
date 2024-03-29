import java.util.*;

public class prob14 
{
    public static void main(String[] args)
    {

        try (Scanner input = new Scanner(System.in))
        {
            int testCases = Integer.parseInt(input.nextLine());

            for(int testcase = 0; testcase < testCases; testcase++)
            {
                int temps = Integer.parseInt(input.nextLine());
                for (int temp = 0; temp<temps; temp++){
                    String line = input.nextLine();
                    String numString = Delimiters.delimit(line, 0, " ");
                    double num = Double.parseDouble(numString);
                    String type = Delimiters.delimit(line, " ", line.length());
                    double result = 0;
                    if (type.equals("F")){
                        result = decRound((num - 32) * 5 / 9, 1);
                        System.out.println(numString + " F = " + result + " C");
                    } else{
                        result = decRound((num * 9 /5) + 32, 1);
                        System.out.println(numString + " C = " + result + " F");
                    }

                }

            }
        }
    }

    public static double decRound (double value, int precision) {
        int scale = (int) Math.pow(10, precision);
        return (double) Math.round(value * scale) / scale;
    }

    public static class Delimiters 
    {


        /*
        returns whatever is in between the start and end (can use either delimiter strings or indexes)
        */

        public static String delimit(String string, String start, String end){
            int startIndex = string.indexOf(start);
            int endIndex = string.indexOf(end);
            return string.substring(startIndex+1, endIndex);
        }

        public static String delimit(String string, int startIndex, String end){
            int endIndex = string.indexOf(end);
            return string.substring(startIndex, endIndex);
        }

        public static String delimit(String string, String start, int endIndex){
            int startIndex = string.indexOf(start);
            return string.substring(startIndex+1, endIndex);
        }

            /*
        returns all the things separated by a space but the string probably has to be of a certain format
        string cannot have a delimiter at the very beginning or very end (i think)
        for example:
        B1,B2,BB,K returns ["B1", "B2", "BB", "K"] and all is good
        if it looks like ,B1,B2, then youre probably not as happy
        change it from int[] to String or whatever just by getting rid of all the parseInts and making resultList List<String> and resultArray String[].
        */
        public static int[] delimitAll(String line, String spacer){
            List<Integer> resultList = new ArrayList<Integer>();

            while(line.contains(spacer)){
                resultList.add(Integer.parseInt(delimit(line, 0, spacer)));
                line = line.substring(line.indexOf(spacer)+1);
            }
            resultList.add(Integer.parseInt(line));

            int[] resultArray = new int[resultList.size()];
            int i = 0;
            for (Integer result: resultList){
                resultArray[i] = result;
                i++;
            }
            return resultArray;
        }
    }
}