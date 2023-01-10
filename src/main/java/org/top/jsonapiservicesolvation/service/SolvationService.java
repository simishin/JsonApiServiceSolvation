package org.top.jsonapiservicesolvation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.top.jsonapiservicesolvation.logic.ISolvator;


// НАш контроллер
@Controller                                // REST-контроллер
@RequestMapping("/api")             // маршрутизация
public class SolvationService {

    @Autowired                      // аннотация автосвязывания
    private ISolvator solvator;     // объект интерфейс решателя (DI)

    // 1. ping
    @GetMapping("/ping")
    public @ResponseBody ClassMessages.Message ping() {
        return new ClassMessages.Message("pong");
    }

    // 2. статус сервера
    @GetMapping("/status")
    public @ResponseBody ClassMessages.Message status() {
        return new ClassMessages.Message("Server status OK at port 8080");
    }

    // 3. решение
    @PostMapping("/solve")
    public @ResponseBody ClassMessages.IMessage solve(@RequestBody ClassMessages.InputMessage input) {
        System.out.println("Received data: " + input);
        ClassMessages.OutputMessage out = solvator.solve(input);    // вызов решения
        if (out == null) {
            return new ClassMessages.ErrorMessage("coefficient a should be != 0");
        }
        return out;
    }

    @PostMapping("/booltest")
    public @ResponseBody ClassMessages.MessageWithBool booltest(@RequestBody ClassMessages.MessageWithBool input) {
        System.out.println(input);
        return input;
    }
}
