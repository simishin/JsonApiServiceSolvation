package org.top.jsonapiservicesolvation.logic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.top.jsonapiservicesolvation.service.ClassMessages;

import static org.junit.jupiter.api.Assertions.*;

public class SolvatorImplTest {
    @DisplayName("ertysdlkld;")
    @Test
    void solve() {
        SolvatorImpl z = new SolvatorImpl();
        //3,4,5= null
        //1 -2 1 = 1,1
        ClassMessages.InputMessage x = new ClassMessages.InputMessage(1,-2,1);
        ClassMessages.OutputMessage y = z.solve(x);
        System.out.println(y);
        assertNotNull(y,"fgjdskjflkd");

        assertEquals(y.x1(),1);
        assertEquals(y.x2(),1);
        assertEquals(y.rootsCount(),1);
    }
}