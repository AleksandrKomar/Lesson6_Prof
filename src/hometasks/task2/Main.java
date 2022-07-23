package hometasks.task2;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
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
     * @throws MyException           the my exception
     */
    public static void main(String[] args) throws NoSuchMethodException, MyException {
        Math math = new Math();

        Class<?> cl = Math.class;
        Method method = cl.getDeclaredMethod("MathMul", int.class, int.class);
        MathAnno mathAnno = method.getAnnotation(MathAnno.class);

        math.MathSum(mathAnno.num1(), mathAnno.num2());
        math.MathMul(mathAnno.num1(), mathAnno.num2());
        math.MathDiv(mathAnno.num1(), mathAnno.num2());
        math.Mathsub(mathAnno.num1(), mathAnno.num2());
    }

}

/**
 * The interface Math anno.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface MathAnno {
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

    /**
     * Math mul.
     *
     * @param num1 the num 1
     * @param num2 the num 2
     */
    @MathAnno(num1 = 100, num2 = 200)
    public void MathMul(int num1, int num2) {
        System.out.println(num1 * num2);
    }

    /**
     * Math div.
     *
     * @param num1 the num 1
     * @param num2 the num 2
     * @throws MyException the my exception
     */
    @MathAnno(num1 = 100, num2 = 200)
    public void MathDiv(int num1, int num2) throws MyException {

        try {
            System.out.println(num1 / num2);
        } catch (ArithmeticException ex) {
            throw new MyException("Divide by Zero!!!");
        }

    }

    /**
     * Mathsub.
     *
     * @param num1 the num 1
     * @param num2 the num 2
     */
    @MathAnno(num1 = 100, num2 = 200)
    public void Mathsub(int num1, int num2) {
        System.out.println(num1 - num2);
    }

}