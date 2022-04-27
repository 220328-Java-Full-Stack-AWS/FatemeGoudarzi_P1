
export async function registerRequest(newUser) {
    let userResourceURL = "http://localhost:8080/P1/register";
    let response = await fetch(
        userResourceURL,
        {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
                "mode": "register"
            },
            body: JSON.stringify(newUser)
        }
    );
    return response;
}

export async function loginRequest(authDto) {
  let userResourceURL = "http://localhost:8080/P1/login";
    let response = await fetch(
        userResourceURL,
        {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
                "mode": "login"
            },
            body: JSON.stringify(authDto)
        }
    );

    return response;
}

export async function updateUserRequest(user) {
    
    let response = await fetch(
        userResourceURL,
        {
            method: "PUT",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(user)
        }
    );

    return response;
}

export async function getUser(un) {
    let userResourceURL = `http://localhost:8080/P1/users`;

    let response = await fetch(
        userResourceURL,
        {
            method: "GET",
            headers: {
                userName: un
            }
        }
    );

    return response;
}

export async function deleteUser(un) {
    let response = await fetch(
        userResourceURL,
        {
            method: "DELETE",
            headers: {
                username: un
            },
            body: JSON.stringify(user)
        }
    );

    return response;
}

