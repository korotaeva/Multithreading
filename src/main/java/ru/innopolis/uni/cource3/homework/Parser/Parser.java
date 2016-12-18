package ru.innopolis.uni.cource3.homework.Parser;

import ru.innopolis.uni.cource3.homework.BusinessLogic.Monitor;
import ru.innopolis.uni.cource3.homework.BusinessLogic.Sum;

import java.util.List;

/**
 * Created by korot on 15.12.2016.
 */
public interface Parser {
    /**
     * Парсинг строки считываемой из источника данных
     * @param str - строка для обработки
     */
    List<String> parsing(String str);
}
