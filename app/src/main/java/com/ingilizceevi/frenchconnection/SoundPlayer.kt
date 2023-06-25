package com.ingilizceevi.frenchconnection

import android.content.Context
import android.media.MediaPlayer
import android.media.MediaPlayer.OnCompletionListener
import android.net.Uri
import android.widget.Toast
import java.io.IOException


class SoundPlayer(context: Context, pl:MutableList<ConceptualObject>, a:Array<Int>) {
    val context = context
    var mMediaPlayer : MediaPlayer? = null
    val mArray = a
    var playIndex = 0
    val playList = pl

    fun startSound() {
        val index = mArray[playIndex++]
        if(mMediaPlayer!=null)mMediaPlayer!!.release()
        mMediaPlayer = MediaPlayer()
        mMediaPlayer!!.setDataSource(context, playList[index].myUri)
        mMediaPlayer!!.prepare()
        mMediaPlayer!!.setOnCompletionListener(completionListener)
        mMediaPlayer!!.start()
    }

    val completionListener = OnCompletionListener { mediaPlayer ->
        if (playIndex < playList.size) {
            try {
                startSound()
            } catch (e: IOException) { }
        } else { }
    }

    fun getSubjectSound(subject:Int):MediaPlayer{

//        if(mMediaPlayer!=null)mMediaPlayer!!.release()
//        when(subject){
//
//        }
    return MediaPlayer()
    }
}