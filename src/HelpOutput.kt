fun showHelp() {
    val helpText =
            """Welcome! This is help of 'Sematicus' v1.0!
                |For using this app you can use next commands:
                |        'D:' - start filling custom network in format '<expression>-><connection>-><expression>'
                |        'A:' - check network using input format '<expression> <connection>'
                |        'Def:' - use default semantic network
                |        '--k' - stop program
            """.trimMargin()
    println(helpText)
}