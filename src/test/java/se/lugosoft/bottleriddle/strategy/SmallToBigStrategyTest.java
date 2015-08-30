package se.lugosoft.bottleriddle.strategy;

import org.junit.Test;
import se.lugosoft.bottleriddle.manager.BottleManager;
import se.lugosoft.bottleriddle.model.Bottle;

import static org.mockito.Matchers.same;
import static org.mockito.Mockito.*;

public class SmallToBigStrategyTest {
    private BottleManager bottleManagerMock = mock(BottleManager.class);
    private SmallToBigStrategy smallToBigStrategy = new SmallToBigStrategy(bottleManagerMock);

    @Test
    public void emptiesBigBottleIfFull() {
        Bottle bigBottle = new Bottle(5);
        Bottle smallBottle = new Bottle(3);

        bigBottle.setCurrentVolume(5);

        smallToBigStrategy.performAction(bigBottle, smallBottle);

        verify(bottleManagerMock).empty(same(bigBottle));
        verifyNoMoreInteractions(bottleManagerMock);
    }

    @Test
    public void fillsSmallBottleIfEmpty_AndBigBottleNotFull() {
        Bottle bigBottle = new Bottle(5);
        Bottle smallBottle = new Bottle(3);

        bigBottle.setCurrentVolume(3);
        smallBottle.setCurrentVolume(0);

        smallToBigStrategy.performAction(bigBottle, smallBottle);

        verify(bottleManagerMock).fill(same(smallBottle));
        verifyNoMoreInteractions(bottleManagerMock);
    }

    @Test
    public void poursFromSmallBottleToBig_IfBigBottleNotFull_AndSmallBottleNotEmpty() {
        Bottle bigBottle = new Bottle(5);
        Bottle smallBottle = new Bottle(3);

        bigBottle.setCurrentVolume(4);
        smallBottle.setCurrentVolume(2);

        smallToBigStrategy.performAction(bigBottle, smallBottle);

        verify(bottleManagerMock).pour(same(smallBottle), same(bigBottle));
        verifyNoMoreInteractions(bottleManagerMock);
    }
}