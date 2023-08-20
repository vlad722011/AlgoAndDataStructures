package Seminar_4.RedBlackTree;

import java.util.*;

/*
  Класс для проведения теста реализованной структуры данных.
  Запускает в цикле вставку элемента, проверку на содержание элемента в дереве
 и удаление элемента из дерева произвольное количество раз.
 */
public class main {

    /*
      Максимальное число генерирумое для вставки, поиска и удаления
      элемента дерева.
     */
    private final static int MAX_NUMBER = 25;
    /*
      Количество тестовых циклов.
     */
    private final static int TESTS_AMONT = 3;
    /*
      Максимольное количество элементов, генерируемое для вставки,
      поиска и удаления элемента дерева.
     */
    private final static int MAX_ELEMENTS = 15;
    private static Random rand = new Random();

    public static void main(String[] args) {

        RedBlackTree<Integer> rbt;
        int testInsertElementsAmount;
        int testContainElementsAmount;
        int testDeleteElementsAmount;

        Integer num;

        for(int i = 0; i < TESTS_AMONT; i++) {
            try {
                System.out.println("\n\nStart test #" + i);

                rbt = new RedBlackTree<Integer>();

                testInsertElementsAmount = rand.nextInt(MAX_ELEMENTS - 1) + 1;
                testContainElementsAmount  = rand.nextInt(MAX_ELEMENTS / 2) + 1;
                testDeleteElementsAmount = rand.nextInt(MAX_ELEMENTS - 1) + 1;

                System.out.println(" Insertion [" + testInsertElementsAmount + "]:");
                for(int j = 0; j < testInsertElementsAmount; j++) {

                    num = new Integer(rand.nextInt(MAX_NUMBER));
                    System.out.println("  Insert " + num + " into tree");
                    rbt.add(num);
                }
                System.out.println("Tree:");

                RedBlackTree.printTree((RedBlackTree<Integer>)rbt);

                System.out.println(" Contains [" + testContainElementsAmount + "]:");
                for(int j = 0; j < testContainElementsAmount; j++) {

                    num = new Integer(rand.nextInt(MAX_NUMBER));
                    System.out.println("  Is " + num + " contain in tree? It's " + rbt.contains(num));
                }

                System.out.println(" Deletion [" + testDeleteElementsAmount + "]:");
                for(int j = 0; j < testDeleteElementsAmount; j++) {

                    num = new Integer(rand.nextInt(MAX_NUMBER));
                    System.out.println("  Is " + num + " delete from tree? It's " + rbt.remove(num));
                }
                System.out.println("Tree:");

                RedBlackTree.printTree((RedBlackTree<Integer>)rbt);
            }
            catch(Exception e) {
                System.out.println("Got error: " + e.getMessage());
            }
        }
        System.out.println("\nRBT testing is over!\n\n");

        rbt = new RedBlackTree<Integer>();
        Iterator<Integer> it = rbt.iterator();
        System.out.println(it.hasNext());

        rbt.add(new Integer(11));
        rbt.add(new Integer(27));
        rbt.add(new Integer(28));
        rbt.add(new Integer(29));
        rbt.add(new Integer(30));
        rbt.add(new Integer(31));
        rbt.add(new Integer(123));

        RedBlackTree.printTree(rbt);
        System.out.println(it.hasNext());
        Integer number;
        try {
            number = it.next();
            System.out.println(number + ", has next: " + it.hasNext());
            number = it.next();
            System.out.println(number + ", has next: " + it.hasNext());
            number = it.next();
            System.out.println(number + ", has next: " + it.hasNext());
            number = it.next();
            System.out.println(number + ", has next: " + it.hasNext());
            it.remove();
            RedBlackTree.printTree(rbt);
            System.out.println("after remove " + number + ", has next: " + it.hasNext());
            number = it.next();
            System.out.println(number + ", has next: " + it.hasNext());
            it.remove();
            RedBlackTree.printTree(rbt);
            System.out.println("after remove " + number + ", has next: " + it.hasNext());
            System.out.println("tree elements:");
            it = rbt.iterator();
            while(it.hasNext()) {
                System.out.print(it.next() + " ");
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("\n\nRBT.iterator testing is over!\n\n");
    }
}
