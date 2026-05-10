public class CardFactory {

    public static Card getCard(String number) {
        if (number.startsWith("4")) return new VisaCard();
        if (number.startsWith("5")) return new VerveCard();
        if (number.startsWith("37")) return new AmericanXpressCard();
        if (number.startsWith("6")) return new DiscoverCard();
        return new InvalidCard();
    }
}

