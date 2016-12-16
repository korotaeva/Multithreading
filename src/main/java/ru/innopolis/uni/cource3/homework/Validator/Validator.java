package ru.innopolis.uni.cource3.homework.Validator;

/**
 * Created by korot on 15.12.2016.
 */
public interface Validator {
    /**
     * Метод проверки валидации. Проверяет соответствует ли параметр условиям
     * @param obj - параметр для проверки
     * @return - возвращает результат проверки валидатора
     */
    Boolean validate(Object obj);
}
