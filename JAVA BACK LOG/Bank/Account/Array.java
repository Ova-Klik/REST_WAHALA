package Bank.Account;
import java.util.Arrays;
import java.util.Scanner;

import static Bank.Account.ArrayMethod.getSum;

public class Array {

    public static void main(String[] args) {
        //collect 10 numbers and 10 to each number then store it in ana array;
        String[] names = getSum();
        System.out.println(Arrays.toString(names));
    }

}
