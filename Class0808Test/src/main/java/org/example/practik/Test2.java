package org.example.practik;
// Java Stream API:
// Посчитать количество слов в предложении
// Найти сумму четных чисел в коллекции
// Разделить четные и нечетные числа на два списка

// Работа с файлами?

// Дизайн ООП
//
// Спроектировать список, в который можно добавить до N элементов и который поддерживает их сумму. Если добавить
// больше элементов, то они игнорируются.
// Методы add/size/remove(index)/sum()

import org.junit.jupiter.api.Test;

// Написать калькулятор, который принимает два числа и операцию из входного потока и
// выводит результат на экран. Протестировать.
public class Test2 {
    //    public static void main(String[] args) {
//
//    }
    private Number[] numbers;
    private Integer capacity;
    private int size = 0;

    public Test2(Integer capasity) {
        this.numbers = new Number[capasity];
        this.capacity = capasity;
    }

    public Test2(Number[] numbers, Integer capacity, int size) {
        this.numbers = numbers;
        this.capacity = capacity;
        this.size = size;
    }

    public Number[] getNumbers() {
        return numbers;
    }

    public void add(Number number) {
        numbers[size] = number;
        size++;
    }

    public Number remove(int index) {
        Number res = numbers[index];
        numbers[index] = null;
        //   leftShift(index);
        //    size--;
        System.arraycopy(numbers, index + 1, numbers, index, capacity - size--);
        return res;
    }


    private void leftShift(int index) {
        if (numbers[index + 1] == null) {
            return;
        }
    }
}
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
//
//public class NumberListTest {
//
//    @Test
//    public void testRemove() {
//        NumberList numberList = new NumberList();
//
//        // Заполняем список
//        numberList.add(10);
//        numberList.add(20);
//        numberList.add(30);
//
//        // Удаляем элемент по индексу 1 (значение 20)
//        Number removedNumber = numberList.remove(1);
//
//        // Проверяем, что возвращено правильное значение
//        assertEquals(20, removedNumber);
//
//        // Проверяем, что размер списка уменьшился
//        assertEquals(2, numberList.size());
//
//        // Проверяем, что элементы сдвинулись налево
//        assertEquals(10, numberList.get(0));
//        assertEquals(30, numberList.get(1));
//    }
//}
//@Test
//    void removeNegativeCase() {
//        Assertions.assertThrows(IllegalArgumentException.class, () -> myNumberList.remove(-1));
//    }
//public Number remove(int index) {
//        if (index < 0 || index > size - 1) {
//            throw new IllegalArgumentException();
//        }
//        Number result = numbers[index];
//        numbers[index] = null;
//        System.arraycopy(numbers, index + 1, numbers, index, capacity - size--);
//        return result;
//    }

//@Test
//    void removeSizeEqualsTest() {
//        myNumberList.remove(3);
//        long size = Arrays.stream(myNumberList.getNumbers())
//                .filter(Objects::nonNull)
//                .count();
//        Assertions.assertEquals(4, size);
//    }
//
//    @Test
//    void removeNegativeCaseSubZeroTest() {
//        Assertions.assertThrows(IllegalArgumentException.class, () -> myNumberList.remove(-1));
//    }
//
//    @Test
//    void removeNegativeCaseAboveSizeTest() {
//        Assertions.assertThrows(IllegalArgumentException.class, () -> myNumberList.remove(7));
//    }
//
//    @Test
//    void removeReturnNumberTest() {
//        Assertions.assertEquals(4, myNumberList.remove(3));
//    }
//
//    @Test
//    void sum() {
//        Assertions.assertEquals(15, myNumberList.sum());
//    }
//
//    @Test
//    void size() {
//        Assertions.assertEquals(5, myNumberList.size());
//    }