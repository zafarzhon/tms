package com.example.homework51;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author zafarzhon
 * @link <a href="https://github.com/zafarzhon">github</a>
 */

public class StringValidationTest {
    private StringValidation validation = new StringValidation();
    @Test
    public void testIsContains(){

        //given when then
        Assertions.assertTrue(validation.isContains("zabc", "abc"));
        Assertions.assertTrue(validation.isContains("zAbc", "abC"));
        Assertions.assertTrue(validation.isContains("zAbc", "abc"));
        Assertions.assertTrue(validation.isContains("zabc", "aBc"));
        Assertions.assertFalse(validation.isContains(null, "abc"));
        Assertions.assertFalse(validation.isContains("zabc", null));


    }
}
// upper lower
// lower upper
// lower lower
// upper upper
// null  str
// str null
