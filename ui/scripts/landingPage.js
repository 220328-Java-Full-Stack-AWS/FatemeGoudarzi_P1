
const reimbSubmitBtn = document.getElementById('submit-reimb-btn');

reimbSubmitBtn.addEventListener('click',reimbCreate);
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

function clickHandler(element){
  let elm_name = element.name;
  let roleId = localStorage.getItem("roleId").toLowerCase();
  if(roleId == "admin" && elm_name=="register"){
      window.location.href="./register.html";
  }
  else if(roleId != "admin" && elm_name=="register")
  {
      alert("You are not authorized to register an account!")
  }
  else if(elm_name=="settings"){
      window.location.href="./settings.html";
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


