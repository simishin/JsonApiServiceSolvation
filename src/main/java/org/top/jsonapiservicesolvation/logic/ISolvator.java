package org.top.jsonapiservicesolvation.logic;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.top.jsonapiservicesolvation.service.ClassMessages;


// интерфейс решателя уравнений
@Component
public interface ISolvator {
    // метод решения
    ClassMessages.OutputMessage solve(ClassMessages.InputMessage input);
}
