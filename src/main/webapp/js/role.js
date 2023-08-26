//$ => jquery
$(document).ready(function(){

    //$("selector") :
    // id : # (Dấu thăng)
    // class :  . (Dấu chấm)
    //find("selector")
    //this: đại diện cho thẻ đang xảy ra sự kiện click
    //parent(): Đi 1 cấp ra thằng cha của selector gọi
    //closest(): Đi ra n cấp chỉ định ( đi ra tổ tiên )
    //String template : `` để gọi code ${code}
    $(".btn-delete").click(function(){
        //Thêm html vào selector chỉ định
        // var html = `<tr>
        //        <td id="role_id" >8</td>
        //        <td>Role_Cứng</td>
        //        <td>Role ABCCSCASc</td>
        //        <td>
        //            <a href="#" class="btn btn-sm btn-primary btn-update">Sửa</a>
        //            <a href="#" roleId="8" class="btn btn-sm btn-danger btn-delete">Xóa</a>
        //        </td>
        //    </tr>`
        //
        // $("#role-body").append(html)

        var id = $(this).attr("roleId")
        var This = $(this)
        $.ajax({
            method: "get",
            url: "http://localhost:8081/crm/api/role?id=" + id,
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