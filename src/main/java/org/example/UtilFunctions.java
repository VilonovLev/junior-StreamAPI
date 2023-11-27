package org.example;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class UtilFunctions {

    //1. Создать список из 1_000 рандомных чисел от 1 до 1_000_000
    static List<Integer> getRandomNumbers(int minNumber, int maxNumber, int length) {
        return ThreadLocalRandom.current()
                .ints(minNumber,maxNumber)
                .limit(length)
                .boxed().toList();
    }

    //1.1 Найти максимальное
    static int max(List<Integer> list) {
        return list.stream()
                .reduce(Math::max)
                .get();
    }

    //2.2 Все числа, большие, чем 500_000, умножить на 5, отнять от них 150 и просуммировать
    static long firstFunctionEvaluation(List<Integer> list) {
        return list.stream()
                .filter(x -> x > 500_000)
                .map(x -> x * 5 - 150)
                .mapToLong(x -> (long) x)
                .reduce(Long::sum).getAsLong();
    }

    //2.3 Найти количество чисел, квадрат которых меньше, чем 100_000
    static long secondFunctionEvaluation(List<Integer> list) {
        return list.stream()
                .filter(x -> x < Math.sqrt(100_000))
                .count();
    }
}
