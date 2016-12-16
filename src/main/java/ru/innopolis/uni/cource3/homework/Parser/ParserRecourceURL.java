package ru.innopolis.uni.cource3.homework.Parser;

import ru.innopolis.uni.cource3.homework.BusinessLogic.Sum;

import java.io.*;
import java.net.URLConnection;
import java.net.*;
/**
 * Created by korot on 14.12.2016.
 */
public class ParserRecourceURL  extends ParserRecource{
    public ParserRecourceURL(String path) {
        super(path);
    }

    @Override
    public void downloadRecource(Sum sum){


        URL oracle = null;
        try {
            oracle = new URL(getPath());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        BufferedReader in = null;
        try {
            in = new BufferedReader(
                    new InputStreamReader(oracle.openStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String inputLine;
        try {
            while ((inputLine = in.readLine()) != null)
                System.out.println(inputLine);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
