package ru.innopolis.uni.course3.homework.BusinessLogic;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innopolis.uni.cource3.homework.BusinessLogic.Sum;
import static org.junit.Assert.assertTrue;
import java.math.BigInteger;

/**
 * Created by korot on 15.12.2016.
 */
public class SumTest {
    private static Logger logger = LoggerFactory.getLogger(SumTest.class);

    @Test
    public void processing(){
        Sum sum = new Sum();
        sum.processing("46435135");

        assertTrue("Сумма", sum.getSumValue() == BigInteger.valueOf(46435135));
    }

    // ожидаем исключение
    @Test(expected = NumberFormatException.class)
    public void Sum(){
        //int  sum = 4;
        Sum sum = new Sum();
        sum.processing("6gvhgggh4");
       // assertTrue("gvklh;", sum == 4);
    }
 /*

    @After
    public void calculateSum(){

    }
*/
}