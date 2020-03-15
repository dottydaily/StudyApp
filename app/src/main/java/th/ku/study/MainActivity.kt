package th.ku.study

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var diceNumber1: Int = -1
    private var diceNumber2: Int = -1
    private var diceResourceArray = arrayOf(R.drawable.empty_dice,
        R.drawable.dice_1, R.drawable.dice_2, R.drawable.dice_3,
        R.drawable.dice_4, R.drawable.dice_5, R.drawable.dice_6)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        roll_button.setOnClickListener { rollDice() }
        countup_button.setOnClickListener { countUp() }
        reset_button.setOnClickListener { reset() }
    }

    private fun rollDice() {
        var randomImageId = getRandomDiceImage()
        diceNumber1 = diceResourceArray.indexOf(randomImageId)
        dice_image1.setImageResource(randomImageId)

        randomImageId = getRandomDiceImage()
        diceNumber2 = diceResourceArray.indexOf(randomImageId)
        dice_image2.setImageResource(randomImageId)

        Toast.makeText(this, "Roll : ${diceNumber1 + diceNumber2}",
            Toast.LENGTH_SHORT).show()
    }

    private fun countUp() {
        diceNumber1 = if (diceNumber1 == -1) 1 else diceNumber1
        diceNumber2 = if (diceNumber2 == -1) 1 else diceNumber2

        if (diceNumber1 < 6) {
            dice_image1.setImageResource(diceResourceArray[++diceNumber1])
        }
        if (diceNumber2 < 6) {
            dice_image2.setImageResource(diceResourceArray[++diceNumber2])
        }
    }

    private fun reset() {
        diceNumber1 = -1
        diceNumber2 = -1

        dice_image1.setImageResource(R.drawable.empty_dice)
        dice_image2.setImageResource(R.drawable.empty_dice)
        Toast.makeText(this, "Reset", Toast.LENGTH_SHORT).show()
    }

    private fun getRandomDiceImage() : Int {
        val randomNumber = (1..6).random()
        return diceResourceArray[randomNumber]
    }
}