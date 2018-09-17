package ru.mapkn3.BullCowGame.util;

import java.util.Random;

/**
 * Класс игры "Быки-коровы"
 *
 * @author Mapkn3
 */
public class BullCowGame {
    private String secretNumber;

    /**
     * Конструктор по умолчанию
     *
     * @author Mapkn3
     */
    public BullCowGame() {
        secretNumber = generateSecretNumber(4);
    }

    /**
     * Получение секретного загаданного числа
     *
     * @return загаданное число в виде строки ({@link String})
     * @author Mapkn3
     */
    public String getSecretNumber() {
        return secretNumber;
    }

    /**
     * Генерация секретного числа заданной длины (от 1 до 10 символов), цифры которого не повторяются
     *
     * @param length - длина требуемого секретного числа,
     *               если значение меньше 1, то устанавливается значение 1,
     *               если значение больше 10, то устанавливается значение 10
     * @return секретного число в виде строки ({@link String})
     * @author Mapkn3
     */
    public String generateSecretNumber(int length) {
        int n = length;
        n = n < 1 ? 1 : n;
        n = n > 10 ? 10 : n;
        StringBuilder sb = new StringBuilder();
        new Random().ints(n * 3, 0, 10)
                .distinct()
                .limit(n)
                .forEach(sb::append);
        return sb.toString();
    }

    /**
     * Проверка числа от пользователя на соответствие загаданному числу
     *
     * @param number - число - предположение пользователя
     * @return строка вида {@code dБdК}, где {@code d} - цифра от 0 до 9, результат попытки пользователя, сформированный согласно правилам игры
     * @author Mapkn3
     */
    public String compareNumber(String number) {
        int bull = 0;
        int cow = 0;
        for (int i = 0; i < secretNumber.length(); i++) {
            if (number.charAt(i) == secretNumber.charAt(i)) {
                bull++;
            } else if (secretNumber.indexOf(number.charAt(i)) != -1) {
                cow++;
            }
        }
        return String.format("%dБ%dК", bull, cow);
    }
}
