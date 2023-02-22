import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JunitDemo1Test {



    @Test
    void test() {
        JunitDemo1 test = new JunitDemo1();
        String result=test.method1("Hello");
        assertEquals("olleH",result);
    }
}