import React, { useState } from 'react';

const UserForm = (props) => {
    const [firstName, setFirstName] = useState("");
    const [firstNameError, setFirstNameError] = useState("");
    const [lastName, setLastName] = useState("");
    const [lastNameError, setLastNameError] = useState("");
    const [email, setEmail] = useState("");
    const [emailError, setEmailError] = useState("");
    const [password, setPassword] = useState(""); 
    const [passwordError, setPasswordError] = useState("");
    const [confirmPassword, setConfirmPassword] = useState(""); 
    const [confirmPasswordError, setConfirmPasswordError] = useState("");

    const createUser = (e) => {
        e.preventDefault();
    
        const newUser = {firstName, lastName, email, password, confirmPassword};

        console.log("Welcome", newUser);

        setFirstName("");
        setLastName("");
        setEmail("");
        setPassword("");
        setConfirmPassword("");
    };

    const handleFirstName = (e) => {
        setFirstName(e.target.value);
        if(e.target.value.length === 0) {
            setFirstNameError("");
        } else if(e.target.value.length < 1) {
            setFirstNameError("First name is required!");
        } else if(e.target.value.length < 2) {
            setFirstNameError("First name must be 2 characters or longer!");
        } else {
            // an empty string is considered a "falsy" value
            setFirstNameError("");
        }
    }

    const handleLastName = (e) => {
        setLastName(e.target.value);
        if(e.target.value.length === 0) {
            setLastNameError("");
        } else if(e.target.value.length < 1) {
            setLastNameError("Last name is required!");
        } else if(e.target.value.length < 2) {
            setLastNameError("Title must be 2 characters or longer!");
        } else {
            setLastNameError("");
        }
    }

    const handleEmail = (e) => {
        setEmail(e.target.value);
        if(e.target.value.length === 0) {
            setEmailError("");
        } else if(e.target.value.length < 1) {
            setEmailError("Email is required!");
        } else if(e.target.value.length < 2) {
            setEmailError("Title must be 2 characters or longer!");
        } else {
            setEmailError("");
        }
    }

    const handlePassword = (e) => {
        setPassword(e.target.value);
        if(e.target.value.length === 0) {
            setPasswordError("");
        } else if(e.target.value.length < 1) {
            setPasswordError("Password is required!");
        } else if(e.target.value.length < 8) {
            setPasswordError("Password must be 8 characters or longer!");
        } else {
            setPasswordError("");
        }
    }

    const handlePasswordConfirm = (e) => {
        setConfirmPassword(e.target.value);
        if(e.target.value.length === 0 ){
            setConfirmPasswordError("")
        } else if(e.target.value.length < password.length || e.target.value.length > password.length) {
            setConfirmPasswordError("")
            // How can I make this happen only after the form is submitted?
        }else if(e.target.value.length !== password) {
            setConfirmPasswordError("Passwords must match");
        } else {
            setConfirmPasswordError("");
        }
    }

    return(
        <div>
            <form onSubmit={ createUser } >
                <div>
                    <label> First Name: </label>
                    <input type="text" value= {firstName} onChange= { handleFirstName } />
                    {
                        firstNameError ?
                        <p>{firstNameError}</p> :
                        ''
                    }
                </div>
                <div>
                    <label> Last Name: </label>
                    <input type="text" value= {lastName} onChange= { handleLastName } />
                    {
                        lastNameError ?
                        <p>{lastNameError}</p> :
                        ''
                    }
                </div>
                <div>
                    <label> Email Address: </label>
                    <input type="text" value= {email} onChange= { handleEmail } />
                    {
                        emailError ?
                        <p>{emailError}</p> :
                        ''
                    }
                </div>
                <div>
                    <label> Password: </label>
                    <input type="password" value= {password} onChange= { handlePassword } />
                    {
                        passwordError ?
                        <p>{passwordError}</p> :
                        ''
                    }
                </div>
                <div>
                    <label> Confirm Password: </label>
                    <input type="password" value= {confirmPassword} onChange= { handlePasswordConfirm } />
                    {
                        confirmPasswordError ?
                        <p>{confirmPasswordError}</p> :
                        ''
                    }
                </div>
                <div>
                    {
                        // is the falsey coming from the ternary or the handling function?
                        firstNameError || lastNameError || emailError || passwordError || confirmPasswordError ?
                        <input type="submit" value = "Create User" disabled /> :
                        <input type="submit" value=" Create User" />
                    }
                </div>
            </form>
        </div>
    );
};

export default UserForm; 