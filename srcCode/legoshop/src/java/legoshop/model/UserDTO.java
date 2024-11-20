/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package legoshop.model;


public class UserDTO {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String avatar;
    private String userName;
    private String password;
    private String address;
    private String phone;
    private int roleID;

    public UserDTO() {
    }

    public UserDTO(int id, String firstName, String lastName, String email, String avatar, String userName, String password, String address, String phone, int roleID) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.avatar = avatar;
        this.userName = userName;
        this.password = password;
        this.address = address;
        this.phone = phone;
        this.roleID = roleID;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    @Override
    public String toString() {
        return "UserDTO{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", avatar=" + avatar + ", userName=" + userName + ", password=" + password + ", address=" + address + ", phone=" + phone + ", roleID=" + roleID + '}';
    }
    
    
}
