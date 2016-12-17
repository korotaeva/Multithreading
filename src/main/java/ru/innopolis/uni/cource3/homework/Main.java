package ru.innopolis.uni.cource3.homework;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innopolis.uni.cource3.homework.BusinessLogic.Sum;
import ru.innopolis.uni.cource3.homework.Recource.Recource;
import ru.innopolis.uni.cource3.homework.Recource.FileRecource;
import ru.innopolis.uni.cource3.homework.Recource.URLRecource;
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
        resources.add("c:/files/1.txt");
        resources.add("c:/files/2.txt");
        resources.add("c:/files/3.txt");

        for (Object path : resources) {
            Recource recource = (new ValidatorURL()).validate(path)
                    ? new URLRecource(path.toString())
                    : new FileRecource(path.toString());

            Thread resourceThread = new ResourceThread(recource, sum);
            resourceThread.start();
        }
    }

}
