package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private var newOperator=true
    private  var oldNum=""
    private var operator = "+"
    private lateinit var etResult: EditText
    private lateinit var btn0: Button
    private lateinit var btn1: Button
    private lateinit var btn2: Button
    private lateinit var btn3: Button
    private lateinit var btn4: Button
    private lateinit var btn5: Button
    private lateinit var btn6: Button
    private lateinit var btn7: Button
    private lateinit var btn8: Button
    private lateinit var btn9: Button
    private lateinit var btnMultiply: Button
    private lateinit var btnDecimal: Button
    private lateinit var btnAdd:     Button
    private lateinit var btnSubtract: Button
    private lateinit var btnDivide: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etResult = findViewById(R.id.etResult)
        btn0 = findViewById(R.id.btn0)
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)
        btn5 = findViewById(R.id.btn5)
        btn6 = findViewById(R.id.btn6)
        btn7 = findViewById(R.id.btn7)
        btn8 = findViewById(R.id.btn8)
        btn9 = findViewById(R.id.btn9)
        btnDecimal=findViewById(R.id.btnDecimal)
        btnMultiply = findViewById(R.id.btnMultiply)
        btnAdd = findViewById(R.id.btnAdd)
        btnSubtract = findViewById(R.id.btnSubtract)
        btnDivide=findViewById(R.id.btnDivide)
    }
    fun forNumAction(view: View) {
        if (newOperator)
            etResult.setText("")
        newOperator=false
        var btnClick:String=etResult.text.toString()
        val btnSelect:Button=view as Button
        when(btnSelect.id){
            btn1.id->{btnClick+="1"}
            btn2.id->{btnClick+="2"}
            btn3.id->{btnClick+="3"}
            btn4.id->{btnClick+="4"}
            btn5.id->{btnClick+="5"}
            btn6.id->{btnClick+="6"}
            btn7.id->{btnClick+="7"}
            btn8.id->{btnClick+="8"}
            btn9.id->{btnClick+="9"}
            btn0.id->{btnClick+="0"}
            btnDecimal.id->{btnClick += "."}
        }
        etResult.setText(btnClick)
    }
    fun forOperatorAction(view: View) {
        newOperator = true
        oldNum=etResult.text.toString()
        val btnSelect:Button=view as Button
        when(btnSelect.id){
            btnDivide.id->{operator ="/"}
            btnMultiply.id->{operator="*"}
            btnAdd.id->{operator="+"}
            btnSubtract.id->{operator="-"}
        }
    }
    fun forClearAction(view: View) {
        etResult.setText("0")
        newOperator=true
    }
    fun forCalculateAction(view: View) {
        val newNum:String= etResult.text.toString()
        var result=0.0
        when(operator){
            "+"->{result=oldNum.toDouble() + newNum.toDouble()}
            "-"->{result=oldNum.toDouble() - newNum.toDouble()}
            "*"->{result=oldNum.toDouble() * newNum.toDouble()}
            "/"->{result=oldNum.toDouble() / newNum.toDouble()}
        }
        etResult.setText(result.toString())
    }
    }