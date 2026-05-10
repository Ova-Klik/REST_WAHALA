public class CardUtils {

    public static boolean checkValidity(String number) {
        int sum = 0;

        for (int index = number.length() - 1; index >= 0; index--) {
            int digit = number.charAt(index) - '0';
            if ((number.length() - 1 - index) % 2 == 1) {
                digit *= 2;
                if (digit > 9) digit -= 9;
            }
            sum += digit;
        }
        return sum % 10 == 0;
    }

    public static boolean checkLengthBetween(String number, int min, int max) {
        return number.length() >= min && number.length() <= max;
    }

    public static boolean checkCardIsDigits(String number) {
        for (char newCharacter : number.toCharArray()) {
            if (!Character.isDigit(newCharacter)) return false;
        }
        return true;
    }
}

