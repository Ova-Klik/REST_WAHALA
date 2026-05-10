public class Factorial{

    public static void main(String ...args) {
        int number = 5;
        print(getFactorial(number));

    }
        public static int getFactorial(int number){

            if(number==0 || number==1 ) return 1;
            return number * getFactorial(number-1);
        }

        public static void print(Object message){
            System.out.println(message);
        }
    }
