import myCollections.ListOnArray;
import myCollections.ListOnLink;

public class AppStart {
    /**
     * Пускай мы будем нумеровать элементы списков с 1.
     * <p>
     * Пример:
     * Метод get(0) будет возвращать -1, а get(1) - значение первого добавленного элемента.
     * Метод indexOf(первое_добавленное_значение) будет возвращать 1.
     */
    public static ListOnArray arrayList;
    public static ListOnLink linkedList;

    public static void main(String[] args) {


        /**
         * Реализованные списки.
         */
        arrayList = new ListOnArray();
        linkedList = new ListOnLink();

        System.out.println("Списки инициализированы");
        getInfoAboutLists();

        /**
         * Наполнение списков и вывод информации о них
         */
        for (int i = 0; i < 10; i++) {
            arrayList.add(i * 23 + 6);
            linkedList.add((i + 1) * (i + 1) + 2);
        }

        System.out.println("\n\nСписки заполнены");
        getInfoAboutLists();

        System.out.println("\nМетоды get()");
        System.out.println(arrayList.get(1));   // 6
        System.out.println(linkedList.get(1));  // 3
        System.out.println(arrayList.get(8));   // 167
        System.out.println(linkedList.get(8));  // 66
        System.out.println(arrayList.get(888)); // null
        System.out.println(linkedList.get(-8)); // null


        System.out.println("\nМетоды indexOf()");
        System.out.println(arrayList.indexOf(new Integer(121))); // 6
        System.out.println(linkedList.indexOf(new Integer(38))); // 6

        System.out.println("\nМетоды remove()");
        System.out.println(arrayList.remove(4)); // 0
        System.out.println(linkedList.remove(4)); // 0
        System.out.println(arrayList.remove(-5)); // -1
        System.out.println(linkedList.remove(444)); // -1
        getInfoAboutLists();


        System.out.println("\nМетоды equals()\n----");
        System.out.println("arrayList.hashCode(): " + arrayList.hashCode());
        System.out.println("arrayList.equals(arrayList): " + arrayList.equals(arrayList));
        System.out.println("arrayList.equals(null): " + arrayList.equals(null));
        System.out.println("arrayList.equals(new ListOnArray()): " + arrayList.equals(new ListOnArray()));
        System.out.println("----");
        System.out.println("linkedList.hashCode(): " + linkedList.hashCode());
        System.out.println("linkedList.equals(linkedList): " + linkedList.equals(linkedList));
        System.out.println("linkedList.equals(null): " + linkedList.equals(null));
        System.out.println("linkedList.equals(new ListOnLink()): " + linkedList.equals(new ListOnLink()));
        System.out.println("----");
        System.out.println("linkedList.equals(arrayList): " + linkedList.equals(arrayList));


        System.out.println("\nМетоды clear()");
        arrayList.clear();
        linkedList.clear();
        getInfoAboutLists();

    }

    /**
     * Метод выводит всю информацию о наших списках.
     */
    public static void getInfoAboutLists() {
        System.out.println("-----\narrayList:");
        System.out.println("Is empty: " + arrayList.isEmpty());
        System.out.println("Size: " + arrayList.size());
        arrayList.print();

        System.out.println("-----\nlinkedList:");
        System.out.println("Is empty: " + linkedList.isEmpty());
        System.out.println("Size: " + linkedList.size());
        linkedList.print();
    }
}
