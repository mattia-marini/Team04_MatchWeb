function getAge(birthDateStr, minAge = 18) {
    const today = new Date();
    const birthDate = new Date(birthDateStr);

    let age = today.getFullYear() - birthDate.getFullYear();

    // adjust if birthday hasn't happened yet this year
    const hasHadBirthday =
        today.getMonth() > birthDate.getMonth() ||
        (today.getMonth() === birthDate.getMonth() && today.getDate() >= birthDate.getDate());

    if (!hasHadBirthday) {
        age--;
    }

    return age
}

function showAlertMsg(text) {
    document.getElementById("front-end-error-text").innerText = text
    document.getElementById("front-end-error-container").hidden = false;
}

function checkPassword() {
    const password = passwordField.value;
    const confirmPassword = confirmPasswordField.value;

    const regex = {
        length: password.length >= 8,
        special: /[^A-Za-z0-9]/.test(password),
        number: (password.match(/\d/g) || []).length >= 2,
        lowercase: /[a-z]/.test(password)
    };

    let isWellFormed = false;
    if (password.length < 9) {
        passwordFormatField.innerText = "La passowrd deve avere almeno 9 caratteri"
    } else if (!regex.lowercase) {
        passwordFormatField.innerText = "La passowrd deve contenere almeno un carattere minuscolo"
    } else if (!regex.number) {
        passwordFormatField.innerText = "La passowrd deve contenere almeno due numeri"
    } else if (!regex.special) {
        passwordFormatField.innerText = "La passowrd deve contenere almeno carattere speciale"
    } else if (password !== "utente!team_04") {
        passwordFormatField.innerText = "La passowrd deve essere 'utente!team_04'"
    } else if (password !== confirmPassword) {
        passwordFormatField.innerText = "Le passowrd non coincidono"
    } else {
        isWellFormed = true
    }
    passwordFormatField.hidden = isWellFormed

    return isWellFormed
}


document.getElementById("reg-form").addEventListener("submit", e => {
    e.preventDefault();

    if (!e.currentTarget.checkValidity()) {
        e.currentTarget.reportValidity();
        return;
    }


    // check confirm password
    const password = document.getElementById("password").value;
    const confirmPassword = document.getElementById("confirmPassword").value;
    if (password !== confirmPassword) {
        showAlertMsg("Le due password non coincidono!");
        return;
    }

    // check 18+
    const age = new Date(document.getElementById("birthDate").value);
    if (getAge(age) < 18) {
        showAlertMsg("L'utente deve essere maggiorenne per accedere al servizio");
        return;
    }

    // check that soccer is selected
    if (document.getElementById("sport").value !== "CALCIO") {
        showAlertMsg("Servizio non disponibile! Servizi disponibili: Calcio");
        return;
    }

    // check passwords
    if (!checkPassword()) {
        showAlertMsg("Per favore ricontrolla le password!");
        return;
    }


    e.currentTarget.submit()
})

const passwordField = document.getElementById("password");
const confirmPasswordField = document.getElementById("confirmPassword");
const passwordFormatField = document.getElementById("passwordFormatField")


passwordField.addEventListener("input", ev => {
    checkPassword()
})
confirmPasswordField.addEventListener("input", ev => {
    checkPassword()
})