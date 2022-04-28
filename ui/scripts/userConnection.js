const baseUrl = 'http://localhost:8080/P1';
const registerUrl = `${baseUrl}/register`;
const loginUrl = `${baseUrl}/login`;
const usersUrl = `${baseUrl}/users`;

export async function registerRequest(newUser) {
    let response = await fetch(
        registerUrl,
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
    let response = await fetch(
        loginUrl,
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
        usersUrl,
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
    let response = await fetch(
        usersUrl,
        {
            method: "GET",
            headers: {
                userName: un
            }
        }
    );

    return response;
}

export async function getAllUsers() {
    let response = await fetch(
        usersUrl,
        {
            method: "GET",
            headers: {
            }
        }
    );

    return await response.json();
}

export async function deleteUser(un) {
    let response = await fetch(
        usersUrl,
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

