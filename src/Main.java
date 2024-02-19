import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static String[] rome = new String[] {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};

    public static void main(String[] args) {

        String input = null;

        System.out.println("Введите пример (в одну строку например: '1+2' ) " +
                "используя (только целые) числа от 1 до 10, только арабскими или только римскими цифрами ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            input = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        input = calc(input);
        System.out.println(input);
    }

    public static String calc(String input){
        int romeNum = 0;
        int oneNum = 0;
        int twoNum = 0;
        if (input.contains("+")) {
            String[] res = input.split("\\+");
            if (res.length > 2) {
                throw new RuntimeException("Ввведите корректный пример");
            }
            for (String s : rome) {
                for (String re : res) {
                    if (re.equals(s)) {
                        romeNum++;
                    }
                }
            }
            if (romeNum > 0 && romeNum < 3) {
                oneNum = changeRome(res[0].trim());
                twoNum = changeRome(res[1].trim());
            } else {
                oneNum = Integer.parseInt(res[0].trim());
                twoNum = Integer.parseInt(res[1].trim());
            }
            return String.valueOf(plus(oneNum, twoNum));
        } else if (input.contains("-")) {
            String[] res = input.split("-");
            if (res.length > 2) {
                throw new RuntimeException("Ввведите корректный пример");
            }
            for (String s : rome) {
                for (String re : res) {
                    if (re.equals(s)) {
                        romeNum++;
                    }
                }
            }
            if (romeNum > 0 && romeNum < 3) {
                oneNum = changeRome(res[0].trim());
                twoNum = changeRome(res[1].trim());
            } else {
                oneNum = Integer.parseInt(res[0].trim());
                twoNum = Integer.parseInt(res[1].trim());
            }
            return String.valueOf(minus(oneNum, twoNum));
        } else if (input.contains("/")) {
            String[] res = input.split("/");
            if (res.length > 2) {
                throw new RuntimeException("Ввведите корректный пример");
            }
            for (String s : rome) {
                for (String re : res) {
                    if (re.equals(s)) {
                        romeNum++;
                    }
                }
            }
            if (romeNum > 0 && romeNum < 3) {
                oneNum = changeRome(res[0].trim());
                twoNum = changeRome(res[1].trim());
            } else {
                oneNum = Integer.parseInt(res[0].trim());
                twoNum = Integer.parseInt(res[1].trim());
            }
            return String.valueOf(div(oneNum, twoNum));
        } else if (input.contains("*")) {
            String[] res = input.split("\\*");
            if (res.length > 2) {
                throw new RuntimeException("Ввведите корректный пример");
            }
            for (String s : rome) {
                for (String re : res) {
                    if (re.equals(s)) {
                        romeNum++;
                    }
                }
            }
            if (romeNum > 0 && romeNum < 3) {
                oneNum = changeRome(res[0].trim());
                twoNum = changeRome(res[1].trim());
            } else {
                oneNum = Integer.parseInt(res[0].trim());
                twoNum = Integer.parseInt(res[1].trim());
            }
            return String.valueOf(mult(oneNum, twoNum));
        }
        return "no";
    }

    private static int changeRome (String num) {
        int romeRes = 0;
            for (int i = 0; i < 10; i++) {
                if (num.equals(rome[i])) {
                    romeRes = i + 1;
                }
            }
            return romeRes;
    }

    private static int plus(int one, int two) {
        if (one > 10 || two > 10 || one < 1 || two < 1) {
            throw new RuntimeException("Введите число от 1 до 10 только арабскими или только римскими цифрами");
        }
        return one + two;
    }

    private static int minus(int one, int two) {
        if (one > 10 || two > 10 || one < 1 || two < 1) {
            throw new RuntimeException("Введите число от 1 до 10 только арабскими или только римскими цифрами");
        }
        return one - two;
    }

    private static int div(int one, int two) {
        if (one > 10 || two > 10 || one < 1 || two < 1) {
            throw new RuntimeException("Введите число от 1 до 10 только арабскими или только римскими цифрами");
        }
        return one / two;
    }

    private static int mult(int one, int two) {
        if (one > 10 || two > 10 || one < 1 || two < 1) {
            throw new RuntimeException("Введите число от 1 до 10 только арабскими или только римскими цифрами");
        }
        return one * two;
    }
}