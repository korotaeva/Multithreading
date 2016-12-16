package ru.innopolis.uni.cource3.homework.Parser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innopolis.uni.cource3.homework.BusinessLogic.Sum;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by korot on 14.12.2016.
 */
public class ParserRecourceFile extends ParserRecource {

    public ParserRecourceFile(String path) {
        super(path);
    }

    @Override
    public void downloadRecource(Sum sum){
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

        } catch (IOException e) {
            logger.error(e.getMessage());
            sum.setError(true);

        }
    }
}
