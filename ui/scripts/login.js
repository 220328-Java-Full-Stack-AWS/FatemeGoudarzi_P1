import {loginRequest} from "./userConnection.js";
import {openAlertMessage,closeAlertMessage} from "./alertbox.js"

const loginElm = document.getElementById("login-btn");
loginElm.addEventListener('click',submitForm)

async function submitForm() {
        
    let authDto = {
        userName: document.getElementById("username").value,
        passWord: document.getElementById("password").value
    }
   
        let response = await loginRequest(authDto);
        console.log("Response: ", response);
        const result=  await response.json();
    
        if (response.status == 200) {
            localStorage.setItem("authToken", response.headers.get("authToken"));
            localStorage.setItem("userId", result.userId);
            localStorage.setItem("roleId", result.roleId);
            //navigate the window to the landing page
            window.location.href = "./landingPage.html";
    
        } else if(response.status ==401) {
            openAlertMessage("Unable to log in! Check your username and password!");
        }

   
}