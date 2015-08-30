package se.lugosoft.bottleriddle;

import se.lugosoft.bottleriddle.manager.BottleManager;
import se.lugosoft.bottleriddle.model.Bottle;
import se.lugosoft.bottleriddle.strategy.BigToSmallStrategy;
import se.lugosoft.bottleriddle.strategy.SmallToBigStrategy;

import java.util.Arrays;

public class Main {
    private static final int BOTTLE_1_VOLUME = 3;
    private static final int BOTTLE_2_VOLUME = 5;
    private static final int[] TARGET_VOLUMES = {1, 4};

    public static void main(String[] args) {
        final BottleRiddleSolver bottleRiddleSolver = createBottleRiddleSolver();

        Arrays.stream(TARGET_VOLUMES).forEach((targetVolume) ->
                bottleRiddleSolver.solve(new Bottle(BOTTLE_1_VOLUME), new Bottle(BOTTLE_2_VOLUME), targetVolume));
    }

    private static BottleRiddleSolver createBottleRiddleSolver() {
        final BottleManager bottleManager = new BottleManager();

        final BigToSmallStrategy bigToSmallStrategy = new BigToSmallStrategy(bottleManager);
        final SmallToBigStrategy smallToBigStrategy = new SmallToBigStrategy(bottleManager);

        return new BottleRiddleSolver(bigToSmallStrategy, smallToBigStrategy);
    }
}
