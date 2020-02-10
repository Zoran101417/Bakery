package bakery.packaging.app.utils;

import java.util.*;

public class CombinatePackagin {

    public static Map<Integer, Integer> getRightCalculatedCombination(Integer orderAmount, List<Integer> orderContainers) {
        if (orderContainers.isEmpty())
            return Collections.EMPTY_MAP;

        orderContainers.sort(Collections.reverseOrder());

        LinkedList<Integer> effectiveContainers = new LinkedList<>(orderContainers);

        Map<Integer, Integer> result;
        Integer effectiveContainer;

        Integer holdNumber = effectiveContainers.pop();
        LinkedList<Integer> remainingContainers = new LinkedList<>(effectiveContainers);

        do {
            if (remainingContainers.size() == 0) {
                holdNumber = effectiveContainers.pop();
                remainingContainers.addAll(new LinkedList<>(effectiveContainers));
            }

            LinkedList<Integer> numbersToIterate = mergeCombinations(holdNumber, remainingContainers);

            result = new HashMap<>();
            effectiveContainer = CombinatePackagin.getRightCombination(result, orderAmount, numbersToIterate);

            if (effectiveContainer > 0 && remainingContainers.size() > 0) {
                remainingContainers.pop();
            }

        } while (effectiveContainer > 0 && effectiveContainers.size() > 0);

        return effectiveContainer == 0 ? result : Collections.EMPTY_MAP;
    }

    private static Integer getRightCombination(Map<Integer, Integer> combinationResult, Integer orderAmount, List<Integer> orderContainers) {
        Integer effectiveContainer = orderAmount;

        Map<Integer, Integer> result = new HashMap<>();

        for (int i = 0; i < orderContainers.size() && effectiveContainer > 0; i++) {
            Integer divisor = orderContainers.get(i);
            int remainder = effectiveContainer / divisor;
            result.put(divisor, remainder);
            effectiveContainer = effectiveContainer - (remainder * divisor);
        }
        combinationResult.putAll(result);
        return effectiveContainer;
    }

    private static LinkedList<Integer> mergeCombinations(Integer holdNumber, LinkedList<Integer> effectiveDivisors) {
        LinkedList<Integer> output = new LinkedList<>();
        output.add(holdNumber);
        output.addAll(effectiveDivisors);

        return output;
    }
}
