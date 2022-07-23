package hometasks.task3;

import org.junit.Test;

public class Main {

    @Test
    public void test() throws Exception {
        System.out.println(new A1().getClass().getAnnotation(InheritedAnnotation.class));
        System.out.println(new B1().getClass().getAnnotation(InheritedAnnotation.class));
        System.out.println(new C1().getClass().getAnnotation(InheritedAnnotation.class));
        System.out.println(new A2().getClass().getAnnotation(UninheritedAnnotation.class));
        System.out.println(new B2().getClass().getAnnotation(UninheritedAnnotation.class));
        System.out.println(new C2().getClass().getAnnotation(UninheritedAnnotation.class));
    }

}


