package myCollections;

public class Node<T> {

    private T value; // Хранимое значение. Для которого и создавалась коллекция
    private Node next; // Ссылка на следующий элемент коллекции.

    /**
     * Пустой конструктор
     */
    Node() {

    }

    /**
     * Конструктор, принимающий хранимое значение.
     */
    Node(T value) {
        this.value = value;
    }


    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return next;
    }


}
