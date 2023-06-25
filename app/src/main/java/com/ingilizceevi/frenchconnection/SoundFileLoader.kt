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
        return fillMyArray(myConceptualObjectList)
    }

    fun fillMyArray(co : MutableList<ConceptualObject>):MutableList<ConceptualObject> {
        var i = 0
        val myListOfDrawableObjects : MutableList<ConceptualObject> = ArrayList(0)
        val myPath = Environment.getExternalStorageDirectory().path + "/Pictures/" + location + "/"
        //val myPath = Environment.getExternalStorageDirectory().path + "/Pictures/MyImages/" + myChapter + "/"
        File(myPath).walkBottomUp().forEach {
            if (it.isFile) {
                val d = Drawable.createFromPath(it.absolutePath)!!
                val s = it.toString().substringAfterLast("/").dropLast(4)
                co[i++].myDrawable = d
            }
        }
        return co
    }
}