package ru.mipt.npm.integrator

import java.util.*

class SimpleMonteCarloIntegrator(val n: Int = 10000) : MonteCarloIntegrator {
    val rnd = Random();


    override fun integrate(func: (List<Double>) -> Double, area: List<Pair<Double, Double>>): Double {
        var volume = 1.0;

        for (pair in area) {
            assert(pair.second > pair.first);
            volume *= (pair.second - pair.first);
        }

        var sum: Double = 0.0;

        for (i in (0..n)) {
            val vector = area.map { rnd.nextDouble() * (it.second - it.first) + it.first }
            sum += func(vector);
        }

        return volume * sum / n;

    }
}