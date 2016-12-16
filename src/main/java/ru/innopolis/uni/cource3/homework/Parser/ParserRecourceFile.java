package ru.innopolis.uni.cource3.homework.Parser;

import ru.innopolis.uni.cource3.homework.BusinessLogic.Sum;
import ru.innopolis.uni.cource3.homework.Loader.Loader;
import ru.innopolis.uni.cource3.homework.Recource.Recource;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by korot on 14.12.2016.
 */
public class ParserRecourceFile extends Recource  {

    public ParserRecourceFile(String path) {
        super(path);
    }

    @Override
    public void downloadRecource(Sum sum) throws IOException {
        try (FileReader file = new FileReader(getPath());
             BufferedReader buffer = new BufferedReader(file)) {
            String str;
            while ((str = buffer.readLine()) != null && !sum.isError()) {
                String[] tokens = str.split(" ");
                for (String element : tokens) {
                    sum.calculateSum(element);
                }
            }
        } catch (FileNotFoundException e) {
            logger.error(e.getMessage());
            sum.setError(true);
            throw e;
        } catch (IOException e) {
            logger.error(e.getMessage());
            sum.setError(true);
            throw e;
        }
    }
}
