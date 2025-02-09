document.addEventListener("DOMContentLoaded", function () {
    const apiUrl = "http://localhost:8080/Java_Weather_app-1.0-SNAPSHOT/api/weather?city=Mumbai";

    fetch(apiUrl)
        .then(response => response.json())
        .then(data => {
            console.log("API Response:", data); // Debugging

            if (!data || data.length === 0) {
                console.error("No data received from API.");
                return;
            }

            const dates = data.map(entry => entry.date.split(" ")[0]);
            const temperatures = data.map(entry => entry.temp);

            console.log("Processed Dates:", dates);
            console.log("Processed Temperatures:", temperatures);

            const ctx = document.getElementById("weatherChart").getContext("2d");
            new Chart(ctx, {
                type: "line",
                data: {
                    labels: dates,
                    datasets: [{
                        label: "Temperature (°C)",
                        data: temperatures,
                        borderColor: "blue",
                        backgroundColor: "rgba(0, 0, 255, 0.2)",
                        fill: true
                    }]
                },
                options: {
                    responsive: true,
                    scales: {
                        x: { title: { display: true, text: "Date" } },
                        y: { title: { display: true, text: "Temperature (°C)" } }
                    }
                }
            });
        })
        .catch(error => console.error("Error fetching weather data:", error));
});
