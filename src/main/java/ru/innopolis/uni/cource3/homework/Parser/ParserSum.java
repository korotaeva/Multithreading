package ru.innopolis.uni.cource3.homework.Parser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innopolis.uni.cource3.homework.Recource.Recource;
import ru.innopolis.uni.cource3.homework.Validator.ValidatorEvenPositive;

import java.math.BigInteger;

/**
 * Created by korot on 17.12.2016.
 */
public class ParserSum implements Parser{

    @Override
    public int parsing(String str) {
        int i = Integer.parseInt(str);
        return i;

    }
}
