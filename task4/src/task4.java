import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class task4 {
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length != 1) {
            System.err.println("Укажите путь к файлу с числами");
            return;
        }

        ArrayList<Integer> numbers = new ArrayList<>();
        Scanner scanner = new Scanner(new File(args[0]));

        while (scanner.hasNext()) {
            numbers.add(scanner.nextInt());
        }

        scanner.close();

        if (numbers.isEmpty()) {
            System.err.println("Файл не должен быть пустым");
            return;
        }

        Collections.sort(numbers);
        int median = numbers.get(numbers.size() / 2);

        long moves = 0;

        for (int number : numbers) {
            moves += Math.abs((long) number - median);

            if (moves > 20) {
                System.out.println(
                        "20 ходов недостаточно для приведения всех элементов массива к одному числу"
                );
                return;
            }
        }

        System.out.println(moves);
    }
}