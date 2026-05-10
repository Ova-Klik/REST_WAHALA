public class AmericanXpressCard implements Card {

    @Override
    public String getType() {
        return "American Express Card";
    }

    @Override
    public boolean checkValidity(String number) {
        return CardUtils.checkValidity(number) && CardUtils.checkLengthBetween(number, 15, 15);
    }
}

