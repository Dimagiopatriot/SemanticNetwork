class Dictionary<V> {

    companion object {
        val TO = "to"
        val THE = "the"
        val FOR = "for"
        val A = "a"
        val AN = "an"
        val AND = "and"
        val IS = "is"
        val FROM = "from"

        val predicates = listOf(TO, THE, FOR, A, AN, IS, FROM, AND)
    }

    val nodes = ArrayList<Node<NodeType, V>>()

    val result = HashSet<String>()

    fun addNodeToSemanticDictionaty(node: Node<NodeType, V>): Node<NodeType, V> {
        nodes.add(node)
        return node
    }

    fun parseLanguage(sentence: String) {
        result.clear()
        if (!nodes.isEmpty()) {
            var clearSentence = sentence
            val startArray = sentence.split(" ")
            predicates.forEach { it -> startArray.forEach { item ->
                run {
                    if (!item.equals(it)) {
                        clearSentence += item + " "
                    }
                }
            } }
            nodes.forEach {
                it -> if (it.nodesApper != null && it.nodesLover != null) {
                    if (clearSentence.contains(it.value.toString())) {
                        it.nodesApper.forEach { nApp ->
                            if (clearSentence.contains(nApp.value.toString())) {
                                it.nodesLover.forEach { nLov ->
                                    run {
                                        if (!clearSentence.contains(nLov.value.toString())) {
                                            result.add(nLov.value.toString())
                                        }
                                    }
                                }
                            }
                        }
                        it.nodesLover.forEach { nLov ->
                            if (clearSentence.contains(nLov.value.toString())) {
                                it.nodesApper.forEach { nApp ->
                                    run {
                                        if (!clearSentence.contains(nApp.value.toString())) {
                                            result.add(nApp.value.toString())
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            println(result)
        } else {
            println("Dictionary is empty")
        }
    }

    fun printDictionary() {
        println(nodes.toString())
    }
}