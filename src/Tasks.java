import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Tasks {

    List<Integer> arrayX = new ArrayList<>();
    List<Integer> arrayS = new ArrayList<>();
    List<Integer> arrayM = new ArrayList<>();
    List<Integer> initialize = new ArrayList<>();
    List<Integer> otherNumbers = new ArrayList<>();
    List<Integer> mergeList = new ArrayList<>();
    Integer[] list;
    boolean exit = true;
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void Start(){

        try {
            System.out.println("Выберите тип заполнение массива числами:\n" +
                    " 1 - Заполнить массив самостоятельно\n" +
                    " 2 - Автозаполнение массива");
            switch (Integer.parseInt(reader.readLine())){
                case 1:
                    System.out.println("Сколько чисел должно быть в массиве? Введите колличество:");
                    int listLength = Integer.parseInt(reader.readLine());
                    list = new Integer[listLength];
                    System.out.println("Введите числа:");
                    for (int i = 0; i < list.length; i++) {
                        list[i] = Integer.parseInt(reader.readLine());
                    }
                    break;
                case 2:
                    Random random = new Random();
                    list = new Integer[30];
                    for (int i = 0; i < list.length; i++) {
                        list[i] = random.nextInt(1000) + 1;
                    }
            }
        }catch (IOException e) {
            System.out.println("Ошибка : Некорректный ввод");
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: Введите число соответствующее пункту");
        }

        Arrays.sort(list);
        System.out.println("Массив содержит данные числа:");
        for (int i = 0; i < list.length ; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < list.length; i++) {
            if (list[i]%3 == 0){
                arrayX.add(list[i]);
            }
            if (list[i]%7 == 0){
                arrayS.add(list[i]);
            }
            if (list[i]%21 == 0){
                arrayM.add(list[i]);
            }
            if (list[i]%3 != 0 && list[i]%7 != 0 && list[i]%21 != 0){
                otherNumbers.add(list[i]);
            }
        }
        while (exit) {
            try {
                System.out.println("=========================================================================");
                System.out.println("Выберите нужную операцию \n" +
                        " 1 - initArray \n" +
                        " 2 - print \n" +
                        " 3 - printType \n" +
                        " 4 - anyMore \n" +
                        " 5 - clearType \n" +
                        " 6 - merge \n" +
                        " 7 - help \n" +
                        " 0 - выход из программы");
                switch (Integer.parseInt(reader.readLine())) {
                    case 1:
                        System.out.println("Инициализация массива:");
                        initArray();
                        break;
                    case 2:
                        System.out.println("Вывод всех списков:");
                        print();
                        break;
                    case 3:
                        System.out.println("Типизированный вывод:");
                        printType();
                        break;
                    case 4:
                        System.out.println("Вывод чисел не вошедших в списки:");
                        anyMore();
                        break;
                    case 5:
                        System.out.println("Слияние и очистка списков:");
                        clearType();
                        break;
                    case 6:
                        System.out.println("Слияние всех списков в один и очистка всех списков:");
                        merge();
                        break;
                    case 7:
                        System.out.println("Справка по командам:");
                        help();
                        break;
                    case 0:
                        System.out.println("Вы вышли из программы");
                        exit = false;
                }
            } catch (IOException e) {
                System.out.println("Ошибка : Некорректный ввод");
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: Введите число соответствующее пункту");
            }
        }
    }
    public void initArray(){
        Collections.addAll(initialize, list);
        for (int i = 0; i < initialize.size(); i++) {
            System.out.print(initialize.get(i) + " ");
        }
        System.out.println();
    }

    public void print(){
        System.out.println("\nчисла которые можно поделить без остатка на 3:");
        if (arrayX.isEmpty())
            System.out.print("Этот список пуст");
        else
        for (int j = 0; j < arrayX.size(); j++) {
            System.out.print(arrayX.get(j) + " ");
        }
        System.out.println("\nчисла которые можно поделить без остатка на 7:");
        if (arrayS.isEmpty())
            System.out.print("Этот список пуст");
        else
        for (int j = 0; j < arrayS.size(); j++) {
            System.out.print(arrayS.get(j) + " ");
        }
        System.out.println("\nчисла которые можно поделить без остатка на 21:");
        if (arrayM.isEmpty())
            System.out.print("Этот список пуст");
        else
        for (int j = 0; j < arrayM.size(); j++) {
            System.out.print(arrayM.get(j) + " ");
        }
        System.out.println();
    }
    public void printType(){
        try {
            List temp;
            System.out.println("Выберите список: \n" +
                    " 1 - числа которые можно поделить без остатка на 3 \n" +
                    " 2 - числа которые можно поделить без остатка на 7 \n" +
                    " 3 - числа которые можно поделить без остатка на 21");
            switch (Integer.parseInt(reader.readLine())) {
                case 1:
                    temp = arrayX;
                    break;
                case 2:
                    temp = arrayS;
                    break;
                case 3:
                    temp = arrayM;
                    break;
                default:
                    return;
            }

            for (int i = 0; i < temp.size(); i++) {
                System.out.print(temp.get(i) + " ");
            }
            System.out.println();
        }catch (IOException e){
            System.out.println("Ошибка : Некорректный ввод");
        }catch (NumberFormatException e){
            System.out.println("Ошибка: Введите число соответствующее пункту");
        }
    }
    public void anyMore(){
        for (int i = 0; i < otherNumbers.size(); i++) {
            System.out.print(otherNumbers.get(i) + " ");
        }
        System.out.println();
    }
    public void clearType(){
        try {
            List temp;
            System.out.println("Выбирите список для удаления: \n" +
                    " 1 - очистить список с числами которые можно поделить без остатка на 3 \n" +
                    " 2 - очистить список с числами которые можно поделить без остатка на 7 \n" +
                    " 3 - очистить список с числами которые можно поделить без остатка на 21");
            switch (Integer.parseInt(reader.readLine())) {
                case 1:
                    temp = arrayX;
                    arrayX.clear();
                    break;
                case 2:
                    temp = arrayS;
                    arrayS.clear();
                    break;
                case 3:
                    temp = arrayM;
                    arrayM.clear();
                    break;
                default:
                    return;
            }
            for (int i = 0; i < temp.size(); i++) {
                System.out.print(temp.get(i) + " ");
            }
            System.out.println();
        }catch (IOException e){
            System.out.println("Ошибка : Некорректный ввод");
        }catch (NumberFormatException e){
            System.out.println("Ошибка: Введите число соответствующее пункту");
        }
    }
    public void merge(){
        mergeList.addAll(arrayX);
        mergeList.addAll(arrayS);
        mergeList.addAll(arrayM);
        for (int i = 0; i < mergeList.size(); i++) {
            System.out.print(mergeList.get(i) + " ");
        }
        System.out.println();
        arrayX.clear();
        arrayS.clear();
        arrayM.clear();
    }
    public void help(){
        System.out.println(
                "init array\t- инициализация списков набором значений array\n" +
                "print \t\t- печать всех списков \n" +
                "print type \t- печать конкретного списка, где type принимает значения X,S,M\n" +
                "anyMore\t\t- выводит на экран были ли значения не вошедшие ни в один список \n" +
                "clear type\t- чистка списка , где type принимает значения X,S,M\n" +
                "merge\t\t- слить все списки в один вывести на экран и очистить все списки");
    }

}
