package org.hattrickscoreboardl.debug;


import android.test.suitebuilder.TestSuiteBuilder;

import junit.framework.Test;
import junit.framework.TestSuite;


/**
 * A listbutton suite containing release tests like Hattrick Automatic authentication.
 */
public class DebugTests extends TestSuite {
    public static Test suite() {
        return new TestSuiteBuilder(DebugTests.class).includeAllPackagesUnderHere().build();
    }
}