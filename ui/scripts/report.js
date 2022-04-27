import{getAllReimbursement} from "./reimbursementConnection.js"
document.addEventListener("DOMContentLoaded", onload);

let reimb = [];
async function onload(){
    const result = await getAllReimbursement();
    var table = document.createElement('table');
    console.log(result);
    
document.getElementById("report").appendChild(table)
var header = table.createTHead();
var row = header.insertRow(0); 

row.insertCell(0).innerText="Id" ;
row.insertCell(1).innerText="Description" ;
row.insertCell(2).innerText="Creation date" ;
row.insertCell(3).innerText="Resolution date" ;
row.insertCell(4).innerText="Status" ;
row.insertCell(5).innerText="Type" ;

    result.forEach(element => {
        var tr = document.createElement('tr');   

        var td1 = document.createElement('td');
        var td2 = document.createElement('td');
        var td3 = document.createElement('td');
        var td4 = document.createElement('td');
        var td5 = document.createElement('td');
        var td6 = document.createElement('td');
        var td7 = document.createElement('td');
        var td8 = document.createElement('td');
    
        var text1 = document.createTextNode(element.reimbursementId);
        var text2 = document.createTextNode(element.reimbursementDescription);
        const creationDate = new Date(element.creationDate)
        let resolutionDate
        if(element.resolutionDate != null){
            resolutionDate = new Date(element.resolutionDate);
            resolutionDate.toLocaleDateString();
        }else{
            resolutionDate="";
        }
        
        var text3 = document.createTextNode(creationDate.toLocaleDateString());
        var text4 = document.createTextNode(resolutionDate);
        const status= element.reimbursementStatus;
        let statusType="";

        switch(status){
            case 10:
                statusType = "NEW";
                break;
            case 20:
                statusType = "APPROVED";
                break;
            case 30:
                statusType = "PENDING";
                break;
        }

        var text5 = document.createTextNode(statusType);
        var text6 = document.createTextNode(element.reimbursementTypeId);

        td1.appendChild(text1);
        td2.appendChild(text2);
        td3.appendChild(text3);
        td4.appendChild(text4);
        td5.appendChild(text5);
        td6.appendChild(text6);

        const approveBtn = document.createElement('button');
        const denyBtn = document.createElement('button');

        approveBtn.innerText="Approve";
        denyBtn.innerText="Deny";

        approveBtn.addEventListener('click' , approve);
        approveBtn.addEventListener('click' , deny);

        td7.appendChild(approveBtn);
        td7.appendChild(denyBtn);

        tr.appendChild(td1);
        tr.appendChild(td2);
        tr.appendChild(td3);
        tr.appendChild(td4);
        tr.appendChild(td5);
        tr.appendChild(td6);
        tr.appendChild(td7);
        tr.appendChild(td8);
    
        table.appendChild(tr);

    });

function approve(){};
function deny(){};

}
