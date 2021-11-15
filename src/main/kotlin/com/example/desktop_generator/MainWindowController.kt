package com.example.desktop_generator

import javafx.fxml.FXML
import javafx.scene.control.*
import javafx.scene.layout.BorderPane
import kotlin.system.exitProcess

class MainWindowController {
    @FXML
    lateinit var close_button: Button
    @FXML
    lateinit var minimize_button : Button;
    @FXML
    lateinit var main_window_pane: BorderPane

    @FXML
    fun onCloseButtonClicked(){
        exitProcess(0)
    }
    @FXML
    fun onMinimizeButtonClicked(){

    }
}