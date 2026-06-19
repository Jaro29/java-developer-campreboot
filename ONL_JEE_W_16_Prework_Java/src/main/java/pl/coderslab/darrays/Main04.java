package pl.coderslab.darrays;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main04 {

    public static void main(String[] args) {
        int[] numbers = new int[]{4, 643, 112, 9999, 69};
        int sum0odd = 0;
        for (int number : numbers) {
            if (number % 2 == 0) {
                System.out.println(number);
            } else {
                sum0odd = sum0odd + number;
            }
        }
        log.info("SUMA: {}", sum0odd);

    }

}
