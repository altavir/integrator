package ru.mipt.npm.integrator

import java.nio.charset.Charset

/**
 * Created by darksnake on 25-Mar-17.
 */


val sinFunc = { x: Double -> Math.sin(x) }

fun normal(x: Double, x0: Double = 0.5, sigma: Double = 0.1): Double {
    return 1.0 / Math.sqrt(2.0 * Math.PI) / sigma * Math.exp(-(x - x0) * (x - x0) / 2 / sigma / sigma);
}

val badFunc = { x: Double -> Math.sin(x) + normal(x, sigma = 0.002) }


fun main(args: Array<String>) {

    println(Charset.defaultCharset())

    //val sin = Func { x -> Math.sin(x) }

//    println("Integrating sine from 0 to Pi")

    println("Интегрируем плохую функцию:")

    val riemann = RiemannIntegrator(100);
    println("Метод прямоугольников, 100 узлов: ${riemann.integrate(badFunc, 0.0, Math.PI)}")

    val riemannDense = RiemannIntegrator(300);
    println("Метод прямоугольников, 300 узлов: ${riemannDense.integrate(badFunc, 0.0, Math.PI)}")

    val riemannVeryDense = RiemannIntegrator(500);
    println("Метод прямоугольников, 500 узлов: ${riemannVeryDense.integrate(badFunc, 0.0, Math.PI)}")

    val split = SplitIntegrator(riemann, listOf(0.4, 0.6))
    println("Раздельное интегрирование, 300 узлов: ${split.integrate(badFunc, 0.0, Math.PI)}")

}

