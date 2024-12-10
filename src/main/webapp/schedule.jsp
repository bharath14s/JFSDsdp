<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Nomination Schedule</title>
</head>
<body>
    <h1>Add Nomination Schedule</h1>
    <form id="scheduleForm">
        <label for="startDate">Start Date:</label>
        <input type="date" id="startDate" name="startDate" required /><br><br>

        <label for="endDate">End Date:</label>
        <input type="date" id="endDate" name="endDate" required /><br><br>

        <label for="details">Details:</label>
        <textarea id="details" name="details" required></textarea><br><br>

        <button type="submit">Add Schedule</button>
    </form>

    <script>
        document.getElementById('scheduleForm').addEventListener('submit', async (event) => {
            event.preventDefault();
            const formData = {
                startDate: document.getElementById('startDate').value,
                endDate: document.getElementById('endDate').value,
                details: document.getElementById('details').value,
                createdBy: "Admin" // Dynamic user (you can change this based on login)
            };
            const response = await fetch('http://localhost:8080/api/schedules', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(formData)
            });
            if (response.ok) {
                alert('Schedule added successfully!');
            } else {
                alert('Failed to add schedule');
            }
        });
    </script>
</body>
</html>
