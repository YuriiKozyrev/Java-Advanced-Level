package Lesson2.HW;


class ArrayCheck {
    public static int arrayCheckMethod(String stringArray[][]){

        // Проверка двумерного массива на соответсвие размеру 4*4
        int criticalLength = 4;
        int i;

        try {
            for (i = 0; i < stringArray.length; i++) {
                if (stringArray[i].length != criticalLength) {
                    throw new MyArraySizeException("Двумерный массив не соответствует размеру 4 * 4!");
                }
            }
            if (i != criticalLength) throw new MyArraySizeException("Двумерный массив не соответствует размеру 4 * 4!");

        } catch (MyArraySizeException exc1) {
            exc1.printStackTrace();
        }

        // Далее метод преобразует элементы массива в Int и суммирует их,
        // если в какой-то ячейке лежат неверные данные,
        // то кидает исключение MyArrayDataException с детализацией проблемной ячейки
        int sum = 0;
        int i1, i2;

        for (i1 = 0; i1 < stringArray.length; i1++) {
            String[] x = stringArray[i1];

            for (i2 = 0; i2 < x.length; i2++) {
                String y = x[i2];
                //System.out.println("y: " + y + "  и y length: " + y.length());

                try {
                    for (i = 0; i < y.length(); i++) {
                        if (!Character.isDigit(y.charAt(i))) {
                            throw new MyArrayDataException("В числовом массиве обнаружено не число по адресу:  строка - " +
                                    (i1 + 1) + " столбец - " + (i2 + 1) + " содержимое: " + y);
                        }
                    }
                    sum += Integer.parseInt(y);

                }catch (MyArrayDataException exc2) {
                    exc2.printStackTrace();
                }
            }
        }
        return sum;
    }
}

public class MainClass {
    public static void main(String[] args) {

        String stringArray[][] = {
                {"00", "7", "2", "2"},
                {"11", "12", "7", "14"},
                {"aa", "22", "23", "24"},
                {"31", "6", "bb", "100", "111"},
                {"31", "32", "3ссмсм", "34"}
        };

        System.out.println("Cумма цифровых элементов массива: " + ArrayCheck.arrayCheckMethod(stringArray));
    }
}
