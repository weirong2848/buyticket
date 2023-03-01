;
! function() {
    var layer = layui.layer,
        form = layui.form,
        carousel = layui.carousel;

    // 鑳屾櫙鍥剧墖杞挱
    carousel.render({
        elem: '#login_carousel',
        width: '100%',
        height: '100%',
        interval: 3000,
        arrow: 'none',
        anim: 'fade',
        indicator: 'none'
    });

    // 楠岃瘉鐮佸€煎瓨鍌ㄥ彉閲�
    var vailCode;
    // 鎵ц鑾峰彇楠岃瘉鐮�
    refCode();

    // 鐐瑰嚮鍒锋柊楠岃瘉鐮�
    $("#refCode_login_img").on("click", function() {
        refCode();
    });

    // 鑾峰彇楠岃瘉鐮�
    function refCode() {
        $.ajax({
            url: "user/imageVailCode.do",
            type: "post",
            success: function(result) {
                vailCode = result.data.rand;
                $("#refCode_login_img").prop("src", "data:image/jpg;base64," + result.data.image);
                $("#code").val("");
            }
        });
    }

    // 鑷畾涔夐獙璇佽鍒�
    form.verify({
        account: function(value) {
            var regPhone = /^1[34578]\d{9}$/;
            if(!regPhone.test(value.trim())) {
                return "璇疯緭鍏ユ纭殑鎵嬫満鍙�";
            }
        },
        code: function(value) {
            if(value.toUpperCase() != vailCode) {
                refCode();
                return "楠岃瘉鐮佷笉姝ｇ‘";
            }
        }
    });

    //鐩戝惉鎻愪氦
    form.on("submit(login)", function() {
        $.ajax({
            url: "user/login.do",
            type: "post",
            data: {
                "account": $("#account").val(),
                "password": $("#password").val()
            },
            success: function(result) {
                if(result.status == 0) {
                    location = "index.html";
                } else {
                    refCode();
                    $("#password").val("");
                    layer.alert(result.msg, {
                        title: '鎻愪氦缁撴灉'
                    });
                }
            }
        });

        return false;
    });
}();