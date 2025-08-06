$("#signInBtn").click(function(event) {
    event.preventDefault();

    let username = $("#username").val();
    let password = $("#password").val();

    if (username === ""||password === "") {
        alert("Please enter username and password");
        return;
    }

    $.ajax({
        type: "POST",
        url: "http://localhost:8080/auth/login",
        data: JSON.stringify({ username: username, password: password }),
        contentType: "application/json",
        success: function(response) {
            alert("Login successful!\nResponse from server: " + response.message);
            // Store the JWT token in localStorage
            console.log(response.data.accessToken);
            if (!localStorage.getItem("accessToken")) {
                localStorage.setItem("accessToken", response.data.accessToken);
            }
            window.location.href = "dashboard.html";// Redirect to the main page
        },
        error: function(response) {
            let errMsg = "An error occurred!";
            if (response.responseJSON && response.responseJSON.message) {
                errMsg = response.responseJSON.message;
            }
            alert(errMsg);
        }
    });


});