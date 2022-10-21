package com.company;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Primes {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean valid = false;
        int n = 0;

        while (!valid) { //re-prompts user if they enter faulty input
            System.out.println("Enter max number: ");
            n = sc.nextInt();
            if (n > 0) {
                valid = true;
            } else {
                System.out.println("Please enter a number that is both non-zero and non-negative.");
            }
        }

        Queue<Integer> result = new LinkedList<>();
        Queue<Integer> numbers = new LinkedList<>();

        boolean[] numbersIsPrime = new boolean[n];
        numbersIsPrime[0] = false; //setting 1 to false
        for (int i = 1; i < n; i++) { //setting 2 to n (inclusive) to true
            numbersIsPrime[i] = true;
        }

        pushToNumbers(numbers, n);
        isPrime(n, numbers, numbersIsPrime);
        numbersToResult(numbers, result);
    }

    public static void pushToNumbers(Queue<Integer> numbers, int n) { //filling numbers queue
        for (int i = 2; i <= n; i++) {
            numbers.add(i);
        }
        System.out.println("Input queue: " + numbers);
    }

    public static void isPrime(int n, Queue<Integer> numbers, boolean[] numbersIsPrime) {
        for (int i = 2; i <= n; i++) {
            if (numbersIsPrime[i - 1]) { //automatically true with this condition
                for (int j = (int) Math.pow(i, 2); j <= n; j += i) { //iterates through multiples of i (non-prime numbers) to remove them, starting from 4 (first non-prime number greater than 2)
                    numbersIsPrime[j - 1] = false; //indicating non-prime numbers
                    numbers.remove(j); //removing non-prime value from numbers queue; only prime numbers remain in the queue
                }
            }
        }
    }

    public static void numbersToResult(Queue<Integer> numbers, Queue<Integer> result) { //moving values from numbers to the values array
        while (!numbers.isEmpty()) {
            int a = numbers.remove();
            result.add(a);
        }
        System.out.println("Result queue: " + result);
    }
}