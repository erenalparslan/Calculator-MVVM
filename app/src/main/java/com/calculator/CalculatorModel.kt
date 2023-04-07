package com.calculator
import android.util.Log
import androidx.lifecycle.MutableLiveData
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class CalculatorModel(private val exp: MutableLiveData<String>,private val answer: MutableLiveData<String>) {

    fun addNumber(n: String) {
        var string = exp.value!!
        if (n == ".") {
            var lastDot = false
            for (i in string) {
                if (i.isDigit())
                    continue
                lastDot = i == '.'                  //Girilen sayılar string olarak tutulur.1 defa nokta koyulmasına izin verir. İlk sayı girildiğinde
                                                                //mevcut değer '.' değilse ve string boşsa numarayı stringe ekler.
            }
            if (lastDot)
                return
        }
        if (string.trim() == "0")
            string = ""
        if (n == "." && string == "")
            string = "0"
        string += n
        exp.value = string
        Log.d("number", exp.value!!)
        reevaluate()
    }

     fun reevaluate() {
        val text = getFormatted()
        Log.d("number", text)
        val expression = ExpressionBuilder(text).build()

        try {
            val result = expression.evaluate()
            if (Math.floor(result) == result)                   //getFormatted dödürdüğü string değerini ExpressionBuilder sınıfı ile çözer.
                answer.value = result.toString()
            else
                answer.value = result.toString()
        } catch (e: Exception) {
            answer.value = "Invalid"
        }
    }

    private fun getFormatted(): String {
        var string = exp.value!!
        Log.d("number", string)
        if (string[string.length - 1] == '.')
            string = string.substring(0, string.length - 1)

        while (!string[string.length - 1].isDigit() && string.isNotEmpty())
            string = string.substring(0, string.length - 1)
                                                                                //Expression Builder sınıfına hazılamak için uygun formata döker.String döndürür.
        var countO = 0
        var countC = 0
        for (i in string) {
            if (i == '(')
                countO++
            if (i == ')')
                countC++
        }
        if (countC == countO)
            return string
        for (i in 1..countO - countC)
            string += ")"

        return string
    }

    fun bClose() {
        var string = exp.value!!
        var countO = 0
        var countC = 0
        for (i in string) {
            if (i == '(')
                countO++
            if (i == ')')
                countC++
        }

        if (string[string.length - 1] == '(') {
            string = string.substring(0, string.length - 1)
            exp.value = string
            return
        }

        if (countC < countO) {
            string += ")"
            exp.value = string
        }
    }

    fun bOpen() {
        var string = exp.value!!
        if (string[string.length - 1] == '.')
            string = string.substring(0, string.length - 1)
        string += "("
        exp.value = string
    }
/*    fun addOperator(o: Char) {
        if (o == '-' && exp.value == "0") {
            exp.value = "-"
            answer.value = "-"
            return
        }
        var string = exp.value!!
        if (string[string.length - 1] == '.')                       //Opearatörlerin yanlış kullanımını engeller.Denklem stringine yazdırır.
            string = string.substring(0, string.length - 1)
        if (string[string.length - 1] == '(' && o != '-')
            return
        if (!string[string.length - 1].isDigit() && o != '-')
            string = string.substring(0, string.length - 1)
        string += o.toString()
        exp.value = string
    }*/

    fun addOperator(o: Char) {
        if (o == '-' && exp.value == "0") {
            exp.value = "-"
            answer.value = "-"
            return
        }
        var string = exp.value!!
        if (string.isEmpty() && o == '-') {
            string += o.toString()
        } else {
            val lastChar = string.lastOrNull()
            if (lastChar != null) {
                if (lastChar.isDigit() || lastChar == ')') {
                    string += o.toString()
                } else if (lastChar == '(' && o == '-') {
                    string += o.toString()
                } else if (lastChar != '(' && o == '-') {
                    string += "$o"
                }
            }
        }
        exp.value = string
    }

    fun reset() {
        exp.value = "0"
        answer.value = "0"
    }

    fun equate() {
        exp.value = answer.value
    }

    fun delete() {

        val string = exp.value!!
        if (string.length == 1 || (string.length == 2 && string[0] == '-'))
            reset()
        else {
            exp.value = string.substring(0, string.length - 1)
            reevaluate()
        }
    }


}