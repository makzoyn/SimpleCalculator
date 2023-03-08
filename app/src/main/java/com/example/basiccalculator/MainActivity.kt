package com.example.basiccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView




class MainActivity : AppCompatActivity() {

    private lateinit var operation : TextView
    private lateinit var prevOperation : TextView
    private lateinit var calcText : EditText
    private lateinit var btnDivision: Button
    private lateinit var btnPlus: Button
    private lateinit var btnMultiplication: Button
    private lateinit var btnMinus: Button
    private lateinit var btnComma: Button
    private lateinit var btnResult: Button
    private lateinit var btnOne: Button
    private lateinit var btnTwo: Button
    private lateinit var btnThree: Button
    private lateinit var btnFour: Button
    private lateinit var btnFive: Button
    private lateinit var btnSix: Button
    private lateinit var btnSeven: Button
    private lateinit var btnEight: Button
    private lateinit var btnNine: Button
    private lateinit var btnZero: Button
    private lateinit var btnClear: Button
    private lateinit var btnDelete: Button


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
            val str = calcText.text.toString()+
                    btnOne.text.toString()
            calcText.setText(str)
        }
        btnTwo.setOnClickListener {
            val str = calcText.text.toString()+
                    btnTwo.text.toString()
            calcText.setText(str)
        }
        btnThree.setOnClickListener {
            val str = calcText.text.toString()+
                    btnThree.text.toString()
            calcText.setText(str)
        }
        btnFour.setOnClickListener {
            val str = calcText.text.toString()+
                    btnFour.text.toString()
            calcText.setText(str)
        }
        btnFive.setOnClickListener {
            val str = calcText.text.toString()+
                    btnFive.text.toString()
            calcText.setText(str)
        }
        btnSix.setOnClickListener {
            val str = calcText.text.toString()+
                    btnSix.text.toString()
            calcText.setText(str)
        }
        btnSeven.setOnClickListener {
            val str = calcText.text.toString()+
                    btnSeven.text.toString()
            calcText.setText(str)
        }
        btnEight.setOnClickListener {
            val str = calcText.text.toString()+
                    btnEight.text.toString()
            calcText.setText(str)
        }
        btnNine.setOnClickListener {
            val str = calcText.text.toString()+
                    btnNine.text.toString()
            calcText.setText(str)
        }
        btnZero.setOnClickListener {
            val str = calcText.text.toString()+
                    btnZero.text.toString()
            calcText.setText(str)
        }

        btnDivision.setOnClickListener {
            if(!checkEmptyCalc() && checkEmptyOperation()){
                prevOperation.text = btnDivision
                    .text
                    .toString()
                operation.text = calcText
                    .text
                    .toString()
                calcText.setText("")
            }
            else if(!checkEmptyCalc() && !checkEmptyOperation()){
                operation.text = calculateResult().run(::placeComma)
                prevOperation.text = btnDivision
                    .text
                    .toString()
                calcText.setText("")
            }
            else if(checkEmptyCalc() && !checkEmptyOperation()){
                prevOperation.text = btnDivision
                    .text
                    .toString()
            }
        }
        btnMultiplication.setOnClickListener {
            if(!checkEmptyCalc() && checkEmptyOperation()){
                prevOperation.text = btnMultiplication
                    .text
                    .toString()
                operation.text = calcText
                    .text
                    .toString()
                calcText.setText("")
            }
            else if(!checkEmptyCalc() && !checkEmptyOperation()){
                operation.text = calculateResult().run(::placeComma)
                prevOperation.text = btnMultiplication
                    .text
                    .toString()
                calcText.setText("")
            }
            else if(checkEmptyCalc() && !checkEmptyOperation()){
                prevOperation.text = btnMultiplication
                    .text
                    .toString()
            }
        }
        btnMinus.setOnClickListener {
            if(!checkEmptyCalc() && checkEmptyOperation()){
                prevOperation.text = btnMinus
                    .text
                    .toString()
                operation.text = calcText
                    .text
                    .toString()
                calcText.setText("")
            }
            else if(!checkEmptyCalc() && !checkEmptyOperation()){
                operation.text = calculateResult().run(::placeComma)
                prevOperation.text = btnMinus
                    .text
                    .toString()
                calcText.setText("")
            }
            else if(checkEmptyCalc() && !checkEmptyOperation()){
                prevOperation.text = btnMinus
                    .text
                    .toString()
            }
        }
        btnPlus.setOnClickListener {
            if(!checkEmptyCalc() && checkEmptyOperation()){
                prevOperation.text = btnPlus
                    .text
                    .toString()
                operation.text = calcText
                    .text
                    .toString()
                calcText.setText("")
            }
            else if(!checkEmptyCalc() && !checkEmptyOperation()){
                operation.text = calculateResult().run(::placeComma)
                prevOperation.text = btnPlus
                    .text
                    .toString()
                calcText.setText("")
            }
            else if(checkEmptyCalc() && !checkEmptyOperation()){
                prevOperation.text = btnPlus
                    .text
                    .toString()
            }
        }
        btnComma.setOnClickListener {
            if(!checkComma(calcText.text.toString()) && !checkEmptyCalc()){
                val str = calcText.text.toString()+
                        btnComma.text.toString()
                calcText.setText(str)
            }
        }
        btnResult.setOnClickListener {
            if(!checkEmptyOperation())
            {
                calcText.setText(calculateResult().run(::placeComma))
                prevOperation.text = ""
                operation.text = ""
            }
        }
        btnDelete.setOnClickListener {
            calcText.setText((calcText
                .text
                .toString())
                .run(::removeLastChar))
        }
        btnClear.setOnClickListener {
            calcText.setText("")
            prevOperation.text = ""
            operation.text = ""
        }
    }
    //проверка поля ввода на пустоту
    private fun checkEmptyCalc(): Boolean {
        return calcText.text.toString().isEmpty()
    }
    //проверка поля операция на пустоту
    private fun checkEmptyOperation() : Boolean{
        return operation.text.toString().isEmpty()
    }

    //удаление последнего символа регулярным выражением
    private fun removeLastChar(str: String?): String? {
        return str?.replaceFirst(".$".toRegex(), "")
    }
    //подсчет результата калькулятора
    private fun calculateResult(): String {
        return when(prevOperation.text.toString()){
            "/" -> {
                (operation.text.toString().run(::replaceComma).toDouble() /
                        calcText.text.toString().run(::replaceComma).toDouble()).toString()

            }
            "x" -> {
                (operation.text.toString().run(::replaceComma).toDouble() *
                        calcText.text.toString().run(::replaceComma).toDouble()).toString()

            }
            "+" -> {
                (operation.text.toString().run(::replaceComma).toDouble() +
                        calcText.text.toString().run(::replaceComma).toDouble()).toString()

            }
            "-" -> {
                (operation.text.toString().run(::replaceComma).toDouble() -
                        calcText.text.toString().run(::replaceComma).toDouble()).toString()

            }
            else -> {
                ""
            }
        }
    }
    //проверка есть ли в строке запятая
    private fun checkComma(str : String): Boolean{
        return str.contains(",")
    }
    //две функции для отображения запятой,
    // когда считаю убираю запятую,
    // когда вывожу результат добавляю
    private fun placeComma(str: String) : String{
        return str.replace(".", ",")
    }
    private fun replaceComma(str: String) : String{
        return str.replace(",", ".")
    }

}