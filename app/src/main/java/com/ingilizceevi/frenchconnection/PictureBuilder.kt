package com.ingilizceevi.frenchconnection

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.activityViewModels

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class PictureBuilder : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    lateinit var main : View
    lateinit var myGrammerPicture : ImageView
    lateinit var myContentPicture : ImageView
    lateinit var mySoundPlayer : SoundPlayer
    private val gameBrain: SoundBrain by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        gameBrain.createAllPossibleSounds()
        gameBrain.createAllPossibleGrammar()
        val x  = 2
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        main = inflater.inflate(R.layout.fragment_picture_builder, container, false)
        myGrammerPicture = main.findViewById(R.id.GrammerView)
        myContentPicture = main.findViewById(R.id.ContentView)
        return main
    }

    fun setScene(scenario:Array<Int>){
        changeGrammerImage(scenario[1])
        changeContentImage(scenario[0])
    }
    fun changeGrammerImage(GrammerNumber:Int){
        val i = gameBrain.grammarCount
        if(i==0){myGrammerPicture.setImageResource(R.drawable.positive)}
        if(i==1){myGrammerPicture.setImageResource(R.drawable.negativesign)}
        if(i==2){myGrammerPicture.setImageResource(R.drawable.question)}
        gameBrain.increaseGrammar()

    }
    fun changeContentImage(ConceptNumber:Int){
       // myContentPicture.visibility = View.INVISIBLE
        val d = gameBrain.allPossibleSounds[++gameBrain.pictureCount].myDrawable
        myContentPicture.setImageDrawable(d)
    }
    fun changeSubjectText(){
    }




    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PictureBuilder().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}