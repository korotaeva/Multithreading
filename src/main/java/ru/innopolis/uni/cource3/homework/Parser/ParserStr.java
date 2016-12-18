package ru.innopolis.uni.cource3.homework.Parser;

import ru.innopolis.uni.cource3.homework.BusinessLogic.Monitor;

import java.util.Arrays;
import java.util.List;

/**
 * Created by korot on 17.12.2016.
 */
public class ParserStr implements Parser{

    /**
     * Парсинг строки считываемой из источника данных
     * на числа, разделенные пробелом.
     * @param str - строка для обработки

     */
    @Override
    public List<String>  parsing(String str) {
        String[] tokens = str.split(" ");
        List<String> tokensList = Arrays.asList(tokens);
        tokensList.remove("");
        return tokensList;
    }
}
