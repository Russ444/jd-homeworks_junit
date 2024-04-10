import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PasswordChecker passwordChecker = new PasswordChecker();
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Введите минимальную длину пароля: ");
            int minLength = scanner.nextInt();
            passwordChecker.setMinLength(minLength);

            System.out.print("Введите максимальное число повтроений одного символа подряд в пароле : ");
            int maxRepeats = scanner.nextInt();
            passwordChecker.setMaxRepeats(maxRepeats);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
            return;
        }

        scanner.nextLine();

        while (true) {
            System.out.print("Введите пароль или end для завершения работы программы: ");
            String password = scanner.nextLine();

            if (password.equals("end")) {
                break;
            }

            boolean validPasswd = false;

            try {
                validPasswd = passwordChecker.verify(password);
            } catch (IllegalStateException e) {
                System.out.print("Ошибка: " + e.getMessage());
                return;
            }

            if (validPasswd) {
                System.out.println("Пароль прошел проверку!");
            } else {
                System.out.println("Пароль не подходит!");
            }
        }

        System.out.println("Работа программы завершена!");
    }
}