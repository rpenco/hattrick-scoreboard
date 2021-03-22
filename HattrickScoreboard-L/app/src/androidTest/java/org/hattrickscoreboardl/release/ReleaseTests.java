package org.hattrickscoreboardl.release;


import android.test.suitebuilder.TestSuiteBuilder;

import junit.framework.Test;
import junit.framework.TestSuite;


/**
 * A listbutton suite containing all debug tests not with Hattrick Automatic Authentication.
 */
public class ReleaseTests extends TestSuite {
    public static Test suite() {
        return new TestSuiteBuilder(ReleaseTests.class).includeAllPackagesUnderHere().build();
    }
}