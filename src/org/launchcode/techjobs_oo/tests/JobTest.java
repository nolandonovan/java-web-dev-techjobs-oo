package org.launchcode.techjobs_oo.tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;
import java.util.regex.Pattern;
import static org.junit.Assert.*;


public class JobTest {
    Job jobOne;
    Job jobTwo;
    Job jobThree;
    Job jobFour;

    @Before
    public void createJobObjects(){
        jobOne = new Job();
        jobTwo = new Job();
        jobThree = new Job(
                "Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence")
        );
        jobFour = new Job(
                "Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence")
        );
    }

    @Test
    public void testSettingJobId(){
        assertFalse(jobOne.getId() == jobTwo.getId());
        assertTrue((jobTwo.getId() - jobOne.getId()) == 1);
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        // test Job constructor sets the correct class and value for each field
        // fields: id, name, employer, location, positionType, and coreCompetency
        // data types: int, String, Employer, Location, PositionType, and CoreCompetency

        //test classes
        assertTrue( jobThree instanceof  Job );
        assertTrue( jobThree.getId() == (int) jobThree.getId());
        assertTrue( jobThree.getName() instanceof  String );
        assertTrue( jobThree.getEmployer() instanceof  Employer );
        assertTrue( jobThree.getLocation() instanceof  Location );
        assertTrue( jobThree.getPositionType() instanceof  PositionType );
        assertTrue( jobThree.getCoreCompetency() instanceof  CoreCompetency );

        //test values
        assertEquals("Product tester", jobThree.getName());
        assertEquals("ACME", jobThree.getEmployer().getValue());
        assertEquals("Desert", jobThree.getLocation().getValue());
        assertEquals("Quality control", jobThree.getPositionType().getValue());
        assertEquals("Persistence", jobThree.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality(){
        assertFalse(jobThree.equals(jobFour));
    }

    @Test
    public void testJobToStringFormat(){
        assertTrue(Pattern.matches("\n(.*\n){6}" , jobThree.toString() ) );
    }

    @Test
    public void testToStringReturnsNotExists(){
        Job job = new Job();
        assertEquals("OOPS! This job does not seem to exist.",job.toString());
    }

    @Test
    public void testToStringReturnsDataNotAvailable(){
        Job job = new Job(
                "Product tester",
                new Employer(""),
                new Location(),
                new PositionType(" "),
                new CoreCompetency("Persistence")
        );

        String expectedOutput = "\nID: 5\n" +
                "Name: Product tester\n" +
                "Employer: Data not available\n" +
                "Location: Data not available\n" +
                "Position Type: Data not available\n" +
                "Core Competency: Persistence\n";

        assertEquals(expectedOutput,job.toString());
    }

}
