package ru.mipt.npm.integrator

/**
 * Created by darksnake on 15-Apr-17.
 */
data class UnivariateIntegrand(
        val function: (Double) -> Double,
        val low: Double,
        val up: Double,
        val res: Double? = null
//        val numCalls: Int = 0,
)