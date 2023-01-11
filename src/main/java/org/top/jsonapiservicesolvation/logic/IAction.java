package org.top.jsonapiservicesolvation.logic;

import org.springframework.stereotype.Component;
import org.top.jsonapiservicesolvation.entity.Answer;
import org.top.jsonapiservicesolvation.entity.Demand;

@Component
public interface IAction {
    Answer action(Demand input);
}
