document.addEventListener('DOMContentLoaded', function () {
    // Character counter for review content
    const reviewContent = document.getElementById('reviewContent');
    const charCount = document.getElementById('charCount');
    const contentError = document.getElementById('content-error');
    const submitBtn = document.getElementById('submitBtn');
    const ratingInputs = document.querySelectorAll('input[name="rating"]');
    const ratingError = document.getElementById('rating-error');

    // Character counter
    reviewContent.addEventListener('input', function () {
        const length = this.value.length;
        charCount.textContent = length;

        // Show error if less than 100 characters
        if (length < 100) {
            contentError.style.display = 'block';
            validateForm();
        } else {
            contentError.style.display = 'none';
            validateForm();
        }
    });

    // Validate rating
    ratingInputs.forEach(input => {
        input.addEventListener('change', function () {
            ratingError.style.display = 'none';
            validateForm();
        });
    });

    // Form validation
    function validateForm() {
        const isContentValid = reviewContent.value.length >= 100;
        const isRatingSelected = Array.from(ratingInputs).some(input => input.checked);

        // Enable submit button only if all validations pass
        submitBtn.disabled = !(isContentValid && isRatingSelected);
    }

    // Initial validation
    validateForm();

    // Form submission
    document.getElementById('reviewForm').addEventListener('submit', function (event) {
        // Prevent form submission if validation fails
        if (!submitBtn.disabled) {
            return true;
        }

        event.preventDefault();

        // Show appropriate error messages
        if (reviewContent.value.length < 100) {
            contentError.style.display = 'block';
        }

        if (!Array.from(ratingInputs).some(input => input.checked)) {
            ratingError.style.display = 'block';
        }
    });
});