package com.example.desktop_generator

import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.scene.control.Label

class WarningWindowController {
    @FXML
    private lateinit var  warning_label: Label
    lateinit var close_button: Button
    @FXML
    fun onWarningWindowCreated(arg: String){
        warning_label.text = arg
    }
}