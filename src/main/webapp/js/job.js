//$ => jquery
$(document).ready(function(){
    $(".btn-delete").click(function(){
        var id = $(this).attr("jobId")
        var This = $(this)
        $.ajax({
            method: "get",
            url: "http://localhost:8081/crm/api/job?id=" + id,
            // data: { name: "John", location: "Boston" } => Gửi tham số dạng post
        }).done(function( data ) {
            if(data.success){
                //Xoá thành công
                This.closest("tr").remove()
            }else{
                console.log(data)
                //Xoá thất bại
                alert("Xoá thất bại")
            }

        });
    })
})