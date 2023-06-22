package com.ingilizceevi.frenchconnection


import android.net.Uri
import androidx.lifecycle.ViewModel

class SoundBrain: ViewModel(){

    lateinit var soundSequenceToBePlayed: MutableList<Int>
    lateinit var allPossibleSounds: MutableList<ConceptualObject>

    fun createAllPossibleSounds(){
        allPossibleSounds = SoundFileLoader("chapter98").fillAudioMap()
    }
    fun createNewSoundSequenceToBePlayed(array:Array<Int>){
        val tempList : MutableList<Int> = arrayListOf(0)
        val size = array.size
        for(i in 0 until size){
            tempList.add(array[i])
        }
        soundSequenceToBePlayed = tempList
    }

    fun createSound():MutableList<Uri>{
        val mySound : MutableList<Uri> = ArrayList(0)
        for(i in 0 until soundSequenceToBePlayed.size){
            val key = soundSequenceToBePlayed[i]
            val concept = allPossibleSounds[key]
            mySound.add(concept.myUri)
        }
        return mySound
    }
}