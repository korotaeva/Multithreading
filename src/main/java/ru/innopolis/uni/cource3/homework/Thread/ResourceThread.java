package ru.innopolis.uni.cource3.homework.Thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innopolis.uni.cource3.homework.BusinessLogic.Sum;
import ru.innopolis.uni.cource3.homework.Recource.Recource;

import java.io.IOException;


/**
 * Created by korot on 10.12.2016.
 * Поток, который загружает ресурсы и вычисляет сумму
 */
public class ResourceThread  extends Thread implements Runnable{


    private static Logger logger = LoggerFactory.getLogger(ResourceThread.class);

    public Recource getRecource() {
        return recource;
    }

    public void setRecource(Recource recource) {
        this.recource = recource;
    }

    private Recource recource;


    public ResourceThread(Recource recource, Sum sum) {
        this.recource = recource;
        this.sum = sum;
    }


    public Sum getSum() {
        return sum;
    }

    public void setSum(Sum sum) {
        this.sum = sum;
    }

    private Sum sum;

    @Override
    public void run() {
        if (recource.getPath() != null && !recource.getPath().equals("")){
            try {
                recource.downloadRecource(getSum());
            } catch (IOException e) {
                e.printStackTrace();


            }
        }
    }

}
