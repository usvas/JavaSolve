package myCollections;

import java.util.AbstractList;

/**
 * Разрабатываемая коллекция основана на принципе связного списка.
 * Она будет хранить целочисленные значения типа int.
 * <p>
 * Необходимо реализовать все приведённые здесь методы.
 * По желанию можно добавить свои методы. Уже реализован метод print().
 */
public class ListOnLink extends AbstractList<Integer> {

    private Node head;  // Элемент списка, которая хранит число и ссылку на следующий узел
    private int size;   // Размер списка

    /**
     * Создание пустого списка.
     */
    public ListOnLink() {
        head = new Node();
        size = 0;
    }

    /**
     * Метод добавляющий значение типа Integer в конец коллекции.
     * Должно возращаться значение true;
     */
    @Override
    public boolean add(Integer i) {
        Node t = head;
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
    public Integer remove(int index) {
        if (index > 0) {
            Node t = head;
            int i = 1;
            if (index == 1) {
                head = head.getNext();
            } else {
                while ((t.getNext() != null) && (i != (index - 1))) {
                    i++;
                    t = t.getNext();
                }
                if (t.getNext() == null) {
                    return new Integer(-1);
                } else {
                    t.getNext().setNext(t.getNext().getNext());
                }
            }
            size--;
            return new Integer(0);
        }
        return new Integer(-1);

    }


    /**
     * Метод возвращает номер позиции, на которой находится
     * элемент коллекции с заданным значением.
     * Если позиция отсутствует (не нашли в коллекции), должны вернуть -1.
     */
    @Override
    public int indexOf(Object o) {
        return super.indexOf(o);
    }


    /**
     * Если сложно с поиском элемента типа Object, реализуйте данный метод.
     * Требования и описание аналогичное методу public int indexOf(Object o).
     */
    public int indexOf(int o) {
        if (!isEmpty()) {
            Node t = head.getNext();
            int i = 1;
            while ((t.getValue() != o) && (t.getNext() != null)) {
                t = t.getNext();
                i++;
            }
            if (t.getValue() == o) {
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
            Node t = head;
            int i = 0;
            while ((t.getNext() != null)) {
                t = t.getNext();
                i++;
                hash = hash + i * t.getValue();
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
    public Integer get(int index) {
        if (index > 0) {
            Node t = head;
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
    public void print() {
        if (!isEmpty()) {
            Node t = head.getNext();
            System.out.print(t.getValue());
            while (t.getNext() != null) {
                t = t.getNext();
                System.out.print(", " + t.getValue());
            }
            System.out.println(".");
        } else {
            System.out.println("This list is empty.");
        }
    }

}
