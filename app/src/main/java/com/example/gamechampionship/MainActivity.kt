package com.example.gamechampionship
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text
import java.util.*
import java.util.concurrent.TimeUnit


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val colorsArray = arrayOf(Color.BLACK, Color.BLUE, Color.RED, Color.GREEN, Color.YELLOW)

        val textWinner: TextView = findViewById(R.id.winner)
        val scoreOne: TextView = findViewById(R.id.score1)
        val scoreTwo: TextView = findViewById(R.id.score2)
        val result: TextView = findViewById(R.id.result)
        val restarB: TextView = findViewById(R.id.restartB)
        val clickB1: Button = findViewById(R.id.player1_button)
        val clickB2: Button = findViewById(R.id.player2_button)


        var scoreOneString = scoreOne.getText().toString()
        var scoreOneInt = scoreOneString.toInt()

        var scoreTwoString = scoreTwo.getText().toString()
        var scoreTwoInt = scoreTwoString.toInt()

        if(scoreOneInt != 3 && scoreTwoInt != 3){
            clickB1.setOnClickListener{
                first_button(textWinner, scoreOne, result)
            }

            clickB2.setOnClickListener{
                second_button(textWinner, scoreTwo, result)
            }


            red_circle.setOnClickListener{
                red_circle.setColorFilter(colorsArray[getRandom(colorsArray.size)])
                println(getRandom(4))
            }
            restarB.setOnClickListener{
                restart(scoreOne,scoreTwo,result,textWinner)
            }
        }else{
            restarB.setOnClickListener{
                restart(scoreOne,scoreTwo,result,textWinner)
            }
        }







    }


    private fun gameLoop(button1:Button, button2:Button, score1: TextView,score2: TextView ,result: TextView, textw: TextView, restart:Button){
        var scoreOneString = score1.getText().toString()
        var scoreOneInt = scoreOneString.toInt()

        var scoreTwoString = score2.getText().toString()
        var scoreTwoInt = scoreTwoString.toInt()



        restart.isVisible = false
        if(scoreOneInt != 3 && scoreTwoInt != 3){
            button1.setOnClickListener{
                first_button(textw, score1, result)
            }

            button2.setOnClickListener{
                second_button(textw, score2, result)
            }
        }


    }


    private fun first_button(textw: TextView, score: TextView, result: TextView){
        textw.text = "Winner: Player 1"
        var scoreOneString = score.getText().toString()
        var scoreInt = scoreOneString.toInt()
        scoreInt += 1
        score.text = scoreInt.toString()

        if(scoreInt == 3 ){
            result.text = "GAME OVER"
        }



    }

    private fun second_button(textw:TextView, score: TextView, result: TextView){
        textw.text = "Winner: Player 2"

        var scoreTwoString = score.getText().toString()
        var scoreInt = scoreTwoString.toInt()
        scoreInt += 1
        score.text = scoreInt.toString()

        if(scoreInt == 3 ){
            result.text = "GAME OVER"
        }


    }


    private fun getRandom(arraySize: Int):Int{
        var rand = Random()
        var randomNum = rand.nextInt(arraySize)
        return randomNum
    }


    private fun restart(score1: TextView, score2: TextView, result: TextView, textw: TextView){
        result.text = "          Result:"
        score1.text = "0"
        score2.text = "0"
        textw.text = "Winner:"

    }

    private fun isGameOver(score1: TextView, score2: TextView, restart: Button){
        var scoreOneString = score1.getText().toString()
        var scoreOneInt = scoreOneString.toInt()

        val scoreTwoString = score2.getText().toString()
        var scoreTwoInt = scoreTwoString.toInt()

        if(scoreOneInt == 3 || scoreTwoInt == 3){
            restart.isVisible = true
        }


    }



}
