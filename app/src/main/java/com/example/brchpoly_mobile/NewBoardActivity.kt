package com.example.brchpoly_mobile

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_new_board.*
import petrov.kristiyan.colorpicker.ColorPicker
import petrov.kristiyan.colorpicker.ColorPicker.OnChooseColorListener
import java.lang.Integer.parseInt
import java.lang.Integer.parseUnsignedInt
import java.util.*

var selectedMode="none"
class NewBoardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_board)
        //actionbar
        val playerDiv1=findViewById<LinearLayout>(R.id.player1Div)
        val playerDiv2=findViewById<LinearLayout>(R.id.player2Div)
        val playerDiv3=findViewById<LinearLayout>(R.id.player3Div)
        val playerDiv4=findViewById<LinearLayout>(R.id.player4Div)
        val randomColorsButton=findViewById<Button>(R.id.randomColors)

        var player1Name=findViewById<EditText>(R.id.player1Name)
        var player2Name=findViewById<EditText>(R.id.player2Name)
        var player3Name=findViewById<EditText>(R.id.player3Name)
        var player4Name=findViewById<EditText>(R.id.player4Name)

        val color1=findViewById<Button>(R.id.player1Color)
        val color2=findViewById<Button>(R.id.player2Color)
        val color3=findViewById<Button>(R.id.player3Color)
        val color4=findViewById<Button>(R.id.player4Color)
        val createBoard=findViewById<Button>(R.id.createBoard)
        val actionbar = supportActionBar
        var boardName=findViewById(R.id.boardName) as EditText
        var startingBalance=findViewById<TextView>(R.id.editTextNumber)
        var salary=findViewById<TextView>(R.id.editTextNumber2)
        //*** Inputs
        fun validator(){
            var canCreate=true
            if(boardName.text.length<1){
                Toast.makeText(this,"Name of the board is to short :/", Toast.LENGTH_SHORT).show()
                canCreate=false
            }
            if(startingBalance.text.toString()!=""){
                if(parseUnsignedInt(startingBalance.text.toString()) <1) {
                    Toast.makeText(this, "Your starting balance is too low", Toast.LENGTH_SHORT).show()
                    canCreate = false
                }
                if(parseUnsignedInt(startingBalance.text.toString())>1000000){
                    Toast.makeText(this,"Your starting balance is too high", Toast.LENGTH_SHORT).show()
                    canCreate=false}}
            if(startingBalance.text.toString()==""){
                Toast.makeText(this, "Your starting balance is too low", Toast.LENGTH_SHORT).show()
                canCreate = false
            }
            if(salary.text.toString()!=""){
                if(parseUnsignedInt(salary.text.toString()) <1) {
                    Toast.makeText(this, "Your salary is too low", Toast.LENGTH_SHORT).show()
                    canCreate = false
                }
                if(parseUnsignedInt(salary.text.toString())>1000000){
                    Toast.makeText(this,"Your salary is too high", Toast.LENGTH_SHORT).show()
                    canCreate=false}}
            if(salary.text.toString()==""){
                Toast.makeText(this, "Your salary is too low", Toast.LENGTH_SHORT).show()
                canCreate = false
            }
            if(selectedMode=="none"){
                Toast.makeText(this, "Your've to select game mode first", Toast.LENGTH_SHORT).show()
                canCreate = false
            }
            if(selectedMode=="2" && player1Name.text.toString()=="" || player2Name.text.toString()==""){
                Toast.makeText(this, "Every player must have a name", Toast.LENGTH_SHORT).show()
                canCreate = false
            }
            if(selectedMode=="3" && player1Name.text.toString()=="" || player2Name.text.toString()=="" || player3Name.text.toString()==""){
                Toast.makeText(this, "Every player must have a name", Toast.LENGTH_SHORT).show()
                canCreate = false
            }
            if(selectedMode=="4" && player1Name.text.toString()=="" || player2Name.text.toString()=="" || player3Name.text.toString()=="" || player4Name.text.toString()==""){
                Toast.makeText(this, "Every player must have a name", Toast.LENGTH_SHORT).show()
                canCreate = false
            }

            if(canCreate){

            }
        }
        //***
        //set actionbar title
        actionbar!!.title = "Board creator"
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)

        radioGroup.setOnCheckedChangeListener(
            RadioGroup.OnCheckedChangeListener { group, checkedId ->
                val radio: RadioButton = findViewById(checkedId)
                if(radio.text=="2 players"){
                    selectedMode="2"
                    playerDiv1.visibility = View.VISIBLE
                    playerDiv2.visibility = View.VISIBLE
                    playerDiv3.visibility = View.INVISIBLE
                    playerDiv4.visibility = View.INVISIBLE
                }
                if(radio.text=="3 players"){
                    selectedMode="3"
                    playerDiv1.visibility = View.VISIBLE
                    playerDiv2.visibility = View.VISIBLE
                    playerDiv3.visibility = View.VISIBLE
                    playerDiv4.visibility = View.INVISIBLE
                }
                if(radio.text=="4 players"){
                    selectedMode="4"
                    playerDiv1.visibility = View.VISIBLE
                    playerDiv2.visibility = View.VISIBLE
                    playerDiv3.visibility = View.VISIBLE
                    playerDiv4.visibility = View.VISIBLE
                }
            })
        fun randomColors(){
            color1.setBackgroundColor(Random().nextInt())
            color2.setBackgroundColor(Random().nextInt())
            color3.setBackgroundColor(Random().nextInt())
            color4.setBackgroundColor(Random().nextInt())
        }
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
        randomColorsButton.setOnClickListener(){
            randomColors()
        }
        createBoard.setOnClickListener(){
           validator()

        }
        randomColors()

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    }



