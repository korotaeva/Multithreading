package ru.innopolis.uni.cource3.homework.Parser;

import ru.innopolis.uni.cource3.homework.BusinessLogic.Monitor;

/**
 * Created by korot on 17.12.2016.
 */
public class ParserSum implements Parser{

    @Override
    public void parsing(String str, Monitor monitor) {
        String[] tokens = str.split(" ");
        for (String element : tokens) {
            monitor.processing(element);
        }
    }
}
