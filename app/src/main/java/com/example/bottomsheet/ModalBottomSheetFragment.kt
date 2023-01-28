package com.example.bottomsheet

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ModalBottomSheetFragment : BottomSheetDialogFragment() {
    private lateinit var coordinatorLayout: CoordinatorLayout
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_modal_bottom_sheet, container, false)

        coordinatorLayout = view.findViewById(R.id.coordinator_layout)

        // we can change the layout as well
        val linearLayout = LinearLayout(activity as Context)
        linearLayout.orientation = LinearLayout.VERTICAL
        val layoutParams = CoordinatorLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        val behavior = BottomSheetBehavior<LinearLayout>()
        behavior.state = BottomSheetBehavior.STATE_COLLAPSED // initially layout in its peek height
        behavior.peekHeight = 150
        layoutParams.behavior = behavior
        //linearLayout.background = ResourcesCompat.getDrawable(resources,R.drawable.background_bottom_sheet,null)

        addUI(linearLayout, layoutParams)


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

                        val button4 = Button(activity as Context)
                        button4.text = "Button 4_"
                        linearLayout.addView(button4)

                        val button5 = Button(activity as Context)
                        button5.text = "Button 5_"
                        linearLayout.addView(button5)
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

        return view
    }

    private fun addUI(
        linearLayout: LinearLayout,
        layoutParams: CoordinatorLayout.LayoutParams
    ) {
        // Sample buttons in the layout
        val button1 = Button(activity as Context)
        button1.text = "Button 1"
        linearLayout.addView(button1)

        val button2 = Button(activity as Context)
        button2.text = "Button 2"
        linearLayout.addView(button2)

        val button3 = Button(activity as Context)
        button3.text = "Button 3"
        linearLayout.addView(button3)

        val button3_ = Button(activity as Context)
        button3_.text = "Button 3_"
        linearLayout.addView(button3_)

        // adding layout in the coordinator layout
        // we can add as many as layouts in the coordinator layout as child views
        coordinatorLayout.addView(linearLayout, layoutParams)
    }

    companion object {
        const val TAG = "ModalBottomSheet"
    }

}