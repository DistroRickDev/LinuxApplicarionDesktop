package com.example.desktop_generator

import javafx.fxml.FXML
import javafx.scene.control.*
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.stage.FileChooser

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
        val file = FileDialog.getFileFromDialog("Choose the executable")
        if (file.isFile) {
            println("Chosen file ${file.name}")
            executable_input.text = file.absolutePath
        }
    }

    @FXML
    fun onIconSearchButtonClicked() {
        val file = FileDialog.getFileFromDialog("Choose an icon", "Image file formats", listOf("*.png", "*.jpg", "*.jpeg"))
        if (file.isFile) {
            icon_imageview.image = Image(file.toURI().toString())
            mImageUrl = icon_imageview.image.url.drop(5)
        }
    }

    @FXML
    fun onGenerateButtonClicked() {
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

