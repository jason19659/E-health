
jQuery(document).ready(function() {

    /*
        Background slideshow
    */
    $.backstretch([
      "assets/img/backgrounds/1.jpg"
    , "assets/img/backgrounds/2.jpg"
    , "assets/img/backgrounds/3.jpg"
    , "assets/img/backgrounds/4.jpg"
    , "assets/img/backgrounds/5.jpg"
    , "assets/img/backgrounds/6.jpg"
    , "assets/img/backgrounds/7.jpg"
    , "assets/img/backgrounds/8.jpg"
    , "assets/img/backgrounds/9.jpg"
    ], {duration: 3000, fade: 750});

    /*
        Tooltips
    */
    $('.links a.home').tooltip();
    $('.links a.blog').tooltip();

    /*
        Form validation
    */
    $('.register form').submit(function(){
       
        ////
        var firstname = $(this).find('input#username').val();
        var lastname = $(this).find('input#phone').val();
        var email = $(this).find('input#email').val();
        var password = $(this).find('input#password').val();
        if(firstname == '') {
            $(this).find("label[for='username']").append("<span style='display:none' class='red'> - 请输入用户名.</span>");
            $(this).find("label[for='username'] span").fadeIn('medium');
            return false;
        }
        if(lastname == '') {
            $(this).find("label[for='phone']").append("<span style='display:none' class='red'> - 请输入电话.</span>");
            $(this).find("label[for='phone'] span").fadeIn('medium');
            return false;
        }
        if(email == '') {
            $(this).find("label[for='email']").append("<span style='display:none' class='red'> - 请输入合法的邮箱地址.</span>");
            $(this).find("label[for='email'] span").fadeIn('medium');
            return false;
        }
        if(password == '') {
            $(this).find("label[for='password']").append("<span style='display:none' class='red'> - 请输入合法的密码.</span>");
            $(this).find("label[for='password'] span").fadeIn('medium');
            return false;
        }
        if(repassword == '') {
            $(this).find("label[for='repassword']").append("<span style='display:none' class='red'> - 请输入合法的确认密码.</span>");
            $(this).find("label[for='repassword'] span").fadeIn('medium');
            return false;
        }
    });


});


