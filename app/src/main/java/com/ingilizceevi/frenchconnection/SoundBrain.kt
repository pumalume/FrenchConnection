package com.ingilizceevi.frenchconnection


import android.net.Uri
import androidx.lifecycle.ViewModel

class SoundBrain: ViewModel(){

    lateinit var soundSequenceToBePlayed: MutableList<Int>
    lateinit var allPossibleSounds: MutableList<ConceptualObject>
    lateinit var allPossibleGrammar: MutableList<ConceptualObject>
    var pictureCount = 0
    var grammarCount = 0
    val scenario = arrayOf(0, 0, 0)

    fun increaseGrammar(){
        grammarCount++
        if(grammarCount==3) grammarCount=0
    }
    fun createAllPossibleSounds(){
        allPossibleSounds = SoundFileLoader("chapter01").fillAudioMap()
    }
    fun createAllPossibleGrammar(){
        allPossibleGrammar = SoundFileLoader("grammar").fillAudioMap()
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