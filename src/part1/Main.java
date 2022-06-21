package part1;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
/*
1.Створити власну анотацію, яка буде приймати хоча б один параметр. Створити клас із певними полями і над декількома полями написати власну анотацію.
Створити метод який буде записувати поля класу які промарковані анотацією в файл(рефлексія).

 */

    public static void main(String args[]) throws Exception {
        Hello hello = new Hello();
        Method m = hello.getClass().getMethod("sayHello");
        MyAnnotation methodAnno = m.getAnnotation(MyAnnotation.class);
        System.out.printf("value of method annotation is: %s \n", methodAnno.value());

        Field f = hello.getClass().getField("firstName");
        MyAnnotation fieldAnno = f.getAnnotation(MyAnnotation.class);
        System.out.printf("value of field annotation is: %s \n", fieldAnno.value());

        Class<Hello> myClass = Hello.class;
        MyAnnotation classAnno = myClass.getAnnotation(MyAnnotation.class);
        System.out.printf("value of class annotation is: %s \n", classAnno.value());

        //Створити метод який буде записувати поля класу які промарковані анотацією в файл(рефлексія).
        List<String> annotatedFieldNames =
                Arrays.asList(hello.getClass().getFields()).
                        stream().filter(field -> field.isAnnotationPresent(MyAnnotation.class))
                        .map(Field::getName).collect(Collectors.toList());
        Path out = Paths.get("reflection");
        Files.write(out,annotatedFieldNames, Charset.defaultCharset());
    }

}
