package ru.innopolis.uni.cource3.homework;

import org.apache.log4j.MDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innopolis.uni.cource3.homework.BusinessLogic.Sum;
import ru.innopolis.uni.cource3.homework.Parser.ParserRecource;
import ru.innopolis.uni.cource3.homework.Parser.ParserRecourceFile;
import ru.innopolis.uni.cource3.homework.Parser.ParserRecourceURL;
import ru.innopolis.uni.cource3.homework.Thread.ResourceThread;
import ru.innopolis.uni.cource3.homework.Validator.ValidatorURL;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        for (Object path : resources) {
            ParserRecource recource = (new ValidatorURL()).validate(path)
                    ? new ParserRecourceURL(path.toString())
                    : new ParserRecourceFile(path.toString());

            Thread resourceThread = new ResourceThread(recource, sum);
            resourceThread.start();
        }
    }

}
