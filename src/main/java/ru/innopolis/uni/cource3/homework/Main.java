package ru.innopolis.uni.cource3.homework;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innopolis.uni.cource3.homework.BusinessLogic.Sum;
import ru.innopolis.uni.cource3.homework.Recource.Recource;
import ru.innopolis.uni.cource3.homework.Parser.ParserRecourceFile;
import ru.innopolis.uni.cource3.homework.Parser.ParserRecourceURL;
import ru.innopolis.uni.cource3.homework.Thread.ResourceThread;
import ru.innopolis.uni.cource3.homework.Validator.ValidatorURL;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by korot on 10.12.2016. 1
 */
public class Main {
    private static Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {

        Sum sum = new Sum();
        // загрузить список ресурсов

        List resources = new ArrayList<String>();
        resources.add("c:/1/1.txt");
        resources.add("c:/1/2.txt");
        resources.add("c:/1/3.txt");
        //resources.add("http://vels.org.ru/index.php?menu=chisla");

        for (Object path : resources) {
            Recource recource = (new ValidatorURL()).validate(path)
                    ? new ParserRecourceURL(path.toString())
                    : new ParserRecourceFile(path.toString());

            Thread resourceThread = new ResourceThread(recource, sum);
            resourceThread.start();
        }
    }

}
