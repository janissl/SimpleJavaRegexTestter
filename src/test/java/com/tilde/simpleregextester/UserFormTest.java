/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tilde.simpleregextester;

import org.junit.Assert;
//import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author janis.slapins
 */
public class UserFormTest {
//    private static UserForm f;
//
//    @BeforeClass
//    public static void initUserForm() {
//        f = new UserForm();
//    }

    @Test
    public void testHasEscapeSequence(){
        UserForm f = new UserForm();
        Assert.assertFalse(f.hasEscapeSequence(""));
        Assert.assertFalse(f.hasEscapeSequence("\\s"));
        Assert.assertTrue(f.hasEscapeSequence("\\"));
        Assert.assertFalse(f.hasEscapeSequence("\\\\"));
        Assert.assertFalse(f.hasEscapeSequence("\\ "));
        Assert.assertTrue(f.hasEscapeSequence("abc\\\\\\"));
    }

    @Test
    public void testGetRegexGroups() {
        UserForm f = new UserForm();
        String rx = "a(bc)d(e)f";
        Assert.assertEquals(new ArrayList<>(Arrays.asList("a(bc)d(e)f", "(bc)", "(e)")), f.getRegexGroups(rx));
        rx = "a(b(c)de)f";
        Assert.assertEquals(new ArrayList<>(Arrays.asList("a(b(c)de)f", "(b(c)de)", "(c)")), f.getRegexGroups(rx));
    }
}
