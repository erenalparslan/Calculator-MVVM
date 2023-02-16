package com.calculator


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class MyViewModel : ViewModel() {
    val exp = MutableLiveData<String>()
    val answer = MutableLiveData<String>()
    val calculatorModel=CalculatorModel(exp,answer)

    init {
        exp.value = "0"
        answer.value = "0"
    }

    fun delete() {

        calculatorModel.delete()
    }

    fun equate() {

        calculatorModel.equate()
    }

    fun reset() {

        calculatorModel.reset()
    }

    fun addOperator(o: Char) {

        calculatorModel.addOperator(o)
    }

    fun bOpen() {

        calculatorModel.bOpen()
    }

    fun bClose() {

        calculatorModel.bClose()
    }

    fun addNumber(n: String) {

        calculatorModel.addNumber(n)
    }
}