package com.example.aldajo92.customview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

/*
    code based on: https://antonioleiva.com/kotlin-android-custom-views/
 */

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val object1 = MyClass(1)
        val object2 = MyClass(1, "hello")
        val object3 = MyClass(param = 1, optParamOne = "hello")
        val object4 = MyClass(1, "hello", 4)

        message_text_view.setText(R.string.welcome_message)
    }
}
