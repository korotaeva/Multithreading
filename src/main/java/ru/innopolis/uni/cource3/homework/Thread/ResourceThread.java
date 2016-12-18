package ru.innopolis.uni.cource3.homework.Thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innopolis.uni.cource3.homework.BusinessLogic.Monitor;
import ru.innopolis.uni.cource3.homework.Recource.Recource;

import java.io.IOException;


/**
 * Created by korot on 10.12.2016.
 * Поток, который загружает ресурсы и выполняет бизнес логику приложения
 */
public class ResourceThread   implements Runnable{

    private static Logger logger = LoggerFactory.getLogger(ResourceThread.class);

    public Recource getRecource() {
        return recource;
    }

    public void setRecource(Recource recource) {
        this.recource = recource;
    }

    private Recource recource;

    public ResourceThread(Recource recource, Monitor monitor) {
        this.recource = recource;
        this.monitor = monitor;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    private Monitor monitor;

    @Override
    public void run() {
        logger.info(Thread.currentThread().getName() + " : process started - " + recource.getPath());

        if (recource.getPath() != null && !recource.getPath().equals("")){
            try {
                recource.resourceProcessing(getMonitor());
            } catch (IOException e) {
                e.printStackTrace();
                logger.error(e.getMessage());
                monitor.setError(true);
            }
        }
        if (monitor.isError()) {
            logger.error(Thread.currentThread().getName() + " : started stopped - " + recource.getPath());
        }
        else {
            logger.info(Thread.currentThread().getName() + " : process finished success - " + recource.getPath());
        }
    }

}
