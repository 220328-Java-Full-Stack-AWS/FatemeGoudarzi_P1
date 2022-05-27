import { getAllReimbursement, deleteReimbursement, updateReimbursement } from "./reimbursementConnection.js"
import { getAllUsers } from "./userConnection.js";
document.addEventListener("DOMContentLoaded", onload);

const ReimbursementType = {
    101: "Food",
    201: "Travel",
    301: "Lodging",
    401: "Others"
}
const StatusType = {
    10: "NEW",
    20: "APPROVED",
    30: "PENDING",
}
let reimbursements = [];
let users = {};

const roleId = window.localStorage.getItem("roleId");

async function onload() {
    reimbursements = await getAllReimbursement();
    const usersList = await getAllUsers()
    users = usersList.reduce((acc, user) => {
        acc[user.userId] = `${user.firstName} ${user.lastName}`;
        return acc
    }, {});
    fillReport();
};
function removeReport() {
    document.getElementById("table").remove();
}
function fillReport() {
    var table = document.createElement('table');
    table.id = 'table';
    document.getElementById("report").appendChild(table)
    var header = table.createTHead();
    var row = header.insertRow(0);

    row.insertCell(0).innerText = "Id";
    row.insertCell(1).innerText = "Creator";
    row.insertCell(2).innerText = "Description";
    row.insertCell(3).innerText = "Creation date";
    row.insertCell(4).innerText = "Resolution date";
    row.insertCell(5).innerText = "Status";
    row.insertCell(6).innerText = "Type";
    row.insertCell(7).innerText = "Approve";
    row.insertCell(8).innerText = "Deny";
    row.insertCell(9).innerText = "Delete";
    row.insertCell(10).innerText = "Edit";
    reimbursements.forEach(element => {

        var tr = document.createElement('tr');
        if (element.reimbursementStatus === 20) {
            tr.classList.add("reimbursementApproved");
        }
        if (element.reimbursementStatus === 30) {
            tr.classList.add("reimbursementDenied");
        }
        var td1 = document.createElement('td');
        var td11 = document.createElement('td');
        var td2 = document.createElement('td');
        var td3 = document.createElement('td');
        var td4 = document.createElement('td');
        var td5 = document.createElement('td');
        var td6 = document.createElement('td');
        var td7 = document.createElement('td');
        var td8 = document.createElement('td');
        var td9 = document.createElement('td');
        var td10 = document.createElement('td');

       
      
        const creationDate = new Date(element.creationDate)
        let resolutionDate
        if (element.resolutionDate != null) {
            resolutionDate = new Date(element.resolutionDate).toLocaleDateString();
        } else {
            resolutionDate = "";
        }

        let statusType = StatusType[element.reimbursementStatus]

        let type = ReimbursementType[element.reimbursementTypeId];

        td1.appendChild(document.createTextNode(element.reimbursementId));
        td11.appendChild(document.createTextNode(users[element.reimbursementCreator]))
        td2.appendChild(document.createTextNode(element.reimbursementDescription));
        td3.appendChild(document.createTextNode(creationDate.toLocaleDateString()));
        td4.appendChild(document.createTextNode(resolutionDate));
        td5.appendChild(document.createTextNode(statusType));
        td6.appendChild(document.createTextNode(type));

        const approveBtn = document.createElement('button');
        const denyBtn = document.createElement('button');
        const deleteBtn = document.createElement('button');
        const editBtn = document.createElement('button');

        approveBtn.innerText = "Approve";
        denyBtn.innerText = "Deny";
        deleteBtn.innerText = "Delete";
        editBtn.innerText = "Edit";

        approveBtn.addEventListener('click', () => approveDeny(element.reimbursementId, 20) );
        denyBtn.addEventListener('click', () => approveDeny(element.reimbursementId, 30));
        deleteBtn.addEventListener('click', () => onDelete(element.reimbursementId));
        approveBtn.disabled = roleId !== "3";
        denyBtn.disabled = roleId !== "3";
        td7.appendChild(approveBtn);
        td8.appendChild(denyBtn);
        td9.appendChild(deleteBtn);
        td10.appendChild(editBtn);
        deleteBtn.disabled = statusType !== "NEW";


        tr.appendChild(td1);
        tr.appendChild(td11);
        tr.appendChild(td2);
        tr.appendChild(td3);
        tr.appendChild(td4);
        tr.appendChild(td5);
        tr.appendChild(td6);
        tr.appendChild(td7);
        tr.appendChild(td8);
        tr.appendChild(td9);
        tr.appendChild(td10);

        table.appendChild(tr);
    })
}
async function approveDeny(id, reimbursementStatus) {
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


