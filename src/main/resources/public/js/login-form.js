$(document).ready(function (){
   $("#submit").click(function () {
      let usernameValue = $('input[name="username"]').val();
      let passwordValue = $('input[name="password"]').val();
      $('input[name="username"]').val("");
      $('input[name="password"]').val("");
      let inputData = { username: usernameValue, password: passwordValue };
      let dataToServer = JSON.stringify(inputData);
      console.log(dataToServer);
      $.ajax({
          type: "POST",
          url: "http://localhost:8080/form",
          data: dataToServer,
          dataType: "json",
          contentType: "application/json"
      }).then(function (data, status) {
          let username=$("#uname").text();
          if(username!==""){
              $("#uname").remove();
          }
          if(data.username!==undefined){
              $("#form-answer").append("<span id='uname'>"+data.username+"</span>");
          }
          let message= $("#message").text();
          if(message!==""){
              $("#message").remove();
          }
          if(data.message!==undefined){
              $("#form-answer").append("<span id='message'>"+data.message+"</span>");
          }
      });
   });
});