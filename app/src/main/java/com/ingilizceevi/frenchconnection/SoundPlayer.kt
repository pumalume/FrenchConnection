package com.ingilizceevi.frenchconnection

import android.content.Context
import android.media.MediaPlayer
import android.media.MediaPlayer.OnCompletionListener
import android.net.Uri
import android.widget.Toast
import java.io.IOException


class SoundPlayer(c: Context) {
    private val context = c
    private lateinit var mMediaPlayer : MediaPlayer
    private var playIndex = 0
    private lateinit var sounds : MutableList<Uri>

    fun setupSoundSequence(s:MutableList<Uri>){

        sounds = s
        playIndex=0
    }
    fun startSound() {
        mMediaPlayer = MediaPlayer()
        mMediaPlayer.setDataSource(context, sounds[playIndex++])
        mMediaPlayer.prepare()
        mMediaPlayer.setOnCompletionListener(completionListener)
        mMediaPlayer!!.start()
    }

    val completionListener = OnCompletionListener { mediaPlayer ->
        if (playIndex < sounds.size) {
            try {
                startSound()
            } catch (e: IOException) { }
        } else { }
    }
}