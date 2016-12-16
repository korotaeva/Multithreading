package ru.innopolis.uni.cource3.homework.Parser;

import ru.innopolis.uni.cource3.homework.BusinessLogic.Monitor;
import ru.innopolis.uni.cource3.homework.BusinessLogic.Sum;
import ru.innopolis.uni.cource3.homework.Loader.Loader;
import ru.innopolis.uni.cource3.homework.Recource.Recource;

import java.io.*;
import java.net.*;
/**
 * Created by korot on 14.12.2016.
 */
public class ParserRecourceURL  extends Recource implements Loader {
    public ParserRecourceURL(String path) {
        super(path);
    }

    @Override
    public void resourceProcessing(Monitor monitor) throws IOException {

        try {
            URL oracle = new URL(getPath());
            BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null)
                System.out.println(inputLine);


            in.close();
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
