data class Node<N: NodeType, V>(val type: N, val value: V,
                           val nodesApper: List<Node<N, V>>? = null,
                           val nodesLover: List<Node<N, V>>? = null) {
}