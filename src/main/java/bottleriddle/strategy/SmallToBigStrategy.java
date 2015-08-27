package bottleriddle.strategy;

import bottleriddle.BottleManager;
import bottleriddle.model.Bottle;

/**
 * Created by danie_000 on 27/08/2015.
 */
public class SmallToBigStrategy implements bottleriddle.strategy.BottleRiddleStrategy {
    @Override
    public void performAction(BottleManager bottleManager, Bottle bigBottle, Bottle smallBottle) {
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
