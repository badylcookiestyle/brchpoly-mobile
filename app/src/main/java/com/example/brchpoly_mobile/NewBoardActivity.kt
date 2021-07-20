package com.example.brchpoly_mobile

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_new_board.*
import petrov.kristiyan.colorpicker.ColorPicker
import petrov.kristiyan.colorpicker.ColorPicker.OnChooseColorListener
import java.lang.Math.log


class NewBoardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_board)
        //actionbar
        var playerDiv1=findViewById<RadioButton>(R.id.player1Div)
        var playerDiv2=findViewById<RadioButton>(R.id.player2Div)
        var playerDiv3=findViewById<RadioButton>(R.id.player3Div)
        var playerDiv4=findViewById<RadioButton>(R.id.player4Div)

        var color1=findViewById<Button>(R.id.player1Color)
        var color2=findViewById<Button>(R.id.player2Color)
        var color3=findViewById<Button>(R.id.player3Color)
        var color4=findViewById<Button>(R.id.player4Color)
        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "Board creator"
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)
        radioGroup.setOnCheckedChangeListener(
            RadioGroup.OnCheckedChangeListener { group, checkedId ->
                val radio: RadioButton = findViewById(checkedId)
                if(radio.text=="2 players"){
            //        playerDiv1.visibility = View.VISIBLE
              //      playerDiv2.visibility = View.VISIBLE
                }
            })
        fun drawPicker(inst: Button){

            var colorPicker = ColorPicker(this)

            colorPicker.setOnChooseColorListener(object : OnChooseColorListener {
                override fun onChooseColor(position: Int, color: Int) {
                    inst.setBackgroundColor(color)
                }

                override fun onCancel() {
                    // put code
                }
            })
            colorPicker.show()
        }
        color1.setOnClickListener{
            drawPicker(color1)
        }
        color2.setOnClickListener{
            drawPicker(color2)
        }
        color3.setOnClickListener {
            drawPicker(color3)
        }
        color4.setOnClickListener{
            drawPicker(color4)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    }



