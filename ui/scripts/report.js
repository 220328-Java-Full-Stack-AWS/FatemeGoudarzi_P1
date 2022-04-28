import { getAllReimbursement, deleteReimbursement, updateReimbursement } from "./reimbursementConnection.js"
document.addEventListener("DOMContentLoaded", onload);

let reimbursements = [];

const roleId = window.localStorage.getItem("roleId");

async function onload() {
    reimbursements = await getAllReimbursement();
    fillReport();
};
function removeReport(){
    document.getElementById("table").remove();
}
function fillReport() {
    var table = document.createElement('table');
    table.id = 'table';
    document.getElementById("report").appendChild(table)
    var header = table.createTHead();
    var row = header.insertRow(0);
    
    row.insertCell(0).innerText = "Id";
    row.insertCell(1).innerText = "Description";
    row.insertCell(2).innerText = "Creation date";
    row.insertCell(3).innerText = "Resolution date";
    row.insertCell(4).innerText = "Status";
    row.insertCell(5).innerText = "Type";
    row.insertCell(6).innerText = "Approve";
    row.insertCell(7).innerText = "Deny";
    row.insertCell(8).innerText = "Delete";
    reimbursements.forEach(element => {
       
        var tr = document.createElement('tr');
        if (element.reimbursementStatus === 20) {
            tr.classList.add("reimbursementApproved");
        }
        if (element.reimbursementStatus === 30) {
            tr.classList.add("reimbursementDenied");
        }
        var td1 = document.createElement('td');
        var td2 = document.createElement('td');
        var td3 = document.createElement('td');
        var td4 = document.createElement('td');
        var td5 = document.createElement('td');
        var td6 = document.createElement('td');
        var td7 = document.createElement('td');
        var td8 = document.createElement('td');
        var td9 = document.createElement('td');

        var text1 = document.createTextNode(element.reimbursementId);
        var text2 = document.createTextNode(element.reimbursementDescription);
        const creationDate = new Date(element.creationDate)
        let resolutionDate
        if (element.resolutionDate != null) {
            resolutionDate = new Date(element.resolutionDate).toLocaleDateString();
        } else {
            resolutionDate = "";
        }

        const status = element.reimbursementStatus;
        let statusType = "";
        switch (status) {
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

        const TypeId = element.reimbursementTypeId;
        let type = "";

        switch (TypeId) {
            case 101:
                type = "Food";
                break;
            case 201:
                type = "Travel";
                break;
            case 301:
                type = "Lodging";
                break;
            case 401:
                type = "Others";
                break;
        }

        var text3 = document.createTextNode(creationDate.toLocaleDateString());
        var text4 = document.createTextNode(resolutionDate);
        var text5 = document.createTextNode(statusType);
        var text6 = document.createTextNode(type);

        td1.appendChild(text1);
        td2.appendChild(text2);
        td3.appendChild(text3);
        td4.appendChild(text4);
        td5.appendChild(text5);
        td6.appendChild(text6);

        const approveBtn = document.createElement('button');
        const denyBtn = document.createElement('button');
        const deleteBtn = document.createElement('button');

        approveBtn.innerText = "Approve";
        denyBtn.innerText = "Deny";
        deleteBtn.innerText = "Delete";

        approveBtn.addEventListener('click', () => approveDeny(element.reimbursementId, 20));
        denyBtn.addEventListener('click', () => approveDeny(element.reimbursementId, 30));
        deleteBtn.addEventListener('click', () => onDelete(element.reimbursementId));
        approveBtn.disabled = roleId !== "2";
        denyBtn.disabled = roleId !== "2";
        td7.appendChild(approveBtn);
        td8.appendChild(denyBtn);
        td9.appendChild(deleteBtn);
        deleteBtn.disabled = statusType !== "NEW";


        tr.appendChild(td1);
        tr.appendChild(td2);
        tr.appendChild(td3);
        tr.appendChild(td4);
        tr.appendChild(td5);
        tr.appendChild(td6);
        tr.appendChild(td7);
        tr.appendChild(td8);
        tr.appendChild(td9);

        table.appendChild(tr);
    })
}
async function approveDeny(id, reimbursementStatus ) {
    const index = reimbursements.findIndex(r => r.reimbursementId === id);
    const newReimbursement = { ...reimbursements[index] };
    newReimbursement.reimbursementStatus = reimbursementStatus;
    const updatedReimbursement = await updateReimbursement(newReimbursement);
    reimbursements[index] = updatedReimbursement;
    removeReport();
    fillReport();
};

async function onDelete(id) {
    const index = reimbursements.findIndex(r => r.reimbursementId === id);
    await deleteReimbursement(reimbursements[index].reimbursementId);
    reimbursements.splice(index, 1);
    removeReport();
    fillReport();
}


