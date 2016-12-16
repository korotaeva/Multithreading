package ru.innopolis.uni.cource3.homework.Parser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innopolis.uni.cource3.homework.BusinessLogic.Sum;


/**
 * Created by korot on 10.12.2016.
 */
public class ParserRecource{
    public static Logger logger = LoggerFactory.getLogger(ParserRecource.class);

    public ParserRecource(String path) {
        this.path = path;

    }


    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void downloadRecource(Sum sum){

    }
}
