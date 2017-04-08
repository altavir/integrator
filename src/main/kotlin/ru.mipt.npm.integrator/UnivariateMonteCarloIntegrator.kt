package ru.mipt.npm.integrator

class UnivariateMonteCarloIntegrator(val n: Int = 500) : UnivariateIntegrator {
    val integrator = SimpleMonteCarloIntegrator(n);

    override fun integrate(func: (Double) -> Double, a: Double, b: Double): Double {
        val mFunc: (List<Double>) -> Double = { list -> func(list[0]) }
        val area = arrayListOf(Pair(a, b));

        return integrator.integrate(mFunc, area);
    }
}