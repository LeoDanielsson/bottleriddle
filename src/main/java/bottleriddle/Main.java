package bottleriddle;

import bottleriddle.model.Bottle;

import java.util.Arrays;

public class Main {
    private static final int BOTTLE_1_VOLUME = 3;
    private static final int BOTTLE_2_VOLUME = 5;
    private static final int[] TARGET_VOLUMES = {1, 4};

    public static void main(String[] args) {
        final BottleRiddleSolver bottleRiddleSolver = new BottleRiddleSolver();

        Arrays.stream(TARGET_VOLUMES).forEach((targetVolume) ->
                bottleRiddleSolver.solve(new Bottle(BOTTLE_1_VOLUME), new Bottle(BOTTLE_2_VOLUME), targetVolume));
    }
}
