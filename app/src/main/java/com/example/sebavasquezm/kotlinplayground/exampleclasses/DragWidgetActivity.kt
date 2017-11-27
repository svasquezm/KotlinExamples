package com.example.sebavasquezm.kotlinplayground.exampleclasses

import android.animation.ValueAnimator
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.DragEvent
import android.view.MotionEvent
import android.view.View
import android.view.animation.AccelerateInterpolator
import android.view.animation.LinearInterpolator
import android.view.animation.TranslateAnimation
import android.widget.ViewAnimator
import com.example.sebavasquezm.kotlinplayground.R
import kotlinx.android.synthetic.main.drag_widget_activity.*

/**
 * Created by seba.vasquez.m on 11/26/17.
 */
class DragWidgetActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.drag_widget_activity)

        vStartLayer.visibility    = View.VISIBLE
        vEndLayer.visibility      = View.VISIBLE
        vFinishedLayer.visibility = View.VISIBLE

        var canMove = true

        // Define difference betweem raw_x and original x position
        var dx = 0f

        // Add Listener to Drag action
        vStartLayer.setOnTouchListener({view, event ->
            when(event.actionMasked){
                MotionEvent.ACTION_DOWN -> dx = view.x - event.rawX
                MotionEvent.ACTION_MOVE -> {
                    if(canMove) {
                        if (view.x >= 0) {
                            view.x = event.rawX + dx
                        } else {
                            canMove = false
                        }
                    }
                }
                MotionEvent.ACTION_UP   -> {
                    var anim = if (view.x < 0.6 * view.width) {
                        ValueAnimator.ofFloat(view.x, 0f)
                    } else {
                        ValueAnimator.ofFloat(view.x, view.width.toFloat())
                    }
                    anim.duration = 400
                    anim.addUpdateListener({
                        valueAnimator: ValueAnimator ->
                        view.x = valueAnimator.animatedValue as Float
                    })
                    anim.interpolator = AccelerateInterpolator()
                    anim.start()
                    canMove = true
                }
            }
        true})

        vEndLayer.setOnTouchListener({view, event ->
            when(event.actionMasked){
                MotionEvent.ACTION_DOWN -> dx = view.x - event.rawX
                MotionEvent.ACTION_MOVE -> {
                    if(canMove) {
                        if (view.x >= -0.4 * view.width) {
                            view.x = event.rawX - dx
                        } else {
                            canMove = false
                        }
                    }
                }
                MotionEvent.ACTION_UP   -> {
                    var anim = if (view.x > 0.4 * view.width) {
                        ValueAnimator.ofFloat(view.x, 0f)
                    } else {
                        ValueAnimator.ofFloat(view.x, -view.width.toFloat())
                    }
                    anim.duration = 400
                    anim.addUpdateListener({
                        valueAnimator: ValueAnimator ->
                        view.x = valueAnimator.animatedValue as Float
                    })
                    anim.interpolator = AccelerateInterpolator()
                    anim.start()
                    canMove = true
                }
            }
            true})
    }
}