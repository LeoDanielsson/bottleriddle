package bottleriddle.strategy;

import bottleriddle.BottleManager;
import bottleriddle.model.Bottle;

/**
 * Created by danie_000 on 27/08/2015.
 */
public class SmallToBigStrategy implements bottleriddle.strategy.BottleRiddleStrategy {
    private final BottleManager bottleManager;

    public SmallToBigStrategy(BottleManager bottleManager) {
        this.bottleManager = bottleManager;
    }

    @Override
    public void performAction(Bottle bigBottle, Bottle smallBottle) {
        if(bigBottle.isFull()) {
            bottleManager.empty(bigBottle);
        }

        if(smallBottle.isEmpty()) {
            bottleManager.fill(smallBottle);
            return;
        }
        bottleManager.pour(smallBottle, bigBottle);
    }
}
