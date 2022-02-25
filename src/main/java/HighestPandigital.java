import java.util.Arrays;
/*
Take the number 192 and multiply it by each of 1, 2, and 3:
192 × 1 = 192
192 × 2 = 384
192 × 3 = 576
By concatenating each product, we get the 1 to 9 pandigital, 192384576. We will call 192384576
the concatenated product of 192 and (1,2,3). The same can be achieved by starting with 9 and
multiplying by 1, 2, 3, 4, and 5,giving the pandigital, 918273645, which is the concatenated
product of 9 and (1,2,3,4,5).
What is the largest 1 to 9 pandigital 9-digit number that can be formed as the concatenated
product of an integer with (1,2, ... , n) where n>1?

 */
public class HighestPandigital {
    public static void main(String[] args) {
        System.out.println("The largest pandigital is "+ solve());
    }

    public static long solve() {
        long result = 0;
        String temp;
        //starting number
        for (int x = 0; x < 9999; x++) {
            temp = "";
            //multiplies starting number with each iteration of n and adds it to the number
            for (int n = 1; n < 9999; n ++) {
                temp = temp + (x*n);
                if (temp.length() >= 9) break; //stops iteration once length equals 9
            }
            //checks if the number is actually a pandigital and compares if it is the max
            if(check(temp)) result = Long.max(result, Long.parseLong(temp));
        }
        return result;
    }

    public static boolean check(String result) {
        if (result.length() != 9) return false;
        char[] charArray = result.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray).equals("123456789");
    }
}