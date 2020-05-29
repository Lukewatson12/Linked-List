class Entry {
    public static void main(String[] args) throws Exception {
        LinkedList linkedList = new LinkedList();
        linkedList.pushNode(new Node(5));
        linkedList.pushNode(new Node(3));
        linkedList.pushNode(new Node(9));
        linkedList.pushNode(new Node(7));

        Node node = linkedList.getNodeByValue(3);

        linkedList.deleteNode(7);

        linkedList.getNodeByValue(7);
    }
}

class LinkedList {

    private Node headNode;
    private Node tailNode;

    LinkedList() {
        this.headNode = null;
    }

    public Node getHeadNode() {
        return headNode;
    }

    public Node getTailNode() {
        return tailNode;
    }

    public void pushNode(Node nextNode) {
        if (tailNode == null) {
            tailNode = nextNode;
        }

        if (this.headNode != null) {
            this.headNode.setPreviousNode(nextNode);
        }


        nextNode.setNextNode(this.headNode);
        headNode = nextNode;
    }

    public void deleteNode(int nodeValue) throws Exception {
        Node node = getNodeByValue(nodeValue);

        resetNodeRelations(node);

        if(node == getTailNode()) {
            tailNode = node.getPreviousNode();
        } else if (node == getHeadNode()) {
            headNode = node.getNextNode();
        }
    }

    private void resetNodeRelations(Node node) {
        if (node.hasNextNode() && node.hasPreviousNode()) {
            Node nextNode = node.getNextNode();
            Node previousNode = node.getPreviousNode();

            nextNode.setPreviousNode(previousNode);
            previousNode.setNextNode(nextNode);
        } else if (node.hasPreviousNode() && !node.hasNextNode()) {
            node.getPreviousNode().setNextNode(null);
        } else {
            node.getNextNode().setPreviousNode(null);
        }
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

}

class Node {
    private int value;
    private Node nextNode;
    private Node previousNode;

    Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public Node getPreviousNode() {
        return previousNode;
    }

    public boolean hasNextNode() {
        return this.nextNode != null;
    }

    public boolean hasPreviousNode() {
        return this.previousNode != null;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public void setPreviousNode(Node previousNode) {
        this.previousNode = previousNode;
    }
}
