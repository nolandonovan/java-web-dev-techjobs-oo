package org.launchcode.techjobs_oo.tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;
import static org.junit.Assert.*;

public class JobTest {
    Job jobOne;
    Job jobTwo;

    @Before
    public void createJobObjects(){
        Job jobOne = new Job();
        Job jobTwo = new Job();
    }

    @Test
    public void testSettingJobId(){
        assertFalse(jobOne.getId() == jobTwo.getId());
        assertTrue((jobTwo.getId() - jobOne.getId()) == 1);
    }

}
