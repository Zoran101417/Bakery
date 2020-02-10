package bakery.packaging.app.utils;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CombinatePackaginTest {

    @Test
    public void givenEmptyOrderContainers_andEmptyResultReturned() {
        Map rightCalculation = CombinatePackagin.getRightCalculatedCombination(24, Collections.EMPTY_LIST);
        assertTrue(rightCalculation.isEmpty());
    }

    @Test
    public void givenAccurateOrderContainers_andExpectedResultReturned() {

        Map<Integer, Integer> rightCalculation = CombinatePackagin.getRightCalculatedCombination(14, Arrays.asList(2, 8));
        assertEquals(0, rightCalculation.get(2).compareTo(3));
        assertEquals(0, rightCalculation.get(8).compareTo(1));
        assertEquals(2, rightCalculation.size());

        Map<Integer, Integer> rightCalculation2 = CombinatePackagin.getRightCalculatedCombination(13, Arrays.asList(9, 5, 3));
        assertEquals(0, rightCalculation2.get(5).compareTo(2));
        assertEquals(0, rightCalculation2.get(3).compareTo(1));
        assertEquals(2, rightCalculation2.size());

        Map<Integer, Integer> rightCalculation3 = CombinatePackagin.getRightCalculatedCombination(13, Arrays.asList(2, 5, 8));
        assertEquals(0, rightCalculation3.get(8).compareTo(1));
        assertEquals(0, rightCalculation3.get(2).compareTo(3));
        assertEquals(2, rightCalculation3.size());

        Map<Integer, Integer> rightCalculation4 = CombinatePackagin.getRightCalculatedCombination(14, Arrays.asList(10, 14));
        assertEquals(0, rightCalculation4.get(14).compareTo(1));
        assertEquals(1, rightCalculation4.size());

    }

    @Test
    public void givenNonAccurateOrderContainers_andEmptyResultReturned() {
        Map rightCalculation = CombinatePackagin.getRightCalculatedCombination(24, Arrays.asList(30, 32));
        assertTrue(rightCalculation.isEmpty());

        Map rightCalculation2 = CombinatePackagin.getRightCalculatedCombination(14, Arrays.asList(4, 8));
        assertTrue(rightCalculation2.isEmpty());
    }
}
