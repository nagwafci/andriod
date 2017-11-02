package com.example.magic.tictacmalk

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    var player1= ArrayList<Int>()
    var player2= ArrayList<Int>()
    var ActivePlayer=1
    var emptyCells= ArrayList<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buClick(view: View){
        val buSelected= view as Button
        var cellID:Int=0
        when(buSelected.id){
            R.id.b1-> cellID=1
            R.id.b2-> cellID=2
            R.id.b3-> cellID=3
            R.id.b4-> cellID=4
            R.id.b5-> cellID=5
            R.id.b6-> cellID=6
            R.id.b7-> cellID=7
            R.id.b8-> cellID=8
            R.id.b9-> cellID=9

        }


        PlayGame(cellID,buSelected)
    }


    fun PlayGame(cellID:Int,buSelected: Button){

        if(ActivePlayer==1){

            buSelected.setBackgroundResource(R.drawable.malk)
            player1.add(cellID)
            ActivePlayer=2
            AutoPlay()
        }else{

            buSelected.setBackgroundResource(R.color.darkgreen)
            player2.add(cellID)
            ActivePlayer=1
        }


        buSelected.isEnabled=false
        CheckWiner()
    }
    fun  CheckWiner(){
        var winer=-1

        // row 1
        if(player1.contains(1) && player1.contains(2) && player1.contains(3)){
            winer=1
        }
        if(player2.contains(1) && player2.contains(2) && player2.contains(3)){
            winer=2
        }


        // row 2
        if(player1.contains(4) && player1.contains(5) && player1.contains(6)){
            winer=1
        }
        if(player2.contains(4) && player2.contains(5) && player2.contains(6)){
            winer=2
        }




        // row 3
        if(player1.contains(7) && player1.contains(8) && player1.contains(9)){
            winer=1
        }
        if(player2.contains(7) && player2.contains(8) && player2.contains(9)){
            winer=2
        }



        // col 1
        if(player1.contains(1) && player1.contains(4) && player1.contains(7)){
            winer=1
        }
        if(player2.contains(1) && player2.contains(4) && player2.contains(7)){
            winer=2
        }



        // col 2
        if(player1.contains(2) && player1.contains(5) && player1.contains(8)){
            winer=1
        }
        if(player2.contains(2) && player2.contains(5) && player2.contains(8)){
            winer=2
        }


        // col 3
        if(player1.contains(3) && player1.contains(6) && player1.contains(9)){
            winer=1
        }
        if(player2.contains(3) && player2.contains(6) && player2.contains(9)){
            winer=2
        }


        if( winer != -1){

            if (winer==1){
                Toast.makeText(this," Malk  win the game", Toast.LENGTH_LONG).show()

            }else{
                Toast.makeText(this," Player 2  win the game", Toast.LENGTH_LONG).show()

            }

        }

    }
    fun AutoPlay(){


        for ( cellID in 1..9){

            if(!( player1.contains(cellID) || player2.contains(cellID))) {
                emptyCells.add(cellID)
            }
        }


        val r= Random()
        val randIndex=r.nextInt(emptyCells.size-0)+0
        val cellID= emptyCells[randIndex]

        var buSelect: Button?
        when(cellID){
            1-> buSelect=b1
            2-> buSelect=b2
            3-> buSelect=b3
            4-> buSelect=b4
            5-> buSelect=b5
            6-> buSelect=b6
            7-> buSelect=b7
            8-> buSelect=b8
            9-> buSelect=b9
            else->{
                buSelect=b1
            }
        }

        PlayGame(cellID,buSelect)

    }
    fun playAgainEvent(view:View){
        player1.clear()
        player2.clear()
        emptyCells.clear()
        setContentView(R.layout.activity_main)


        //ActivePlayer=1
             }


}
