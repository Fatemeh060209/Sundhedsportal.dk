const loginForm = document.getElementById("login-form");
const loginButton = document.getElementById("login-form-submit");
const loginErrorMsg = document.getElementById("login-error-msg");

loginButton.addEventListener("click", (e) => {
    e.preventDefault();
    const CPR = loginForm.CPR.value;
    const Kodeord = loginForm.Kodeord.value;

    if (CPR === "user" && Kodeord === "1") {
        location.replace('Sundhedsportal-Login.html');
      //  alert("You have successfully logged in.");


    } else {
        loginErrorMsg.style.opacity = 1;
    }
})