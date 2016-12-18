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
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

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


        ExecutorService executorService = Executors.newFixedThreadPool(resources.size());

        resources.forEach(path ->
                executorService.submit(() ->
                        (new FileRecource(path.toString())).resourceProcessing(sum)));


        /*for (Object path : resources) {
            Recource recource = (new ValidatorURL()).validate(path)
                    ? new URLRecource(path.toString())
                    : new FileRecource(path.toString());

            ResourceThread resourceThread = new ResourceThread(recource, sum);

            executorService.submit(resourceThread);

           *//* Thread t = new Thread(resourceThread);
            t.start();*//*

        }*/
        executorService.shutdown();

    }

}
