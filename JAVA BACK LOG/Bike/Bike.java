package Bike;

import CustomException.PowerStateException;

public class Bike {
    private int power = 0;
    private int speed = 0;
    private int  gear = 1;

    public boolean checkPowerOff() {
        return power==0;
    }

    public void turnOn() {
        if (power == 1) throw new PowerStateException("Bike is on");
        power=1;
    }

    public int getSpeed() {
        return speed;
    }

    public int getGear() {
        return gear;
    }

    public void updateGear(int speed){
        if (speed <21)          gear = 1;
        else if (speed <31)     gear = 2;
        else if (speed <41)     gear = 3;
        else                    gear = 4;

    }

    public void accelerate() {
        if(checkPowerOff()) return;
        updateGear(getSpeed());
        speed += gear;

    }

    public void decelerate() {
        if(checkPowerOff()) return;
        updateGear(getSpeed());
        speed-=gear;
    }
}
