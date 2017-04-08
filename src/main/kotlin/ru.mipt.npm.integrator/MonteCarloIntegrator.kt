package ru.mipt.npm.integrator

/**
 * Created by darksnake on 07-Apr-17.
 */
interface MonteCarloIntegrator {
    fun integrate(func: (List<Double>) -> Double, area: List<Pair<Double, Double>>) : Double;
}