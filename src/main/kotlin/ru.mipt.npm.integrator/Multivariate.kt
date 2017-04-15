package ru.mipt.npm.integrator

/**
 * Created by darksnake on 15-Apr-17.
 */

val means = doubleArrayOf(0.0, 0.0, 0.0, 0.0, 0.0)
val sigmas = doubleArrayOf(1.0, 2.0, 3.0, 4.0, 5.0)

val gauss = GaussFunction(means, sigmas).asFunction();

fun main(args: Array<String>) {
    val n = 1000000;
    val integrator = SimpleMonteCarloIntegrator(n);

    val borders = sigmas.map { Pair(-it * 4, it * 4) }

    println("Интегрируем нормальное распределение в $n узлах:")

    println("Результат: ${integrator.integrate(gauss,borders)}")
}