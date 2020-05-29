class Entry {
    public static void main(String[] args) throws Exception {
        LinkedList linkedList = new LinkedList();
        linkedList.pushNode(new Node(5));
        linkedList.pushNode(new Node(3));
        linkedList.pushNode(new Node(9));
        linkedList.pushNode(new Node(7));

//        Node node = linkedList.getNodeByValue(3);
        Node node = linkedList.getNodeByValue(12);

        System.out.println(node);
    }
}

class LinkedList {

    private Node headNode;

    LinkedList() {
        this.headNode = null;
    }

    public Node getHeadNode() {
        return headNode;
    }

    public Node getNodeByValue(int value) throws Exception {
        boolean isSearchingForNode = true;
        Node currentNode = this.getHeadNode();

        while (isSearchingForNode) {
            if (currentNode.getValue() == value) {
                return currentNode;
            }

            if (currentNode.hasNextNode()) {
                currentNode = currentNode.getNextNode();
            } else {
                isSearchingForNode = false;
            }
        }

        throw new Exception("Node not found");
    }

    public void pushNode(Node nextNode) {
        nextNode.setNextNode(this.headNode);
        headNode = nextNode;
    }

}

class Node {
    private int value;
    private Node nextNode;

    Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public boolean hasNextNode() {
        return this.nextNode.nextNode != null;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}
