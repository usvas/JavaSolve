package myCollections;

import java.util.AbstractList;


/**
 * Разрабатываемая коллекция основана на принципе связного списка.
 * Она будет хранить целочисленные значения типа int.
 * <p>
 * Необходимо реализовать все приведённые здесь методы.
 * По желанию можно добавить свои методы. Уже реализован метод print().
 */
public class ListOnLink<T> extends AbstractList<T> {

    private Node<T> head;  // Элемент списка, которая хранит число и ссылку на следующий узел
    private int size;   // Размер списка

    /**
     * Создание пустого списка.
     */
    public ListOnLink() {
        head = new Node<T>();
        size = 0;
    }

    /**
     * Метод добавляющий значение типа Integer в конец коллекции.
     * Должно возращаться значение true;
     */
    @Override
    public boolean add(T i) {
        Node<T> t = head;
        while (t.getNext() != null) {
            t = t.getNext();
        }
        t.setNext(new Node(i));
        size++;
        return true;
    }

    /**
     * Метод производит удаление элемента находящегося на указанной позиции.
     * В случае успешного проведения операция метод возвращает 0.
     * В случае невозможности удаления метод должен вернуть -1.
     */
    @Override
    public T remove(int index) {
        if ((index > 0) && (index <= size)) {
            Node<T> t = head;
            Node<T> rem = null;
            int i = 1;
            if (index == 1) {
                head = head.getNext();
            } else {
                while ((t.getNext() != null) && (i != (index - 1))) {
                    i++;
                    t = t.getNext();
                }
                if (t.getNext() == null) {
                    return null;
                } else {
                    rem = t.getNext().getNext();
                    t.getNext().setNext(t.getNext().getNext().getNext());
                }
            }
            size--;
            return rem.getValue();
        }
        return null;
    }


    /**
     * Метод возвращает номер позиции, на которой находится
     * элемент коллекции с заданным значением.
     * Если позиция отсутствует (не нашли в коллекции), должны вернуть -1.
     */
    @Override
    public int indexOf(Object o) {
        if (!isEmpty()) {
            Node<T> t = head.getNext();
            int i = 1;
            while ((!o.equals(t)) && (t.getNext() != null)) {
                t = t.getNext();
                i++;
            }
            if (o.equals(t)) {
                return i;
            } else if (t.getNext() == null) {
                return -1;
            }
        }
        return -1;
    }

    /**
     * Метод должен очищать коллекцию.
     * Она должна стать такой, какой была при вызове конструктора.
     */
    @Override
    public void clear() {
        head.setNext(null);
        size = 0;
    }

    /**
     * Метод производит сравнение двух объектов.
     * Можете определить принцип равенства и не равенства объектов,
     * как захочется. Рекомендуется использовать метод hashCode().
     * <p>
     * o.equals(null) - вернёт false;
     * o.equals(o) - вернёт true;
     * o.equals(otherObject) - должен вернуть true или false в зависимости
     * от самих объектов и от вашей реализации этого метода
     */
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        return (this.hashCode() == o.hashCode());
    }

    /**
     * Метод, который должен возвращать некоторое целое число.
     * Для одного объекта, повторно вызванный метод возвращает одно и то же число.
     * Для различных объектов метод может возвращать как одинаковые значения, так и разные.
     * Реализация метода полностью зависит от программиста.
     */
    @Override
    public int hashCode() {
        int hash = -1258768272;
        if (!isEmpty()) {
            Node<T> t = head;
            int i = 0;
            while ((t.getNext() != null)) {
                t = t.getNext();
                i++;
                T element = t.getValue();
                hash = hash + i * element.hashCode();
                ;
            }

        }
        return hash;
    }

    /**
     * Метод отвечает на вопрос "Коллекция пуста?".
     * Возращает true или false.
     */
    @Override
    public boolean isEmpty() {
        return (size == 0) ? true : false;
    }


    /**
     * Метод возвращает значение (типа Integer) элемента коллекциия на позиции index.
     * Если по каким-либо причинам вернуть не получилось, метод возвращает null.
     */
    @Override
    public T get(int index) {
        if (index > 0) {
            Node<T> t = head;
            int i = 1;
            while ((t.getNext() != null) && (i != (index))) {
                i++;
                t = t.getNext();
            }
            return t.getValue();
        } else {
            return null;
        }
    }


    /**
     * Метод возвращает размер коллекции.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Собственный метод, который будете использовать
     * для отслеживания изменений состояния коллекции.
     */
    @Override
    public String toString() {
        String res = "";
        if (!isEmpty()) {
            Node<T> t = head.getNext();
            res += t.getValue().toString();
            while (t.getNext() != null) {
                t = t.getNext();
                res += ", " + t.getValue().toString();
            }
            res += ".";
        } else {
            res += "This list is empty.";
        }
        return res;
    }


}
