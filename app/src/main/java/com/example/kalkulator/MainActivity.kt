package com.example.kalkulator

import android.annotation.SuppressLint
import android.os.Bundle
import android.service.autofill.FillEventHistory
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.kalkulator.ui.theme.KalkulatorTheme
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : ComponentActivity() {
    lateinit var tvHis : TextView
    lateinit var tvCur : TextView
    lateinit var b1 : Button
    lateinit var b2 : Button
    lateinit var b3 : Button
    lateinit var b4 : Button
    lateinit var b5 : Button
    lateinit var b6 : Button
    lateinit var b7 : Button
    lateinit var b8 : Button
    lateinit var b9 : Button
    lateinit var b0 : Button
    lateinit var b00 : Button
    lateinit var bperiod : Button
    lateinit var bpersen : Button
    lateinit var btambah : Button
    lateinit var bkurang : Button
    lateinit var bKali : Button
    lateinit var bbagi : Button
    lateinit var bSamadengan : Button
    lateinit var bback : Button
    lateinit var bclear : Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kalkulator)

        tvHis = findViewById(R.id.tvold)
        tvCur = findViewById(R.id.tvhasil)
        b1 = findViewById(R.id.btnOne)
        b2 = findViewById(R.id.btnTwo)
        b3 = findViewById(R.id.btnThree)
        b4 = findViewById(R.id.btnFour)
        b5 = findViewById(R.id.btnFive)
        b6 = findViewById(R.id.btnSix)
        b7 = findViewById(R.id.btnSeven)
        b8 = findViewById(R.id.btnEight)
        b9 = findViewById(R.id.btnNine)
        b0 = findViewById(R.id.btnZero)
        b00 = findViewById(R.id.btnDoublezero)
        bperiod = findViewById(R.id.btnPeriod)
        bpersen = findViewById(R.id.btnPersen)
        btambah = findViewById(R.id.btnTambah)
        bkurang = findViewById(R.id.btnKurang)
        bKali = findViewById(R.id.btnKali)
        bbagi = findViewById(R.id.btnBagi)
        bSamadengan = findViewById(R.id.btnSamaDengan)
        bback = findViewById(R.id.btnBackspace)
        bclear = findViewById(R.id.btnClear)

        b1.setOnClickListener { appenOnClick ( true, "1") }
        b2.setOnClickListener { appenOnClick(true, "2") }
        b3.setOnClickListener { appenOnClick(true,"3") }
        b4.setOnClickListener { appenOnClick(true, "4") }
        b5.setOnClickListener { appenOnClick(true, "5") }
        b6.setOnClickListener { appenOnClick(true, "6") }
        b7.setOnClickListener { appenOnClick(true,"7") }
        b8.setOnClickListener { appenOnClick(true, "8") }
        b9.setOnClickListener { appenOnClick(true, "9") }
        b0.setOnClickListener { appenOnClick(true,"0") }
        b00.setOnClickListener { appenOnClick(true,"00") }
        bperiod.setOnClickListener { appenOnClick(true, ".") }
        bpersen.setOnClickListener { appenOnClick(true,"%") }
        btambah.setOnClickListener { appenOnClick(false,"+") }
        bkurang.setOnClickListener { appenOnClick(false, "-") }
        bKali.setOnClickListener { appenOnClick(false, "*") }
        bbagi.setOnClickListener { appenOnClick(false, "/") }
        bSamadengan.setOnClickListener { hitung() }
    }

    private fun hitung(){
        try {
            val input = ExpressionBuilder(tvCur.text.toString()).build()
            val output = input.evaluate()
            val inputLong = output.toLong()

            if (output == inputLong.toDouble()){
                tvHis.text = inputLong.toString()
            }else {
                tvCur.text = output.toString()
            }
        } catch (e: Exception){
            Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
        }
    }

    private fun appenOnClick(hapus: Boolean, string: String){
        if (hapus){
            tvHis.text = ""
            tvCur.append(string)
        }else {
            tvCur.append(tvHis.text)
            tvCur.append(string)
            tvHis.text = ""
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KalkulatorTheme {
        Greeting("Android")
    }
}