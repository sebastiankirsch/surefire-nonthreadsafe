package de.tcc.bugs.surefire;

import org.junit.Test;

public class OtherThreadSafeTest {

    @Test
    public void keepSecondThreadOccupiedForAWhile() throws InterruptedException {
        Thread.sleep(200);
    }

}
