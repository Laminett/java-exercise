package kr.co.gpt.reversenumber;

public class ReverseNumber {

    public ReverseNumber(int number) {
        if (number == 0) {
            return;
        }
        System.out.println(number);
        new ReverseNumber(number - 1);
    }
}
