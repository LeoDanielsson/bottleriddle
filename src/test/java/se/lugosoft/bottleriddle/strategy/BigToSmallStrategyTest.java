package se.lugosoft.bottleriddle.strategy;

import org.junit.Test;
import se.lugosoft.bottleriddle.manager.BottleManager;
import se.lugosoft.bottleriddle.model.Bottle;

import static org.mockito.Matchers.same;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public class BigToSmallStrategyTest {
    private BottleManager bottleManagerMock = mock(BottleManager.class);
    private BigToSmallStrategy bigToSmallStrategy = new BigToSmallStrategy(bottleManagerMock);

    @Test
    public void emptiesSmallBottleIfFull() {
        Bottle bigBottle = new Bottle(5);
        Bottle smallBottle = new Bottle(3);

        smallBottle.setCurrentVolume(3);

        bigToSmallStrategy.performAction(bigBottle, smallBottle);

        verify(bottleManagerMock).empty(same(smallBottle));
        verifyNoMoreInteractions(bottleManagerMock);
    }

    @Test
    public void fillsBigBottleIfEmpty_AndSmallBottleNotFull() {
        Bottle bigBottle = new Bottle(5);
        Bottle smallBottle = new Bottle(3);

        bigBottle.setCurrentVolume(0);
        smallBottle.setCurrentVolume(2);

        bigToSmallStrategy.performAction(bigBottle, smallBottle);

        verify(bottleManagerMock).fill(same(bigBottle));
        verifyNoMoreInteractions(bottleManagerMock);
    }

    @Test
    public void poursFromBigBottleToSmall_IfSmallBottleNotFull_AndBigBottleNotEmpty() {
        Bottle bigBottle = new Bottle(5);
        Bottle smallBottle = new Bottle(3);

        bigBottle.setCurrentVolume(4);
        smallBottle.setCurrentVolume(2);

        bigToSmallStrategy.performAction(bigBottle, smallBottle);

        verify(bottleManagerMock).pour(same(bigBottle), same(smallBottle));
        verifyNoMoreInteractions(bottleManagerMock);
    }
}