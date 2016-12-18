package ru.innopolis.uni.cource3.homework.BusinessLogic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innopolis.uni.cource3.homework.Validator.ValidatorEvenPositive;

import java.math.BigInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by korot on 10.12.2016.
 * Конкретная реализация объекта Monitor-а
 */
public class Sum implements Monitor {
    private static Logger logger = LoggerFactory.getLogger(Sum.class);

    /**
     * Метод для получения итоговой суммы
     * @return возвращает сумму
     */
    public BigInteger getSumValue() {
        return sumValue;
    }

    /**
     * Метод для задания суммы
     * @param sum
     */
    public void setSumValue(BigInteger sum) {
        this.sumValue = sum;
    }

    public Sum() {
        this.sumValue = BigInteger.valueOf(0);
    }

    /**
     * Сумма - итоговое значение,
     * в которое пишут все потоки
     */
    private volatile BigInteger sumValue;



    /**
     * Метод по изменению итоговой суммы
     * @param i - значение, на которое меняется сумма
     * @return - возвращает итоговую сумму
     */
    public BigInteger increment(int i){

        return sumValue = sumValue.add(BigInteger.valueOf(i));
    }

    /**
     * Проверка флага - есть ли в системе исключение
     * @return
     */
    public boolean isError() {
        return isError;
    }

    /**
     * Метод изменения флага, сообщающем о наличии ошибки в одном из потоков
     * @param error
     */
    public void setError(boolean error) {
        isError = error;
    }

    /**
     * Флаг о наличии ошибки в одном из потоков
     */
    private boolean isError = false;

    Lock lock = new ReentrantLock();

    /**
     * Метод, позволяющий считать сумму всех четных положительных чисел
     * в отдельном потоке для каждого файла.
     * Определенна критическая секция с разделяемым ресурсом
     * @param str получает строку с числом
     */
    @Override
    public void processing(String str){
        try {
            int i = Integer.parseInt(str);

            if ((new ValidatorEvenPositive()).validate(i)){
                lock.lock();
                try {
                    // update object state
                   //synchronized (sumValue) {
                    BigInteger temp = getSumValue();
                    increment(i);
                    logger.info("{} + {} = {}", temp, i, getSumValue());
                     //}
                }
                finally {
                    lock.unlock();
                }

            }
        }
        catch (NumberFormatException e){
            logger.error("Error", e);
            setError(true);
        }
    }




}
