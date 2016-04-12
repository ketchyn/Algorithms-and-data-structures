package reflection;

import com.sun.istack.internal.NotNull;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Alexandr on 17.02.2016.
 */
public class ReflectionDeployer {
    private static boolean first = true;
    private static List<Field>list = new ArrayList() ;

    public static List<Field> deploy(Class o, Class limitClass) {


        Class SuperClazz = o.getSuperclass();
        if (SuperClazz.getName().equals(Object.class.getName())) return list;

        if (first == true) {
            Field[] fields = o.getDeclaredFields();
            first = false;
            list.addAll(Arrays.asList(fields));
        }
        Field[] fieldsSuper = SuperClazz.getDeclaredFields();
        list.addAll(Arrays.asList(fieldsSuper));
        if (SuperClazz.getName().toString().equals(limitClass.getName().toString())) {
            return list;
        } else {
            deploy(SuperClazz, limitClass);
            return list;
        }


    }
}
