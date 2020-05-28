package com.example.calculator

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.view_calculator_input.view.*

class CalculatorInputView(context: Context, attributeSet: AttributeSet?): RelativeLayout(context, attributeSet) {
    init {
        //inflate layout
        LayoutInflater.from(context).inflate(R.layout.view_calculator_input, this, true)

        //read attribute set
        attributeSet?.run {
            val typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.CalculatorInputView)

            val textResource = typedArray.getString(R.styleable.CalculatorInputView_item_text)
            val iconResource = typedArray.getResourceId(R.styleable.CalculatorInputView_item_icon, -1)

//            if(iconResource != -1){
//                input_element_text.visibility = View.GONE //hiding the text
//                input_element_image.apply {
//                    visibility = View.VISIBLE //making icon resource visible
//                    setImageResource(iconResource) //set the actual iamge
//                }
//            } else if(!textResource.isNullOrEmpty()){
//                input_element_image.visibility = View.GONE
//                input_element_text.apply {
//                    visibility = View.VISIBLE
//                    text = textResource
//                }
//            } else{
//                input_element_image.visibility = View.GONE
//                input_element_text.visibility = View.GONE
//            }


            when{
                iconResource != -1 -> {
                    input_element_text.visibility = View.GONE //hiding the text
                    input_element_image.apply {
                        visibility = View.VISIBLE //making icon resource visible
                        setImageResource(iconResource) //set the actual iamge
                    }
                } !textResource.isNullOrEmpty() -> {
                    input_element_image.visibility = View.GONE
                    input_element_text.apply {
                        visibility = View.VISIBLE
                        text = textResource
                    }
                } else -> {
                    input_element_image.visibility = View.GONE
                    input_element_text.visibility = View.GONE
                }

            }
            typedArray.recycle()
        }
    }

    override fun setOnClickListener(l: OnClickListener?) {
        input_element_click.setOnClickListener(l)
    }
}