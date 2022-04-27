import{getUser} from "./userConnection.js";
import{newReimbursement,getAllReimbursement} from "./reimbursementConnection.js"

const reimbSubmitBtn = document.getElementById('submit-reimb-btn');
const registerElm = document.getElementById('register');
const allReimbElm = document.getElementById('all-reimb-btn');
let reimb =[];
reimbSubmitBtn.addEventListener('click',reimbCreate);
registerElm.addEventListener('click',registerAccount);
allReimbElm.addEventListener('click', () => {
  window.location.href = "./report.html";
});

let authorizedUser = localStorage.getItem("authToken");
console.log("authorizedUser: ", authorizedUser);

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
  if(roleId == 2){
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
 const result=  await response.json();
 console.log("Response: ", response);
 

 if (response.status == 201) {
      alert(`Successfully Submitted!\n Your reimbursment Id is : result.${response.reimbursementId}`);
      document.getElementById("reimb-type").value=101;
      document.getElementById("amount").value='';
      document.getElementById("description").value="";
  } else {
      alert("Unable to submit!");
  }

}


