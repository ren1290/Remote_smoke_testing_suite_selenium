document.addEventListener("DOMContentLoaded", function () {
    // Your JavaScript code here

    function displayFormResults(formData) {
        var modal = document.getElementById("myModal");
        var modalContent = document.getElementById("modal-content");
        modalContent.innerHTML = `
            <h2 class="form-heading"><b>Test completed successfully</b></h2>
            <h4 class="form-sub-heading"><b>Please find the below results</b></h4>
            <div class="online-form">
                <p><b>URL Submitted: </b><span>${formData.url}</span></p>
                <p><b>Browsers Selected: </b><span>${formData.browsers.join(", ")}</span></p>
                ${formData.isElement ? '<p>The expected element is available on the page.</p>' : '<p>The expected element is not available on the page.</p>'}
            </div>`;
        modal.style.display = "block";
    }

    function showAlert() {
        var urlValue = document.getElementById("urlInput").value;
        var selectedCbox = document.querySelectorAll('input[type="checkbox"]');
        var isChecked = Array.from(selectedCbox).some(function (checkbox) {
            return checkbox.checked;
        });

        if (!isChecked) {
            document.getElementById('browserError').textContent = "Please select at least one browser.";
        } else {
            document.getElementById('browserError').textContent = "";
            var formData = {
                url: urlValue,
                browsers: []
            };
            selectedCbox.forEach(function (cb) {
                if (cb.checked) {
                    formData.browsers.push(cb.value);
                }
            });
            formData.isElement = true; // Update isElement based on your condition
            displayFormResults(formData);
        }

        return false; // Prevent form submission
    }

    function closeModal() {
    var modal = document.getElementById("myModal");
    modal.style.display = "none";
}
});