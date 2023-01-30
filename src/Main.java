import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        int currentYear = LocalDate.now().getYear(); //определяю текущий год
        printYearType(currentYear);
        printYearType(2024);

        System.out.println();
        printRequest((byte) 1, 2015);
        printRequest((byte) 1, 2023);
        printRequest((byte) 0, 2022);
        printRequest((byte) 0, 2023);

        System.out.println();
        printDeliveryDays(101);
        printDeliveryDays(70);
        printDeliveryDays(30);
        printDeliveryDays(15);


    }

    //Задача 1
    //Реализуйте метод, который получает в качестве параметра год,
    //проверяет, является ли он високосным, и выводит результат в консоль.
    //Я бы написал метод возвращающий високосность, а вывод в консоль сделал бы по результатам вызова.
    //Но в задании просят вывод включить в метод. Так и делаю.
    public static void printYearType(int year) {
        //високосным является каждый четвертый год, но не является каждый сотый.
        //Также високосным является каждый четырехсотый год.
        boolean isLeap = (year % 4 == 0 && year % 100 != 0 || year % 400 == 0);
        System.out.println("Год " + year + (isLeap ? "" : " не") + " является високосным");
    }

    //Задача 2
    //Напишите метод, куда подаются два параметра:
    //тип операционной системы (0 — iOS, 1 — Android ) и год выпуска устройства.
    //Если устройство старше текущего года, предложите ему установить облегченную версию.
    //В результате программа должна выводить в консоль сообщение,
    //какую версию приложения (обычную или облегченную) и для какой ОС (Android или iOS) установить пользователю.
    public static void printRequest(byte os, int year) {
        int currentYear = LocalDate.now().getYear(); //определяю текущий год
        System.out.println("Установите " + (year < currentYear ? "" : "облегченную ") + "версию приложения " +
                "для " + (os == 0 ? "iOS " : "Android ") + "по ссылке");
    }

    //Задача 3
    //Доставка в пределах 20 км занимает сутки.
    //Доставка в пределах от 20 км до 60 км добавляет еще один день доставки.
    //Доставка в пределах от 60 км до 100 км добавляет еще одни сутки.
    //Свыше 100 км доставки нет.
    //Напишите программу, которая выдает сообщение в консоль: "Потребуется дней: " + срок доставки.
    //Ваша задача — доработать код, а именно написать метод, который на вход принимает дистанцию и возвращает итоговое количество дней доставки.
    public static int calculateDeliveryDays(int deliveryDistance) {
        if (deliveryDistance > 100) {
            return -1;
        }
        int days = 1;
        if (deliveryDistance > 20) {
            days += 1;
        }
        if (deliveryDistance > 60) {
            days += 1;
        }
        return days;
    }

    public static void printDeliveryDays(int deliveryDistance) {
        int deliveryDays = calculateDeliveryDays(deliveryDistance);
        if (deliveryDays == -1) {
            System.out.println("Для расстояния " + deliveryDistance + " км доставки нет");
        } else {
            System.out.println("Для расстояния " + deliveryDistance + " км потребуется дней: " + deliveryDays);
        }
    }
}