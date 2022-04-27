
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

    return response;
}

export async function deleteReimbursement(reimbursement) {
    let response = await fetch(
        reimbursementResourceURL,
        {
            method: "DELETE",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(reimbursement)
        }
    );

    return response;
}