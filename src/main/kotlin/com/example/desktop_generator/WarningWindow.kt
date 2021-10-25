package com.example.desktop_generator
import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage


class WarningWindow(warning: String = "") : Application() {
    override fun start(stage: Stage) {
        val fxmlLoader = FXMLLoader(HelloApplication::class.java.getResource("warning-windows.fxml"))
        val scene = Scene(fxmlLoader.load(), 400.0, 200.0)
        val controller = fxmlLoader.getController<WarningWindowController>()
        stage.title = "Warning Message"
        stage.scene = scene
        controller.onWarningWindowCreated(mWarnig)
        controller.close_button.setOnAction {
            stage.close()
            println("Warning Message Closed")
        }
        stage.show()
    }
    fun setWarning(warning: String) {
        mWarnig = warning
    }
    fun getWarning() = mWarnig
    private var mWarnig:String = warning
}

fun main() {
    Application.launch(HelloApplication::class.java)
}