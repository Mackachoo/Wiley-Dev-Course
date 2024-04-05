var apiURL = "http://dvd-library.us-east-1.elasticbeanstalk.com/dvds/";

$(document).ready(function () {
    fetchData();
});

$("#createButton").click(function () { });

$("#searchForm").submit(function (event) {
    event.preventDefault();

    var term = $("#searchTerm").val();
    var category = $("#selectCategory").val();
});

function fetchData() {
    $.ajax({
        url: apiURL,
        method: "GET",
        success: function (dvds) {
            // Clear previous table data
            $("#resultTable tbody").empty();    // This doesn't seem to work...

            console.log(dvds)

            // Iterate through the response data and create table rows
            dvds.forEach(function (dvd) {
                var row = $("<tr>");
                $("<td>").text(dvd.title).appendTo(row);
                $("<td>").text(dvd.releaseYear).appendTo(row);
                $("<td>").text(dvd.director).appendTo(row);
                $("<td>").text(dvd.rating).appendTo(row);
                console.log(row);
                row.appendTo($("#resultTable tbody"));
            });

        },
        error: function (error) {
            console.log("Error:", error);
        }
    });
}

