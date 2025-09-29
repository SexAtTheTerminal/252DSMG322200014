package com.example.basic_knowledge

fun main()
{
    val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
    val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
    val question3 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)
    println(question1.toString())

    println("${Quiz.answered} of ${Quiz.total} answered.")

    Quiz.printProgressBar()

    Quiz2().printProgressBar()


    val quiz123 = Quiz()
    quiz123.printQuiz()

    Quiz().apply {
        printQuiz()
    }
}

data class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty
)

enum class Difficulty {
    EASY, MEDIUM, HARD
}

interface ProgressPrintable{
    val progressText: String
    fun printProgressBar()
}

class Quiz{
    val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
    val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
    val question3 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)


    companion object StudentProgress{
        var total: Int = 10
        var answered: Int = 3
    }

    fun printQuiz() {
    question1.let {
        println(it.questionText)
        println(it.answer)
        println(it.difficulty)
    }
    println()
    question2.let {
        println(it.questionText)
        println(it.answer)
        println(it.difficulty)
    }
    println()
    question3.let {
        println(it.questionText)
        println(it.answer)
        println(it.difficulty)
    }
    println()
}
}

//Propiedad de extensión
val Quiz.StudentProgress.progressText: String
        get() = "${answered} of ${total} answered"

//Funcion de extensión
fun Quiz.StudentProgress.printProgressBar() {
    repeat(Quiz.answered) { print("|") }
    repeat(Quiz.total - Quiz.answered) { print("-") }
    println()
    println(Quiz.progressText)
}


class Quiz2: ProgressPrintable{

    override val progressText: String
        get() = "${answered} of ${total} answered"

    override fun printProgressBar() {
        repeat(Quiz.answered) { print("|") }
        repeat(Quiz.total - Quiz.answered) { print("-") }
        println()
        println(Quiz.progressText)
    }

    companion object StudentProgress{
        var total: Int = 10
        var answered: Int = 3
    }
}