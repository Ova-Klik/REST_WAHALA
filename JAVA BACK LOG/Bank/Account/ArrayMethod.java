package Bank.Account;
import java.util.Scanner;
public class ArrayMethod {

    public static String[] getSum() {
        String[] sum = new String[10];

        Scanner vic = new Scanner(System.in);

        for (int index = 0; index < 10; index++) {
            System.out.println("Kindly enter next name: ");
            sum[index] = vic.nextLine();
        }
        return sum;
    }
}