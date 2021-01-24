package Introspection.Exemple;

import java.lang.reflect.Method;
import java.util.Map;

public class TestsIntrospection extends junit.framework.TestCase {

    public void test_Class() {

        try {
            Class<?> cl = Class.forName("java.lang.String");
            Method[] methods =  cl.getDeclaredMethods();

        } catch (ClassNotFoundException nfe) {
            fail("Oups " + nfe.getMessage());
        }
    }
}
