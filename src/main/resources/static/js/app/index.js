var name = $('#name').val();
var company = $('#company').val();
var grade = $('#grade').val();
var code = $('#code').val();

var index = {

  init: function () {
    var _this = this;
    $('#btn-search').on('click', function () {
      _this.search();
    });
    this.search();
  },
  search: function () {
    name = $('#name').val();
    company = $('#company').val();
    grade = $('#grade').val();
    code = $('#code').val();
    page = 0;

    console.log("name : " + name + " company : " + company + " grade : " + grade
        + " code : " + code);
    $.ajax({
      type: 'GET',
      url: '/search',
      data: {
        code: code,
        name: name,
        company: company,
        grade: grade,
        page: page,
        size: 100
      },
      dataType: 'json',
      contentType: 'application/json; charset=utf-8'
    }).done(function (data) {
      console.log(data);
      $("#tbody").empty();
      var content = data.content;
      var totalElements = data.totalElements;
      $("#totalElements").text("검색된 마스크 개수 : " + totalElements + " 건");

      for (var i = 0; i < content.length; i++) {
        var name = content[i].name;
        var company = content[i].company;
        var grade = content[i].grade;
        var code = content[i].code;
        console.log(name + " --- " + company + " --- " + code);
        var table_body_element = "<tr><td>" + code + "</td><td>" + name
            + "</td><td>" + company + "</td><td>" + grade + "</td></tr>"
        $("#tbody").append(table_body_element);
      }

      $("#nav").remove();
      $(document).ready(function () {
        $("table").after('<div id="nav"></div>');
        var rowPerPage = 100;
        var rowsTotal = totalElements;
        var pagesTotal = Math.ceil(rowsTotal / rowPerPage);
        for (i = 0; i < pagesTotal; i++) {
          $("<button type=\"button\"></button>").attr("id", i).text(
              i + 1).appendTo("#nav");
        }
        $("#nav button:first").addClass("active");
      });

    }).fail(function (error) {
      console.log("error");
      alert(error);
    });
  }
}
index.init();

$(document).on('click', "#nav button", function () {
  console.log("click");
  $("#nav button").removeClass("active");
  $(this).addClass("active");
  var currPage = $(this).attr("id");

  console.log("name : " + name + " company : " + company + " grade : " + grade
      + " code : " + code);

  $.ajax({
    type: 'GET',
    url: '/search',
    data: {
      code: code,
      name: name,
      company: company,
      grade: grade,
      page: currPage,
      size: 100
    },
    dataType: 'json',
    contentType: 'application/json; charset=utf-8'
  }).done(function (data) {
    console.log(data);
    $("#tbody").empty();
    var content = data.content;
    var totalElements = data.totalElements;
    $("#totalElements").text("검색된 마스크 개수 : " + totalElements + " 건");

    for (var i = 0; i < content.length; i++) {
      var name = content[i].name;
      var company = content[i].company;
      var grade = content[i].grade;
      var code = content[i].code;
      console.log(name + " --- " + company + " --- " + code);
      var table_body_element = "<tr><td>" + code + "</td><td>" + name
          + "</td><td>" + company + "</td><td>" + grade + "</td></tr>"
      $("#tbody").append(table_body_element);
    }
  }).fail(function (error) {
    console.log("error");
    alert(error);
  });
});
