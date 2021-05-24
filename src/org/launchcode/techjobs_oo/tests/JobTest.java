package org.launchcode.techjobs_oo.tests;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import org.launchcode.techjobs_oo.*;

public class JobTest {

    Job jobOne;
    Job jobTwo;
    @Before
    public void createJobObjects() {
        jobOne = new Job();
        jobTwo = new Job();
    }

    @Test
    public void testSettingJobId() {
        assertTrue(jobOne.getId() != jobTwo.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals(testJob.getName(), "Product tester");
        assertEquals(testJob.getEmployer().getValue(), "ACME");
        assertEquals(testJob.getLocation().getValue(), "Desert");
        assertEquals(testJob.getPositionType().getValue(), "Quality control");
        assertEquals(testJob.getCoreCompetency().getValue(), "Persistence");
    }

    @Test
    public void testJobsForEquality() {
        Job Job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job Job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(Job1.equals(Job2));
    }

    @Test
    public void testToStringNewLine() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals(" ", job.toString().substring(0, 1));
        assertEquals(" ", job.toString().substring(job.toString().length() - 1));
    }

    @Test
    public void testReturnLabel() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(job.toString().contains("ID: "));
        assertTrue(job.toString().contains("Name: "));
        assertTrue(job.toString().contains("Employer: "));
        assertTrue(job.toString().contains("Location: "));
        assertTrue(job.toString().contains("Position Type: "));
        assertTrue(job.toString().contains("Core Competency: "));
    }

    @Test
    public void testDataNotFound() {
        Job job = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        assertTrue(job.toString().contains("Name: Data not available"));
        assertTrue(job.toString().contains("Employer: Data not available"));
        assertTrue(job.toString().contains("Location: Data not available"));
        assertTrue(job.toString().contains("Position Type: Data not available"));
        assertTrue(job.toString().contains("Core Competency: Data not available"));
    }
}
