package ru.innopolis.uni.cource3.homework.BusinessLogic;

/**
 * Created by korot on 16.12.2016.
 */
public interface Monitor {
    boolean isError = false;

    boolean isError();

    void setError(boolean error);

    void processing(String str);
}
