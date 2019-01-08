class DictionaryInputStrategy(val dictionary: Dictionary<String>) : InputStrategy {

    val defDictionary = listOf(
            "Aragorn->king_of->Gondor,Arnor",
            "Shire->motherland->hobbits",
            "Elfs,humans->child_of->Iluvatar",
            "Tolkien->author_of->Silmarillion,The_Lord_of_the_Rings,The_Hobbit"
            )

    fun processDefaultDictionary() {
        defDictionary.forEach { it -> processInput(it) }
    }

    override fun processInput(input: String) {
        val items = input.split("->")
        val firstStage = items[0].split(",")
                .toTypedArray()
                .map { it ->
                    dictionary.addNodeToSemanticDictionaty(Node(NodeType.ITEM, it))
                }
        val secondStage = items[2].split(",")
                .toTypedArray()
                .map { it ->
                    dictionary.addNodeToSemanticDictionaty(Node(NodeType.ITEM, it))
                }
        dictionary.addNodeToSemanticDictionaty(Node(NodeType.RELATIONSHIP, items[1], firstStage, secondStage))
        //dictionary.printDictionary()
    }
}