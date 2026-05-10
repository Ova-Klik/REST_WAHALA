public class VisaCard implements Card {
    
    @Override
    public String getType() {
        return "Visa Card";
    }

    @Override
    public boolean checkValidity(String number) {
        return CardUtils.checkValidity(number) && CardUtils.checkLengthBetween(number, 13, 16);
    }
}

