document.addEventListener("DOMContentLoaded", function () {
    const token = localStorage.getItem("accessToken");

    if (!token) {
        alert("Please login first!");
        window.location.href = "signIn.html";
        return;
    }
    console.log("Logged in");
});

