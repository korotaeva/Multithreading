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
public interface Recource extends Loader {
    public static Logger logger = LoggerFactory.getLogger(Recource.class);

    String getPath();

    void setPath(String path);

    /**
     * Метод по обработке ресурса в отдельном потоке
     * @param monitor - это разделяемый объект, который включает
     *                результат выполнения бизнес логики
     * @throws IOException
     */
    void resourceProcessing(Monitor monitor)throws IOException ;

}
