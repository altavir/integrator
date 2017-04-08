package ru.mipt.npm.integrator

class SplitIntegrator(val integrator: UnivariateIntegrator, val borders: List<Double>) : UnivariateIntegrator {


    override fun integrate(func: (Double) -> Double, a: Double, b: Double): Double {
        assert(b > a)

        val filterBorders = borders.filter { it -> it > a && it < b }.sorted()

        var loBorder = a;

        var sum = 0.0

        for (upBorder in filterBorders) {
            sum += integrator.integrate(func, loBorder, upBorder);
            loBorder = upBorder;
        }
        sum += integrator.integrate(func, loBorder, b);

        return sum;
    }
}