package model;

/**
 * Created by danie_000 on 27/08/2015.
 */
public final class Bottle {
    private final int maxVolume;
    private int currentVolume = 0;

    public Bottle(int maxVolume) {
        this.maxVolume = maxVolume;
    }

    public int getMaxVolume() {
        return maxVolume;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentVolume(int currentVolume) {
        this.currentVolume = currentVolume;
    }
}