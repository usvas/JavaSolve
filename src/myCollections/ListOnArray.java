package myCollections;

import java.util.AbstractList;

/**
 * Разрабатываемая коллекция основана на использовании массива.
 * Она будет хранить целочисленные значения типа int.
 * <p>
 * Необходимо реализовать все приведённые здесь методы.
 * Реализуйте метод print() по аналогии с методов в ListOnLink.
 * По желанию можно добавить и другие свои методы.
 */
public class ListOnArray extends AbstractList<Integer> {

    /**
     * Массив, который будет хранить все значения.
     */
    private Integer[] arrObjects = new Integer[0];

    /**
     * Метод возвращает размер коллекции.
     */
    @Override
    public int size() {
        return arrObjects.length;
    }

    /**
     * Метод отвечает на вопрос "Коллекция пуста?".
     * Возращает true или false.
     */
    @Override
    public boolean isEmpty() {
        return (arrObjects.length == 0) ? true : false;
    }

    /**
     * Метод добавляющий значение типа Integer в конец коллекции.
     * Должно возращаться значение true;
     */
    @Override
    public boolean add(Integer newValue) {
        Integer[] newArray = new Integer[arrObjects.length + 1];
        for (int i = 0; i < arrObjects.length; i++) {
            newArray[i] = arrObjects[i];
        }
        newArray[arrObjects.length] = newValue;
        arrObjects = newArray;
        return true;
    }


    /**
     * Метод должен очищать коллекцию.
     * Она должна стать такой, какой была при вызове конструктора.
     */
    @Override
    public void clear() {
        arrObjects = new Integer[0];
    }


    /**
     * Метод возвращает значение (типа Integer) элемента коллекциия на позиции index.
     * Если по каким-либо причинам вернуть не получилось, метод возвращает null.
     */
    @Override
    public Integer get(int index) {
        if ((index >= 0) && (index < arrObjects.length)) {
            return arrObjects[index];
        }
        return null;
    }

    /**
     * Метод обновляет значение элемента массива на
     * позиции index на новое значение element.
     */
    @Override
    public Integer set(int index, Integer element) {
        return null;
    }

    /**
     * Метод производит удаление элемента находящегося на указанной позиции.
     * В случае успешного проведения операция метод возвращает 0.
     * В случае невозможности удаления метод должен вернуть -1.
     */
    @Override
    public Integer remove(int index) {
        if ((index > 0) & (index <= arrObjects.length)) {
            index--;
            Integer[] newArray = new Integer[arrObjects.length - 1];
            for (int i = 0; i <= newArray.length; i++) {
                if (i == index) {
                    continue;
                } else if (i < index) {
                    newArray[i] = arrObjects[i];
                } else {
                    newArray[i - 1] = arrObjects[i];
                }
            }
            arrObjects = newArray;
            return 0;
        }
        return -1;
    }

    /**
     * Метод возвращает номер позиции, на которой находится
     * элемент коллекции с заданным значением.
     * Если позиция отсутствует (не нашли в коллекции), должны вернуть -1.
     */
    @Override
    public int indexOf(Object o) {
        int i = (Integer) o;
        for (int j = 0; j < arrObjects.length; j++) {
            if (i == arrObjects[j]) {
                return j + 1;
            }
        }
        return -1;
    }

    /**
     * Собственный метод, который будете использовать
     * для отслеживания изменений состояния коллекции.
     */
    public void print() {
        int i = 0;
        if (arrObjects.length >= 1) {
            System.out.print(arrObjects[i]);
            i++;

            while (i < arrObjects.length) {
                System.out.print(", " + arrObjects[i]);
                i++;
            }
            System.out.println(".");
        }
    }
}
