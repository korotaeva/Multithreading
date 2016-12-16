package ru.innopolis.uni.cource3.homework.BusinessLogic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innopolis.uni.cource3.homework.Validator.ValidatorEvenPositive;

import java.math.BigInteger;

/**
 * Created by korot on 10.12.2016.
 */
public class Sum implements Monitor {
    private static Logger logger = LoggerFactory.getLogger(Sum.class);

    public BigInteger getSumValue() {
        return sumValue;
    }

    public void setSumValue(BigInteger sum) {
        this.sumValue = sum;
    }

    public Sum() {
        this.sumValue = BigInteger.valueOf(0);
    }

    private BigInteger sumValue;

    public BigInteger increment(int i){

        return sumValue = sumValue.add(BigInteger.valueOf(i));
    }


    public boolean isError() {
        return isError;
    }

    public void setError(boolean error) {
        isError = error;
    }

    private boolean isError = false;

    /**
     *
     * @param str
     */
    @Override
    public void processing(String str){
        try {
            int i = Integer.parseInt(str);

            if ((new ValidatorEvenPositive()).validate(i)){
                synchronized (this) {
                    BigInteger temp = getSumValue();
                    increment(i);
                    logger.info("{} + {} = {}", temp, i, getSumValue());
                }
            }
        }
        catch (NumberFormatException e){
            logger.error(e.getMessage());
            setError(true);
            throw e;

        }
    }




}
