package ru.innopolis.uni.cource3.homework.Validator;

/**
 * Created by korot on 15.12.2016.
 */
public class ValidatorEvenPositive implements Validator{
    /**
     * Метод проверки валидации. Проверяет соответствует ли параметр условиям
     * @param obj - параметр для проверки
     * @return выдает true если число положительное и четное
     */
    public Boolean validate(Object obj){
        int i = (Integer)obj;
        return  (i % 2 == 0 && i > 0);
    }
}
