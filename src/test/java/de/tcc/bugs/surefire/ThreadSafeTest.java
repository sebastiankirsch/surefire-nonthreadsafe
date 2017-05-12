package de.tcc.bugs.surefire;

import static de.tcc.bugs.surefire.NonThreadSafeTest.ATOMIC;
import static java.lang.Thread.currentThread;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ThreadSafeTest {

    @Test
    public void assertAtomic() throws InterruptedException {
        assertThat(currentThread().getName(), not(containsString("NotThreadSafe")));
        for (int i = 10; i-- > 0; ) {
            assertFalse("ATOMIC has to be false if tests don't interfere!", ATOMIC.get());
            Thread.sleep(100);
        }
    }

}
