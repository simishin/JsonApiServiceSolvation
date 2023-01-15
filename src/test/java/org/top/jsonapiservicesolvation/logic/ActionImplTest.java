package org.top.jsonapiservicesolvation.logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.internal.matchers.Null;
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
     * используется для проверки более подробной информации о сгенерированном исключении
     */
    @Test
    void action() {
        Demand x = new Demand(3.0, 4.0, 1390.0,"");
        RuntimeException thrown = assertThrows( RuntimeException.class, () -> {

            Answer y = z.action(x);
//            assertEquals(y.oppositeSide(),5);
            //Code under test
        });
        System.out.println(thrown.getMessage());
        System.out.println(thrown.getClass().getName());
        Assertions.assertEquals("Угол больше 2Пи", thrown.getMessage()); //для первого прерывания
 //       assertTrue(thrown.getMessage().contains("Угол больше 2Пи")); //альтернатива для первого прерывания
    } //----------------------------------------------------------------------------------
    @Test
    void actionF() { //используется для проверки  только типа исключения.
        Demand x = new Demand(3.0, 4.0, 390.0,"");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {

            Answer y = z.action(x);
//            assertEquals(y.oppositeSide(),5);
            //Code under test
        });
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

    /**
     *
     * @param y
     * @param x1
     * @param x2
     * @param x3
     * @param x4
     */
    @ParameterizedTest
    @MethodSource("method1DataProvider")
    public void method1(Double y, double x1, double x2, double x3, String x4) {
        Demand x = new Demand(x1, x2, x3, x4);
        if (y.isNaN()) {
            System.out.println("IllegalArgumentException");
            Assertions.assertThrows(
                    IllegalArgumentException.class,
                    () -> { z.action(x); }
            );
        }
        else {
            assertEquals(y, z.action(x).oppositeSide(),0.0001);
        }
    }
    static Stream<Arguments> method1DataProvider() {
        return Stream.of(
        arguments(3.0318, 10.0, 7.0, 3.0, ""),
        arguments(Double.NaN, 3.0, 4.0, 390, ""),
        arguments(5.0, 3.0, 4.0, 90.0, ""),
        arguments(5.915, 3.0, 4.0, 2.0, "r",0.1)
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