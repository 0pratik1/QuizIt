package com.example.quizit

object Constants{
    const val UserName:String="username"
    const val totalQue: String="totalque"
    const val correctAns:String="correctans"
    fun getQuestion(): ArrayList<Question>{
        val queList=ArrayList<Question>()
        val que1=Question(
            1,
            "Which is the biggest planet in solar system?",
            "Earth",
            "Mars",
            "moon",
            "Jupiter",
            4
        )
        queList.add(que1)
        val que2=Question(
            1,
            "Which is the smallest planet in solar system?",
            "Earth",
            "Mars",
            "venus",
            "Jupiter",
            3
        )
        queList.add(que2)
        val que3=Question(
            1,
            "What is capital of India?",
            "Pune",
            "Mumbai",
            "Delhi",
            "Jupiter",
            3
        )
        queList.add(que3)
        val que4=Question(
            1,
            "What is capital of Maharashtra?",
            "Pune",
            "Mumbai",
            "Delhi",
            "Jupiter",
            2
        )
        queList.add(que4)
        val que5=Question(
            1,
            "what is national game of india?",
            "Pune",
            "Mumbai",
            "Delhi",
            "Jupiter",
            2
        )
        queList.add(que5)
        return queList
    }
}