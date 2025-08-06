document.addEventListener("DOMContentLoaded", function () {
    const token = localStorage.getItem("accessToken");

    if (!token) {
    alert("Please login first!");
    window.location.href = "signIn.html";
    return;
    }

    console.log(token);

    // First: Try Admin
    $.ajax({
    type: "GET",
    url: "http://localhost:8080/hello/admin",
    headers: {
    "Authorization": "Bearer " + token
    },

    success: function (response) {
    console.log("🛡️ Logged in as ADMIN");
    $("#roleSet").text("Role: Admin");
    /*document.body.innerHTML += `<p>${response}</p>`;*/
    // You can redirect to admin dashboard here
    },

    error: function () {
    // If not admin, try user
            $.ajax({
            type: "GET",
            url: "http://localhost:8080/hello/user",
            headers: {
            "Authorization": "Bearer " + token
            },

            success: function (response) {
            console.log("👤 Logged in as USER");
            $("#roleSet").text("Role: User");
            /*document.body.innerHTML += `<p>${response}</p>`;*/
            // You can redirect to user dashboard here
            },

            error: function () {
            alert("❌ Unauthorized! Your token is invalid or expired.");
            window.location.href = "signIn.html";
            }
        });
    }
    });
});

//Logout Btn --> Remove Token and Refresh
$("#logoutBtn").click(function () {
    localStorage.removeItem("accessToken");
    location.reload();

})

