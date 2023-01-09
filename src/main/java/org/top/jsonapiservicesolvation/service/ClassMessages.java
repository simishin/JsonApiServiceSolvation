package org.top.jsonapiservicesolvation.service;

import java.util.Date;

// классы сообщений
public class ClassMessages {
    // пустой интерфейс
    public interface IMessage {

    }

    // класс простого сообщения
    public static class Message implements IMessage {
        public String message;  // строка сообщения
        public Date time;       // время сообщения

        public Message(String message) {
            this.message = message;
            this.time = new Date(); // записываем время создания сообщения
        }

        @Override
        public String toString() {
            return time + ": " + message;
        }
    }

    // входное сообщение
    public static class InputMessage implements IMessage {
        // коэффициенты КВУР
        public double a;
        public double b;
        public double c;

        InputMessage(double a, double b, double c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public String toString() {
            return a + "x^2 + " + b + "x + " + c + " = 0";
        }
    }

    // сообщение результата
    public static class OutputMessage implements IMessage {
        public int rootsCount;  // кол-во корней
        public Double x1;       // сами корни
        public Double x2;

        public OutputMessage(int rootsCount, double x1, double x2) {
            this.rootsCount = rootsCount;
            if (rootsCount == 0) {
                this.x1 = this.x2 = null;
            } else if (rootsCount == 1) {
                this.x1 = this.x2 = x1;
            } else {
                this.x1 = x1;
                this.x2 = x2;
            }
        }

        @Override
        public String toString() {
            return rootsCount + ": " + x1 + ", " + x2;
        }
    }

    // сообщение ошибки
    public static class ErrorMessage extends Message {
        public ErrorMessage(String error) {
            super(error);
        }
    }

    public static class MessageWithBool {
        public Boolean flag;

        @Override
        public String toString() {
            return "flag " + flag;
        }
    }
}
