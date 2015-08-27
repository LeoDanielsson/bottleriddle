package bottleriddle;

import bottleriddle.model.Bottle;
import bottleriddle.strategy.BigToSmallStrategy;
import bottleriddle.strategy.BottleRiddleStrategy;
import bottleriddle.strategy.SmallToBigStrategy;

/**
 * Created by danie_000 on 27/08/2015.
 */
public class BottleRiddleSolver {

    final BottleManager bottleManager = new BottleManager();

    public void solve(final Bottle bottle1, final Bottle bottle2, final int targetVolume) {
        System.out.printf("\nStaring to solve. Target volume: %d\n", targetVolume);
        printState(bottle1, bottle2);

        final Bottle bigBottle;
        final Bottle smallBottle;

        if (bottle1.getMaxVolume() > bottle2.getMaxVolume()) {
            bigBottle = bottle1;
            smallBottle = bottle2;
        } else {
            bigBottle = bottle2;
            smallBottle = bottle1;
        }

        int stepCount = 0;

        BottleRiddleStrategy strategy = chooseStrategy(bigBottle, smallBottle, targetVolume);

        while (!solved(bigBottle, smallBottle, targetVolume)) {
            strategy.performAction(bigBottle, smallBottle);
            printState(smallBottle, bigBottle);
            stepCount++;
        }

        System.out.printf("Found solution in %d steps.\n", stepCount);
    }

    private BottleRiddleStrategy chooseStrategy(Bottle bigBottle, Bottle smallBottle, int targetVolume) {
        if (bigBottle.getMaxVolume() - smallBottle.getMaxVolume() > targetVolume) {
            return new SmallToBigStrategy(bottleManager);
        }
        return new BigToSmallStrategy(bottleManager);
    }

    private static boolean solved(Bottle bottle1, Bottle bottle2, int targetVolume) {
        if (bottle1.getCurrentVolume() == targetVolume) {
            System.out.printf("SOLVED: Bottle 1 contains %d litres.\n", targetVolume);
            return true;
        }
        if (bottle2.getCurrentVolume() == targetVolume) {
            System.out.printf("SOLVED: Bottle 2 contains %d litres.\n", targetVolume);
            return true;
        }
        return false;
    }

    private static void printState(Bottle bottle1, Bottle bottle2) {
        System.out.printf("[%d/%d] [%d/%d] \n", bottle1.getCurrentVolume(), bottle1.getMaxVolume(), bottle2.getCurrentVolume(), bottle2.getMaxVolume());
    }
}
