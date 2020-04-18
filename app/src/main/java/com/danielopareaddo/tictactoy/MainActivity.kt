package com.danielopareaddo.tictactoy

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        }

    fun buClicked (view: View){

        val buSelected = view as Button   //This will convert the variable into a button
        var cellID = 0

        when (buSelected.id){         //This will in put these numbers into the button per button ID(address) selected
            R.id.bu1 -> cellID =1
            R.id.bu2 -> cellID =2
            R.id.bu3 -> cellID =3
            R.id.bu4 -> cellID =4
            R.id.bu5 -> cellID =5
            R.id.bu6 -> cellID =6
            R.id.bu7 -> cellID =7
            R.id.bu8 -> cellID =8
            R.id.bu9 -> cellID =9

        }

        //Toast.makeText(this, "button $cellID pressed", Toast.LENGTH_SHORT).show()

        PlayGame(cellID, buSelected) // at the end of this buClicked function we will pass information or values of the cellID and buSelected variables to the function PlayGame
    }

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var activePlayer = 1

    fun PlayGame (cellID:Int, buSelected:Button){  // In this new function we will need 2 things the cellID which is an integer and the button variable with is of type Button.

        if (activePlayer == 1){

            buSelected.text = "X"
            buSelected.setBackgroundResource(R.color.blue)
            player1.add(cellID)
            activePlayer = 2
            autoPlay()

        }else {

            buSelected.text = "O"
            buSelected.setBackgroundResource(R.color.darkgreen)
            player2.add(cellID)
            activePlayer = 1

        }

        buSelected.isEnabled = false
        checkWinner()

    }

    fun checkWinner(){


        var winner = -1

        //row 1
        if(player1.contains(1) && player1.contains(2) && player1.contains(3)){
            winner = 1
        }
        if(player2.contains(1) && player2.contains(2) && player2.contains(3)){
            winner = 2
        }

        //row 2
        if(player1.contains(4) && player1.contains(5) && player1.contains(6)){
            winner = 1
        }
        if(player2.contains(4) && player2.contains(5) && player2.contains(6)){
            winner = 2
        }

        //row 3
        if(player1.contains(7) && player1.contains(8) && player1.contains(9)){
            winner = 1
        }
        if(player2.contains(7) && player2.contains(8) && player2.contains(9)){
            winner = 2
        }

        //column 1
        if(player1.contains(1) && player1.contains(4) && player1.contains(7)){
            winner = 1
        }
        if(player2.contains(1) && player2.contains(4) && player2.contains(7)){
            winner = 2
        }

        //column 2
        if(player1.contains(2) && player1.contains(5) && player1.contains(8)){
            winner = 1
        }
        if(player2.contains(2) && player2.contains(5) && player2.contains(8)){
            winner = 2
        }

        //column 3
        if(player1.contains(3) && player1.contains(6) && player1.contains(9)){
            winner = 1
        }
        if(player2.contains(3) && player2.contains(6) && player2.contains(9)){
            winner = 2
        }

        if (winner != -1){

         if (winner == 1){

             Toast.makeText(this, "Player 1 won the game", Toast.LENGTH_LONG).show()
         }else{
             Toast.makeText(this, "Player 2 won the game", Toast.LENGTH_LONG).show()
         }

        }


    }

    fun autoPlay () {

        var emptyCells = ArrayList<Int>()

        for (cellID in 1..9){

            if (!(player1.contains(cellID) || player2.contains(cellID))){
                emptyCells.add(cellID)
            }

        }

        val r = Random
        val randIndex = r.nextInt (emptyCells.size - 0) + 0
        val cellID = emptyCells[randIndex]                         //[] also means get


        var buSelected:Button?
        when (cellID){

            1 -> buSelected=bu1
            2 -> buSelected=bu2
            3 -> buSelected=bu3
            4 -> buSelected=bu4
            5 -> buSelected=bu5
            6 -> buSelected=bu6
            7 -> buSelected=bu7
            8 -> buSelected=bu8
            9 -> buSelected=bu9

            else -> {
                buSelected = bu1
            }
        }

        PlayGame(cellID, buSelected)

    }

}
