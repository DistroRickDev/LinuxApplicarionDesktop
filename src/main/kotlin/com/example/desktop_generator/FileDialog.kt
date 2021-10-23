package com.example.desktop_generator

import javafx.stage.FileChooser
import java.io.File

class FileDialog() {
    companion object{
        fun getFileFromDialog(title: String, discription: String ="",filter: List<String> = listOf()): File {
            val fileChooser = FileChooser()
            if(discription.isNotEmpty() && filter.isNotEmpty()){
                val extFilter = FileChooser.ExtensionFilter(discription, filter)
                fileChooser.extensionFilters.add(extFilter)
            }
            fileChooser.title = "Choose the executable"
            return fileChooser.showOpenDialog(null)
        }
    }
}