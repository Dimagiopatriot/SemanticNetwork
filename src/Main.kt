import java.util.*

val KILL = "--k"

fun main(args: Array<String>) {

    val dictionary = Dictionary<String>()
    val inputStrategyContext = InputStrategyContext()
    val dictionaryInputStrategy = DictionaryInputStrategy(dictionary)
    val analyzeInputStrategy = AnalyzeInputStrategy(dictionary)

    var word = ""
    val input = Scanner(System.`in`)
    while (!word.equals(KILL)) {
        word = input.nextLine()
        when {
            word.equals(KILL) -> return
            word.startsWith("--h") || word == "--help" -> {
                showHelp()
            }
            word.contains("--") -> println("Incorrect command")
            word.startsWith("D:") -> {
                println("Input dictionary words")
                inputStrategyContext.setupInputStrategy(dictionaryInputStrategy)
            }
            word.startsWith("A:") -> {
                println("Input analyze sentence")
                inputStrategyContext.setupInputStrategy(analyzeInputStrategy)
            }
            word.startsWith("Def:") -> {
                println("Default dictionary")
                println(dictionaryInputStrategy.defDictionary.toString())
                dictionaryInputStrategy.processDefaultDictionary()
                println("Input analyze sentence")
                inputStrategyContext.setupInputStrategy(analyzeInputStrategy)

            }
            else -> {
                if (inputStrategyContext.isInputStrategyInitialized()) {
                    inputStrategyContext.executeStrategy(word)
                } else {
                    println("Define custom dictionary by command 'D:' or use default dictionary by command 'Def:'")
                }
            }
        }
    }
}

