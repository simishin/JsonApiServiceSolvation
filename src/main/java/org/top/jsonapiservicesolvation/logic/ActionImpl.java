package org.top.jsonapiservicesolvation.logic;

import org.top.jsonapiservicesolvation.entity.Answer;
import org.top.jsonapiservicesolvation.entity.Demand;
/**
 * калькулятор теоремы коссинусов.
 * нахождение третьей стороны до двум сторонам и углу между ними.
 * Угол может быть в градусах или радианах либо так и так.
 */
public class ActionImpl implements IAction{
    @Override
    public Answer action(Demand x) {

        if (x.sideFirst()==0) return new Answer(x.sideSecond());
        if (x.sideSecond()==0) return new Answer(x.sideFirst());
        boolean b=true; //false - радианы/ true- градусы
        if (! x.measure().isBlank())
            if (x.measure().trim().toLowerCase().startsWith("r")) b=false;;

        double y = b ? Math.toRadians(x.corner()) : x.corner();
//        System.out.println( x.toString()+"\t"+y+"\t"+2* y +"\t"+((2*y) % Math.PI));
//        if ( 2*y == Math.PI ) new Answer(Math.sqrt(x.sideFirst()*x.sideFirst() + x.sideSecond()*x.sideSecond()
//                - 2* x.sideFirst()* x.sideSecond()));
//        if ((2*y) % Math.PI == 0 )  return  null;

        return new Answer(Math.sqrt(x.sideFirst()*x.sideFirst() + x.sideSecond()*x.sideSecond()
                - 2* x.sideFirst()* x.sideSecond()*Math.cos(y)));
    }//action
}//class ActionImpl
