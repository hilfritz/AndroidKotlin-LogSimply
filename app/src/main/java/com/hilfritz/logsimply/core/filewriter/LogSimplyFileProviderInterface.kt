package com.hilfritz.logsimply.core.filewriter

import java.io.File

/**
 *
 * @author Hilfritz Camallere on 21/6/18
 *
 */
interface LogSimplyFileProviderInterface {
    var logFile:File?
    fun getFile(): File
    fun writeStringToFile(data: String, file:File)
    fun readStringFromTextFile(file:File):String
}