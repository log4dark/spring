package com.log4dark.spring.service.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddNumberTest {

    @Test
    void add() {
        AddNumber addNumber = new AddNumber();
        assertEquals(addNumber.add(8,9), 17);
    }

    @Test
    void testAdd() {
        AddNumber addNumber = new AddNumber();
        assertEquals(addNumber.add(1,2,3), 10);
        /*
        org.opentest4j.AssertionFailedError:
        Expected :6
        Actual   :10
         */
    }
}