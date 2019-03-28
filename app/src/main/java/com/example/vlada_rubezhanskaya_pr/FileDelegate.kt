package com.example.vlada_rubezhanskaya_pr

import android.app.Activity
import android.content.Context
import java.io.File
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class FileDelegate(
    val fileName: String,
    val defaultValue: String
) : ReadWriteProperty<Activity, String> {

    override fun getValue(thisRef: Activity, property: KProperty<*>) = run {
        val file = File(thisRef.cacheDir, fileName)
        if (file.exists())
            file.readText()
        else
            defaultValue
    }

    override fun setValue(thisRef: Activity, property: KProperty<*>, value: String) = run {
        val file = File(thisRef.cacheDir, fileName)
        file.parentFile.mkdirs()
        if (!file.exists())
            file.createNewFile()
        file.writeText(value)
    }

}