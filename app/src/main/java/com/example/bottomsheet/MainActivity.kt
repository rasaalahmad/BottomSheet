package com.example.bottomsheet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior

class MainActivity : AppCompatActivity() {
    private lateinit var modalBottomSheetFragment: ModalBottomSheetFragment
    lateinit var bottomSheetOpenButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomSheetOpenButton = findViewById(R.id.bottom_sheet_button)

        bottomSheetOpenButton.setOnClickListener {
            modalBottomSheetFragment = ModalBottomSheetFragment()
            modalBottomSheetFragment.show(supportFragmentManager,ModalBottomSheetFragment.TAG)
        }
    }
}