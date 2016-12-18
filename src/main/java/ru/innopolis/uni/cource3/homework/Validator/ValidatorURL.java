package ru.innopolis.uni.cource3.homework.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by korot on 15.12.2016.
 */
public class ValidatorURL {

    /**
     * Метод проверки валидации. Проверяет соответствует ли параметр условиям
     * @param obj - параметр для проверки
     * @return выдает true если строка соответствует формату URL
     */
    public static boolean validate(Object obj){
        String path = (String)obj;

        Pattern pattern = Pattern.compile("^(https?:\\/\\/)?([\\da-z\\.-]+)\\.([a-z\\.]{2,6})([\\/\\w \\.-]*)*\\/?$");
        Matcher m = pattern.matcher(path.toLowerCase());
        return m.matches();
    }
}
