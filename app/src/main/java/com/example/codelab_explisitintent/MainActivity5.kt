package com.example.codelab_explisitintent

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity5 : AppCompatActivity() {

    companion object {
        const val SelectedItem = "SELECTED_ITEM"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main5)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val rgItems = findViewById<RadioGroup>(R.id.rgItems)
        val btnConfirm = findViewById<Button>(R.id.btnConfirm)

        btnConfirm.setOnClickListener {
            val selectedId = rgItems.checkedRadioButtonId
            if (selectedId != -1) {
                val selectedRadio = findViewById<RadioButton>(selectedId)
                val selectedText = selectedRadio.text.toString()

                val resultIntent = Intent().apply {
                    putExtra(SelectedItem, selectedText)
                }
                setResult(Activity.RESULT_OK, resultIntent)
                finish() // balik ke MainActivity
            }
        }
    }
}
