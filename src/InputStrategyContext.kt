class InputStrategyContext {

    lateinit var inputStrategy: InputStrategy

    fun setupInputStrategy(inputStrategy: InputStrategy) {
        this.inputStrategy = inputStrategy
    }

    fun executeStrategy(statement: String) {
        inputStrategy.processInput(statement)
    }

    fun isInputStrategyInitialized() = ::inputStrategy.isInitialized
}