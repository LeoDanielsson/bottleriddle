package bottleriddle.strategy;

import bottleriddle.manager.BottleManager;
import bottleriddle.model.Bottle;

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
