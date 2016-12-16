package ru.innopolis.uni.course3.homework;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innopolis.uni.cource3.homework.BusinessLogic.Sum;
import ru.innopolis.uni.cource3.homework.Validator.ValidatorURL;

import static org.junit.Assert.assertTrue;

/**
 * Created by korot on 15.12.2016.
 */
public class ValidatorURLTest {
    private static Logger logger = LoggerFactory.getLogger(ValidatorURLTest.class);

    @Test
    public void validate(){
        ValidatorURL validatorURL = new ValidatorURL();
        String url = "http://www.oracle.com/technetwork/articles/java/index-137868.html";
        String path = "C:\\Projects\\Java\\Innopolis\\homework1\\src\\main\\java\\ru\\innopolis\\uni\\cource3\\homework";
        String url1 = "http://www.oracle.com/index.html";

        assertTrue("URL корректен", validatorURL.validate(url));
        assertTrue("URL корректен", validatorURL.validate(url1));
        assertTrue("URL корректен", !validatorURL.validate(path));

    }

}
