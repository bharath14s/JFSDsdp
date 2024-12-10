<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Nomination Schedule</title>
</head>
<body>
    <h1>Nomination Schedule</h1>
    <div id="scheduleList"></div>

    <script>
        async function fetchSchedules() {
            const response = await fetch('http://localhost:8080/api/schedules');
            const schedules = await response.json();
            const scheduleList = document.getElementById('scheduleList');
            scheduleList.innerHTML = schedules.map(schedule =>
                `<div>
                    <h3>${schedule.details}</h3>
                    <p>From: ${new Date(schedule.startDate).toLocaleDateString()} 
                    To: ${new Date(schedule.endDate).toLocaleDateString()}</p>
                </div>`
            ).join('');
        }
        fetchSchedules();
    </script>
</body>
</html>
