import java.util.*;

public class Main {

    public static void main(String[] args){
        //Задача 1
        System.out.println("Задача 1");
        System.out.println(checkStr("Hello World"));
        System.out.println();

        //Задача 2
        System.out.println("Задача 2");
        runTask2();
    }


    //Задача 1
    static boolean checkStr(String s) {
        if(s.equals("Hello World")){
            return true;
        } else{
            return false;
        }
    }


    //Задача 2
    static void runTask2(){

        //оригинальный массив;
        int[] array = {31, 30, 34, 34, 18, 25, 16, 8, 27};

        //получить минимальную разница между ближайшими числами;
        int[] nearestNumber = getNearestNumbers(array);

        //получить количество элементов между ближайшими числами;
        int getCountNumbers = getCountNumbers(nearestNumber[0],nearestNumber[1],array);
    }

    public static int[] getNearestNumbers(int[] array){
        int a = 0;
        int b=0;
        int min = Integer.MAX_VALUE;
        //копируем массив;
        int[] arraySort = Arrays.copyOf(array, array.length);
        //сортируем новый массив;
        Arrays.sort(arraySort);
        System.out.println(Arrays.toString(array));
        System.out.print("Минимальная разница между близстоящими значениями массива: ");
        try{
            for (int i = 0; i < arraySort.length; i++) {
                //в условии я исключаю одинаковые числа, так как они не являются близстоящими
                if ((arraySort[i + 1] - arraySort[i]) < min && (arraySort[i + 1] - arraySort[i])!=0) {
                    min = arraySort[i + 1] - arraySort[i];
                    b=arraySort[i+1];
                    a=arraySort[i];
                }
            }
        }catch (Exception e){}
        System.out.println(min + " ");
        return new int[]{a, b};
    }

    public static int getCountNumbers(int a, int b, int[]array){
        int indexA=0;
        int indexB=0;
        int amount;
        //находим индексы близстоящих значений;
        for(int i = 0; i<array.length; i++){
            if(array[i]==a){
                indexA = i;
            } else if(array[i]==b){
                indexB = i;
            }
        }
        //определяем колличество эллементов между близстоящими числами;
        amount = indexB-indexA;
        if(amount<0){
            amount=amount*(-1)-1;
        } else{
            amount=amount-1;
        }
        System.out.println("Количество элементов в массиве между a и b: " + amount);
        return amount;
    }
}
//Ответы на вопросы:
//        1.	Какое назначение у метода public static void main в Java?
//        Метод main входная точка программы. Все существующие реализации Java-интерпретаторов, получив команду
//        интерпретировать класс, начинают свою работу с вызова метода main. Java-транслятор может оттранслировать класс,
//        в котором нет метода main. А вот Java-интерпретатор запускать классы без метода main не умеет.
//
//        2.	Назовите разницу между System.out.println и System.err.println.
//        System.out.println – это стандартный вывод.
//        System.err.println помогает нам специально отображать сообщение как ошибку. Мы можем использовать приведенный
//        выше фрагмент кода, чтобы показать сообщение об ошибке как: System.err.println («Обнаружено исключение!»);
//
//        3.	Что такое Интерфейс (interface)?
//        Интерфейс — это абстрактный класс, у которого ни один метод не реализован, все они публичные и нет переменных
//        класса. Интерфейс нужен когда описывается только интерфейс. Например, один класс хочет дать другому возможность
//        доступа к некоторым своим методам, но не хочет себя «раскрывать». Поэтому он просто реализует интерфейс.
//        Таким образом, абстрактный метод определяет интерфейс, но не реализацию метода.
//
//        4.	Когда стоит использовать абстрактный класс вместо Интерфейса (interface)?
//        Абстрактный класс нужен, когда нужно семейство классов, у которых есть много общего. Можно применить и интерфейс,
//        но тогда нужно будет писать много идентичного кода.
//
//        5.	Назовите разницу между public методом и protected методом.
//        public означает, что метод виден и доступен любому классу, а protected означает, что метод виден в пределах
//        всех классов, находящихся в том же пакете, что и наш, а также в пределах всех классов-наследников нашего класса.
//
//        6.	Что такое static переменная?
//        Переменные static, по существу, являются глобальными переменными. При объявлении объектов, копии статических
//        переменных не создаются - создается одна статическая переменная на весь класс. Статическая переменная создается
//        при загрузке класса.
//
//        7.	Что такое исключения (Exception)?
//        Исключение - это ошибка, возникающая в процессе выполнения программы.
//
//        8.	Является ли хорошей практикой или нет перехват RuntimeException?
//        Я считаю, что перехват RuntimeException плохая практика, потому что это означает, что Вы понимаете каждую
//        ситуацию, которая может пойти не так, и вы можете продолжать, несмотря ни на что, а ведь иногда возникают
//        действительно катастрофические ошибки. К таким исключениям относится, например, NullPointerException.
//
//        9.	Какое ключевое слово следует использовать в сигнатуре метода, чтобы исключить перехват исключения в этом
//        методе?
//        Иногда исключения нецелесообразно обрабатывать в том методе, в котором они возникают. В таком случае их следует
//        указывать с помощью ключевого слова throws.
//
//        10.	Назовите последнюю версию Java.
//        Релизная версия Java 14 вышла 17 марта 2020.
//
//        11.	Какое значение у сборщика мусора (garbage collector)?
//        Garbage Collection избавляет разработчиков от необходимости заботиться об освобождении управляемой памяти.
//
//        12.	Назовите разницу между HashSet и TreeSet.
//        1)	HashSet хранит объекты в случайном порядке, тогда как TreeSet применяет естественный порядок элементов.
//        2)	HashSet может хранить null объекты, тогда как TreeSet нет.
//        3)	HashSet быстрее, чем TreeSet
//        4)	TreeSet богат функциональными возможностями, поэтому проще и мощнее HashSet.
//
//        13.	Какой метод типа Thread вызывается при запуске потока?
//        Для запуска потока вызывается метод start.
//
//        14.	Можно ли обновить объект String (без использования интроспекции)?
//        Объект String нельзя обновить, так как он неизменяемый.
//
//        15.	Каков механизм взаимодействия между методами equals и hashcode?
//        Если хэш-код объекта не совпадает с хэш-кодом другого объекта, то можно не выполнять метод equals(): мы просто
//        знаем, что два объекта не совпадают. С другой стороны, если хэш-код одинаковый то, необходимо выполнить метод
//        equals(), чтобы определить, совпадают ли значения полей.
//
//        16.	Кто такой James Gosling?
//        James Gosling автор объектно-ориентированного и кросс-платформенного языка программирования Java. Кроме того,
//        является создателем оконной системы NeWS, Gosling Emacs, а также был одним из разработчиков Star Seven.

