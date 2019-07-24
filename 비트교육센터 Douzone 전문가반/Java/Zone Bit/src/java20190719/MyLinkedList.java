package java20190719;

public class MyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    public MyLinkedList() {
        size = 0;
    }

    private class Node {
        private Node nextNode;
        private Node prevNode;
        private Object data;

        Node(Object data) {
            this.data = data;
            this.nextNode = null;
            this.prevNode = null;
        }
    }

    public void addFirst(Object data) {
        Node newNode = new Node(data);

        if (head != null) {
            // 기존 노드가 있음
            newNode.nextNode = head;
            head.prevNode = newNode;
        }

        head = newNode;
        if (head.nextNode == null) {
            tail = head;
        }
        size++;
    }

    public void add(Object data) {
        if (size == 0) {
            addFirst(data);
        } else {
            Node newNode = new Node(data);
            tail.nextNode = newNode;
            newNode.prevNode = tail;
            tail = newNode;
            size++;
        }
    }

    public String toString() {
        StringBuffer result = new StringBuffer("[");
        if (size != 0) {
            Node node = head;
            result.append(node.data);
            while (node.nextNode != null) {
                node = node.nextNode;
                result.append(", ");
                result.append(node.data);
            }
        }
        result.append("]");
        return result.toString();
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addFirst(40);
        list.addFirst(30);
        list.addFirst(20);
        list.addFirst(10);
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list.toString()); // 10 20 30 40
    }
}