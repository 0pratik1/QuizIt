package com.example.quizit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_result_a_ctivity.*

class ResultACtivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_a_ctivity)


        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN

        val username=intent.getStringExtra(Constants.UserName)
        tv_name.text=username
        val totalque=intent.getIntExtra(Constants.totalQue,0)
        val correct=intent.getIntExtra(Constants.correctAns,0)
        tv_result.text="Your Score is $correct out of $totalque"
        btn_finish.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
    }
}