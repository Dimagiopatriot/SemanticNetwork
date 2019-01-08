class AnalyzeInputStrategy(val dictionary: Dictionary<String>): InputStrategy {

    override fun processInput(input: String) {
        dictionary.parseLanguage(input)
    }
}