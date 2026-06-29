package commandPattern;

public class Light {
    private boolean isOn = false;

    public void turnOn() {
        isOn = true;
        System.out.println("The light is now ON.");
    }

    public void turnOff() {
        isOn = false;
        System.out.println("The light is now OFF.");
    }

    public boolean isOn() {
        return isOn;
    }
}
