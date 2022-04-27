import {registerRequest} from "./userConnection.js";
import {openAlertMessage,closeAlertMessage} from "./alertbox.js"
const registerElm = document.getElementById("register-btn");
registerElm.addEventListener('click',submitForm)



async function submitForm() {
    let firstName = document.getElementById("firstname").value;               
    let lastName = document.getElementById("lastname").value
    let randomNumber= Math.floor(Math.random()*1000)
    let username =`${firstName}${lastName}${randomNumber}`
    let email=`${username}@reva.com`             
    document.getElementById("username").value=username;
    document.getElementById("email").value=email;
    let newUser = {
        firstName: firstName,
        lastName: lastName,
        userName: username,
        email: email,
        passWord: document.getElementById("password").value
    }
    console.log(newUser);

    let response = await registerRequest(newUser);

    console.log("Response: ", response);
    console.log("Response JSON: ", response.json());

    if (response.status == 201) {
        openAlertMessage("user account successfully created.");
        //navigate the window to the landing page
         //window.location.href = "./landingPage.html";

    } else {
        openAlertMessage("Unable to register!");
    }

}