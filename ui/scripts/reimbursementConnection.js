
let reimbursementResourceURL = "http://localhost:8080/P1/reimbursement";

export async function newReimbursement(newReimbursement) {
    let response = await fetch(
        reimbursementResourceURL,
        {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(newReimbursement)
        }
    );

    return response;
}

export async function getAllReimbursement() {
    const roleId = window.localStorage.getItem("roleId")
    let response = await fetch(
        reimbursementResourceURL,
        {
            method: "GET",
            headers: 
                { ... roleId === "2" ? 
                 {} :
                 { creator_id : window.localStorage.getItem("userId")}
            }
        }
    );
    return await response.json();
}

export async function getReimbursement(id) {
    let response = await fetch(
        reimbursementResourceURL,
        {
            method: "GET",
            headers: {
                reimbursementId: id
            }
        }
    );

    return response;
}

export async function updateReimbursement(reimbursement) {
    reimbursement.reimbursementResolver = window.localStorage.getItem("userId");
    reimbursement.resolutionDate = Date.now();
    let response = await fetch(
        reimbursementResourceURL,
        {
            method: "PUT",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(reimbursement)
        }
    );

    return await response.json();
}

export async function deleteReimbursement(reimbursementId) {
    await fetch(
        reimbursementResourceURL,
        {
            method: "DELETE",
            headers: {
                reimbursement_id : reimbursementId
            },
        }
    );
}