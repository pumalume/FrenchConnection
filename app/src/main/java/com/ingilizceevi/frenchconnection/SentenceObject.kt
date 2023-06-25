package com.ingilizceevi.frenchconnection

import android.net.Uri

class SentenceObject(s:Uri, p:Uri) {
    val subject : Uri = s
    val predicate : Uri = p
    val soundSequence = ArrayList<Uri>()
    init {
        createSoundSequence()
    }
    fun createSoundSequence(){
        soundSequence.add(subject)
        soundSequence.add(predicate)
    }

}