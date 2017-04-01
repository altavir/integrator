package ru.mipt.npm.integrator

/**
 * Simple Riemann integrator with fixed number of nodes
 */
class RiemannIntegrator(val numPoints: Int) : UnivariateIntegrator {

    override fun integrate(func: (Double) -> Double, a: Double, b: Double): Double {
        var sum: Double = 0.0;

        val step = (b - a) / (numPoints - 1)

        for (i in 0..numPoints) {
            val x = a + i * step
            sum += func(x) * step
        }
        return sum;
    }
}