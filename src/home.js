var apiURL = "http://dvd-library.us-east-1.elasticbeanstalk.com/dvd";

$(document).ready(function () {
    fetchAllDvds();
});

// Main Page Functions --------------------------------------------------------

$("#searchForm").submit(function (event) {
    event.preventDefault();

    var term = $("#searchTerm").val();
    var category = $("#selectCategory").val();

    if (term === "" || category === "") {
        $('#callout').text("Please enter a search term and select a category.").show().delay(2000).fadeOut();
        return;
    }

    fetchDvdByCategory(category, term);
});

function displayTable(dvds) {
    console.log("Displaying DVDs in the table");
    $("#dvdTable tbody").empty();

    dvds.forEach(function (dvd) {
        var row = $("<tr>");
        $("<td>").html('<button class="btn" onclick="showDVD(' + dvd.id + ')">' + dvd.title + '</button>').appendTo(row);
        $("<td>").text(dvd.releaseYear).appendTo(row);
        $("<td>").text(dvd.director).appendTo(row);
        $("<td>").text(dvd.rating).appendTo(row);
        $("<td>").html('<button class="btn" onclick="editDVD(' + dvd.id + ')">Edit</button> | <button class="btn" onclick="deleteDVD(' + dvd.id + ')">Delete</button>').appendTo(row);
        row.appendTo($("#dvdTable tbody"));
    });

}

// Data Fetch Methods ---------------------------------------------------------

function fetchAllDvds() {
    console.log("Fetching all DVDs from the API...");
    $.ajax({
        url: apiURL + "s",
        method: "GET",
        success: dvds => displayTable(dvds),
        error: error => console.log("Error:", error)
    });
}

function fetchDvdByCategory(category, title) {
    console.log("Fetching DVDs via search form from the API...");
    $.ajax({
        url: apiURL + "s/" + category + "/" + title,
        method: "GET",
        success: dvds => displayTable(dvds),
        error: error => console.log("Error:", error)
    });
}

async function fetchDvd(id) {
    console.log("Fetching DVD", id + "...");
    let dvd = null;
    await $.ajax({
        url: apiURL + "/" + id,
        method: "GET",
        success: data => dvd = data,
        error: error => console.log("Error:", error)
    });
    return dvd;
}

// Data Manipulation Methods -------------------------------------------------

let activeID = null;

async function showDVD(id) {
    console.log("Show ID:", id);
    activeID = id;
    let dvd = await fetchDvd(id);
    $('#dvdModal .modal-title').text(dvd.title);
    $('#title').val(dvd.title);
    $('#releaseYear').val(dvd.releaseYear);
    $('#director').val(dvd.director);
    $('#rating').val(dvd.rating);
    $('#notes').val(dvd.notes);

    $('#dvdForm>fieldset').attr('disabled', 'disabled');
    $('#dvdModal .modal-footer').hide();
    $('#dvdModal').modal("show");
}

async function editDVD(id) {
    console.log("Edit ID:", id);
    activeID = id;
    let dvd = await fetchDvd(id);
    $('#dvdModal .modal-title').text("Edit DVD: " + dvd.title);
    $('#title').val(dvd.title);
    $('#releaseYear').val(dvd.releaseYear);
    $('#director').val(dvd.director);
    $('#rating').val(dvd.rating);
    $('#notes').val(dvd.notes);

    $('#dvdForm>fieldset').removeAttr('disabled');
    $('#dvdModal .modal-footer').show();
    $('#dvdModal').modal("show");
}

$("#createButton").click(async function () {
    console.log("Creating ID:");
    activeID = "";
    $('#dvdModal .modal-title').text("Create new DVD");

    $('#dvdForm>fieldset').removeAttr('disabled');
    $('#dvdModal .modal-footer').show();
    $('#dvdModal').modal("show");
});

$("#saveButton").click(async function (event) {
    event.preventDefault();
    console.log("Submitting DVD");
    let dvd = {
        dvdId: activeID === "" ? null : activeID,
        title: $('#title').val(),
        releaseYear: $('#releaseYear').val(),
        director: $('#director').val(),
        rating: $('#rating').val(),
        notes: $('#notes').val()
    };
    await $.ajax({
        url: apiURL + "/" + activeID,
        method: activeID === "" ? "POST" : "PUT",
        contentType: "application/json",
        data: JSON.stringify(dvd),
        success: success => console.log("Success ", success),
        error: error => console.log("Error:", error)
    });
    $('#dvdModal').modal("hide");
    fetchAllDvds();
});


async function deleteDVD(id) {
    console.log("Confim Deletion...");
    activeID = id;
    $('#deleteModal').modal("show");
}

$("#deleteButton").click(async function () {
    console.log("Deleting DVD ID:", activeID);
    await $.ajax({
        url: apiURL + "/" + activeID,
        method: "DELETE",
        success: success => console.log("Success:", success),
        error: error => console.log("Error:", error)
    });
    $('#deleteModal').modal("hide");
    fetchAllDvds();
});
