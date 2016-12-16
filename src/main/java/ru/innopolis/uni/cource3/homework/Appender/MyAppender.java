package ru.innopolis.uni.cource3.homework.Appender;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;

import java.awt.*;

/**
 * Created by korot on 14.12.2016.
 */
public class MyAppender  extends AppenderSkeleton {
    /**
     * Пикаем и выводим сообщение.
     * @param event отсюда берётся сообщение.
     */
    @Override
    protected void append(LoggingEvent event) {
        //Toolkit.getDefaultToolkit().beep();
        //System.out.println(event.getMessage());
    }

    /**
     * ресурсы не выделялись - закрывать ничего не надо.
     */
    @Override
    public void close() {

    }
    /**
     * Layout не используется.
     */
    @Override
    public boolean requiresLayout() {
        return false;
    }
}