
window.onload =function (){
    queruStudent();
}
function queruStudent(){
   /* let mytable =$("#mytable");
    let stuName = $("#stuName").val();
    let stuAge = $("#stuAge").val();
    let stuSex = $("#stuSex").val();
    let stuFamily = $("#stuFamily").val();
    let UserVo ={stuName,stuAge,stuSex,stuFamily};
    $.get("/findUser",{stu:JSON.stringify(UserVo)},function (date){
        mytable.empty();
        let arr = JSON.parse(date);
        for (let i =0;i<arr.length;i++) {
            mytable.append("<tr><td>"+arr[i].stuId+"</td>" +
                "<td>"+arr[i].stuName+"</td>" +
                "<td>"+arr[i].stuAge+"</td>" +
                "<td>"+arr[i].stuSex+"</td>" +
                "<td>"+arr[i].stuFamily+"</td>" +
                "<td id='td_one'><a href='#' onclick='delUser("+arr[i].stuId+")'>删除</a>&nbsp;&nbsp;&nbsp;<a href='#'>修改</a></td></tr>");
        }
    });*/
    let mytable =$("#mytable");
    let stuName = $("#stuName").val();
    let stuAge = $("#stuAge").val();
    let stuSex = $("#stuSex").val();
    let stuFamily = $("#stuFamily").val();
    let UserVo ={stuName,stuAge,stuSex,stuFamily};
    $.ajax({
        url:"http://localhost:8080/findUser",
        type:'POST',
        dataType:'json',
        contentType:"application/json",
        data:JSON.stringify(UserVo),//转为json格式
        success:function (date){
            mytable.empty();
            let  arr = date;
            for (let i =0;i<arr.length;i++) {
                mytable.append("<tr><td>"+arr[i].stuId+"</td>" +
                    "<td>"+arr[i].stuName+"</td>" +
                    "<td>"+arr[i].stuAge+"</td>" +
                    "<td>"+arr[i].stuSex+"</td>" +
                    "<td>"+arr[i].stuFamily+"</td>" +
                    "<td id='td_one'><a href='#' onclick='delUser("+arr[i].stuId+")'>删除</a>&nbsp;&nbsp;&nbsp;<a href='#'>修改</a></td></tr>");
            }
        }
    })
}
function delUser(id){
    $.ajax({
        url:"http://localhost:8080/delUser/"+id,
        type:'get',
        dataType:'json',
        contentType:"application/json",
    /*    data:JSON.stringify(id),*/
        success:function (date){
           if (date){
               alert("删除成功");
               queruStudent();
           }else{
               alert("删除失败")
           }
        }
    })
}

function insertUser(){
    let mytable =$("#mytablea");
    let stuName = $("#stuNamea").val();
    let stuAge = $("#stuAgea").val();
    let stuSex = $("#stuSexa").val();
    let stuFamily = $("#stuFamilya").val();
    let UserVo ={stuName,stuAge,stuSex,stuFamily};
     $.ajax({
         url: "http://localhost:8080/insertUser",
         type: "POST",
         dataType: "json",
         contentType: "application/json",
         data: JSON.stringify(UserVo),
         success:function (date){
             if (date){
                 alert("增加成功");
                 queruStudent();
             }else {
                 alert("增加失败");
             }
         }
     })
}