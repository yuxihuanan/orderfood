$(function () {
    $("#picture").change(function () {
        var filePath = $(this).val();//获取文件路径
        fileFormat = filePath.substring(filePath.lastIndexOf(".")).toLowerCase();
        src = window.URL.createObjectURL(this.files[0]);
        if (!fileFormat.match(/.png|.jpg|.jpeg/)) {
            error_prompt_alert('上传错误,文件格式必须为：png/jpg/jpeg');
            return;
        }
        $('#pictureshow').attr('src', src);
    });
})