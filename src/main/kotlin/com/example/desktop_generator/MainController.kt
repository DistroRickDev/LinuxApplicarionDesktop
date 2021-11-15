package com.example.desktop_generator

import javafx.fxml.FXML
import javafx.scene.control.*
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.stage.Stage

class MainController() {
    private lateinit var mImageUrl: String

    @FXML
    private lateinit var icon_imageview: ImageView

    @FXML
    private lateinit var application_input: TextField

    @FXML
    private lateinit var executable_input: TextField

    @FXML
    private lateinit var comment_text_input: TextField

    @FXML
    private lateinit var terminal_checkbox: CheckBox

    @FXML
    fun onSearchExecutableClicked() {
        try {
            val file = FileDialog.getFileFromDialog("Choose the executable")
            if (file.isFile && file.canExecute()) {
                println("Chosen file ${file.name}")
                executable_input.text = file.absolutePath
            }
            else{
                println("Invalid executable")
                val warningWindow = WarningWindow("Invalid executable")
                warningWindow.start(Stage())
            }
        } catch (er: NullPointerException) {
            println("Error choosing file")
            val warningWindow = WarningWindow("Invalid executable file")
            warningWindow.start(Stage())
        }
    }

    @FXML
    fun onIconSearchButtonClicked() {
        try {
            val file =
                FileDialog.getFileFromDialog("Choose an icon", "Image file formats", listOf("*.png", "*.jpg", "*.jpeg"))
            if (file.isFile) {
                icon_imageview.image = Image(file.toURI().toString())
                mImageUrl = icon_imageview.image.url.drop(5)
            }
        } catch (er: NullPointerException) {
            println("Error choosing file")
            val warningWindow = WarningWindow("Invalid icon file")
            warningWindow.start(Stage())
        }

    }

    @FXML
    fun onGenerateButtonClicked() {
            val warningWindow = WarningWindow()
            if(application_input.text.isEmpty()){
                warningWindow.setWarning("Application name is empty")
            }
            else if(executable_input.text.isEmpty()){
                warningWindow.setWarning("Executable is empty or invalid")
            }
            else if(!::mImageUrl.isInitialized){
                warningWindow.setWarning("Icon is empty or invalid")
            }
            if(warningWindow.getWarning().isNotEmpty() || warningWindow.getWarning().isNotBlank()){
                warningWindow.start(Stage())
                return
            }
            val fileGenerator = GenerateFile(
                LinuxApplication(
                    application_input.text,
                    executable_input.text,
                    mImageUrl,
                    terminal_checkbox.isSelected,
                    comment_text_input.text
                )
            )
            fileGenerator.generate()
        }
}

