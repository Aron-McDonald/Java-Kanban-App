/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpackage;

/**
 *
 * @author Aron McDonald
 */
public class Account {
    private String name;        // Private member variable to store the account holder's name
    private String surname;     // Private member variable to store the account holder's surname
    private String username;    // Private member variable to store the account holder's username
    private String password;    // Private member variable to store the account holder's password

    public void setName(String nameInput) {
        this.name = nameInput;
    }
    // Method to set the account holder's name
    // Parameters:
    //   - nameInput: The name to set for the account holder

    public void setSurname(String surnameInput) {
        this.surname = surnameInput;
    }
    // Method to set the account holder's surname
    // Parameters:
    //   - surnameInput: The surname to set for the account holder

    public void setUsername(String usernameInput) {
        this.username = usernameInput;
    }
    // Method to set the account holder's username
    // Parameters:
    //   - usernameInput: The username to set for the account holder

    public void setPassword(String passwordInput) {
        this.password = passwordInput;
    }
    // Method to set the account holder's password
    // Parameters:
    //   - passwordInput: The password to set for the account holder

    public String getName() {
        return this.name;
    }
    // Method to retrieve the account holder's name
    // Returns:
    //   - The name of the account holder

    public String getSurname() {
        return this.surname;
    }
    // Method to retrieve the account holder's surname
    // Returns:
    //   - The surname of the account holder

    public String getUsername() {
        return this.username;
    }
    // Method to retrieve the account holder's username
    // Returns:
    //   - The username of the account holder

    public String getPassword() {
        return this.password;
    }
    // Method to retrieve the account holder's password
    // Returns:
    //   - The password of the account holder
}
