package Introspection.Exemple;

import java.lang.reflect.Method;
import java.util.Map;

public class TestsIntrospection extends junit.framework.TestCase {

    public void test_Class() {

        try {
            Class<?> cl = Class.forName("java.lang.String");
            Method[] methods =  cl.getDeclaredMethods();

            Object o = cl.getConstructor().newInstance();
            assertTrue(o instanceof String);

            Method method = null;

            for (Method m : methods) {
                if (m.getName().equals("valueOf")){
                    Class<?>[] param = m.getParameterTypes();
                    if (param.length == 1 && param[0].equals(int.class))
                        method = m;
                }
            }

            Integer[] args = {1};

            Object number =  method.invoke( o, args);

            assertTrue(number instanceof String);

            assertEquals("1", (String) number);

        } catch (Exception e) {
            fail("Oups " + e.getMessage());
        }
    }
}
