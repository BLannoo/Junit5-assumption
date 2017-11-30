package com.cegeka.junit5;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Tag;

@Tag("class")
public class TagDemo {

    @Test
    @Tag("development")
    @Tag("production")
    void testCaseA() { //run in all environments
        Assert.fail();
    }

    @Test
    @Tag("development")
    void testCaseB() {
    }

    @Test
    @Tag("development")
    void testCaseC() {
    }

}
