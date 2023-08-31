//$ => jquery
$(document).ready(function(){
    $(".btn-delete").click(function(){
        var id = $(this).attr("memberId")
        var This = $(this)
        $.ajax({
            method: "get",
            url: "http://localhost:8081/crm/api/member?id=" + id,
            // data: { name: "John", location: "Boston" } => Gửi tham số dạng post
        }).done(function( data ) {
            if(data.success){
                //Xoá thành công
                This.closest("tr").remove()
            }else{
                //Xoá thất bại
                alert("Xoá thất bại")
            }

        });
    })
})