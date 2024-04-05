$("#weatherForm").submit(async function (event) {
    event.preventDefault(); // Prevent default form submission behavior
    var zipCode = $('#zipCodeInput').val();
    if (!zipCode || zipCode.length != 5) {
        var errorDiv = $('<div>').addClass('alert alert-danger').text('Please enter a valid 5 digit zip code');
        $('#zipError').html(errorDiv);
        return;
    } else {
        $('#zipError').html("");
    }
    var units = $('#unitsSelect').val();

    $.ajax({
        type: 'GET',
        url: 'http://api.openweathermap.org/geo/1.0/zip?zip=' + zipCode + ',US&appid=838f1487ba59fd8646fb3e8aa3620ac2',
        success: function (loc) {
            console.log('✔ GeoAPI', loc);

            // Current Weather Request
            $.ajax({
                type: 'GET',
                url: 'https://api.openweathermap.org/data/2.5/weather?lat=' + loc.lat + '&lon=' + loc.lon + '&units=' + units + '&appid=838f1487ba59fd8646fb3e8aa3620ac2',
                success: function (weather) {
                    var weatherDiv = $('#weatherDisplay');
                    console.log('✔ Weather API', weather);

                    var weatherIcon = 'http://openweathermap.org/img/wn/' + weather.weather[0].icon + '.png';
                    var weatherDesc = weather.weather[0].description;
                    var weatherTemp = weather.main.temp;
                    var weatherFeelsLike = weather.main.feels_like;
                    var weatherHumidity = weather.main.humidity;
                    var weatherWindSpeed = weather.wind.speed;

                    var tempUnit = units == "metric" ? 'C' : 'F';
                    var speedUnit = units == "metric" ? 'kmh' : 'mph';

                    weatherDiv.html(
                        '<h3>Current Weather in ' + loc.name + '</h3>' +
                        '<div class="row align-items-stretch justify-content-around">' +
                        '<div class="col-4 alert alert-primary d-flex flex-column align-items-center justify-content-center"><img width="100" src="' + weatherIcon + '" alt="Weather Icon">' +
                        '<h4>' + capitalizeFirstLetter(weatherDesc) + '</h4></div>' +
                        '<div class="col-4 alert alert-primary d-flex flex-column align-items-right justify-content-center">' +
                        'Temperature: ' + weatherTemp + '°' + tempUnit + '<br/>' +
                        'Feels Like: ' + weatherFeelsLike + '°' + tempUnit + '<br/>' +
                        'Humidity: ' + weatherHumidity + '%<br/>' +
                        'Wind Speed: ' + weatherWindSpeed + ' ' + speedUnit + '<br/>' +
                        '</div>' +
                        '</div>');
                },
                error: function () {
                    console.log('✘ Weather API');
                }
            });

            // Future Weather Request
            $.ajax({
                type: 'GET',
                url: 'https://api.openweathermap.org/data/2.5/forecast?lat=' + loc.lat + '&lon=' + loc.lon + '&units=' + units + '&appid=838f1487ba59fd8646fb3e8aa3620ac2',
                success: function (forecast) {
                    var weatherDiv = $('#forecastDisplay');
                    console.log('✔ Forecast API', forecast);
                    var htmlDiv = '<h3>Five Day Forecast</h3><div class="row text-center align-items-stretch justify-content-between">';

                    var tempUnit = units == "metric" ? 'C' : 'F';
                    var currentDate;
                    var tempHigh;
                    var tempLow;
                    var descs;

                    $.each(forecast.list, function (index, weather) {
                        var date = new Date(weather.dt_txt);
                        if (!currentDate) {
                            // Start first Day
                            currentDate = date;
                            tempHigh = -9999;
                            tempLow = 9999;
                            descs = [];
                        }
                        if (currentDate.getDate() != date.getDate()) {
                            // Display Day
                            var weatherMode = descs.sort((a, b) =>
                                descs.filter(v => v.desc === a.desc).length
                                - descs.filter(v => v.desc === b.desc).length).pop();
                            var weatherIcon = 'http://openweathermap.org/img/wn/' + weatherMode.icon + '.png';
                            var weatherDesc = weatherMode.description;

                            htmlDiv += '' +
                                '<div class="col-2 alert alert-dark">' +
                                '<h5>' + currentDate.toLocaleString('en-US', { day: 'numeric', month: 'long' }) + '</h5>' +
                                '<img width="100" src="' + weatherIcon + '" alt="Weather Icon">' +
                                '<h4>' + capitalizeFirstLetter(weatherDesc) + '</h4>' +
                                'Highs: ' + tempHigh + '°' + tempUnit + '<br/>' +
                                'Lows: ' + tempLow + '°' + tempUnit +
                                '</div>';

                            // Reset Day
                            currentDate = date;
                            tempHigh = -9999;
                            tempLow = 9999;
                            descs = [];
                        }
                        if (currentDate.getDate() == date.getDate()) {
                            // Add time to Day
                            if (weather.main.temp_max > tempHigh) {
                                tempHigh = weather.main.temp_max;
                            }
                            if (weather.main.temp_min < tempLow) {
                                tempLow = weather.main.temp_min;
                            }
                            console.log(descs);
                            descs.push(weather.weather[0]);
                        }

                    })

                    htmlDiv += '</div>';
                    weatherDiv.html(htmlDiv);
                },
                error: function () {
                    console.log('✘ Forecast API');
                }
            });


        },
        error: function () {
            console.log('✘ GeoAPI');
            $('#weatherDisplay').html('<div class="alert alert-warning">GeoAPi did not find location based on your zip code!</div>');
        }
    });
});

function capitalizeFirstLetter(str) {
    var words = str.split(" ");
    var capitalizedWords = words.map(function (word) {
        return word.charAt(0).toUpperCase() + word.substring(1);
    });
    return capitalizedWords.join(" ");
}
