package com.example.desktop_generator

class LinuxApplication(
    appName: String,
    execPath: String,
    iconPath: String,
    consoleStatus: Boolean,
    comment: String = " "
) {
    private var mApplicationName: String = appName
    private var mExecutablePath: String = execPath
    private var mIconPath: String = iconPath
    private var mIsConsoleEnabled = consoleStatus
    private var mComment: String = comment

    fun getApplicationName() = mApplicationName
    fun getExecutablePath() = mExecutablePath
    fun getIconPath() = mIconPath
    fun getConsoleEnablingStatus() = mIsConsoleEnabled
    fun getComment() = mComment
}