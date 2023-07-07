/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpackage;

import javax.swing.JOptionPane;

/**
 *
 * @author Aron McDonald
 */
public class Task {
    private String taskName;                // Private member variable to store the task name
    private int taskNumber;                  // Private member variable to store the task number
    private String taskDescription;         // Private member variable to store the task description
    private String developerFirstName;   // Private member variable to store the developer's first name
    private String developerLastName;     // Private member variable to store the developer's last name
    private int taskDuration;                // Private member variable to store the task duration
    private String taskStatus;               // Private member variable to store the task status

    public Task(
        String taskName,
        int taskNumber,
        String taskDescription,
        String developerFirstName,
        String developerLastName,
        int taskDuration,
        String taskStatus
    ) {
        this.taskName = taskName;
        this.taskNumber = taskNumber;
        this.taskDescription = taskDescription;
        this.developerFirstName = developerFirstName;
        this.developerLastName = developerLastName;
        this.taskDuration = taskDuration;
        this.taskStatus = taskStatus;
    }
    // Constructor to initialize the Task object with the provided information.
    // Parameters:
    //   - taskName: The name of the task.
    //   - taskNumber: The number of the task.
    //   - taskDescription: The description of the task.
    //   - developerFirstName: The first name of the developer assigned to the task.
    //   - developerLastName: The last name of the developer assigned to the task.
    //   - taskDuration: The duration of the task in hours.
    //   - taskStatus: The status of the task.

    public boolean checkTaskDescription() {
        return taskDescription.length() <= 50;
    }
    // Method to check if the task description is within the specified length limit.
    // Returns:
    //   - true if the task description is less than or equal to 50 characters, false otherwise.

    public String createTaskID() {
        String taskID = taskName.substring(0, 2).toUpperCase() +
                        ":" +
                        taskNumber +
                        ":" +
                        developerFirstName.substring(developerFirstName.length() - 3).toUpperCase();
        return taskID;
    }
    // Method to create a unique task ID based on the task name, task number, and developer's first name.
    // Returns:
    //   - The generated task ID.

    // ...

    public String printTaskDetails() {
        String details = "Task Status: " + getTaskStatus() +
                    "\nDeveloper Details: " + developerFirstName + " " + developerLastName +
                    "\nTask Number: " + taskNumber +
                    "\nTask Name: " + taskName +
                    "\nTask Description: " + taskDescription +
                    "\nTask ID: " + createTaskID() +
                    "\nTask Duration: " + taskDuration + " hours";
    
        JOptionPane.showMessageDialog(null, details, "Task Details", JOptionPane.INFORMATION_MESSAGE);
    
        return details;
    }
    // Method to print the details of the task.
    // Returns:
    //   - A string containing the task details.

    public int returnTotalHours() {
        return taskDuration;
    }
    // Method to return the total duration of the task in hours.
    // Returns:
    //   - The task duration in hours.

    public String getTaskStatus() {
        // Implement the logic to get the task status from the user
        return taskStatus;
    }
    // Method to retrieve the task status.
    // Returns:
    //   - The task status.

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }
    // Method to set the task status.
    // Parameters:
    //   - taskStatus: The new task status to set.
    
    
    public String getTaskName() {
    return taskName;
}

public int getTaskNumber() {
    return taskNumber;
}

public String getTaskDescription() {
    return taskDescription;
}

public String getDeveloperFirstName() {
    return developerFirstName;
}

public String getDeveloperLastName() {
    return developerLastName;
}

public int getTaskDuration() {
    return taskDuration;
}

}


