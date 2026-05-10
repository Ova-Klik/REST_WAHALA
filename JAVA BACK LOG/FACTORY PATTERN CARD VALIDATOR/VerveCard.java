public class VerveCard implements Card {

    @Override
    public String getType() {
        return "Verve Card";
    }

    @Override
    public boolean checkValidity(String number) {
        return CardUtils.checkValidity(number) && CardUtils.checkLengthBetween(number, 13, 16);
    }
}


