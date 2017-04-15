package ru.mipt.npm.integrator.visualization

import javafx.application.Platform
import javafx.collections.FXCollections
import javafx.scene.chart.NumberAxis
import javafx.scene.chart.XYChart
import ru.mipt.npm.integrator.badFunc
import ru.mipt.npm.integrator.sinFunc
import tornadofx.*

/**
 * Created by darksnake on 29-Mar-17.
 */
class Plot : View("My View") {
    val theData = FXCollections.observableArrayList<XYChart.Series<Number, Number>>();


    override val root = borderpane {
        center {
            linechart("function demo", NumberAxis(), NumberAxis()) {
                id = "plot";
                data = theData
                createSymbols = false
            }
        }
    }

    init {
        displayFunction(badFunc, 0.0, Math.PI, "bad")
        displayFunction(sinFunc, 0.0, Math.PI, "sin")
        //displayFunction({ x -> x * x }, 0.0, Math.PI, "parabola")
    }

    fun displayFunction(function: (Double) -> Double, a: Double, b: Double, label: String = "", numPoints: Int = 600) {
        val series = XYChart.Series<Number, Number>();
        series.name = label;


        val step = (b - a) / (numPoints - 1)

        (0..numPoints)
                .map { a + it * step }
                .forEach { series.data.add(XYChart.Data(it, function(it))) }
        Platform.runLater { theData.add(series) }
    }
}
