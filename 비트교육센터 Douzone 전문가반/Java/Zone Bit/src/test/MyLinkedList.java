package test;

public class MyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    public MyLinkedList() {
        size = 0;
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);

        if (head != null) {  // 다른 노드가 존재 할때
            newNode.nextNode = head;  // 새로운 노드의 다음을 헤드로 만들어준다.
            head.prevNode = newNode;  // 헤드의 이전 노드를 새로운 노드로 만든다.
        }

        head = newNode;  // 헤드를 새로운 노드로 만든다.
        if (head.nextNode == null) {  // 새로운 헤드의 다음이 null일 경우
            tail = head;  // 테일에 헤드를 넣어준다.
        }
        size++;
    }

    public void add(int index, int data) {
        if (index == 0) {  // add하고 싶은 위치가 제일 앞일 경우
            addFirst(data);
        }else if (index == size - 1) {  // add하고 싶은 위치가 제일 뒤일 경우
            if (size == 0) {
                addFirst(data);
            } else {
                Node newNode = new Node(data);
                tail.nextNode = newNode;  // 테일의 다음을 새로운 노드로 만든다.
                newNode.prevNode = tail;  // 새로운 노드의 이전을 테일로 만든다.
                tail = newNode;   // 테일을 새로운 노드로 만든다.
                size++;
            }            
        }else{
            Node newNode = new Node(data);
            Node prevNode = getNode(index - 1);
            Node nextNode = prevNode.nextNode;
            // 추가된 노드의 전후 설정
             // 추가된 노드의 전후 설정
             newNode.prevNode = prevNode;
             newNode.nextNode = nextNode;
             // 이전 노드의 전후 설정
             prevNode.nextNode = newNode;
             // 다음 노드의 전후 설정
             nextNode.prevNode = newNode;
     
             size++;
        }
    }

    public boolean removeFirst() {
        if (size == 0) {
            return false;
        }
        Node removeNode = head;  // 수정할 링크리스트를 removeNode넣어준다.
        head = null;  // 헤드를 비우고
        head = removeNode.nextNode;  // head에 다음 노드 값을 넣어준다.
        head.prevNode = null; // 헤드라서 뒤쪽 노드는 없다.
        size--;

        return true;
    }

    public boolean  update(int index, int data) {
        if (size != 0) {
            if (index < size / 2) {
                Node node = head;
                for (int i = 0; i < index; i++) {
                    node = node.nextNode;
                }
                node.data = data;
                return true;
            }else{
                Node node = tail;
                //       i = 2;    i > 3
                for (int i = size - 1; i > index; i--) {
                    node = node.prevNode;
                }
                node.data = data;
                return true;
            }
        }
        return false;
    }

    private class Node{
        private Node nextNode;
        private Node prevNode;
        private int data;

        public Node(int data) {  // 생성 초기에 data만 들고 생성한다.
            this.nextNode = null;
            this.prevNode = null;
            this.data = data;
        }  
    }

    private Node getNode(int index) {
        if (index < size / 2) {
            Node node = head;
            for (int i = 0; i < index; i++) {
                node = node.nextNode;
            }
            return node;
        }else{
            Node node = tail;
            for (int i = size - 1; i > index; i--) {
                node = node.prevNode;
            }
            return node;
        }
    }

    public String toString() {
        StringBuffer result = new StringBuffer("[ ");

        if (size != 0) {
            Node node = head;
            result.append(node.data);
            while (node.nextNode != null) {
                node = node.nextNode;
                result.append(", ");
                result.append(node.data);
            }
        }
        result.append(" ]");
        return result.toString();
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();

        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(30);
        list.addFirst(30);
        list.addFirst(30);
        list.addFirst(30);

        System.out.println(list.toString() + " Size : " + list.size);

        list.update(3, 111);
        System.out.println(list.toString() + " Size : " + list.size);

        list.removeFirst();
        System.out.println(list.toString() + " Size : " + list.size);
    }
}