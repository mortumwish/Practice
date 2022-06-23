package main.java.lampochka;

public class Lamp {
    private boolean isEnable;
    private boolean isBroken;
    private Integer countOfTurnOn = 0;
    private String color;
    private Integer brightness = 0;

    Lamp(String color) {
        this.color = color;
        this.brightness = 100;
    }

    public void on() {
        if (this.isBroken) {
            System.out.println("You can't turn on a broken lamp.");
            return;
        } else if (this.isEnable) {
            System.out.println("Lamp is already enabled.");
            return;
        }
        this.isEnable = true;
        this.countOfTurnOn++;
        if (this.countOfTurnOn > 3) {
            System.out.println("Lamp is broken.");
            this.isBroken = true;
            this.isEnable = false;
            return;
        }
        System.out.println("Lamp is enabled. Color: " + this.color + ", brightness: " + this.brightness + "%.");
    }

    public void off() {
        if (!this.isEnable) {
            System.out.println("Lamp is already disabled.");
            return;
        }
        this.isEnable = false;
        System.out.println("Lamp is disabled.");

    }

    public void status() {
        System.out.print("Status: ");
        if (this.isEnable) {
            System.out.println("Lamp is enabled. Color: " + this.color + ", brightness: " + this.brightness + "%.");
        }
        if (this.isBroken) {
            System.out.println("Lamp is broken.");
        } else if (!this.isEnable) {
            System.out.println("Lamp is disabled.");
        }
    }

    public void setBrightness(Integer brightness) {
        if (!this.isEnable) {
            System.out.println("Error. Lamp is disabled. You can't change the brightness of disabled lamp.");
        } else if (brightness > 100 || brightness < 0) {
            System.out.println("Error, invalid input. The brightness value should be between 0% and 100%.");
        } else {
            this.brightness = brightness;
            System.out.println("Brightness set on: " + brightness + "%.");
        }
    }
}