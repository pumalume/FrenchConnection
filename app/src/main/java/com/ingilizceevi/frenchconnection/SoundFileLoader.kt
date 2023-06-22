package com.ingilizceevi.frenchconnection

import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Environment
import java.io.File

class SoundFileLoader(location:String) {
    val location = location
    fun fillAudioMap(): MutableList<ConceptualObject> {
        val myConceptualObjectList: MutableList<ConceptualObject> = ArrayList(0)
        val myPath = Environment.getExternalStorageDirectory().path + "/Music/" + location + "/"
        //val myPath = Environment.getExternalStorageDirectory().path + "/Music/MySounds/" + myChapter + "/"
        File(myPath).walkBottomUp().forEach {
            if (it.isFile) {
                val u = Uri.parse(it.toString())
                val s = it.toString().substringAfterLast("/").dropLast(4)
                myConceptualObjectList.add(ConceptualObject(u, s))
            }
        }
        return myConceptualObjectList
    }
}