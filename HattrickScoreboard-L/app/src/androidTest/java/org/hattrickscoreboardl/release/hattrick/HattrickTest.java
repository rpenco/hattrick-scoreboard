package org.hattrickscoreboardl.release.hattrick;


import android.test.suitebuilder.TestSuiteBuilder;

import junit.framework.Test;
import junit.framework.TestSuite;


/**
 * A listbutton suite containing all tests for creating application.
 */
public class HattrickTest extends TestSuite {
    public static Test suite() {
        return new TestSuiteBuilder(HattrickTest.class).includeAllPackagesUnderHere().build();
    }
}