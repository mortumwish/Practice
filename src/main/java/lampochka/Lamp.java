package main.java.lampochka;

public class Lamp {
    private boolean isOn;
    private boolean isBroken;
    private int countOfTurnOn = 0;
    private String color;
    private int brightness = 0;
    private final int maxBrightness = 100;
    private final int minBrightness = 0;
    private static int lifespanOfLamp = 3;

    Lamp(String color) {
        this.color = color;
        this.brightness = 100;
    }

    public void on() {
        if (this.isBroken) {
            System.out.println("You can't turn on a broken lamp.");
        } else if (this.isOn) {
            System.out.println("Lamp is already enabled.");
        } else {
            this.isOn = true;
            this.countOfTurnOn++;
            if (this.countOfTurnOn > this.lifespanOfLamp) {
                System.out.println("Lamp is broken.");
                this.isBroken = true;
                this.isOn = false;
            }
            System.out.println("Lamp is enabled. Color: " + this.color + ", brightness: " + this.brightness + "%.");
        }
    }

    public void off() {
        if (this.isBroken) {
            System.out.println("Lamp is broken.");
        } else if (!this.isOn) {
            System.out.println("Lamp is already disabled.");
        } else {
            this.isOn = false;
            System.out.println("Lamp is disabled.");
        }
    }

    public void status() {
        System.out.print("Status: ");
        if (this.isOn) {
            System.out.println("Lamp is enabled. Color: " + this.color + ", brightness: " + this.brightness + "%.");
        }
        if (this.isBroken) {
            System.out.println("Lamp is broken.");
        } else if (!this.isOn) {
            System.out.println("Lamp is disabled.");
        }
    }

    public void setBrightness(Integer brightness) {
        if (!this.isOn) {
            System.out.println("Error. Lamp is disabled. You can't change the brightness of disabled lamp.");
        } else if (brightness > this.maxBrightness || brightness < this.minBrightness) {
            System.out.println("Error, invalid input. The brightness value should be between 0% and 100%.");
        } else {
            this.brightness = brightness;
            System.out.println("Brightness set on: " + brightness + "%.");
        }
    }
}