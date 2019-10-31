package myCollections;

public class Node {

    private int value; // Хранимое значение. Для которого и создавалась коллекция
    private Node next; // Ссылка на следующий элемент коллекции.

    /**
     * Пустой конструктор
     */
    Node() {

    }

    /**
     * Конструктор, принимающий хранимое значение.
     */
    Node(int value) {
        this.value = value;
    }


    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return next;
    }


}
