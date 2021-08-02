package com.hibernateTest;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple SaveAlien.
 */
public class SaveAlienTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SaveAlienTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( SaveAlienTest.class );
    }

    /**
     * Rigourous Case1 :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}
