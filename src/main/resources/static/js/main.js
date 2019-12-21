<!--show password when mouse is over eye icon-->
$(".show-password").hover(
    function () {
        $("#password").attr("type", "text").focus();
    },
    function () {
        $("#password").attr("type", "password");
    }
);

//remain scroll position after redirect
$(window).scroll(function () {
    sessionStorage.scrollTop = $(this).scrollTop();
});

$(document).ready(function () {
    if (sessionStorage.scrollTop !== "undefined") {
        $(window).scrollTop(sessionStorage.scrollTop);
    }
});

//DataTable plug-in
$(document).ready(function () {
    $('#sortableTable').DataTable(
        {
            columnDefs: [
                {
                    ordering: false,
                    targets: [6, 7]
                }
            ],
            pageLength: 25
        });
    $('.dataTables_length').addClass('bs-select');
});

//demo accounts
$(document).ready(function () {
    $("#demo-manager-btn").click(function () {
        $("#email").val("manager@mail.com");
        $("#password").val("112233");
    });
});
$(document).ready(function () {
    $("#demo-ann-btn").click(function () {
        $("#email").val("ann@mail.com");
        $("#password").val("112233");
    });
});
$(document).ready(function () {
    $("#demo-mark-btn").click(function () {
        $("#email").val("mark@mail.com");
        $("#password").val("112233");
    });
});
