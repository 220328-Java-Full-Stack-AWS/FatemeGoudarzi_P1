
const alertWindowElm = document.getElementById("alert-window");
const closeAlertElm = document.getElementById("close-alert-btn");
const messageTitleElm = document.getElementById("message-title");
closeAlertElm.addEventListener('click',closeAlertMessage);

export function openAlertMessage(message){  
    alertWindowElm.classList.remove('hidden');
    messageTitleElm.innerText=message;
}

export function closeAlertMessage(){  
    alertWindowElm.classList.add('hidden');
}

