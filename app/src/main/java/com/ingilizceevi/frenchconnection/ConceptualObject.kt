package com.ingilizceevi.frenchconnection

import android.graphics.drawable.Drawable
import android.net.Uri

class ConceptualObject(uri : Uri, string:String) {

        val myString : String? = string
        val myUri : Uri = uri
        lateinit var myDrawable : Drawable

}