package ru.mipt.npm.integrator

import java.nio.charset.Charset

/**
 * Created by darksnake on 25-Mar-17.
 */

fun main(args: Array<String>) {

    println(Charset.defaultCharset())

    val sin = Func { x -> Math.sin(x) }

    println("Integrating sine from 0 to Pi")

    val res = rieman(sin::value, 0.0, Math.PI, 400)

    println("Результат: ${res}")

}


/**
 *
 */
fun rieman(function: (Double) -> Double, a: Double, b: Double, numPoints: Int = 200): Double {
    var sum: Double = 0.0;

    val step = (b - a) / (numPoints - 1)

    for (i in 0..numPoints) {
        val x = a + i * step
        sum += function(x) * step
    }
    return sum;
}
