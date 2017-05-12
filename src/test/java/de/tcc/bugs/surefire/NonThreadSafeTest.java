package de.tcc.bugs.surefire;

import static java.lang.Thread.currentThread;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import java.util.concurrent.atomic.AtomicBoolean;
import net.jcip.annotations.NotThreadSafe;
import org.junit.Test;

@NotThreadSafe
public class NonThreadSafeTest {

    public static final AtomicBoolean ATOMIC = new AtomicBoolean(false);

    @Test
    public void setAtomic() throws InterruptedException {
        assertThat(currentThread().getName(), containsString("NotThreadSafe"));
        try {
            ATOMIC.set(true);
            Thread.sleep(1_000);
        } finally {
            ATOMIC.set(false);
        }
    }

}
