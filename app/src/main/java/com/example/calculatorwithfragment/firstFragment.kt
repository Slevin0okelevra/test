package com.example.calculatorwithfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.calculatorwithfragment.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {


    lateinit var binding: FragmentFirstBinding
    val model: MainViewModel by viewModels()

//    private val args by navArgs<FirstFragment().args>()
//    private val assertion1 by lazy { assertion1 }
//    private val result1 by lazy { args.result1 }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

    override fun onResume() {
        model._assertion.observe(viewLifecycleOwner) { it ->
            binding.mathOperation.text = it

        }
        model._result.observe(viewLifecycleOwner) { it ->
            binding.resultText.text = it

        }
        super.onResume()

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val math_operation: TextView = binding.mathOperation
        val result_text: TextView = binding.resultText


        binding.btnRaven1.setOnClickListener {
            MAIN.navController.navigate(
                FirstFragmentDirections.actionFirstToSecond(
                    model._assertion.value,
                    model._result.value))
//       binding.apply {
//          if (!a) btnRaven1.setOnClickListener{
//                    MAIN.navController.navigate(R.id.actionFirstToSecond)
//               a = true
//              }
//           else btnRaven1.setOnClickListener{MAIN.navController.popBackStack(R.id.secondFragment,false)
//            a = false
//           }}
        }


        binding.apply {
            btnOne.setOnClickListener { setTextFields("1") }
            btnTwo.setOnClickListener { setTextFields("2") }
            btnThree.setOnClickListener { setTextFields("3") }
            btnFour.setOnClickListener { setTextFields("4") }
            btnFive.setOnClickListener { setTextFields("5") }
            btnSix.setOnClickListener { setTextFields("6") }
            btnSeven.setOnClickListener { setTextFields("7") }
            btnEight.setOnClickListener { setTextFields("8") }
            btnNine.setOnClickListener { setTextFields("9") }
            btnNull.setOnClickListener { setTextFields("0") }
            btnScobaon.setOnClickListener { setTextFields("(") }
            btnScobaoff.setOnClickListener { setTextFields(")") }
            slash.setOnClickListener { setTextFields("/") }
            btnZvezda.setOnClickListener { setTextFields("*") }
            btnPlus.setOnClickListener { setTextFields("+") }
            btnMinus.setOnClickListener { setTextFields("-") }
            btnTchk.setOnClickListener { setTextFields(".") }
            btnAc.setOnClickListener {
                result_text.text = ""
                math_operation.text = ""
            }
            btnBack.setOnClickListener {
                val str = math_operation.text.toString()
                if (str.isNotEmpty())
                    math_operation.text = str.substring(0, str.length - 1)
                result_text.text = ""
            }
            btnRaven.setOnClickListener {
                binding.resultText.text = getnumbers(binding.mathOperation.text.toString())
            }

        }

    }

    fun getnumbers(input: String): String {
        val firstnumber = input.takeWhile { it.isDigit() }.toInt()
        val second = input.takeLastWhile { it.isDigit() }.toInt()
        val operator = input.filter { !it.isDigit() }
        return model.resoult(firstnumber, second, operator)

    }

    fun setTextFields(str: String) {
        val math_operation: TextView = binding.mathOperation
        val result_text: TextView = binding.resultText

        if (result_text.text != "") {
            math_operation.text = result_text.text
            result_text.text = ""
        }

        math_operation.append(str)

    }

}