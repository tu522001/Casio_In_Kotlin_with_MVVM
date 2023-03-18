package com.example.casio_kotlin

import android.text.Editable
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {


    private val _result = MutableLiveData<Int>()
    val result: LiveData<Int>
        get() = _result

    fun calculateSum(number: Number) {

        _result.value = number.number1 + number.number2
    }

    fun calculateSubtraction(number: Number) {
        _result.value = number.number1 - number.number2
    }

    fun calculateMultiplication(number: Number) {
        _result.value = number.number1 * number.number2
    }

    fun calculateDivistion(number: Number) {
        _result.value = number.number1 / number.number2
    }

}