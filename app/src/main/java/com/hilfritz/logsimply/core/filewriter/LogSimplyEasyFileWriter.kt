package com.hilfritz.logsimply.core.filewriter

import android.os.Environment
import java.io.*


/**
 *
 * @author Hilfritz Camallere on 21/6/18
 *
 */
class LogSimplyEasyFileWriter: LogSimplyFileProviderInterface {


    override var logFile: File? = null

    override fun readStringFromTextFile(file: File):String {
        var retVal = ""
        try {
            val inputStream: InputStream = file.inputStream()
            retVal = inputStream.bufferedReader().use { it.readText() }
        } catch (e: Exception) {
            //You'll need to add proper error handling here
            e.printStackTrace()
        }
        return retVal;
    }

    override fun getFile(): File {
        val path = Environment.getExternalStorageDirectory().toString() + File.separator + "log"
        // Create the folder.
        val folder = File(path)
        folder.mkdirs()

        // Create the file.
        logFile = File(folder, "logs.txt")
        return logFile!!
    }

    override fun writeStringToFile(data: String, file:File) {
        // Get the directory for the user's public pictures directory.
        // Save your stream, don't forget to flush() it before closing it.
        try {
            file.createNewFile()
            val fOut = FileOutputStream(file)
            val myOutWriter = OutputStreamWriter(fOut)
            myOutWriter.append(data)

            myOutWriter.close()

            fOut.flush()
            fOut.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}