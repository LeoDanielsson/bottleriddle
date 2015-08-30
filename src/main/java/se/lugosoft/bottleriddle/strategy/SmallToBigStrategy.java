package se.lugosoft.bottleriddle.strategy;

import se.lugosoft.bottleriddle.manager.BottleManager;
import se.lugosoft.bottleriddle.model.Bottle;

public class SmallToBigStrategy implements se.lugosoft.bottleriddle.strategy.BottleRiddleStrategy {
    private final BottleManager bottleManager;

    public SmallToBigStrategy(BottleManager bottleManager) {
        this.bottleManager = bottleManager;
    }

    @Override
    public void performAction(Bottle bigBottle, Bottle smallBottle) {
        if (bigBottle.isFull()) {
            bottleManager.empty(bigBottle);
            return;
        }

        if (smallBottle.isEmpty()) {
            bottleManager.fill(smallBottle);
            return;
        }
        bottleManager.pour(smallBottle, bigBottle);
    }
}
