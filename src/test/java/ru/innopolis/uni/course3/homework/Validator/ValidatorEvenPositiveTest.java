package ru.innopolis.uni.course3.homework.Validator;

import org.junit.Test;
import ru.innopolis.uni.cource3.homework.Validator.ValidatorEvenPositive;

import java.math.BigInteger;

import static org.junit.Assert.assertTrue;

/**
 * Created by korot on 17.12.2016.
 */
public class ValidatorEvenPositiveTest {
    @Test
    public void validate(){
        ValidatorEvenPositive validate = new ValidatorEvenPositive();
        assertTrue("Проверка четного положичетльного",  validate.validate(80));
        assertTrue("Проверка четного отрицательного",  !validate.validate(-80));
        assertTrue("Проверка нечетного положичетльного",  !validate.validate(79));
        assertTrue("Проверка нечетного отрицательного",  !validate.validate(-79));
    }
}
