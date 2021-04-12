package com.example.week_Two_assignment

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView


class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        //Get the intent that started the activity and extract the string
        val message = intent.getStringExtra("question")

        //capture the textView of the layout and set the string as its text
        val textView = findViewById<TextView>(R.id.text_view)
        textView.text = message

    }

    //on button click
    fun sendMessage2 (view: View){
        val editText = findViewById<EditText>(R.id.edit_text2)
        val message2 = editText.text.toString()
        val intent = Intent(this, MainActivity::class.java)

            intent.putExtra("answer", message2)

        //set the data intent and result code sent back to onActivityResult()
          setResult(Activity.RESULT_OK, intent)
            super.finish()
        }





    override fun finish() {
        super.finish()
    }
}
