package bottleriddle.strategy;

import bottleriddle.BottleManager;
import bottleriddle.model.Bottle;


/**
 * Created by danie_000 on 27/08/2015.
 */
public interface BottleRiddleStrategy {
    void performAction(Bottle bigBottle, Bottle smallBottle);
}
