package ru.mipt.npm.integrator

/**
 * Created by darksnake on 15-Apr-17.
 */
class GaussFunction(val mean: DoubleArray, val sigmas: DoubleArray) {
    fun value(x: DoubleArray): Double {
        assert(x.size == mean.size);

        var norm = 1.0;
        var prod = 1.0;

        for (i in (0..x.size-1)) {
            norm *= Math.sqrt(2.0 * Math.PI) * sigmas[i]
            val d = (x[i] - mean[i]) / sigmas[i];
            prod *= Math.exp(-d * d / 2.0);
        }

        return prod / norm;
    }

    fun value(x: List<Double>): Double {
        return value(x.toDoubleArray())
    }

    fun asFunction(): (List<Double>) -> Double {
        return { x : List<Double> -> value(x) };
    }

}