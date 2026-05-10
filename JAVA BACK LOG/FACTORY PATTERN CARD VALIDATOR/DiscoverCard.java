public class DiscoverCard implements Card {

    @Override
    public String getType() {
        return "Discover Card";
    }

    @Override
    public boolean checkValidity(String number) {
        return CardUtils.checkValidity(number) && CardUtils.checkLengthBetween(number, 16, 16);
    }
}

