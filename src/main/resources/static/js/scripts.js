// scripts.js

// Confirm delete popup
document.addEventListener("DOMContentLoaded", function() {
    const deleteLinks = document.querySelectorAll(".btn-danger");
    deleteLinks.forEach(link => {
        link.addEventListener("click", function(e) {
            const confirmDelete = confirm("Are you sure you want to delete this employee?");
            if(!confirmDelete) e.preventDefault();
        });
    });
});

// Optional: small animation when form inputs focus
const inputs = document.querySelectorAll("input");
inputs.forEach(input => {
    input.addEventListener("focus", () => input.classList.add("animate__pulse"));
    input.addEventListener("blur", () => input.classList.remove("animate__pulse"));
});