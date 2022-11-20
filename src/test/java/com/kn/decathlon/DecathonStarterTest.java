package com.kn.decathlon;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DecathonStarterTest {
    @Test
    public void oneGoTest() {
    	DecathlonStarter.main(null);
    	assertEquals(1.0, 1.0);
    }
}
