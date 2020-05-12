package com.setsal.stlab4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.stream.Stream;

class PriorityQueueTest {

    private PriorityQueue<Integer> myQueue;

    static Stream<Arguments> sampleListProvider() {
        // random, correct, length
        return Stream.of(
                arguments(Arrays.asList(2, 3, 1), Arrays.asList(1, 2, 3), 3),
                arguments(Arrays.asList(9, 4, 8, 7), Arrays.asList(4, 7, 8, 9), 4),
                arguments(Arrays.asList(0xfaceb00c, 1, 0, -5, 0xdeadbeef), Arrays.asList(0xdeadbeef, 0xfaceb00c, -5, 0, 1), 5),
                arguments(Arrays.asList(0x20df, 0x0055980, 0x5e7, 0x5a1), Arrays.asList(0x5a1, 0x5e7, 0x20df, 0x0055980), 4),
                arguments(Arrays.asList(0xec129, 99555, 54813, 66), Arrays.asList(66, 54813, 99555, 0xec129), 4)
        );
    }


    @ParameterizedTest(name = "#{index} => random={0}, correct={1}")
    @MethodSource("sampleListProvider")
    @DisplayName("Parameterization Priority Queue Pool Test")
    void PriorityQueueParameterizationTest(List<Integer> random, List<Integer> correct, int length) {
        myQueue = new PriorityQueue<Integer>(random);
        for( int i=0; i<length; i++ ) {
            assertEquals(correct.get(i), myQueue.poll());
        }
    }

    /* This is just for size test :P */
    @ParameterizedTest(name = "#{index} - Run test with size={0}")
    @ValueSource(ints = {0,1,2,3,4})
    @DisplayName("Size of Priority Queue Test")
    void PriorityQueueSizeTest(int input) {
        myQueue = new PriorityQueue<Integer>();
        for( int i=0; i<input; i++ ) {
            myQueue.add(i);
        }
        assertEquals(input, myQueue.size());
    }

    /* Exception Handler Test Case */
    @DisplayName("Give nothing in remove() exception test")
    @Test
    void PriorityQueue_RemoveNull_ExceptionTest() {
        myQueue = new PriorityQueue<Integer>();
        assertThrows(NoSuchElementException.class, () -> {
            myQueue.remove();
        });
    }

    @DisplayName("Null pointer in offer() exception test")
    @Test
    void PriorityQueue_OfferNullPointer_ExceptionTest() {
        myQueue = new PriorityQueue<Integer>();
        assertThrows(NullPointerException.class, () -> {
            myQueue.offer(null);
        });
    }

    @DisplayName("illegal arg in addAll() with queue addAll itself exception test")
    @Test
    void PriorityQueue_addAll_IllegalArgument_ExceptionTest() {
        myQueue = new PriorityQueue<Integer>();
        assertThrows(IllegalArgumentException.class, () -> {
            myQueue.addAll(myQueue);
        });
    }

}
