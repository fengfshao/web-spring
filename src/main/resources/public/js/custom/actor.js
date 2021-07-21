$(document).ready(function(){
  $('#submitActor').click(function() {
        var firstName = $('#firstNameInput').val();
        var lastName = $('#lastNameInput').val();

        var requestBody = {
            "firstName": firstName,
            "lastName": lastName
        }

        $.ajax({
            type: "POST",
            url: "/actor/add",
            data: JSON.stringify(requestBody),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function (data) {
                alert("success");
            },
            error: function (xhr, textStatus, errorThrown) {
                alert(textStatus);
            }
        });
    });
});



