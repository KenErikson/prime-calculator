package fi.ken;

import java.util.ArrayList;
import java.util.List;

public class Main {

    // Validated count with https://www.dcode.fr/prime-number-pi-count
    public static void main(String[] args) {
        List<Integer> primes = calculatePrimes();
        System.out.println("Found primes count: " + primes.size());
        for(int i = 0 ; i<10; i++){
            System.out.println(primes.get(i));
        }
        System.out.println("Last 3 primes:");
        for(int i = 1 ; i<4; i++){
            System.out.println(primes.get(primes.size()-i));
        }

    }

    private static List<Integer> calculatePrimes() {

        List<Integer> primes = new ArrayList<>();

        primes.add(2);

        long timeEnd = System.currentTimeMillis() + 1000;

        int potentialPrime = 3;
        while (System.currentTimeMillis() < timeEnd) {
            int potentialDiv = 3;

            boolean isPrime = true;

            int maxPotentialDiv = potentialPrime / 3;
            while (potentialDiv <= maxPotentialDiv) {
                if (potentialPrime % potentialDiv == 0) {
                    isPrime = false;
                    break;
                }
                potentialDiv += 2;
            }

            if (isPrime) {
                primes.add(potentialPrime);
            }

            potentialPrime += 2;
        }

        return primes;
    }

    /**
     * Found primes count: 28085
     * 2
     * 3
     * 5
     * 7
     * 11
     * 13
     * 17
     * 19
     * 23
     * 29
     * Last 3 primes:
     * 325939
     * 325921
     * 325901
     *
     * tested with https://www.dcode.fr/prime-number-pi-count
     */
}
