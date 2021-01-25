package conditions;

import java.util.*;

public class PEUT_ETRE<T> implements Condition<T>{
   private final static boolean[] res = new boolean[]{true,false};
   private static Random random = new Random();
   public boolean estSatisfaite(T t){
       return res[random.nextInt(2)];
    }
}