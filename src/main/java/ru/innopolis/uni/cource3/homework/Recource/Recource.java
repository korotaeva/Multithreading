package ru.innopolis.uni.cource3.homework.Recource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innopolis.uni.cource3.homework.BusinessLogic.Monitor;
import ru.innopolis.uni.cource3.homework.BusinessLogic.Sum;
import ru.innopolis.uni.cource3.homework.Loader.Loader;
import ru.innopolis.uni.cource3.homework.Parser.Parser;

import java.io.FileNotFoundException;
import java.io.IOException;


/**
 * Created by korot on 10.12.2016.
 */
public class Recource  implements Loader  {
    public static Logger logger = LoggerFactory.getLogger(Recource.class);

    public Recource(String path) {
        this.path = path;

    }

    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }


    @Override
    public void downloadRecource(Monitor monitor) throws IOException {

    }
}
