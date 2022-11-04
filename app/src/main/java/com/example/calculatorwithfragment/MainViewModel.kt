package com.example.calculatorwithfragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val assertion = MutableLiveData<String>()
    val _assertion: LiveData<String> = assertion
    val result = MutableLiveData<String>()
    val _result: LiveData<String> = result
    init {

            }

    fun resoult(firstnumber: Int, secondnumber: Int, operator:String): String{
        return when(operator) {
            "-" -> {
                assertion.postValue("$firstnumber" + operator + "$secondnumber")
                result.postValue((firstnumber - secondnumber).toString())
                (firstnumber - secondnumber).toString()
            }
            "+" -> {
                assertion.postValue("$firstnumber" + operator + "$secondnumber")
                result.postValue((firstnumber + secondnumber).toString())
                (firstnumber + secondnumber).toString()
            }
            "/" -> {
                assertion.postValue("$firstnumber" + operator + "$secondnumber")
                result.postValue((firstnumber / secondnumber).toString())
                (firstnumber / secondnumber).toString()
            }
            "*" -> {
                assertion.postValue("$firstnumber" + operator + "$secondnumber")
                result.postValue((firstnumber * secondnumber).toString())
                (firstnumber * secondnumber).toString()
            }

            else -> ""

        }

    }
}