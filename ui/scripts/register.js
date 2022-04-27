import {registerRequest} from "./userConnection.js";
const registerElm = document.getElementById("register-btn");
registerElm.addEventListener('click',submitForm)

async function submitForm() {
    let newUser = {
        firstName: document.getElementById("firstName").value,
        lastName: document.getElementById("lastName").value,
        userName: document.getElementById("userName").value,
        email: document.getElementById("email").value,
        passWord: document.getElementById("password").value
    }
    console.log(newUser);

    let response = await registerRequest(newUser);

    console.log("Response: ", response);
    console.log("Response JSON: ", response.json());

    if (response.status == 201) {
        alert("user account successfully created.")
        //navigate the window to the landing page
         window.location.href = "./landingPage.html";

    } else {
        alert("Unable to register!");
    }

}