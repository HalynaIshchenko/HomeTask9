package part1;

@MyAnnotation(value = "classValue")
public class Hello {

    @MyAnnotation(value = "fieldValue1")
    public String firstName;

    @MyAnnotation(value = "fieldValue2")
    public String secondName;

    public String gender;

    @MyAnnotation(value = "methodValue")
    public void sayHello() {
        System.out.println("hello annotation");
    }

}
