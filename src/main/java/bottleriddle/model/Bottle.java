package bottleriddle.model;

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

    public boolean isFull() {
        return this.currentVolume == this.maxVolume;
    }

    public boolean isEmpty() {
        return this.currentVolume == 0;
    }
}
