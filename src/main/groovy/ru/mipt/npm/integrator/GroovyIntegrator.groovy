package ru.mipt.npm.integrator

import static ru.mipt.npm.integrator.IntegratorKt.rieman

/**
 * Скрипт аналогичный IntegratorKt
 * Created by darksnake on 26-Mar-17.
 */


println "Интегрируем синус от 0 до \u03c0 по схеме Римана"

def res = rieman({ x -> Math.sin(x) }, 0.0, Math.PI,200)

println "Результат: ${res}"

println "Относительная погрешность: ${1d - res / 2d}"