loadJobsTable();

let selectedJobId = null;
let selectedJob = null;

//Save Jobs in database
$(document).ready(function () {
    $('#saveJobBtn').on('click', function () {
        // Get values from form
        let job = {
            jobTitle: $('#jobTitle').val(),
            company: $('#companyName').val(),
            location: $('#jobLocation').val(),
            type: $('#jobType').val(),
            jobDescription: $('#jobDescription').val(),
            status: "success"
        };

        // Send AJAX request
        $.ajax({
            url: 'http://localhost:8080/api/v1/job/create', // Adjust URL as per your backend
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(job),
            success: function () {
                Swal.fire({
                    title: "Job saved successfully!",
                    icon: "success",
                    draggable: true
                })
                loadJobsTable();
            }
            ,
            error:function () {
                Swal.fire({
                    title: 'Error!',
                    text: 'Error saving job! Please try again.',
                    icon: 'error',
                    confirmButtonText: 'Ok'
                })
            }

        });
    });
});


//Load Jobs Table
function loadJobsTable() {
    $.ajax({
        url: 'http://localhost:8080/api/v1/job/getAll',
        type: 'GET',
        success: function (jobs) {
            let tableBody = $('#jobsTable tbody');
            tableBody.empty();
            jobs.forEach(job => {
                tableBody.append(`
                    <tr>
                        <td>${job.id}</td>
                        <td>${job.jobTitle}</td>
                        <td>${job.company}</td>
                        <td>${job.location}</td>
                        <td>${job.type}</td>
                        <td>${job.status}</td>
                        <td>
                            <button class="btn btn-sm btn-warning edit-btn" data-id="${job.id}" data-bs-toggle="modal" data-bs-target="#editJobModal">Edit</button>
                            <button class="btn btn-sm btn-danger delete-btn" data-id="${job.id}">Delete</button>
                        </td>
                    </tr>
                `);
            });
            paginateTable();
        },
        error: function () {
            Swal.fire({
                title: 'Error!',
                text: 'Error loading jobs! Please try again.',
                icon: 'error',
                confirmButtonText: 'Ok'
            })
        }
    });
}


//Row Selection
/*$('#jobsTable tbody').on('click', 'tr', function () {
    $('#jobsTable tbody tr').removeClass('table-active');
    $(this).addClass('table-active');

    selectedJobId=$(this).find('td:eq(0)').text().trim();
    console.log("Selected Id: "+selectedJobId);

});*/

$(document).ready(function () {
    $("#jobsTableBody").on("click", "tr", function () {
        $("#jobsTableBody tr td").removeClass("table-active"); // Remove highlight from all cells
        $(this).find("td").addClass("table-active"); // Highlight only the clicked row's cells

        selectedJobId=$(this).find('td:eq(0)').text().trim();
        console.log("Selected Id: "+selectedJobId);
    });
});


//Fill Update modal fields
$('#jobsTable').on('click', '.edit-btn', function () {
    //Send Ajax request to get job details
    $.ajax({
        url: 'http://localhost:8080/api/v1/job/get/' + $(this).data('id'),
        type: 'GET',
        success: function (job) {
            $('#editJobTitle').val(job.jobTitle);
            $('#editCompanyName').val(job.company);
            $('#editJobLocation').val(job.location);
            $('#editJobType').val(job.type);
            $('#editJobDescription').val(job.jobDescription);
            selectedJobId = job.id;
        },
        error: function () {
            Swal.fire({
                title: 'Error!',
                text: 'Error loading job details! Please try again.',
                icon: 'error',
                confirmButtonText: 'Ok'
            })
        }
    });
});


//Update Job
$('#updateJobBtn').on('click', function () {
    let updatedJob = {
        id: selectedJobId,
        jobTitle: $('#editJobTitle').val(),
        company: $('#editCompanyName').val(),
        location: $('#editJobLocation').val(),
        type: $('#editJobType').val(),
        jobDescription: $('#editJobDescription').val(),
        status: "success"
    };

    // Send AJAX request to update job
    $.ajax({
        url: 'http://localhost:8080/api/v1/job/update',
        type: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify(updatedJob),
        success: function () {
            Swal.fire({
                title: "Job updated successfully!",
                icon: "success",
                draggable: true
            });
            loadJobsTable();
            $('#editJobModal').modal('hide');
        },
        error:function () {
            Swal.fire({
                title: 'Error!',
                text: 'Error updating job! Please try again.',
                icon: 'error',
                confirmButtonText: 'Ok'
            })
        }
    });
});

//Delete Job
$('#jobsTable').on('click', '.delete-btn', function() {
    $.ajax({
        url: 'http://localhost:8080/api/v1/job/delete/' + $(this).data('id'),
        type: 'DELETE',
        success: function() {
            Swal.fire({
                title: "Job deleted successfully!",
                icon: "success",
                draggable: true
            });
            loadJobsTable();
        },
        error:function () {
            Swal.fire({
                title: 'Error!',
                text: 'Error deleting job! Please try again.',
                icon: 'error',
                confirmButtonText: 'Ok'
            })
        }
    });
});


//Search Job by keyword
$('#searchInput').on('keyup', function() {
    let keyword = $(this).val().toLowerCase();
    if (keyword == "") {
        loadJobsTable(); // Reload the full table if search input is empty
        currentPage = 1; // Reset to first page after search
        paginateTable();
        return;
    }

    // Filter the table rows based on the keyword
    $.ajax({
       url: 'http://localhost:8080/api/v1/job/search/'+ keyword,
       type: 'GET',
         success: function(jobs) {
           if (jobs.length > 0) {
               let tableBody = $('#jobsTable tbody');
               tableBody.empty();
               jobs.forEach(job => {
                   tableBody.append(`
                    <tr>
                        <td>${job.id}</td>
                        <td>${job.jobTitle}</td>
                        <td>${job.company}</td>
                        <td>${job.location}</td>
                        <td>${job.type}</td>
                        <td>${job.status}</td>
                        <td>
                            <button class="btn btn-sm btn-warning edit-btn" data-id="${job.id}" data-bs-toggle="modal" data-bs-target="#editJobModal">Edit</button>
                            <button class="btn btn-sm btn-danger delete-btn" data-id="${job.id}">Delete</button>
                        </td>
                    </tr>
                `);
               });
               currentPage = 1; // Reset to first page after search
               paginateTable();



           }
           else{
               $('#jobsTable tbody').empty(); // Clear the table if no results found
                Swal.fire({
                     title: 'No Results Found',
                     text: 'No jobs found matching your search criteria.',
                     icon: 'info',
                     confirmButtonText: 'Ok'
                })
               currentPage = 1; // Reset to first page after search
               paginateTable();

           }
         },
        error: function () {
            Swal.fire({
                title: 'Error!',
                text: 'Error searching jobs! Please try again.',
                icon: 'error',
                confirmButtonText: 'Ok'
            });
        }

    });
});

/*Pagination*/
const rowsPerPage = 5;
let currentPage = 1;

function paginateTable() {
    const table = document.getElementById("jobsTableBody");
    const rows = table.querySelectorAll("tr");
    const totalRows = rows.length;
    const totalPages = Math.ceil(totalRows / rowsPerPage);

    // Hide all rows
    rows.forEach((row, index) => {
        row.style.display = "none";
        if (index >= (currentPage - 1) * rowsPerPage && index < currentPage * rowsPerPage) {
            row.style.display = "";
        }
    });

    updatePaginationControls(totalPages);
}

const maxVisiblePages = 3;

function updatePaginationControls(totalPages) {
    const pagination = document.getElementById("pagination");
    pagination.innerHTML = '';

    // Previous button
    const prev = document.createElement('li');
    prev.className = `page-item ${currentPage === 1 ? 'disabled' : ''}`;
    prev.innerHTML = `<a class="page-link" href="#">Previous</a>`;
    prev.addEventListener('click', () => {
        if (currentPage > 1) {
            currentPage--;
            paginateTable();
        }
    });
    pagination.appendChild(prev);

    // Determine current group based on page
    const currentGroup = Math.floor((currentPage - 1) / maxVisiblePages);
    const startPage = currentGroup * maxVisiblePages + 1;
    const endPage = Math.min(startPage + maxVisiblePages - 1, totalPages);

    // Page numbers (e.g., 1 2 3 or 4 5 6)
    for (let i = startPage; i <= endPage; i++) {
        const li = document.createElement('li');
        li.className = `page-item ${i === currentPage ? 'active' : ''}`;
        li.innerHTML = `<a class="page-link" href="#">${i}</a>`;
        li.addEventListener('click', () => {
            currentPage = i;
            paginateTable();
        });
        pagination.appendChild(li);
    }

    // Next button
    const next = document.createElement('li');
    next.className = `page-item ${currentPage === totalPages ? 'disabled' : ''}`;
    next.innerHTML = `<a class="page-link" href="#">Next</a>`;
    next.addEventListener('click', () => {
        if (currentPage < totalPages) {
            currentPage++;
            paginateTable();
        }
    });
    pagination.appendChild(next);
}




