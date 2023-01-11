package org.top.jsonapiservicesolvation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.top.jsonapiservicesolvation.entity.Answer;
import org.top.jsonapiservicesolvation.entity.Demand;
import org.top.jsonapiservicesolvation.logic.IAction;
import org.top.jsonapiservicesolvation.logic.ISolvator;


// НАш контроллер
@Controller                                // REST-контроллер
@RequestMapping("/api")             // маршрутизация
public class SolvationService {

    @Autowired                      // аннотация автосвязывания
    private ISolvator solvator;     // объект интерфейс решателя (DI)

    @Autowired
    private IAction activator;

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

    @PostMapping("/activ")
    public @ResponseBody ClassMessages.IMessage action(@RequestBody Demand input){
        Answer out = activator.action(input);
        if (out == null) {
            System.out.println("coefficient a should be != 0");
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
