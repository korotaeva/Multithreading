package ru.innopolis.uni.course3.homework.Parser;

import org.junit.Test;
import ru.innopolis.uni.cource3.homework.BusinessLogic.Sum;
import ru.innopolis.uni.cource3.homework.Parser.ParserStr;

import java.math.BigInteger;

import static org.junit.Assert.assertTrue;

/**
 * Created by korot on 17.12.2016.
 */
public class ParserStrTest {
    @Test
    public void parsing(){
        Sum sum = new Sum();
        ParserStr parserStr = new ParserStr();
        parserStr.parsing("12 8", sum);
        assertTrue("Сумма", sum.getSumValue() == BigInteger.valueOf(20));
    }
}
