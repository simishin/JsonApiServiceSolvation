package org.top.jsonapiservicesolvation.logic;

import org.junit.jupiter.api.Test;
import org.top.jsonapiservicesolvation.entity.Answer;
import org.top.jsonapiservicesolvation.entity.Demand;

import static org.junit.jupiter.api.Assertions.*;

class ActionImplTest {

    @Test
    void action() {
        ActionImpl z = new ActionImpl();
        Demand x = new Demand(3.0, 4.0, 90.0,"");
        Answer y = z.action(x);
        assertEquals(y.oppositeSide(),5);
    }
}