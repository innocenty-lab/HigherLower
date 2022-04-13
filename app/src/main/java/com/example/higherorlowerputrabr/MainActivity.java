package com.example.higherorlowerputrabr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int randomNumber;

    // for repeating the game
    public void randomNumberGenerator() {
        Random rand = new Random();
        randomNumber = rand.nextInt(10) + 1;
    }

    public void onGuess(View view) {
        try {
            String message;
            EditText editTextNumber = (EditText) findViewById(R.id.editTextNumber);
            int guessedNumber = Integer.parseInt(editTextNumber.getText().toString());

            if (guessedNumber < randomNumber)
                message = "Lebih Tinggi!!";
            else if (guessedNumber > randomNumber)
                message = "Lebih Rendah!!";
            else {
                message = "Tebakan Kamu Tepat!!";
                randomNumberGenerator(); // kinda recurtion!
            }
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        } catch (NumberFormatException e) {
            System.err.println(e);
            Toast.makeText(this, "Masukan tebakan kamu berupa angka (1 - 10)", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random rand = new Random();
        randomNumber = rand.nextInt(10) + 1;
    }
}