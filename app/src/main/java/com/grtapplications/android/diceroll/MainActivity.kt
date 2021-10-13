package com.grtapplications.android.diceroll

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dieOneBtn: Button = findViewById(R.id.roll_btn)
        dieOneBtn.setOnClickListener {
            val firstRoll = rollFirstDice()
            val secondRoll = rollSecondDice()
            val result = firstRoll + secondRoll
        }
        // Do a dice roll when the app starts
        rollFirstDice()
        rollSecondDice()
    }

    /**
     * Roll the first die and update the screen with the result.
     */
    private fun rollFirstDice(): Int {
        // Create first Dice object with 6 sides and roll it
        val diceOne = Dice(6)
        val diceOneRoll = diceOne.roll()

        // Find the ImageView in the layout
        val diceOneImage: ImageView = findViewById(R.id.dice_one_iv)

        // Determine which drawable resource ID to use based on the dice roll
        val drawableResource = when (diceOneRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        //Update the ImageView with the correct drawable resource
        diceOneImage.setImageResource(drawableResource)

        // Update the content description for screen readers
        diceOneImage.contentDescription = diceOneRoll.toString()

        // return the dice roll
        return diceOneRoll
    }

    /**
     * Roll the second die and update the screen with the result.
     */
    private fun rollSecondDice(): Int {
        // Create second Dice object with 6 sides and roll it
        val diceTwo = Dice(6)
        val diceTwoRoll = diceTwo.roll()

        // Find the ImageView in the layout
        val diceTwoImage: ImageView = findViewById(R.id.dice_two_iv)

        // Determine which drawable resource ID to use based on the dice roll
        val drawableResource = when (diceTwoRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        //Update the ImageView with the correct drawable resource
        diceTwoImage.setImageResource(drawableResource)

        // Update the content description for screen readers
        diceTwoImage.contentDescription = diceTwoRoll.toString()

        // Return the dice roll
        return diceTwoRoll
    }
}