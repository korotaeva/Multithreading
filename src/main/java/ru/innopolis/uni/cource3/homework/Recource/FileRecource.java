package ru.innopolis.uni.cource3.homework.Recource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innopolis.uni.cource3.homework.BusinessLogic.Monitor;
import ru.innopolis.uni.cource3.homework.Parser.ParserStr;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

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

    /**
     *  Метод по обработке ресурса в отдельном потоке
     *  Читает данные из файла построчно
     * @param monitor - это разделяемый объект, который включает
     *                результат выполнения бизнес логики
     * Если при обработки одного из элементов строки
     * происходит ошибка, записываем в объект монитор флаг ошибки
     * @throws IOException
     */
    @Override
    public void resourceProcessing(Monitor monitor)  {
        try (FileReader file = new FileReader(getPath());
            BufferedReader buffer = new BufferedReader(file)) {
            String str;
            while ((str = buffer.readLine()) != null && !monitor.isError()) {
                List<String> tokens = (new ParserStr()).parsing(str);
                for (String element : tokens) {
                        monitor.processing(element);
                    if (monitor.isError()) {
                        break;
                    }
                }

            }
        } catch (FileNotFoundException e) {
            logger.error("Error", e);
            monitor.setError(true);

        } catch (IOException e) {
            logger.error("Error", e);
            monitor.setError(true);

        }
    }


}
