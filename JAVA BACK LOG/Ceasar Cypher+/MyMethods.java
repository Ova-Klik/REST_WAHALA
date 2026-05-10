
public class MyMethods{
    
    
    public static int stringToInteger(String numbers){
    int number=0;
    
        for(int index=0; index<numbers.length(); index++){
            int number1=numbers.charAt(index)-'0';
            number= number*10 + number1;
    }
    
    return (number);
}

    public static boolean stringIsInteger(String numbers){
    
    int number=stringToInteger(numbers);
    
    if(number%2 == 0){
        return true;
    }else{
    
        return false;
    }
    
    }
    
    public static boolean stringIsDouble(String numbers){
    
    int number=stringToInteger(numbers);
    
    if(number%2 == 0){
        return false;
    }else{
    
        return true;
    }
    
    }
}
