package myCollections;

import java.lang.reflect.Array;
import java.util.AbstractList;

/**
 * Разрабатываемая коллекция основана на использовании массива.
 * Она будет хранить целочисленные значения типа int.
 * <p>
 * Необходимо реализовать все приведённые здесь методы.
 * Реализуйте метод print() по аналогии с методов в ListOnLink.
 * По желанию можно добавить и другие свои методы.
 */
public class ListOnArray<T> extends AbstractList {

    /**
     * Массив, который будет хранить все значения.
     */
    private T[] arrObjects; // =    Array.newInstance(T,0);
    private int size = 0;

    private void initArray(Class cl, int len) {
        arrObjects = (T[]) Array.newInstance(cl, len);
    }

    /**
     * Метод возвращает размер коллекции.
     */
    @Override
    public int size() {
        return size;
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
    public boolean add(T element) {
        if (arrObjects == null) {
            size = 0;
            initArray(arrObjects.getClass(), size);
        }
        size++;
        T[] newArray = (T[]) Array.newInstance(arrObjects.getClass(), size);
        for (int i = 0; i < size; i++) {
            newArray[i] = arrObjects[i];
        }
        newArray[size] = element;
        arrObjects = newArray;
        return true;
    }


    /**
     * Метод должен очищать коллекцию.
     * Она должна стать такой, какой была при вызове конструктора.
     */
    @Override
    public void clear() {
        size = 0;
        arrObjects = (T[]) Array.newInstance(arrObjects.getClass(), size);
    }


    /**
     * Метод возвращает значение (типа Integer) элемента коллекциия на позиции index.
     * Если по каким-либо причинам вернуть не получилось, метод возвращает null.
     */
    @Override
    public T get(int index) {
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
    public T set(int index, T element) {
        if ((index > 0) && (index <= size)) {
            arrObjects[index - 1] = element;
            return element;
        }
        return null;
    }

    /**
     * Метод производит удаление элемента находящегося на указанной позиции.
     * В случае успешного проведения операция метод возвращает 0.
     * В случае невозможности удаления метод должен вернуть -1.
     */
    @Override
    public T remove(int index) {
        if ((index > 0) & (index <= arrObjects.length)) {
            index--;
            size--;
            T[] newArray = (T[]) Array.newInstance(arrObjects.getClass(), size);
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
            return arrObjects[index];
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
//        int i = (Integer) o;
        for (int j = 0; j < arrObjects.length; j++) {
            if (o.equals(arrObjects[j])) {
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
