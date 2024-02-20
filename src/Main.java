import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static String[] rome = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};

    public static void main(String[] args) {
        String input;
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

    public static String calc(String input) {
        boolean arOrRome = true;
        String reg;
        int oneNum = 0;
        int twoNum = 0;

        if (input.contains("+")) reg = "\\+";
        else if (input.contains("-")) reg = "-";
        else if (input.contains("/")) reg = "/";
        else if (input.contains("*")) reg = "\\*";
        else throw new RuntimeException("Ввведите корректный пример");

        String[] res = input.split(reg);
        if (res.length > 2) {
            throw new RuntimeException("Ввведите корректный пример");
        }

        try {
            oneNum = Integer.parseInt(res[0].trim());
            twoNum = Integer.parseInt(res[1].trim());
        } catch (NumberFormatException e) {
            arOrRome = false;
            for (String s : rome) {
                if (res[0].trim().equals(s)) {
                    oneNum = changeRome(res[0].trim());
                    twoNum = changeRome(res[1].trim());
                    break;
                }
            }
        }

        return sol(reg, arOrRome, oneNum, twoNum);
    }

    private static String sol(String reg, boolean arOrRome, int one, int two) {
        if (one > 10 || two > 10 || one < 1 || two < 1) {
            throw new RuntimeException("Введите число от 1 до 10 только арабскими или только римскими цифрами");
        }
        if (arOrRome) {
            switch (reg) {
                case "\\+":
                    return String.valueOf(one + two);
                case "-":
                    return String.valueOf(one - two);
                case "/":
                    return String.valueOf(one / two);
                case "\\*":
                    return String.valueOf(one * two);
            }
        } else {
            switch (reg) {
                case "\\+":
                    return roman(one + two);
                case "-":
                    return roman(one - two);
                case "/":
                    return roman(one / two);
                case "\\*":
                    return roman(one * two);
            }
        }
        return "Введите число от 1 до 10 только арабскими или только римскими цифрами";
    }

    private static int changeRome(String num) {
        int romeRes = 0;
        for (int i = 0; i < 10; i++) {
            if (num.equals(rome[i])) {
                romeRes = i + 1;
            }
        }
        return romeRes;
    }

    private static String roman(int num) {
        if (num < 1)
            throw new RuntimeException("Результатом работы калькулятора с римскими числами могут быть только положительные числа");
        String[][] roman = new String[3][10];
        roman[0] = new String[]{"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        roman[1] = new String[]{"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        roman[2] = new String[]{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IV"};
        String hand = roman[0][num / 100 % 10];
        String ten = roman[1][num / 10 % 10];
        String dig = roman[2][num % 10];
        return hand + ten + dig;
    }
}