package se.lugosoft.bottleriddle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import se.lugosoft.bottleriddle.model.Bottle;
import se.lugosoft.bottleriddle.strategy.BigToSmallStrategy;
import se.lugosoft.bottleriddle.strategy.BottleRiddleStrategy;
import se.lugosoft.bottleriddle.strategy.SmallToBigStrategy;

public class BottleRiddleSolver {
    private static final Logger LOGGER = LoggerFactory.getLogger(BottleRiddleSolver.class);

    private BigToSmallStrategy bigToSmallStrategy;
    private SmallToBigStrategy smallToBigStrategy;

    public BottleRiddleSolver(BigToSmallStrategy bigToSmallStrategy, SmallToBigStrategy smallToBigStrategy) {
        this.bigToSmallStrategy = bigToSmallStrategy;
        this.smallToBigStrategy = smallToBigStrategy;
    }

    public void solve(final Bottle bottle1, final Bottle bottle2, final int targetVolume) {
        LOGGER.info("Starting to solve. Target volume: {}", targetVolume);
        logState(bottle1, bottle2);

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
            logState(smallBottle, bigBottle);
            stepCount++;
        }

        LOGGER.info("Found solution in {} steps.", stepCount);
    }

    private BottleRiddleStrategy chooseStrategy(Bottle bigBottle, Bottle smallBottle, int targetVolume) {
        if (bigBottle.getMaxVolume() - smallBottle.getMaxVolume() > targetVolume) {
            return smallToBigStrategy;
        }
        return bigToSmallStrategy;
    }

    private static boolean solved(Bottle bottle1, Bottle bottle2, int targetVolume) {
        if (bottle1.getCurrentVolume() == targetVolume) {
            LOGGER.info("SOLVED: Bottle 1 contains {} litres", targetVolume);
            return true;
        }
        if (bottle2.getCurrentVolume() == targetVolume) {
            LOGGER.info("SOLVED: Bottle 2 contains {} litres", targetVolume);
            return true;
        }
        return false;
    }

    private static void logState(Bottle bottle1, Bottle bottle2) {
        LOGGER.info("[{}/{}] [{}/{}]", bottle1.getCurrentVolume(), bottle1.getMaxVolume(), bottle2.getCurrentVolume(), bottle2.getMaxVolume());
    }
}
