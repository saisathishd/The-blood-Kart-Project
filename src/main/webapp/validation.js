
		document.getElementById('Registration').addEventListener('submit', function(event) {
    if (!validateForm()) {
        event.preventDefault();
    }
});

function validateForm() {
    let isValid = true;

    // Clear previous errors
    document.querySelectorAll('error').forEach(error => error.textContent = '');

    // Name validation
    const name = document.getElementById('name');
    if (name.value.trim().length < 3 || name.value.trim().length > 20) {
        document.getElementById('nameError').textContent = 'Name must be between 3 and 20 characters long.';
        isValid = false;
    }

    // Mobile validation
    const mobile = document.getElementById('mobile');
    const mobilePattern = /^[6-9][0-9]{9}$/;
    if (!mobilePattern.test(mobile.value.trim())) {
        document.getElementById('mobileError').textContent = 'Enter a valid 10-digit mobile number starting with 6-9.';
        isValid = false;
    }

    // Email validation
    const email = document.getElementById('email');
    const emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;
    if (!emailPattern.test(email.value.trim())) {
        document.getElementById('emailError').textContent = 'Please enter a valid email address.';
        isValid = false;
    }

    // Password validation
    const password = document.getElementById('password');
    if (password.value.trim().length < 8) {
        document.getElementById('passwordError').textContent = 'Password must be at least 8 characters long.';
        isValid = false;
    }

    // Confirm Password validation
    const confirmPassword = document.getElementById('cfm');
    if (confirmPassword.value.trim() !== password.value.trim()) {
        document.getElementById('confirmPasswordError').textContent = 'Passwords do not match.';
        isValid = false;
    }

    return isValid;	
    }
    