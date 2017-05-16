import org.junit.Test;

import ru.otus.ninevskiy.l51.testing_framework.TestingError;
import static ru.otus.ninevskiy.l51.testing_framework.TestingFramework.assertNotNull;
import static ru.otus.ninevskiy.l51.testing_framework.TestingFramework.assertTrue;
import static ru.otus.ninevskiy.l51.testing_framework.TestingFramework.fail;

public class TestingFrameworkTest {
    @Test()
    public void testAssertTrue() {
        assertTrue(true);
    }

    @Test(expected = TestingError.class)
    public void testAssertTrueFails() {
        assertTrue(false);
    }

    @Test()
    public void testAssertNotNull() {
        assertNotNull(new Integer(2));
    }

    @Test(expected = TestingError.class)
    public void testAssertNotNullFails() {
        assertNotNull(null);
    }

    @Test(expected = TestingError.class)
    public void testFail(){
        fail();
    }
}
