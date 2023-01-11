package org.top.jsonapiservicesolvation.logic;

import org.top.jsonapiservicesolvation.entity.Answer;
import org.top.jsonapiservicesolvation.entity.Demand;

/**
 * калькулятор теоремы коссинусов.
 * нахождение третьей стороны до двум сторонам и углу между ними.
 * Угол может быть в градусах или радианах либо так и так.
 * cos(double d): возвращает косинус угла d
 *     toDegrees(double value) переводит радианы в градусы и toRadians(double value) - градусы в радианы
 *     1
 *     2
 *
 *     System.out.println(Math.toDegrees(3.14159)); // 180
 *     System.out.println(Math.toRadians(90)); // 1,57079....
 *
 * Также класс Math определяет две константы: Math.E и Math.PI. Например, вычислим площадь круга:
 */

public class ActionImpl implements IAction{
    @Override
    public Answer action(Demand input) {
        System.out.println( input.toString());
        return new Answer(1232.0);//заглушка
    }
}
