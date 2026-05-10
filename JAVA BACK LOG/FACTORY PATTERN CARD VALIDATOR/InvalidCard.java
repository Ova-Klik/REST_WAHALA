public class InvalidCard implements Card {

    @Override
    public String getType() {
        return "Invalid Card";
    }

    @Override
    public boolean checkValidity(String number) {
        return false;
    }
}

