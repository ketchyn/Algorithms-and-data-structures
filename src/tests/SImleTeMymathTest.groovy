package tests

import org.junit.Test

/**
 * Created by Alexandr on 12.02.2016.
 */
class SImleTeMymathTest extends GroovyTestCase {

@Test
    void testGetsun() {
    SImleTest test = new SImleTest(2, 3);
    int res = test.getsum();
    assertEquals(5,res);
}
}
