package se.lugosoft.bottleriddle.strategy;

import se.lugosoft.bottleriddle.manager.BottleManager;
import se.lugosoft.bottleriddle.model.Bottle;

public class BigToSmallStrategy implements BottleRiddleStrategy {
    private final BottleManager bottleManager;

    public BigToSmallStrategy(BottleManager bottleManager) {
        this.bottleManager = bottleManager;
    }

    @Override
    public void performAction(Bottle bigBottle, Bottle smallBottle) {
        if (smallBottle.isFull()) {
            bottleManager.empty(smallBottle);
            return;
        }

        if (bigBottle.isEmpty()) {
            bottleManager.fill(bigBottle);
            return;
        }

        bottleManager.pour(bigBottle, smallBottle);
    }
}
