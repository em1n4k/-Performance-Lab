import java.io.File;
import java.math.BigDecimal;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class task2 {
    public static void main(String[] args) throws FileNotFoundException {

        // Первый аргумент - это файл эллипса, а второй - файл точек
        if (args.length != 2) {
            System.err.println("Пожалуйста укажите пути к двум файлам");
            return;
        }

        // Смотрим центр и полуоси эллипса
        Scanner ellipse = new Scanner(new File(args[0]));

        BigDecimal centerX = new BigDecimal(ellipse.next());
        BigDecimal centerY = new BigDecimal(ellipse.next());
        BigDecimal a = new BigDecimal(ellipse.next());
        BigDecimal b = new BigDecimal(ellipse.next());

        ellipse.close();

        // Условие на проверку положительных значений полуосей
        if (a.signum() <= 0 || b.signum() <= 0) {
            System.err.println("Полуоси должны быть положительными!");
            return;
        }

        // Квадраты полуосей
        BigDecimal aSquared = a.multiply(a);
        BigDecimal bSquared = b.multiply(b);

        BigDecimal right = aSquared.multiply(bSquared);

        // Чтение точек из второго файла
        Scanner points = new Scanner (new File(args[1]));

        while (points.hasNext()) {
            BigDecimal x = new BigDecimal(points.next());
            BigDecimal y = new BigDecimal(points.next());

            // Смещение точки относительно центра
            BigDecimal dx = x.subtract(centerX);
            BigDecimal dy = y.subtract(centerY);

            BigDecimal first = dx.multiply(dx).multiply(bSquared);
            BigDecimal second = dy.multiply(dy).multiply(aSquared);
            BigDecimal left = first.add(second);

            int comparison = left.compareTo(right);

            if (comparison == 0) {
                System.out.println(0);
            } else if (comparison < 0) {
                System.out.println(1);
            } else {
                System.out.println(2);
            }
        }

        points.close();
    }
}