package com.ingilizceevi.frenchconnection

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentContainer
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.activityViewModels

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class TestFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    lateinit var main:View
    lateinit var buttonGrammer : Button
    lateinit var buttonContent: Button
    lateinit var mySoundPlayer : SoundPlayer
    private val gameBrain: SoundBrain by activityViewModels()


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
        main = inflater.inflate(R.layout.fragment_test, container, false)
        buttonContent = main.findViewById(R.id.button1)
        buttonGrammer = main.findViewById(R.id.button2)
        buttonContent.setOnClickListener(myButtonClicker)
        buttonGrammer.setOnClickListener(otherButtonClicker)
        mySoundPlayer = SoundPlayer(requireContext())

        return main
    }
    val myButtonClicker = View.OnClickListener {
        val p = childFragmentManager.findFragmentById(R.id.testFragmentContainer) as PictureBuilder
        val arr = arrayOf(10, 2, 0)
        p.setScene(arr)
        //p.changeContentImage(0)
    }

    val otherButtonClicker = View.OnClickListener {
        val a = gameBrain.allPossibleGrammar[0].myUri
        val b = gameBrain.allPossibleSounds[2].myUri
        val s = mutableListOf(a, b)
        mySoundPlayer.setupSoundSequence(s)
        mySoundPlayer.startSound()
    }

    fun createSoundList(i:Int, ii:Int):MutableList<Uri>{
       // val uri1 = gameBrain.allPossibleGrammar[i].myUri
        val uri2 = gameBrain.allPossibleSounds[ii].myUri
        val sounds = mutableListOf<Uri>(uri2, uri2)
        return sounds
    }


    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TestFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}