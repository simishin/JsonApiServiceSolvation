package org.top.jsonapiservicesolvation.logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.top.jsonapiservicesolvation.entity.Answer;
import org.top.jsonapiservicesolvation.entity.Demand;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class ActionImplTest {
    ActionImpl z = new ActionImpl();

    /**
     * Ожидаемое исключение JUnit 5
     * https://habr.com/ru/post/591305/
     * Использование Assertions.assertThrows()
     */
    @Test
    void action() {
        Demand x = new Demand(3.0, 4.0, 390.0,"");
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {

            Answer y = z.action(x);
//            assertEquals(y.oppositeSide(),5);
            //Code under test
        });
        Assertions.assertEquals("Угол больше 2Пи", thrown.getMessage());
    } //----------------------------------------------------------------------------------

    /**
     * вариант с урока
     */
    @Test
    void actionq() {
        Demand x = new Demand(3.0, 4.0, 390.0,"");
        try {
            Answer y = z.action(x);
            fail();
        } catch (IllegalArgumentException e){ }
    }

    @ParameterizedTest
    @MethodSource("method1DataProvider")
    public void method1(double y, double x1, double x2, double x3, String x4) {
        assertEquals(y, z.action(new Demand(x1, x2, x3, x4)).oppositeSide(),0.0001);
    }
    static Stream<Arguments> method1DataProvider() { return Stream.of(
        arguments(3.0318, 10.0, 7.0, 3.0, ""),
        arguments(5, 3.0, 4.0, 90.0, ""),
        arguments(5, 3.0, 4.0, 90.0, "g"),
        arguments(5.97944, 3.0, 4.0, 90.0, "r")
        );
    }
    //---------------------------------------------------------------
    @ParameterizedTest
    @CsvSource({
            "5, 3.0, 4.0, 90.0 , \"\"  ",
            "5, 3.0, 4.0, 90.0, g",
            "3.0318, 10.0, 7.0, 3.0 , \"\""
    })
    void testWithCsvSource(double y, double x1, double x2, double x3, String x4) {
        assertEquals(y, z.action(new Demand(x1, x2, x3, x4)).oppositeSide(),0.0001);
    }
    //--------------------------------------------------------------
    @ParameterizedTest
    @CsvSource({
            "5, 3.0, 4.0, 90.0 , \"\"  ",
            "5, 3.0, 4.0, 90.0, g",
            "3.0318, 10.0, 7.0, 3.0 , \"\""
    })
    void testWithCsvSourceQ(double y, double x1, double x2, double x3, String x4) {
        Answer q = z.action(new Demand(x1, x2, x3, x4));
        assertAll("Вот это Да!",
                () -> assertEquals(y, q.oppositeSide(),0.0001)
        );
    }

}//class ActionImplTest