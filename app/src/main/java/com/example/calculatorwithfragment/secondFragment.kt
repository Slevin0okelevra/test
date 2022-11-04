package com.example.calculatorwithfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.calculatorwithfragment.databinding.FragmentSecondBinding


@Suppress("DEPRECATION")
class secondFragment : Fragment() {

    lateinit var binding: FragmentSecondBinding
    val vm: MainViewModelS by viewModels()
    var a = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onResume() {

        val b = vm._assertion1.value
        binding.editText.setText(b)

        vm._result1.observe(viewLifecycleOwner) { it ->
            binding.resultText1.text = it

        }
        super.onResume()

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.apply {

            vm.loader.observe(viewLifecycleOwner){
                test.text = if (it) "Правильно?" else "Думаем"
            }


                btnRaven2.setOnClickListener{MAIN.navController.popBackStack()}



            btnRaven1.setOnClickListener {
                resultText1.text = getnumbers(editText.text.toString())
                editText.clearFocus()
            }



        }
    }

    fun getnumbers(input: String):String {
        val firstnumber = input.takeWhile { it.isDigit() }.toInt()
        val second = input.takeLastWhile { it.isDigit() }.toInt()
        val operator = input.filter { !it.isDigit() }
        return vm.resoult(firstnumber, second, operator)

    }


}