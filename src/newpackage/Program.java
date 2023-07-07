/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpackage;

/**
 *
 * @author Aron McDonald
 */
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class Program {
    public static Account account = new Account();  // Create an instance of the Account class
    public static String accname;  // Declare a string variable to store the account name
    public static String accsurname;  // Declare a string variable to store the account surname
    public static String accusername;  // Declare a string variable to store the account username
    public static String accpassword;  // Declare a string variable to store the account password
    public static String inusername;  // Declare a string variable to store the inputted username during login
    public static String inpassword;  // Declare a string variable to store the inputted password during login
    
    // New variables for task functionality
    public static int numTasks;  // Declare an integer variable to store the number of tasks
    public static Task[] tasks;  // Declare an array of Task objects to store the tasks
    public static int totalHours;  // Declare an integer variable to store the total hours of all tasks
    
    // Arrays for task data
    public static String[] developers;
    public static String[] taskNames;
    public static int[] taskIDs;
    public static int[] taskDurations;
    public static String[] taskStatuses;

    
    public static void main(String[] args) {
        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1 - Create an account");
            System.out.println("2 - Login into an account");
            System.out.println("3 - Quit");

            Scanner input = new Scanner(System.in);  // Create a Scanner object to read user input
            int choice = input.nextInt();  // Read the user's choice

            if (choice == 1) {
                // Account creation code
                System.out.println("What is your name? ");
                input.nextLine();
                accname = input.nextLine();  // Read the user's name

                System.out.println("What is your surname? ");
                accsurname = input.nextLine();  // Read the user's surname

                System.out.println("Please enter a username");
                System.out.println("Your username must contain an underscore and be no more than 5 characters long ");
                accusername = input.nextLine();  // Read the user's username

                boolean validUsername = checkUsername(accusername);  // Check if the username is valid

                while (!validUsername) {
                    System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.");
                    accusername = input.nextLine();  // Read the user's username again
                    validUsername = checkUsername(accusername);  // Check if the updated username is valid
                }

                System.out.println("Please enter a password");
                System.out.println("Your password must contain at least 8 characters, a capital letter, a number and a special character ");
                accpassword = input.nextLine();  // Read the user's password

                boolean validPassword = checkPassword(accpassword);  // Check if the password is valid

                while (!validPassword) {
                    System.out.println("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.");
                    accpassword = input.nextLine();  // Read the user's password again
                    validPassword = checkPassword(accpassword);  // Check if the updated password is valid
                }

                System.out.println(registerUser());  // Register the user and print the registration message
            } else if (choice == 2) {
                // Login code
                System.out.println("Enter your username: ");
                Scanner input1 = new Scanner(System.in);
                inusername = input1.nextLine();  // Read the user's inputted username
                System.out.println("Enter your password: ");
                Scanner input2 = new Scanner(System.in);
                inpassword = input2.nextLine();  // Read the user's inputted password

                boolean loggedIn = loginUser();  // Check if the user is logged in
                if (loggedIn) {
                    initializeTasks();  // Initialize tasks for the logged-in user
                    runTaskMenu();  // Run the task menu
                }
            } else if (choice == 3) {
                break;  // Exit the program
            } else {
                System.out.println("Invalid choice");
            }
        }
    }
    
    
    

    public static boolean checkUsername(String accusername) {
        return accusername.contains("_") && accusername.length() < 6;  // Check if the username contains an underscore and is less than 6 characters long
    }

    public static boolean checkPassword(String accpassword) {
        Pattern pattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$");
        Matcher matcher = pattern.matcher(accpassword);
        return matcher.matches();  // Check if the password matches the specified pattern
    }

    public static boolean loginUser() {
        if (account.getUsername().equals(inusername) && account.getPassword().equals(inpassword)) {
            String welcomeMessage = "Welcome back to EasyKanban " + account.getName() + " " + account.getSurname() + ". It is great to see you again.";
            JOptionPane.showMessageDialog(null, welcomeMessage, "Login Successful", JOptionPane.INFORMATION_MESSAGE);
            return true;  // Return true if the username and password match the account details
        }

        String errorMessage = "Username or password incorrect, please try again.";
        JOptionPane.showMessageDialog(null, errorMessage, "Login Failed", JOptionPane.ERROR_MESSAGE);
        return false;  // Return false if the username or password is incorrect
    }

    public static String registerUser() {
        account.setName(accname);  // Set the account name
        account.setSurname(accsurname);  // Set the account surname
        account.setUsername(accusername);  // Set the account username
        account.setPassword(accpassword);  // Set the account password

        String register = "Your account has been created.";
        return register;  // Return the registration message
    }

    // Task-related methods
    public static void initializeTasks() {
        Scanner input = new Scanner(System.in);
        System.out.println("How many tasks do you want to enter?");
        numTasks = input.nextInt();  // Read the number of tasks to be entered
        tasks = new Task[numTasks];  // Create an array to store the tasks
        totalHours = 0;  // Initialize the total hours counter
        // Initialize arrays with size equal to numTasks
        developers = new String[numTasks];
        taskNames = new String[numTasks];
        taskIDs = new int[numTasks];
        taskDurations = new int[numTasks];
        taskStatuses = new String[numTasks];

        for (int i = 0; i < numTasks; i++) {
            System.out.println("Task " + (i + 1) + ":");
            Task task = createTask(i);  // Create a task
            tasks[i] = task;  // Add the task to the tasks array
            developers[i] = task.getDeveloperFirstName() + " " + task.getDeveloperLastName();
            taskNames[i] = task.getTaskName();
            taskIDs[i] = task.getTaskNumber();
            taskDurations[i] = task.getTaskDuration();
            taskStatuses[i] = task.getTaskStatus();

            totalHours += task.returnTotalHours();  // Add the task's duration to the total hours counter
            System.out.println(task.printTaskDetails());  // Print the task details
        }

        JOptionPane.showMessageDialog(null, "Total hours across all tasks: " + totalHours, "Total Hours", JOptionPane.INFORMATION_MESSAGE);

    }
    
     public static int calculateTotalHours() {
        int totalHours = 0;
        for (int duration : taskDurations) {
            totalHours += duration;
        }
        return totalHours;
     }
     
     public static void displayDoneTasks() {
        System.out.println("Tasks with the status 'Done':");
        for (int i = 0; i < taskStatuses.length; i++) {
            if (taskStatuses[i].equals("Done")) {
                System.out.println("Developer: " + developers[i]);
                System.out.println("Task Name: " + taskNames[i]);
                System.out.println("Task Duration: " + taskDurations[i] + " hours");
                System.out.println();
            }
        }
    }
     
      public static void displayLongestTask() {
        int longestDuration = 0;
        int longestTaskIndex = -1;

        for (int i = 0; i < taskDurations.length; i++) {
            if (taskDurations[i] > longestDuration) {
                longestDuration = taskDurations[i];
                longestTaskIndex = i;
            }
        
         }
        if (longestTaskIndex != -1) {
            System.out.println("Task with the longest duration:");
            System.out.println("Developer: " + developers[longestTaskIndex]);
            System.out.println("Task Duration: " + taskDurations[longestTaskIndex] + " hours");
        } else {
            System.out.println("No tasks found.");
        }
    }
     
    
     
     public static void searchTaskByName(String searchName) {
        boolean found = false;

        for (int i = 0; i < taskNames.length; i++) {
            if (taskNames[i].equals(searchName)) {
                System.out.println("Task found:");
                System.out.println("Task Name: " + taskNames[i]);
                System.out.println("Developer: " + developers[i]);
                System.out.println("Task Status: " + taskStatuses[i]);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Task not found.");
        }
    }
     
     
     public static void searchTasksByDeveloper(String searchDeveloper) {
        boolean found = false;

        for (int i = 0; i < developers.length; i++) {
            if (developers[i].equals(searchDeveloper)) {
                System.out.println("Task:");
                System.out.println("Task Name: " + taskNames[i]);
                System.out.println("Task Status: " + taskStatuses[i]);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No tasks assigned to the developer.");
        }
    }
     
     public static void deleteTaskByName(String taskName) {
        boolean deleted = false;

        for (int i = 0; i < taskNames.length; i++) {
            if (taskNames[i].equals(taskName)) {
                // Delete the task by shifting elements in arrays
                for (int j = i; j < taskNames.length - 1; j++) {
                    taskNames[j] = taskNames[j + 1];
                    developers[j] = developers[j + 1];
                    taskIDs[j] = taskIDs[j + 1];
                    taskDurations[j] = taskDurations[j + 1];
                    taskStatuses[j] = taskStatuses[j + 1];
                }

                // Set the last element to null or default values
                taskNames[taskNames.length - 1] = null;
                developers[taskNames.length - 1] = null;
                taskIDs[taskNames.length - 1] = 0;
                taskDurations[taskNames.length - 1] = 0;
                taskStatuses[taskNames.length - 1] = null;

                deleted = true;
                break;
            }
        }

        if (deleted) {
            System.out.println("Task deleted.");
        } else {
            System.out.println("Task not found.");
        }
    }
     
     public static void displayTaskDetails() {
        for (int i = 0; i < taskNames.length; i++) {
            System.out.println("Task " + (i + 1) + ":");
            System.out.println("Task Name: " + taskNames[i]);
            System.out.println("Developer: " + developers[i]);
            System.out.println("Task ID: " + taskIDs[i]);
            System.out.println("Task Duration: " + taskDurations[i] + " hours");
            System.out.println("Task Status: " + taskStatuses[i]);
            System.out.println();
        }
    }

    public static Task createTask(int taskNumber) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the task name:");
        String taskName = input.nextLine();  // Read the task name

        System.out.println("Enter a short description for the task (not exceeding 50 characters):");
        String taskDescription = input.nextLine();  // Read the task description

        while (taskDescription.length() > 50) {
            System.out.println("Please enter a task description of less than 50 characters:");
            taskDescription = input.nextLine();  // Read the task description again
        }
        
        System.out.println("Task successfully captured");

        System.out.println("Enter the developer's first name:");
        String developerFirstName = input.nextLine();  // Read the developer's first name

        System.out.println("Enter the developer's last name:");
        String developerLastName = input.nextLine();  // Read the developer's last name

        System.out.println("Enter the estimated duration of the task in hours:");
        int taskDuration = input.nextInt();  // Read the task duration

        input.nextLine(); // Consume the newline character after reading the integer
        
        System.out.println("Select the task status:");
        System.out.println("1 - To Do");
        System.out.println("2 - Done");
        System.out.println("3 - Doing");

        int statusChoice = input.nextInt();  // Read the task status choice
        String taskStatus;

        switch (statusChoice) {
            case 1:
                taskStatus = "To Do";
                break;
            case 2:
                taskStatus = "Done";
                break;
            case 3:
                taskStatus = "Doing";
                break;
            default:
                taskStatus = "To Do"; // Default status
                break;
        }

        Task task = new Task(taskName, taskNumber, taskDescription, developerFirstName, developerLastName, taskDuration, taskStatus);  // Create a task object
        return task;  // Return the created task
    }

   public static void runTaskMenu() {
        int choice = 0;

        while (choice != 7) {
            String menuOptions = "Choose an option:\n"
                    + "1 - Add tasks\n"
                    + "2 - Show report\n"
                    + "3 - Display tasks with status 'Done'\n"
                    + "4 - Display task with the longest duration\n"
                    + "5 - Search for a task by name\n"
                    + "6 - Search for tasks assigned to a developer\n"
                    + "7 - Delete a task by name\n"
                    + "8 - Display task details\n"
                    + "9 - Quit";

            choice = Integer.parseInt(JOptionPane.showInputDialog(null, menuOptions, "Task Menu", JOptionPane.PLAIN_MESSAGE));

            switch (choice) {
                case 1:
                    initializeTasks();
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Coming Soon", "Task Menu", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 3:
                    displayDoneTasks();
                    break;
                case 4:
                    displayLongestTask();
                    break;
                case 5:
                    String searchName = JOptionPane.showInputDialog(null, "Enter the task name to search:", "Search Task", JOptionPane.PLAIN_MESSAGE);
                    searchTaskByName(searchName);
                    break;
                case 6:
                    String searchDeveloper = JOptionPane.showInputDialog(null, "Enter the developer name to search:", "Search Developer", JOptionPane.PLAIN_MESSAGE);
                    searchTasksByDeveloper(searchDeveloper);
                    break;
                case 7:
                    String deleteName = JOptionPane.showInputDialog(null, "Enter the task name to delete:", "Delete Task", JOptionPane.PLAIN_MESSAGE);
                    deleteTaskByName(deleteName);
                    break;
                case 8:
                    displayTaskDetails();
                    break;
                case 9:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice", "Task Menu", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        }
    }
   
   
}
