$("#signUpBtn").click(function (event) {
    event.preventDefault(); // 🔥 prevents the form from reloading the page

    let email = $("#email").val();
    let username = $("#username").val();
    let password = $("#password").val();

    if (email === "" || username === "" || password === "") {
        alert("Please fill in all fields.");
        return;
    }

    $.ajax({
        type: "POST",
        url: "http://localhost:8080/auth/register",
        data: JSON.stringify({ email: email, username: username, password: password, role: "USER" }),
        contentType: "application/json",
        success: function(response) {
            /*console.log("Signup successful. Response from server:", response);*/
            alert("Signup successful!\nResponse from server: " + response.message);
            window.location.href = "signIn.html"; // Fix path as needed
        },

        error: function(response) {
            let errMsg = "An error occurred!";
            if (response.responseJSON && response.responseJSON.message) {
                errMsg = response.responseJSON.message;
            }
            alert(errMsg);
            /*console.error("AJAX error:", response);*/
        }
    });
});
