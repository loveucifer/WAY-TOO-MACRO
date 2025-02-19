package com.example.macrotracker

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var macroInput: EditText
    private lateinit var scanBarcodeButton: Button
    private lateinit var barcodeResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        macroInput = findViewById(R.id.macroInput)
        scanBarcodeButton = findViewById(R.id.scanBarcodeButton)
        barcodeResult = findViewById(R.id.barcodeResult)

        scanBarcodeButton.setOnClickListener {
            val intent = Intent(this, BarcodeScannerActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE_SCAN)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_SCAN && resultCode == RESULT_OK) {
            val result = data?.getStringExtra("barcode")
            barcodeResult.text = result
        }
    }

    companion object {
        const val REQUEST_CODE_SCAN = 1
    }
}