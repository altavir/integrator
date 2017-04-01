package ru.mipt.npm.integrator

/**
 * A generic univariate integrator
 * Created by darksnake on 01-Apr-17.
 */
interface UnivariateIntegrator {
    fun integrate(func: (Double)-> Double, a: Double, b: Double): Double;
}