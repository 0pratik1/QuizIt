package com.example.quizit

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_question.*

class QuizQuestion : AppCompatActivity() ,View.OnClickListener{

    var mycurrentpos=1
    var myQuestionList:ArrayList<Question>?=null
    var mySelectedOptionPosition=0
    var mycorrectAns=0
    var myUsername:String?=null
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        myUsername=intent.getStringExtra(Constants.UserName)

        myQuestionList=Constants.getQuestion()
//        val currentpos=1
//        val question:Question?=myQuestionList!![currentpos-1]
//        progressBar.progress=currentpos
//        tv_progress.text="$currentpos"+"/"+progressBar.max
//        tv_question.text=question!!.question
//        optionOne.text=question.option1
//        optiontwo.text=question.option2
//        optionThree.text=question.option3
//        optionFour.text=question.option4
        setQuestion()

        optionOne.setOnClickListener(this)
        optiontwo.setOnClickListener(this)
        optionThree.setOnClickListener(this)
        optionFour.setOnClickListener(this)
        btnSubmit.setOnClickListener(this)

    }
    fun setQuestion(){
        val question:Question?=myQuestionList!![mycurrentpos-1]
        defaultOptionV()
        if(mycurrentpos==myQuestionList!!.size){
            btnSubmit.text="FINISH"
        }else{
            btnSubmit.text="SUBMIT"
        }
        progressBar.progress=mycurrentpos
        tv_progress.text="$mycurrentpos"+"/"+progressBar.max
        tv_question.text=question!!.question
        optionOne.text=question.option1
        optiontwo.text=question.option2
        optionThree.text=question.option3
        optionFour.text=question.option4
    }
    @SuppressLint("Range")
    fun defaultOptionV(){
        val option =ArrayList<TextView>()
        option.add(0,optionOne)
        option.add(1,optiontwo)
        option.add(2,optionThree)
        option.add(3,optionFour)
        for (op in option){
            op.setTextColor(Color.parseColor(("#656262")))
            op.typeface= Typeface.DEFAULT
            op.background=ContextCompat.getDrawable(this,R.drawable.default_option_border_bg)
        }
    }

    override fun onClick(v: View?) {
    when(v?.id){
        R.id.optionOne->{
            selectedOptionView(optionOne,1)
        }
        R.id.optiontwo->{
            selectedOptionView(optiontwo,2)
        }
        R.id.optionThree->{
            selectedOptionView(optionThree,3)

        }
        R.id.optionFour->{
            selectedOptionView(optionFour,4)
        }
        R.id.btnSubmit->{
            if (mySelectedOptionPosition==0){
                mycurrentpos++
                when{
                    mycurrentpos<=myQuestionList!!.size->{
                        setQuestion()
                    }else->{
                    val intent= Intent(this,ResultACtivity::class.java)
                    intent.putExtra(Constants.UserName,myUsername)
                    intent.putExtra(Constants.correctAns,mycorrectAns)
                    intent.putExtra(Constants.totalQue,myQuestionList!!.size)
                    Toast.makeText(this,"You Have completed quiz",Toast.LENGTH_LONG).show()
                    startActivity(intent)
                }
                }
            }else{
                val que =myQuestionList?.get(mycurrentpos-1)
                if (que!!.correct!=mySelectedOptionPosition){
                    ansView(mySelectedOptionPosition,R.drawable.wrong_option_border_bg)

                }else{
                    mycorrectAns++
                }
                ansView(que.correct,R.drawable.correct_option_border_bg)
                if(mycurrentpos==myQuestionList!!.size){
                    btnSubmit.text="FINSIH"
                }else{
                    btnSubmit.text="GO TO NEXT QUESTION"
                }
                mySelectedOptionPosition=0
            }
        }
    }

    }
    fun ansView(answer:Int,draView:Int){
        when(answer){
            1->{
                optionOne.background=ContextCompat.getDrawable(this,draView)
            }
            2->{
                optiontwo.background=ContextCompat.getDrawable(this,draView)
            }
            3->{
                optionThree.background=ContextCompat.getDrawable(this,draView)
            }
            4->{
                optionFour.background=ContextCompat.getDrawable(this,draView)
            }
        }
    }
    fun selectedOptionView(tv:TextView,selectedNum:Int){
        defaultOptionV()
        mySelectedOptionPosition=selectedNum
        tv.setTextColor(Color.parseColor(("#363A43")))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background=ContextCompat.getDrawable(this,R.drawable.selected_option_border_bg)

    }
}