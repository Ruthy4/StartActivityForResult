package com.example.week_Two_assignment

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*


class MainActivity : AppCompatActivity() {
    val handler = Handler()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("MainActivity", "On create")


    }


    //on button click
    fun sendMessage(view: View) {
        val editText = findViewById<EditText>(R.id.edit_text)
        val message = editText.text.toString()
        val intent = Intent(this, MainActivity2::class.java).apply {
            putExtra("question", message)

        }
        startActivityForResult(intent, 100)//activity is started with a request code

    }

    //callback method to get the message from the other activity
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        //check if the result code is the same as what is passed
        if (requestCode == 100 && resultCode == Activity.RESULT_OK) {

            //output the message
            val textView = findViewById<TextView>(R.id.text_view2)
            textView.text = data?.getStringExtra("answer")

            //delay the process death by 3seconds
            handler.postDelayed({super.finish()}, 3000)

        }


    }


}
