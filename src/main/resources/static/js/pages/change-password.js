document.addEventListener('DOMContentLoaded', function () {
    // DOM elements
    const newPassword = document.getElementById('newPassword');
    const confirmPassword = document.getElementById('confirmPassword');
    const passwordMatchText = document.getElementById('password-match-text');
    const strengthText = document.getElementById('password-strength-text');
    const strengthMeter = document.getElementById('strength-meter');
    const submitBtn = document.getElementById('submitBtn');
    const form = document.getElementById('passwordChangeForm');

    // Password requirements elements
    const reqLength = document.getElementById('req-length');
    const reqUppercase = document.getElementById('req-uppercase');
    const reqLowercase = document.getElementById('req-lowercase');
    const reqNumber = document.getElementById('req-number');
    const reqSpecial = document.getElementById('req-special');

    // Password toggle functionality
    document.querySelectorAll('.password-toggle').forEach(toggle => {
        toggle.addEventListener('click', function () {
            const targetId = this.getAttribute('data-target');
            const inputField = document.getElementById(targetId);
            const icon = this.querySelector('i');

            if (inputField.type === 'password') {
                inputField.type = 'text';
                icon.classList.replace('fa-eye-slash', 'fa-eye');
            } else {
                inputField.type = 'password';
                icon.classList.replace('fa-eye', 'fa-eye-slash');
            }
        });
    });

    // Validate password strength and requirements
    function checkPasswordStrength(password) {
        const regex = {
            length: password.length >= 8,
            uppercase: /[A-Z]/.test(password),
            lowercase: /[a-z]/.test(password),
            number: /[0-9]/.test(password),
            special: /[^A-Za-z0-9]/.test(password)
        };

        // Calculate strength score
        let score = 0;
        if (regex.length) score += 20;
        if (regex.uppercase) score += 20;
        if (regex.lowercase) score += 20;
        if (regex.number) score += 20;
        if (regex.special) score += 20;

        return {score, regex};
    }

    // Update requirement icons based on validation
    function updateRequirementIcons(regex) {
        function updateIcon(element, isValid) {
            if (isValid) {
                element.classList.replace('fa-times-circle', 'fa-check-circle');
                element.classList.replace('text-muted', 'text-success');
            } else {
                element.classList.replace('fa-check-circle', 'fa-times-circle');
                element.classList.replace('text-success', 'text-muted');
            }
        }

        updateIcon(reqLength, regex.length);
        updateIcon(reqUppercase, regex.uppercase);
        updateIcon(reqLowercase, regex.lowercase);
        updateIcon(reqNumber, regex.number);
        updateIcon(reqSpecial, regex.special);
    }

    // Update the strength meter visuals
    function updateStrengthMeter(score) {
        // Update meter width
        strengthMeter.style.width = score + '%';

        // Remove existing classes
        strengthMeter.classList.remove('bg-danger', 'bg-warning', 'bg-success');

        // Add appropriate class based on strength
        if (score < 40) {
            strengthMeter.classList.add('bg-danger');
            strengthText.className = 'form-feedback strength-weak';
            strengthText.textContent = 'Password debole';
        } else if (score < 80) {
            strengthMeter.classList.add('bg-warning');
            strengthText.className = 'form-feedback strength-medium';
            strengthText.textContent = 'Password media';
        } else {
            strengthMeter.classList.add('bg-success');
            strengthText.className = 'form-feedback strength-strong';
            strengthText.textContent = 'Password forte';
        }
    }

    // Validate passwords and update UI accordingly
    function validatePasswords() {
        const newPwd = newPassword.value;
        const confirmPwd = confirmPassword.value;

        // Check password strength
        const {score, regex} = checkPasswordStrength(newPwd);

        // Update UI elements
        updateRequirementIcons(regex);
        updateStrengthMeter(score);

        // Check if passwords match
        if (confirmPwd) {
            passwordMatchText.style.display = (newPwd === confirmPwd) ? 'none' : 'block';
        } else {
            passwordMatchText.style.display = 'none';
        }

        // Enable/disable submit button based on validation
        const allRequirementsMet = regex.length && regex.uppercase && regex.lowercase && regex.number && regex.special;
        const passwordsMatch = newPwd === confirmPwd;

        submitBtn.disabled = !(allRequirementsMet && passwordsMatch && confirmPwd);
    }

    // Add event listeners
    newPassword.addEventListener('input', validatePasswords);
    confirmPassword.addEventListener('input', validatePasswords);

    // Form submission validation
    form.addEventListener('submit', function (event) {
        if (!form.checkValidity()) {
            event.preventDefault();
            event.stopPropagation();
        }

        const newPwd = newPassword.value;
        const confirmPwd = confirmPassword.value;

        if (newPwd !== confirmPwd) {
            event.preventDefault();
            passwordMatchText.style.display = 'block';
        }

        form.classList.add('was-validated');
    });
});