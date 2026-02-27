package com.code4future.springbootthymeleafdemo.dto.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LoginForm {

    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "LoginForm{" +
                "email='" + email + '\'' +
                '}';
    }

    public static class EmployeeForm {
        private Long id;

        @NotBlank(message = "Full name must not be blank")
        @Size(min = 2, max = 30, message = "Full name must be between 2 and 30 characters")
        private String fullName;

        @NotBlank(message = "Email must not be blank")
        @Email(message = "The email is not in correct format")
        private String email;
        private String address;

        public EmployeeForm() {
        }

        public EmployeeForm(String fullName, String email, String address) {
            this.fullName = fullName;
            this.email = email;
            this.address = address;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }
}
