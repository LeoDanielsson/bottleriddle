package se.lugosoft.bottleriddle.strategy;

import se.lugosoft.bottleriddle.model.Bottle;

public interface BottleRiddleStrategy {
    void performAction(Bottle bigBottle, Bottle smallBottle);
}
