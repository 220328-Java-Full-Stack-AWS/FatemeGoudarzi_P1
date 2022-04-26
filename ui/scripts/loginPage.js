import {loginRequest} from "./userConnection.js"

const loginElm = document.getElementById("login-btn");
loginElm.addEventListener('click',submitForm)

async function submitForm() {
        
    let authDto = {
        userName: document.getElementById("username").value,
        passWord: document.getElementById("password").value
    }

    let response = await loginRequest(authDto);

    console.log("Response: ", response);
    console.log("Response JSON: ", await response.json());

    if (response.status == 200) {
        /*
        For this to work, you must send back a token in the header of the response
        The key should match the shown key name "authToken" and the value should be
        a string you can use to locally store information about the logged in user.
        In this case we are getting a token that contains the username string, and storing it.
        */
        let token = response.headers.get("authToken");
        localStorage.setItem("authToken", token);

        //navigate the window to the landing page
        window.location.href = "./landingPage.html";

    } else {
        alert("Unable to logasas in! Check username and password!");
    }
}