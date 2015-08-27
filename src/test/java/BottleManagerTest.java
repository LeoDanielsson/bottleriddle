import model.Bottle;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BottleManagerTest {

    private BottleManager bottleManager = new BottleManager();

    @Test
    public void fillSetsVolumeToMaxVolume() {
        Bottle bottle = new Bottle(5);

        bottleManager.fill(bottle);

        assertEquals(5, bottle.getCurrentVolume());
    }

    @Test
    public void emptySetsVolumeToZero() {
        Bottle bottle = new Bottle(5);
        bottle.setCurrentVolume(4);

        bottleManager.empty(bottle);

        assertEquals(0, bottle.getCurrentVolume());
    }

    @Test
    public void pouringFromBigToSmallBottleLeavesRestInBigBottle() {
        Bottle bigBottle = new Bottle(5);
        Bottle smallBottle = new Bottle(3);

        bigBottle.setCurrentVolume(5);

        bottleManager.pour(bigBottle, smallBottle);

        assertEquals(2, bigBottle.getCurrentVolume());
        assertEquals(3, smallBottle.getCurrentVolume());
    }

    @Test
    public void pouringFromSmallBottleToBigBottleFillsBigBottlePartially() {
        Bottle bigBottle = new Bottle(5);
        Bottle smallBottle = new Bottle(3);

        smallBottle.setCurrentVolume(3);

        bottleManager.pour(smallBottle, bigBottle);

        assertEquals(3, bigBottle.getCurrentVolume());
        assertEquals(0, smallBottle.getCurrentVolume());
    }

    @Test
    public void pouringIntoFullBottleDoesNothing() {
        Bottle bigBottle = new Bottle(5);
        Bottle smallBottle = new Bottle(3);

        bigBottle.setCurrentVolume(5);
        smallBottle.setCurrentVolume(3);

        bottleManager.pour(smallBottle, bigBottle);

        assertEquals(5, bigBottle.getCurrentVolume());
        assertEquals(3, smallBottle.getCurrentVolume());
    }
}