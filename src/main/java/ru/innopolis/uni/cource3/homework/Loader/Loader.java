package ru.innopolis.uni.cource3.homework.Loader;

import ru.innopolis.uni.cource3.homework.BusinessLogic.Sum;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by korot on 16.12.2016.
 */
public interface Loader {
    void downloadRecource(Sum sum) throws IOException;
}
