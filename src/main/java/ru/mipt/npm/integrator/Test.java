package ru.mipt.npm.integrator;

/**
 * Created by darksnake on 25-Mar-17.
 */
public class Test {
    public static void main(String[] args){
        Func func = x -> Math.sin(x);

        System.out.println("Hello world");
    }

    static class MyFunction implements Func{

        @Override
        public double value(double value) {
            return 0;
        }
    }
}
