package pl.coderslab.darrays;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main03 {

    public static void main(String[] args) {
        int[] numbers = new int[]{4, 643, 112, 9999, 69};
        int sum;
        sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum = sum + numbers[i];
        }
        log.info("SUMA: {}", sum);
    }
}
