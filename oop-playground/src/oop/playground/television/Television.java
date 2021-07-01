package oop.playground.television;

/**
 * Represents a television. Supports volume and channel changing.
 */
public class Television {
    private static final int MAX_VOLUME = 10;
    private static final int MIN_VOLUME = 0;

    private static final int MAX_CHANNEL = 69;
    private static final int MIN_CHANNEL = 0;

    private int volume;
    private int channel;
    private boolean turnedOn;

    /**
     * Constructs a new turned off television with base volume and channel set to zero.
     */
    public Television() {
        this.volume = MIN_VOLUME;
        this.channel = MIN_CHANNEL;
        this.turnedOn = false;
    }

    public void turnOn() {
        turnedOn = true;
    }

    public void turnOff() {
        turnedOn = false;
    }

    public boolean isTurnedOn() {
        return turnedOn;
    }

    public int getVolume() {
        return volume;
    }

    public void volumeUp() {
        if (volume < MAX_VOLUME) {
            volume++;
        }
    }

    public void volumeDown() {
        if (volume > MIN_VOLUME) {
            volume--;
        }
    }

    public void channelUp() {
        if (channel < MAX_CHANNEL) {
            channel++;
        }
    }

    public void channelDown() {
        if (channel > MIN_CHANNEL) {
            channel--;
        }
    }

    /**
     * Changes the channel to the input.
     * @param channel the desired channel value
     * @throws IllegalArgumentException when channel does not match the interval
     */
    public void changeChannel(final int channel) {
        if (channel > MAX_CHANNEL || channel < MIN_CHANNEL) {
            throw new IllegalArgumentException("Piff");
        }
        this.channel = channel;
    }

    public int getChannel() {
        return channel;
    }
}
