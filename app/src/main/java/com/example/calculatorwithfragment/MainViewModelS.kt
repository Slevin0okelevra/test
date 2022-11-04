package com.example.calculatorwithfragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModelS : ViewModel() {

    val assertion1 = MutableLiveData<String>()
    val _assertion1: LiveData<String> = assertion1
    val result1 = MutableLiveData<String>()
    val _result1: LiveData<String> = result1
    val loader = MutableLiveData<Boolean>()
    val _loader: LiveData<Boolean> = loader
    init {
        loader.postValue(false)
    }

    fun resoult(firstnumber: Int, secondnumber: Int, operator:String): String{
        return when(operator) {
            "-" -> {
                assertion1.postValue("$firstnumber" + operator + "$secondnumber")
                result1.postValue((firstnumber - secondnumber).toString())
                loader.postValue(true)
                (firstnumber - secondnumber).toString()
            }
            "+" -> {
                assertion1.postValue("$firstnumber" + operator + "$secondnumber")
                result1.postValue((firstnumber + secondnumber).toString())
                loader.postValue(true)
                (firstnumber + secondnumber).toString()
            }
            "/" -> {
                assertion1.postValue("$firstnumber" + operator + "$secondnumber")
                result1.postValue((firstnumber / secondnumber).toString())
                loader.postValue(true)
                (firstnumber / secondnumber).toString()
            }
            "*" -> {
                assertion1.postValue("$firstnumber" + operator + "$secondnumber")
                result1.postValue((firstnumber * secondnumber).toString())
                loader.postValue(true)
                (firstnumber * secondnumber).toString()
            }

            else -> ""

        }

    }
}