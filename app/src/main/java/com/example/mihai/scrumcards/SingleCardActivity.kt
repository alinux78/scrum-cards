package com.example.mihai.scrumcards

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_single_card.*
import android.widget.Toast


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

                    override fun onFling(e1: MotionEvent?, e2: MotionEvent?, velocityX: Float, velocityY: Float): Boolean {
                        if (e1 == null || e2 == null) {
                            return false
                        }

                        if (Math.abs(e1.rawY - e2.rawY) < 10) {
                            return false
                        }
                        val textView = this@SingleCardActivity.textView
                        var currentIdx = ScrumCardsAdapter.CARDS.indexOf(textView.text)
                        if (e1.rawX - e2.rawX > 10) {
                            currentIdx++
                        } else if (e2.rawX - e1.rawX > 10) {
                            currentIdx--
                        }
                        currentIdx = currentIdx  % ScrumCardsAdapter.CARDS.size
                        val value = ScrumCardsAdapter.CARDS[currentIdx]
                        intent.putExtra(VALUE, value)
                        showValue(false)
                        return true
                    }
                }
        )

        setContentView(R.layout.activity_single_card)
        showValue(true)

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        detector.onTouchEvent(event)
        return true
    }

    fun showValue(animate:Boolean) {
        var value = intent.getStringExtra(VALUE);
        if (value.length > 2) {
            textView.textScaleX = 0.8F
        }
        textView.text = value
        if (animate) {
            val animation = AnimationUtils.loadAnimation(this, R.anim.scale)
            animation.reset()
            textView.clearAnimation();
            textView.startAnimation(animation);
        }
    }

}
