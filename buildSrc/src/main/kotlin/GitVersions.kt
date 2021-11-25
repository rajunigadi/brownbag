import java.io.File
import java.util.concurrent.TimeUnit

object GitVersions {

    private fun gitSha(): String {
        return "git rev-parse --short HEAD".runCommand()
    }

    private fun gitTag(): String {
        "git fetch --tags".runCommand()
        val des = "git describe --tags".runCommand()
        println("des: $des") //g51bbcb0
        return des
    }

    fun getVersion(): List<Any> {
        var verName = gitTag()
        println("Versions: $verName") //v0.1-1-g51bbcb0
        if (verName.isEmpty()) {
            verName = gitSha()
            println("gitSha: $verName") //g51bbcb0
        }
        var tagSubversion = ""
        if (verName.count{ verName.contains("-") } > 1) {
            tagSubversion = verName.substring(verName.indexOf("-") + 1, verName.lastIndexOf("-"))
            println("tagSubversion: $tagSubversion") //v0.1-1-g51bbcb0
            verName = verName.substring(0, verName.indexOf("-"))// + "." + tagSubversion
            //verName += "-SNAPSHOT"
            println("verName: $verName") //v0.1-1-g51bbcb0
        } else {
            if (verName.count{ verName.contains(".")} < 2) {
                verName += if (verName.count{ verName.contains(".") } < 1) {
                    ".0.0"
                } else {
                    ".0"
                }
            }
        }
        var verCode = verName
            .replace(".$tagSubversion","")
            .replace(".","")
            .replace("-","")
            .replace("RC","")
            .replace("v","")
            .replace("SNAPSHOT","")
        if(verCode == "00" || verCode == "0") {
            verCode = "1"
        }
        println("Versions: $verName : $verCode")
        return listOf(verCode, verName)
    }

    private fun String.runCommand(workingDir: File = File("./")): String {
        val parts = this.split("\\s".toRegex())
        val process = ProcessBuilder(*parts.toTypedArray())
            .directory(workingDir)
            .redirectOutput(ProcessBuilder.Redirect.PIPE)
            .redirectError(ProcessBuilder.Redirect.PIPE)
            .start()

        process.waitFor(2, TimeUnit.MINUTES)
        return process.inputStream.bufferedReader().readText().trim()
    }
}
