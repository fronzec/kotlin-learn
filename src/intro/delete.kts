package intro

import java.io.File

val purgeTime = System.currentTimeMillis() - args[1].toLong() * 24 * 60 * 60 * 1000
val folders = File(args[0]).listFiles { file -> file.isFile }
folders?.filter { file -> file.lastModified() < purgeTime }
    ?.forEach { file ->
        println("Deleting ${file.absolutePath}")
        file.delete()
    }