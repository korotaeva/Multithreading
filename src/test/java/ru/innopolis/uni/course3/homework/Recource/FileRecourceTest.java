package ru.innopolis.uni.course3.homework.Recource;

import org.junit.Test;
import ru.innopolis.uni.cource3.homework.BusinessLogic.Sum;
import ru.innopolis.uni.cource3.homework.Parser.ParserStr;
import ru.innopolis.uni.cource3.homework.Recource.FileRecource;

import java.math.BigInteger;

import static org.junit.Assert.assertTrue;

/**
 * Created by korot on 17.12.2016.
 */
public class FileRecourceTest {
    @Test
    public void resourceProcessing(){
        FileRecource fileRecource = new FileRecource("c:/files/1.txt");
        Sum sum = new Sum();
        fileRecource.resourceProcessing(sum);


        //assertTrue("Сумма", sum.getSumValue() == BigInteger.valueOf(20));
    }
}
