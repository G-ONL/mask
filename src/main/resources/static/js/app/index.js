var index = {
  init: function () {
    var _this = this;
    $('#btn-search').on('click', function () {
      _this.search();
    });
  },
  search: function () {
    var name = $('#name').val();
    var company = $('#company').val();
    var grade = $('#grade').val();
    var code = $('#code').val();

    console.log("name : " + name + " company : " + company + " grade : " + grade
        + " code : " + code);
    $.ajax({
      type: 'GET',
      url: '/search',
      data: {
        code: code,
        name: name,
        company: company,
        grade: grade
      },
      dataType: 'json',
      contentType: 'application/json; charset=utf-8'
    }).done(function (data) {
      console.log(data);
      $("#tbody").empty();
      var content = data.content;
      $("#totalElements").text("검색된 마스크 개수 : "+data.totalElements+" 건");

      for (var i = 0; i < content.length; i++) {
        name = content[i].name;
        company = content[i].company;
        grade = content[i].grade;
        code = content[i].code;
        console.log(name + " --- " + company + " --- " + code);
        var table_body_element = "<tr><td>" + code + "</td><td>" + name
            + "</td><td>" + company + "</td><td>" + grade + "</td></tr>"
        $("#tbody").append(table_body_element);
      }

    }).fail(function (error) {
      console.log("error");
      alert(error);
    });
  }
}
index.init();