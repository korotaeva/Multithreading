package ru.innopolis.uni.course3.homework.Parser;

import org.junit.Test;
import ru.innopolis.uni.cource3.homework.BusinessLogic.Sum;
import ru.innopolis.uni.cource3.homework.Parser.ParserStr;

import java.math.BigInteger;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by korot on 17.12.2016.
 */
public class ParserStrTest {
    @Test
    public void parsing(){
        ParserStr parserStr = new ParserStr();
        List<String> list = parserStr.parsing("12 8");
        assertTrue("Количество пропарсенных элементов совпадает",list.size() == 2);
    }
}
