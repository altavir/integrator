package ru.mipt.npm.integrator.visualization

import javafx.stage.Stage
import tornadofx.*

/**
 * Created by darksnake on 29-Mar-17.
 */
class Viewer: App(Plot::class) {

    override fun start(stage: Stage) {
        super.start(stage)
        stage.isFullScreen = true
    }
}