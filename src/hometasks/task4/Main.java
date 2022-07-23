package hometasks.task4;

import java.lang.annotation.*;
import java.lang.reflect.Method;

/**
 * The type Main.
 */
public class Main {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws NoSuchMethodException the no such method exception
     */
    public static void main(String[] args) throws NoSuchMethodException {
        Math math = new Math();

        Class<?> cl = Math.class;
        Method method = cl.getDeclaredMethod("MathSum", int.class, int.class);
        MathAnno mathAnno = method.getAnnotation(MathAnno.class);
        math.MathSum(mathAnno.num1(), mathAnno.num2());
    }

}

/**
 * The interface Math anno.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface MathAnno {
    /**
     * Num 1 int.
     *
     * @return the int
     */
    int num1() default 0;

    /**
     * Num 2 int.
     *
     * @return the int
     */
    int num2() default 0;
}

/**
 * The type Math.
 */
class Math {
    /**
     * Math sum.
     *
     * @param num1 the num 1
     * @param num2 the num 2
     */
    @MathAnno(num1 = 100, num2 = 200)
    public void MathSum(int num1, int num2) {
        System.out.println(num1 + num2);
    }
}