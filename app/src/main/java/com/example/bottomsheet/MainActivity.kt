package com.example.bottomsheet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.widget.NestedScrollView
import com.google.android.material.bottomsheet.BottomSheetBehavior

class MainActivity : AppCompatActivity() {
    lateinit var bottomSheetOpenButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomSheetOpenButton = findViewById(R.id.bottom_sheet_button)

        val nestedScrollView = findViewById<NestedScrollView>(R.id.bottom_sheet)
        val behavior = BottomSheetBehavior.from(nestedScrollView)
        behavior.state = BottomSheetBehavior.STATE_HIDDEN

        bottomSheetOpenButton.setOnClickListener {
            behavior.halfExpandedRatio = 0.6f
            behavior.isFitToContents = false
            behavior.state = BottomSheetBehavior.STATE_HALF_EXPANDED
            behavior.isDraggable = true

            behavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
                override fun onSlide(bottomSheet: View, slideOffset: Float) {
                    // Handle the sliding of the bottom sheet
                    // 0 means collapsed
                    // 0.5 half expanded
                    // 1 means expanded

                    // actively called this function, so use it carefully
                }

                override fun onStateChanged(bottomSheet: View, newState: Int) {
                    when(newState){
                        BottomSheetBehavior.STATE_COLLAPSED->{
                            // we layout at its peek height
                        }
                        BottomSheetBehavior.STATE_DRAGGING -> {
                            // The user is actively dragging the bottom sheet up or down.
                        }
                        BottomSheetBehavior.STATE_EXPANDED -> {
                            // we can change the layout as well after expanding it completely
                        }
                        BottomSheetBehavior.STATE_HALF_EXPANDED -> {
                            // The bottom sheet is half-expanded
                            // (only applicable if behavior_fitToContents has been set to false),
                            // and is neither dragging or settling
                        }
                        BottomSheetBehavior.STATE_HIDDEN -> {
                        }
                        BottomSheetBehavior.STATE_SETTLING -> {
                            //  The bottom sheet is settling to specific height after a drag/swipe gesture.
                            //  This will be the peek height, expanded height, or 0, in case the user action
                            //  caused the bottom sheet to hide.
                        }
                    }
                }
            })
        }
    }
}