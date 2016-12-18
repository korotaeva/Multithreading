package ru.innopolis.uni.cource3.homework.Recource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innopolis.uni.cource3.homework.BusinessLogic.Monitor;

import java.io.*;
import java.net.*;
/**
 * Created by korot on 14.12.2016.
 */
public class URLRecource implements Recource {
    public static Logger logger = LoggerFactory.getLogger(URLRecource.class);

    public URLRecource(String path) {
        this.path = path;
    }

    private String path = "";

    @Override
    public String getPath() {
        return this.path;
    }

    @Override
    public void setPath(String path) {
        this.path = path;
    }

    /**
     *  Метод по обработке ресурса в отдельном потоке
     *  Читает данные из удаленного источника построчно
     * @param monitor - это разделяемый объект, который включает
     *                результат выполнения бизнес логики
     * @throws IOException
     */
    @Override
    public void resourceProcessing(Monitor monitor) throws IOException {
        URL oracle = new URL(getPath());
        try (BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream()))) {

            String inputLine;
            while ((inputLine = in.readLine()) != null)
                System.out.println(inputLine);


            in.close();
        }
        catch (IOException e) {
            e.printStackTrace();
            logger.error("Error", e);
            //throw e;
        }
    }
}
