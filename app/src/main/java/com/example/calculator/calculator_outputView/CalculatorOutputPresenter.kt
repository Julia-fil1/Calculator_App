package com.example.calculator.calculator_outputView

import bsh.Interpreter
import java.lang.Exception

object CalculatorOutputPresenter {

    //current attached view
    private var myView: CalculatorOutputInterfaceView? = null

    //current equation
    private var myCurrentEquation: String = ""

    //current outcome
    private var myCurrentOutcome: String = ""

    //interpreter (takes care of the calculations)
    private val myInterpreter = Interpreter()

    fun attach(view: CalculatorOutputInterfaceView){
        myView = view
        updateEquation()
        updateOutcome()
    }

    fun detach(){
        myView = null//resetting view (setting it to null)
    }

    fun add(item: String){
        myCurrentEquation = myCurrentEquation.plus(item)
        updateEquation()
        calculateOutcome()
        updateOutcome()
    }

    fun remove(){
        myCurrentEquation = if(myCurrentEquation.length > 1) {
            myCurrentEquation.substring(0, myCurrentEquation.length - 1)
        } else{
            ""
        }
        updateEquation()
        calculateOutcome()
        updateOutcome()
    }

    fun solve(){
        if(myCurrentOutcome.isNotEmpty()){
            myCurrentEquation = myCurrentOutcome
            myCurrentOutcome = ""
        }
        updateEquation()
        updateOutcome()

    }

    fun clear(){
        myCurrentEquation = ""
        myCurrentOutcome = ""
        updateEquation()
        updateOutcome()
    }

    private fun calculateOutcome(){
        if(myCurrentEquation.isNotEmpty()){
            try {
                myInterpreter.eval("result =  $myCurrentEquation")
                val result = myInterpreter.get("result")

                if (result != null && result is Int){
                    myCurrentOutcome = result.toString()
                }
            } catch (e: Exception) {
                myCurrentOutcome = ""
            }
        } else {
            myCurrentOutcome = ""
        }
    }

    private fun updateEquation(){
        myView?.setEquation(myCurrentEquation)
    }

    private fun updateOutcome(){
        myView?.setOutcome(myCurrentOutcome)
    }
}
