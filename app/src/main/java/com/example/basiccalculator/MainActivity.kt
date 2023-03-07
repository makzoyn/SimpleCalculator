package com.example.basiccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView




class MainActivity : AppCompatActivity() {

    lateinit var operation : TextView
    lateinit var prevOperation : TextView
    lateinit var calcText : EditText
    lateinit var btnDivision: Button
    lateinit var btnPlus: Button
    lateinit var btnMultiplication: Button
    lateinit var btnMinus: Button
    lateinit var btnComma: Button
    lateinit var btnResult: Button
    lateinit var btnOne: Button
    lateinit var btnTwo: Button
    lateinit var btnThree: Button
    lateinit var btnFour: Button
    lateinit var btnFive: Button
    lateinit var btnSix: Button
    lateinit var btnSeven: Button
    lateinit var btnEight: Button
    lateinit var btnNine: Button
    lateinit var btnZero: Button
    lateinit var btnClear: Button
    lateinit var btnDelete: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        operation = findViewById(R.id.tvOperation)
        prevOperation = findViewById(R.id.tvPrevOperation)
        calcText = findViewById(R.id.etCalc)
        btnDivision = findViewById(R.id.btn_division)
        btnPlus = findViewById(R.id.btn_plus)
        btnMultiplication = findViewById(R.id.btn_multiplication)
        btnMinus = findViewById(R.id.btn_minus)
        btnComma = findViewById(R.id.btn_comma)
        btnResult = findViewById(R.id.btn_result)
        btnOne = findViewById(R.id.btn1)
        btnTwo = findViewById(R.id.btn2)
        btnThree = findViewById(R.id.btn3)
        btnFour = findViewById(R.id.btn4)
        btnFive = findViewById(R.id.btn5)
        btnSix = findViewById(R.id.btn6)
        btnSeven = findViewById(R.id.btn7)
        btnEight = findViewById(R.id.btn8)
        btnNine = findViewById(R.id.btn9)
        btnZero = findViewById(R.id.btn0)
        btnClear = findViewById(R.id.btn_clear)
        btnDelete = findViewById(R.id.btn_delete)


        btnOne.setOnClickListener {
            val str = calcText.getText().toString()+
                    btnOne.getText().toString()
            calcText.setText(str)
        }
        btnTwo.setOnClickListener {
            val str = calcText.getText().toString()+
                    btnTwo.getText().toString()
            calcText.setText(str)
        }
        btnThree.setOnClickListener {
            val str = calcText.getText().toString()+
                    btnThree.getText().toString()
            calcText.setText(str)
        }
        btnFour.setOnClickListener {
            val str = calcText.getText().toString()+
                    btnFour.getText().toString()
            calcText.setText(str)
        }
        btnFive.setOnClickListener {
            val str = calcText.getText().toString()+
                    btnFive.getText().toString()
            calcText.setText(str)
        }
        btnSix.setOnClickListener {
            val str = calcText.getText().toString()+
                    btnSix.getText().toString()
            calcText.setText(str)
        }
        btnSeven.setOnClickListener {
            val str = calcText.getText().toString()+
                    btnSeven.getText().toString()
            calcText.setText(str)
        }
        btnEight.setOnClickListener {
            val str = calcText.getText().toString()+
                    btnEight.getText().toString()
            calcText.setText(str)
        }
        btnNine.setOnClickListener {
            val str = calcText.getText().toString()+
                    btnNine.getText().toString()
            calcText.setText(str)
        }
        btnZero.setOnClickListener {
            val str = calcText.getText().toString()+
                    btnZero.getText().toString()
            calcText.setText(str)
        }

        btnDivision.setOnClickListener {
            if(checkEmpty() && operation.getText().toString()==""){
                prevOperation.setText(btnDivision.getText().toString())
                operation.setText(calcText.getText().toString())
                calcText.setText("")
            }
            else if(checkEmpty() && operation.getText().toString()!=""){
                operation.setText(calculateResult())
                prevOperation.setText(btnDivision.getText().toString())
                calcText.setText("")
            }
        }
        btnMultiplication.setOnClickListener {
            if(checkEmpty() && operation.getText().toString()==""){
                prevOperation.setText(btnMultiplication.getText().toString())
                operation.setText(calcText.getText().toString())
                calcText.setText("")
            }
            else if(checkEmpty() && operation.getText().toString()!=""){
                operation.setText(calculateResult())
                prevOperation.setText(btnMultiplication.getText().toString())
                calcText.setText("")
            }
        }
        btnMinus.setOnClickListener {
            if(checkEmpty() && operation.getText().toString()==""){
                prevOperation.setText(btnMinus.getText().toString())
                operation.setText(calcText.getText().toString())
                calcText.setText("")
            }
            else if(checkEmpty() && operation.getText().toString()!=""){
                operation.setText(calculateResult())
                prevOperation.setText(btnMinus.getText().toString())
                calcText.setText("")
            }
        }
        btnPlus.setOnClickListener {
            if(checkEmpty() && operation.getText().toString()==""){
                prevOperation.setText(btnPlus.getText().toString())
                operation.setText(calcText.getText().toString())
                calcText.setText("")
            }
            else if(checkEmpty() && operation.getText().toString()!=""){
                operation.setText(calculateResult())
                prevOperation.setText(btnPlus.getText().toString())
                calcText.setText("")
            }
        }
        btnComma.setOnClickListener {
            if(!checkComma(calcText.getText().toString()) && calcText.getText().toString() != ""){
                val str = calcText.getText().toString()+
                        btnComma.getText().toString()
                calcText.setText(str)
            }
        }
        btnResult.setOnClickListener {
            if(operation.getText().toString() != "")
            {
                calcText.setText(calculateResult().run(::placeComma))
                prevOperation.setText("")
                operation.setText("")
            }
        }
        btnDelete.setOnClickListener {
            calcText.setText(removeLastChar(calcText.getText().toString()))
        }
        btnClear.setOnClickListener {
            calcText.setText("")
            prevOperation.setText("")
            operation.setText("")
        }



    }


    private fun checkEmpty(): Boolean {
        return calcText.getText().toString().isNotEmpty()
    }

    fun removeLastChar(str: String?): String? {
        return str?.replaceFirst(".$".toRegex(), "")
    }
    fun calculateResult(): String {
        val saveOperation = prevOperation.getText().toString()
        return when(saveOperation){
            "/" -> {
                (operation.getText().toString().run(::replaceComma).toDouble() /
                        calcText.getText().toString().run(::replaceComma).toDouble()).toString()

            }
            "x" -> {
                (operation.getText().toString().run(::replaceComma).toDouble() *
                        calcText.getText().toString().run(::replaceComma).toDouble()).toString()

            }
            "+" -> {
                (operation.getText().toString().run(::replaceComma).toDouble() +
                        calcText.getText().toString().run(::replaceComma).toDouble()).toString()

            }
            "-" -> {
                (operation.getText().toString().run(::replaceComma).toDouble() -
                        calcText.getText().toString().run(::replaceComma).toDouble()).toString()

            }
            else -> {
                ""
            }
        }
    }

    fun checkComma(str : String): Boolean{
        return str.contains(",")
    }
    fun placeComma(str: String) : String{
        return str.replace(".", ",")
    }
    fun replaceComma(str: String) : String{
        return str.replace(",", ".")
    }

}