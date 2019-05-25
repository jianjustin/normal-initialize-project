$('#username, #password').on('input', function() {
    if ($('#username').val() && $('#password').val()) {
        $('.login').addClass('buttonafter');
    } else {
        $('.login').removeClass('buttonafter');
    }
});

function login(obj) {
    $(obj).attr("disabled", true);

    var username = $.trim($('#username').val());
    var password = $.trim($('#password').val());
    if (username == "" || password == "") {
        $("#info").html('用户名或者密码不能为空');
        $(obj).attr("disabled", false);
    } else {
        $.ajax({
            type : 'post',
            url : '/login',
            data : $("#login-form").serialize(),
            success : function(data) {
                localStorage.setItem("token", data.token);
                location.href = '/swagger-ui.html';
            },
            error : function(xhr, textStatus, errorThrown) {
                var msg = xhr.responseText;
                var response = JSON.parse(msg);
                $("#info").html(response.message);
                $(obj).attr("disabled", false);
            }
        });

    }
}