package ru.innopolis.uni.cource3.homework.Recource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innopolis.uni.cource3.homework.BusinessLogic.Monitor;
import ru.innopolis.uni.cource3.homework.Parser.ParserStr;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by korot on 14.12.2016.
 */
public class FileRecource implements Recource {

    public static Logger logger = LoggerFactory.getLogger(FileRecource.class);

    private String path = "";

    @Override
    public String getPath() {
        return this.path;
    }

    @Override
    public void setPath(String path) {
        this.path = path;
    }

    public FileRecource(String path) {
        this.path = path;
    }

    @Override
    public void resourceProcessing(Monitor monitor) throws IOException {
        try (FileReader file = new FileReader(getPath());
            BufferedReader buffer = new BufferedReader(file)) {
            String str;
            while ((str = buffer.readLine()) != null && !monitor.isError()) {
                (new ParserStr()).parsing(str,monitor);
            }
        } catch (FileNotFoundException e) {
            logger.error(e.getMessage());
            monitor.setError(true);
            throw e;
        } catch (IOException e) {
            logger.error(e.getMessage());
            monitor.setError(true);
            throw e;
        }
    }


}
