

public class task1{

    public static void main(String[] args) {

        // Условие на проверку верного диапазона чисел для массивов
        if (args.length != 4) {
            System.err.println("Пожалуйста введите четыре числа по условию: n1 m1 n2 m2");
            return;
        }

        int n1 = Integer.parseInt(args[0]);
        int m1 = Integer.parseInt(args[1]);
        int n2 = Integer.parseInt(args[2]);
        int m2 = Integer.parseInt(args[3]);

        // Условие на проверку положительных чисел
        if (n1 <= 0 || n2 <= 0 || m1 <= 0 || m2 <= 0) {
            System.err.println("Все числа должны быть положительными!");
            return;
        }

        // Переменна изначальной позиции к которой должны вернуться в конце круга
        long position = 0;

        // Круг по первому массиву
        do {
            System.out.print(position + 1);
            position = (position + m1 - 1) % n1;
        } while (position != 0);

        // Круг по второму массиву
        do {
            System.out.print(position + 1);
            position = (position + m2 - 1) % n2;
        } while (position != 0);

        System.out.println();
    }
}