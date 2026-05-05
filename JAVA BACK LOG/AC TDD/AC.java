public class AC {
    private boolean powerOn = false;
    private int temperature = 0;

    public boolean isOff() {

        return !powerOn;
    }

    public void turnOn() {

        powerOn = true;
        temperature=24;
    }

    public int getTemperature() {
        return temperature;
    }

    public void decreaseTemperature() {
        if(!powerOn)return;
        if(getTemperature()==16)return;
        temperature-=2;

    }
    public void increaseTemperature() {
        if(!powerOn)return;
        if(getTemperature()==30)return;
        temperature+=2;
    }
}
