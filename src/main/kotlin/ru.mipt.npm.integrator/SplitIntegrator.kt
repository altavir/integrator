package ru.mipt.npm.integrator

class SplitIntegrator(val integrator: UnivariateIntegrator, val borders: List<Double>) : UnivariateIntegrator {

    override fun integrate(func: (Double) -> Double, a: Double, b: Double): Double {

        var curA = a;
        var curB = Math.min(borders[0], b);

        var sum = 0.0

        for (border in borders) {
            if (border <= b) {
                sum += integrator.integrate(func, curA, curB);
                curA = curB;
                curB = Math.min(border, b);
            }
        }

        return sum;
    }
}