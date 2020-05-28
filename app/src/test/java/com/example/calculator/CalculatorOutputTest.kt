package com.example.calculator

import com.example.calculator.calculator_outputView.CalculatorOutputInterfaceView
import com.example.calculator.calculator_outputView.CalculatorOutputPresenter
import org.junit.Test
import org.mockito.BDDMockito.then
import org.mockito.Mockito

class CalculatorOutputTest {

    private val myPresenter: CalculatorOutputPresenter = CalculatorOutputPresenter
    private val myMockView = Mockito.mock(CalculatorOutputInterfaceView::class.java)

    @Test
    fun onePlusOneIsTwo(){
        //given that the view is attached
        myPresenter.attach(myMockView)

        //when a number is added
        myPresenter.add("1")

        //then the correct equation should be set
        then(myMockView).should().setEquation("1")

        //when an operator is added
        myPresenter.add("+")

        //then the correct equation should be set
        then(myMockView).should().setEquation("1+")

        //when a number is added
        myPresenter.add("1")

        //then the correct equation should be set
        then(myMockView).should().setEquation("1+1")

        //then the correct outcome should be set
        then(myMockView).should().setOutcome("2")

        //clear presenter
        myPresenter.clear()
    }

    @Test
    fun twoPlusTwoMinusOneIsThree(){
        //given that the view is attached
        myPresenter.attach(myMockView)

        //when a number is added
        myPresenter.add("2")

        //then the correct equation should be set
        then(myMockView).should().setEquation("2")

        //when an operator is added
        myPresenter.add("+")

        //then the correct equation should be set
        then(myMockView).should().setEquation("2+")

        //when a number is added
        myPresenter.add("2")

        //then the correct equation should be set
        then(myMockView).should().setEquation("2+2")

        //then the correct outcome should be set
        then(myMockView).should().setOutcome("4")

        //when an operator is added
        myPresenter.add("-")

        //then the correct equation should be set
        then(myMockView).should().setEquation("2+2-")

        //when a number is added
        myPresenter.add("1")

        //then the correct equation should be set
        then(myMockView).should().setEquation("2+2-1")

        //then the correct outcome should be set
        then(myMockView).should().setOutcome("3")

        //clear presenter
        myPresenter.clear()
    }

}