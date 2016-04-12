package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Alexandr on 17.02.2016.
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Son son = new Son();

       List<Field> list =  ReflectionDeployer.deploy(son.getClass(), Father.class);
        Iterator<Field> iter = list.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next().getName().toString());
        }


    }
}
