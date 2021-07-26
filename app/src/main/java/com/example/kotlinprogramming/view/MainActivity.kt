package com.example.kotlinprogramming.view

import android.media.VolumeShaper
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinprogramming.R
import com.example.kotlinprogramming.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val TAG = "MainActivity"
    private var operandFirst: String? = null;
    private var operandSecond: String? = null;
    private var operator = OPERATOR.NULL
    private var tempValue: String? = null;
    private var isResult  = false

    private lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(mainBinding.root)
        mainBinding.TextView0.setOnClickListener(this)
        mainBinding.TextView2.setOnClickListener(this)
        mainBinding.TextView3.setOnClickListener(this)
        mainBinding.TextView1.setOnClickListener(this)
        mainBinding.TextView4.setOnClickListener(this)
        mainBinding.TextView5.setOnClickListener(this)
        mainBinding.TextView6.setOnClickListener(this)
        mainBinding.TextView7.setOnClickListener(this)
        mainBinding.TextView8.setOnClickListener(this)
        mainBinding.TextView9.setOnClickListener(this)
        mainBinding.TextViewAdd.setOnClickListener(this)
        mainBinding.TextViewSub.setOnClickListener(this)
        mainBinding.textViewMultiple.setOnClickListener(this)
        mainBinding.TextViewDivide.setOnClickListener(this)
        mainBinding.buttonResult.setOnClickListener(this)
        mainBinding.TextViewClean.setOnClickListener(this)
        mainBinding.btnAC.setOnClickListener(this)


    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.TextViewAdd, R.id.textViewMultiple, R.id.TextViewSub, R.id.TextViewDivide -> {
                isResult = false
                val view = p0 as TextView;
                val text = view.text.toString()
                setTempValue(text)
                operandFirst = mainBinding.textViewResult.text.toString()
                mainBinding.textViewResult.text = ""

                when (p0.id) {
                    R.id.TextViewAdd -> {
                        operator = OPERATOR.ADD

                    }
                    R.id.textViewMultiple -> {
                        operator = OPERATOR.MULTIPLE

                    }
                    R.id.TextViewSub -> {
                        operator = OPERATOR.SUBTRACT
                    }
                    else -> {
                        operator = OPERATOR.DIVIDE

                    }
                }


            }
            R.id.buttonResult -> {
                try {
                    operandSecond = mainBinding.textViewResult.text.toString()
                    Log.d(TAG, "onClick: $operandSecond  $operandFirst  $operator")
                    if (operandFirst == null || operandSecond == null ||  isResult ) {
                        //Toast.makeText(this, "Syntax Error", Toast.LENGTH_SHORT).show()
                        return
                    }
                    if (operator != OPERATOR.NULL) {
                        val result = when (operator) {
                            OPERATOR.SUBTRACT -> operandFirst!!.toInt() - operandSecond!!.toInt()
                            OPERATOR.ADD -> operandFirst!!.toInt() + operandSecond!!.toInt()
                            OPERATOR.DIVIDE -> operandFirst!!.toDouble() / operandSecond!!.toDouble()
                            OPERATOR.MULTIPLE -> operandFirst!!.toInt() * operandSecond!!.toInt()
                            OPERATOR.NULL -> operandSecond
                        }
                        isResult = true;
                        mainBinding.textViewResult.text = result.toString()
                        mainBinding.intermediateResult.text = result.toString()
                    }
                } catch (e: Exception) {
                    mainBinding.textViewResult.text = getString(R.string.syntax_error)
                    Log.d(TAG, "onClick: ${e.localizedMessage}")
                }

            }
            R.id.btnAC -> {
                operator = OPERATOR.NULL
                operandFirst = null
                operandSecond = null
                isResult = false
                mainBinding.textViewResult.text = ""
                mainBinding.intermediateResult.text = ""


            }
            R.id.TextViewClean -> {
                if (mainBinding.textViewResult.text.isEmpty()) return

                val tempValue = mainBinding.textViewResult.text.substring(
                    0,
                    mainBinding.textViewResult.text.length - 1
                )
                val tempValueIn = mainBinding.intermediateResult.text.substring(
                    0,
                    mainBinding.intermediateResult.text.length - 1
                )
                mainBinding.textViewResult.text = tempValue
                mainBinding.intermediateResult.text = tempValueIn
            }
            else -> {
                isResult = false
                if (mainBinding.textViewResult.text.toString() == getString(R.string.syntax_error)) {
                    mainBinding.textViewResult.text = ""
                }
                val view = p0 as TextView;
                val text = view.text.toString()
                setResultText(text)
                setTempValue(text)

            }


        }


    }

    private fun setResultText(text: String) {
        val tempValue = "${mainBinding.textViewResult.text}$text"
        mainBinding.textViewResult.text = tempValue

    }

    private fun setTempValue(text: String) {
        val tempValue = "${mainBinding.intermediateResult.text}$text"
        mainBinding.intermediateResult.text = tempValue
    }
}

enum class OPERATOR {
    ADD,
    DIVIDE,
    SUBTRACT,
    MULTIPLE,
    NULL
}