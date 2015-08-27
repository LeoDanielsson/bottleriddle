import model.Bottle;

/**
 * Created by danie_000 on 27/08/2015.
 */
public class BottleRiddleSolver {

    private static final int BOTTLE_1_VOLUME = 3;
    private static final int BOTTLE_2_VOLUME = 5;
    private static final int[] TARGET_VOLUMES = { 1, 4 };

    final BottleManager bottleManager = new BottleManager();

    public static void main(String[] args)  {
        final BottleRiddleSolver bottleRiddleSolver = new BottleRiddleSolver();

        for(int targetVolume : TARGET_VOLUMES) {
            bottleRiddleSolver.solve(new Bottle(BOTTLE_1_VOLUME), new Bottle(BOTTLE_2_VOLUME), targetVolume);
        }
    }

    public void solve(final Bottle bottle1,final Bottle bottle2,final int targetVolume) {
        System.out.printf("\nStaring to solve. Target volume: %d\n", targetVolume);
        printState(bottle1, bottle2);

        final Bottle bigBottle;
        final Bottle smallBottle;

        if(bottle1.getMaxVolume() > bottle2.getMaxVolume()) {
            bigBottle = bottle1;
            smallBottle = bottle2;
        } else {
            bigBottle = bottle2;
            smallBottle = bottle1;
        }

        int stepCount = 0;

        if(bigBottle.getMaxVolume() - smallBottle.getMaxVolume() > targetVolume) {
            while(!solved(bigBottle, smallBottle, targetVolume)) {
                performPourSmallToBigStrategyAction(bigBottle, smallBottle, targetVolume);
                printState(smallBottle, bigBottle);
                stepCount++;
            }
        } else {
            while(!solved(bigBottle, smallBottle, targetVolume)) {
                performPourBigToSmallStrategyAction(bigBottle, smallBottle, targetVolume);
                printState(smallBottle, bigBottle);
                stepCount++;
            }
        }

        System.out.printf("Found solution in %d steps.\n", stepCount);

        //hardCodedSolution(smallBottle, bigBottle, targetVolume);
    }

    private void performPourBigToSmallStrategyAction(Bottle bigBottle, Bottle smallBottle, int targetVolume) {
        if(smallBottle.isFull()) {
            bottleManager.empty(smallBottle);
            return;
        }

        if(bigBottle.isEmpty()) {
            bottleManager.fill(bigBottle);
            return;
        }

        bottleManager.pour(bigBottle, smallBottle);
    }

    private void performPourSmallToBigStrategyAction(Bottle bigBottle, Bottle smallBottle, int targetVolume) {
        if(bigBottle.isFull()) {
            bottleManager.empty(bigBottle);
        }

        if(smallBottle.isEmpty()) {
            bottleManager.fill(smallBottle);
            return;
        }
        bottleManager.pour(smallBottle, bigBottle);
    }


    private void hardCodedSolution(Bottle smallBottle, Bottle bigBottle, int targetVolume) {
        if(targetVolume == 1) {
            bottleManager.fill(smallBottle);
            printState(smallBottle, bigBottle);

            bottleManager.pour(smallBottle, bigBottle);
            printState(smallBottle, bigBottle);

            bottleManager.fill(smallBottle);
            printState(smallBottle, bigBottle);

            bottleManager.pour(smallBottle, bigBottle);
            printState(smallBottle, bigBottle);

            if(solved(smallBottle, bigBottle, targetVolume)) {
                return;
            } else {
                System.out.printf("FAIL!");
            }
        }
        if(targetVolume == 4) {
            bottleManager.fill(bigBottle);
            printState(smallBottle, bigBottle);

            bottleManager.pour(bigBottle, smallBottle);
            printState(smallBottle, bigBottle);

            bottleManager.empty(smallBottle);
            printState(smallBottle, bigBottle);

            bottleManager.pour(bigBottle, smallBottle);
            printState(smallBottle, bigBottle);

            bottleManager.fill(bigBottle);
            printState(smallBottle, bigBottle);

            bottleManager.pour(bigBottle, smallBottle);
            printState(smallBottle, bigBottle);

            if(solved(smallBottle, bigBottle, targetVolume)) {
                return;
            } else {
                System.out.printf("FAIL!");
            }
        }
    }

    private static boolean solved(Bottle bottle1, Bottle bottle2, int targetVolume) {
        if(bottle1.getCurrentVolume() == targetVolume) {
            System.out.printf("SOLVED: Bottle 1 contains %d litres.\n", targetVolume);
            return true;
        }
        if(bottle2.getCurrentVolume() == targetVolume) {
            System.out.printf("SOLVED: Bottle 2 contains %d litres.\n", targetVolume);
            return true;
        }
        return false;
    }

    private static void printState(Bottle bottle1, Bottle bottle2) {
        System.out.printf("[%d/%d] [%d/%d] \n", bottle1.getCurrentVolume(), bottle1.getMaxVolume(), bottle2.getCurrentVolume(), bottle2.getMaxVolume());
    }


}
