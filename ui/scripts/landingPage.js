import{getUser} from "./userConnection.js";
import{newReimbursement} from "./reimbursementConnection.js"

const reimbSubmitBtn = document.getElementById('submit-reimb-btn');
const registerElm = document.getElementById('register');

reimbSubmitBtn.addEventListener('click',reimbCreate);
registerElm.addEventListener('click',registerAccount)
let authorizedUser = localStorage.getItem("authToken");
console.log("authorizedUser: ", authorizedUser);

/*
This is a self-invoking function. To build one, wrap the function declaration in ()
then add another pair of () at the end to act as the parameter list. Effectively
as soon as the function is defined it is called.
*/
(async function displayUser() {
  let response = await getUser(authorizedUser);
  let json = await response.json();
  console.log("Response: ", response);
  console.log("Response JSON: ", json);
  let header ="Welcome, " + json.firstName +" "+ json.lastName;
  document.getElementById("header-title").innerText = header;
})(); 

function registerAccount(){
  let roleId = localStorage.getItem("roleId").toLowerCase();
  if(roleId == "admin"){
      window.location.href="./register.html";
  }  else {
      alert("Sorry!You are not authorized to register an account!");
  }
}

async function reimbCreate(){
  let reimbType=document.getElementById("reimb-type").value;
  let amount=document.getElementById("amount").value;
  let description=document.getElementById("description").value;
  console.log(reimbType, amount,description);  
  const timeStamp = Date.now();
  const newReimbursementData=
  {       
      "creationDate": timeStamp,
      "reimbursementTypeId":reimbType,
      "reimbursementDescription":description,
      "reimbursementAmount":amount,
      "reimbursementCreator":localStorage.getItem("userId")
 }
 console.log(newReimbursementData);
 let response = await newReimbursement(newReimbursementData);
 if (response.status == 201) {
      alert("Successfully Submitted!");
      document.getElementById("reimb-type").value=101;
      document.getElementById("amount").value='';
      document.getElementById("description").value="";
  } else {
      alert("Unable to submit!");
  }

}


