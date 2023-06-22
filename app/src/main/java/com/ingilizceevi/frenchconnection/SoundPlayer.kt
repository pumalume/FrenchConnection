package com.ingilizceevi.frenchconnection

import android.content.Context
import android.media.MediaPlayer
import android.media.MediaPlayer.OnCompletionListener
import android.net.Uri
import android.widget.Toast
import java.io.IOException


class SoundPlayer(context: Context, pl:MutableList<Uri>) {
    val context = context
    var mMediaPlayer : MediaPlayer? = null
    var playIndex = 0
    val playList = pl

    fun startSound() {
        mMediaPlayer = MediaPlayer()
        mMediaPlayer!!.setDataSource(context, playList[playIndex])
        mMediaPlayer!!.prepare()
        mMediaPlayer!!.setOnCompletionListener(completionListener)
        mMediaPlayer!!.start()
    }

    val completionListener = OnCompletionListener { mediaPlayer ->
        playIndex++
        if (playIndex < playList.size) {
            try {
                mediaPlayer!!.setDataSource(context, playList[playIndex])
                mediaPlayer!!.prepare()
                mediaPlayer.start()
            } catch (e: IOException) { }
        } else { }
    }
}