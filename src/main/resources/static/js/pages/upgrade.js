document.getElementById('searchUsers').addEventListener('keyup', function () {
    let searchValue = this.value.toLowerCase();
    let rows = document.getElementById('usersTableBody').getElementsByTagName('tr');

    for (let i = 0; i < rows.length; i++) {
        let username = rows[i].getElementsByTagName('td')[0].textContent.toLowerCase();
        let fullName = rows[i].getElementsByTagName('td')[1].textContent.toLowerCase();
        let email = rows[i].getElementsByTagName('td')[3].textContent.toLowerCase();

        if (username.includes(searchValue) || fullName.includes(searchValue) || email.includes(searchValue)) {
            rows[i].style.display = '';
        } else {
            rows[i].style.display = 'none';
        }
    }
});


function toggleButton() {
    const checked = document.querySelectorAll('input[name="usernames"]:checked').length;
    document.getElementById("submitBtn").disabled = checked === 0;
}

document.querySelectorAll('input[name="usernames"]').forEach(cb => {
    cb.addEventListener("change", toggleButton);
});