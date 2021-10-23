package com.example.desktop_generator

import java.io.File

class GenerateFile(app: LinuxApplication?) {
    fun generate() {
        mFile.writeText("[Desktop Entry]\n" +
                "Comment=${mLinuxApplication.getComment()}\n" +
                "Exec=${mLinuxApplication.getExecutablePath()}\n" +
                "Icon=${mLinuxApplication.getIconPath()}\n" +
                "Name=${mLinuxApplication.getApplicationName()}\n" +
                "NoDisplay=false\n" +
                "Terminal=${mTerminalStatus}\n" +
                "Type=Application\n")
        println("FILE GENERATED WITH SUCCESS")
    }

    private lateinit var mLinuxApplication: LinuxApplication
    private val mUser: String = System.getenv("USER")
    private val mApplicationLocation: String = "/home/$mUser/.local/share/applications/"
    private val mFileType: String = ".desktop"
    private lateinit var mFile: File
    private lateinit var mTerminalStatus: String
    init {
        if (app != null) {
            mLinuxApplication = app
            mTerminalStatus = mLinuxApplication.getConsoleEnablingStatus().toString()
            mFile= File(mApplicationLocation + mLinuxApplication.getApplicationName() + mFileType)
        }
        mFile.createNewFile()
    }
}