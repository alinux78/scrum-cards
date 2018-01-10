package com.example.mihai.scrumcards

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.view.ViewConfiguration
import kotlinx.android.synthetic.main.activity_single_card.*

class SingleCardActivity : AppCompatActivity() {

    companion object {
        const val VALUE = "value"
    }

    private lateinit var detector: GestureDetector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detector = GestureDetector(
                this@SingleCardActivity,
                object : GestureDetector.SimpleOnGestureListener() {
                    override fun onDoubleTap(e: MotionEvent?): Boolean {
                        this@SingleCardActivity.finish()
                        return true
                    }
                }
        )

        setContentView(R.layout.activity_single_card)
        showValue();

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        detector.onTouchEvent(event)
        return true
    }

    fun showValue() {
        var value = intent.getStringExtra(VALUE);
        if (value.length > 2) {
            textView.textScaleX = 0.8F
        }
        textView.text = value;
    }

}
