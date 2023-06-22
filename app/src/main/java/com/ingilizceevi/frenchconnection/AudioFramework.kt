package com.ingilizceevi.frenchconnection

import android.media.MediaPlayer
import android.media.MediaPlayer.OnCompletionListener
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AudioFramework.newInstance] factory method to
 * create an instance of this fragment.
 */
class AudioFramework : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private val soundBrain: SoundBrain by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val main = inflater.inflate(R.layout.fragment_audio_framework, container, false)
        val button = main.findViewById<Button>(R.id.button)
        button.setOnClickListener(myOnClickListener)

        return main
    }

    val myOnClickListener = View.OnClickListener { createAudioFile() }

    fun createAudioFile(){
        val a :Array<Int> = arrayOf(0,1,2)
        soundBrain.createAllPossibleSounds()
        soundBrain.createNewSoundSequenceToBePlayed(a)
        val soundPlayer = SoundPlayer(requireContext(), soundBrain.createSound())
        soundPlayer.startSound()


    }

        companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AudioFramework.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AudioFramework().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}