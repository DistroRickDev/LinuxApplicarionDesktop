package com.example.desktop_generator

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage
import javafx.stage.StageStyle

class DesktopGeneratorApp : Application() {
    override fun start(stage: Stage) {
        val fxmlLoader = FXMLLoader(DesktopGeneratorApp::class.java.getResource("main-window.fxml"))
        val scene = Scene(fxmlLoader.load(), 600.0, 400.0)
        scene.stylesheets.add("MainWindow.css")
        stage.initStyle(StageStyle.UNDECORATED)
        stage.title = "Linux Application Generator"
        stage.scene = scene
        stage.show()
    }
}