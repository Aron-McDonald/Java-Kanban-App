/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package newpackage;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
/**
 *
 * @author Aron McDonald
 */
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;

public class ProgramTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUp() {
        // Populate arrays with test data
        Program.developers = new String[]{"Mike Smith", "Edward Harrison", "Samantha Paulson", "Glenda Oberholzer"};
        Program.taskNames = new String[]{"Create Login", "Create Add Features", "Create Reports", "Add Arrays"};
        Program.taskIDs = new int[]{1, 2, 3, 4};
        Program.taskDurations = new int[]{5, 8, 2, 11};
        Program.taskStatuses = new String[]{"To Do", "Doing", "Done", "To Do"};
    }

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outputStream));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testPopulateArrays_DevelopersCorrectlyPopulated() {
        String[] expectedDevelopers = {"Mike Smith", "Edward Harrison", "Samantha Paulson", "Glenda Oberholzer"};
        Assert.assertArrayEquals(expectedDevelopers, Program.developers);
    }

    @Test
    public void testDisplayDeveloperAndDuration_LongestTask() {
        // Set the longest task duration to 11
        int expectedDuration = 11;

        // Call the method to find the task with the longest duration
        Program.displayLongestTask();

        // Capture the printed output
        String printedOutput = outputStream.toString().trim();

        // Assert that the expected developer and duration are displayed
        Assert.assertTrue(printedOutput.contains("Developer: Glenda Oberholzer"));
        Assert.assertTrue(printedOutput.contains("Duration: 11 hours"));
    }

    @Test
    public void testSearchTaskByName_TaskFound() {
        String searchName = "Create Reports";
        // Call the method to search for the task by name
        Program.searchTaskByName(searchName);

        // Capture the printed output
        String printedOutput = outputStream.toString().trim();

        // Assert that the expected task details are displayed
        Assert.assertTrue(printedOutput.contains("Task Name: Create Reports"));
        Assert.assertTrue(printedOutput.contains("Developer: Samantha Paulson"));
        Assert.assertTrue(printedOutput.contains("Task Status: Done"));
    }

    @Test
    public void testSearchTasksByDeveloper_TasksFound() {
        String searchDeveloper = "Mike Smith";
        // Call the method to search for tasks assigned to a specific developer
        Program.searchTasksByDeveloper(searchDeveloper);

        // Capture the printed output
        String printedOutput = outputStream.toString().trim();

        // Assert that the expected tasks details are displayed
        Assert.assertTrue(printedOutput.contains("Task Name: Create Login"));
        Assert.assertTrue(printedOutput.contains("Task Status: To Do"));
    }

    @Test
    public void testDeleteTaskByName_TaskDeleted() {
        String taskNameToDelete = "Create Add Features";
        // Call the method to delete the task by name
        Program.deleteTaskByName(taskNameToDelete);

        // Assert that the task is deleted from the arrays
        Assert.assertFalse(taskNameFound(Program.taskNames, taskNameToDelete));
    }

    @Test
public void testDisplayReport_ReportDisplayed() {
    // Call the method to display the task details report
    Program.displayTaskDetails();

    // Capture the printed output
    String printedOutput = outputStream.toString().trim();

    // Assert that the expected task details are displayed
    Assert.assertTrue(printedOutput.contains("Task Name: Create Login"));
    Assert.assertTrue(printedOutput.contains("Developer: Mike Smith"));
    Assert.assertTrue(printedOutput.contains("Task Status: To Do"));

    Assert.assertTrue(printedOutput.contains("Task Name: Create Add Features"));
    Assert.assertTrue(printedOutput.contains("Developer: Edward Harrison"));
    Assert.assertTrue(printedOutput.contains("Task Status: Doing"));

    Assert.assertTrue(printedOutput.contains("Task Name: Create Reports"));
    Assert.assertTrue(printedOutput.contains("Developer: Samantha Paulson"));
    Assert.assertTrue(printedOutput.contains("Task Status: Done"));

    Assert.assertTrue(printedOutput.contains("Task Name: Add Arrays"));
    Assert.assertTrue(printedOutput.contains("Developer: Glenda Oberholzer"));
    Assert.assertTrue(printedOutput.contains("Task Status: To Do"));
}


    // Helper method to check if a task name exists in an array of task names
    private boolean taskNameFound(String[] taskNames, String searchName) {
        for (String name : taskNames) {
            if (name.equals(searchName)) {
                return true;
            }
        }
        return false;
    }
}
