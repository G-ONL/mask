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

    $.ajax({
      type: 'GET',
      url: '/search',
      data: {
        code: code,
        name: name,
        company: company,
        grade: grade,
        page: page,
      },
      dataType: 'json',
      contentType: 'application/json; charset=utf-8'
    }).done(function (data) {

      //div 안의 element를 .empty()하고
      // 그 안에 채워넣기

      $("#card-body").empty();
      var content = data.content;
      var totalElements = data.totalElements;
      var pagesTotal = data.totalPages;
      $("#totalElements").text("검색된 마스크 개수 : " + totalElements + " 건");

      //만들기
      for (var i = 0; i < content.length; i++) {
        var name = content[i].name;
        var company = content[i].company;
        var grade = content[i].grade;
        var code = content[i].code;

        var table_body_element = "<tr><td>" + code + "</td><td>" + name
            + "</td><td>" + company + "</td><td>" + grade + "</td></tr>"

        var card_body_element = "      <div class=\"col-md-6 card mb-3 m-1 card-49\">\n"
            + "        <div class=\"row no-gutters\">\n"
            + "          <div class=\"col-md-4 card-img-middle\">\n"
            + "            <img\n"
            + "                src=\"https://image.shutterstock.com/image-photo/doctor-mask-corona-virus-protection-260nw-1631607358.jpg\"\n"
            + "                class=\"card-img\">\n"
            + "          </div>\n"
            + "          <div class=\"col-md-8\">\n"
            + "            <div class=\"card-body\">\n"
            + "              <h5 class=\"card-title\">" + name + "</h5>\n"
            + "              <p class=\"card-text\">" + code + "</p>\n"
            + "              <p class=\"card-text\">" + company + "</p>\n"
            + "              <p class=\"card-text\">" + grade + "</p>\n"
            + "\n"
            + "            </div>\n"
            + "          </div>\n"
            + "        </div>\n"
            + "      </div>"

        $("#card-body").append(card_body_element);

      }

      //nav 정리
      $("#page-nav").empty();
      $(document).ready(function () {
        var previous = "<li class=\"page-item disabled\">\n"
            + "<span class=\"page-link\"><</span>\n"
            + "</li>"

        var currentPage = "<li class=\"page-item active\" aria-current=\"page\">\n"
            + "<span class=\"page-link\">\n"
            + "1\n"
            + "</span>\n"
            + "</li>"
        $("#page-nav").append(previous);
        $("#page-nav").append(currentPage);

        if (pagesTotal > 5) {
          for (i = 1; i < 5; i++) {
            var m = i + 1;
            var element = "<li class=\"page-item\">\n"
                + "<a class=\"page-link page-click\" id=" + i + ">\n"
                + m + "\n"
                + "</a>\n"
                + "</li>"
            $(element).appendTo("#page-nav");
          }
          var endPage = " <li class=\"page-item\">\n"
              + "<a class=\"page-link page-click\" id=" + i + ">></a>\n"
              + "</li>"
          $(endPage).appendTo("#page-nav");

        } else {
          for (i = 1; i < pagesTotal; i++) {
            var m = i + 1;

            var element = "<li class=\"page-item\">\n"
                + "<a class=\"page-link page-click\" id=" + i + ">\n"
                + m + "\n"
                + "</a>\n"
                + "</li>"
            $(element).appendTo("#page-nav");
          }
          var endPage = " <li class=\"page-item disabled\">\n"
              + "          <span class=\"page-link\">></span>\n"
              + "        </li>"
          $(endPage).appendTo("#page-nav");

        }
      });

    }).fail(function (error) {
      console.log("error");
      alert(error);
    });

  }
}
index.init();
$(document).on('click', ".page-click", function () {

  var currPage = $(this).attr("id");

  $.ajax({
    type: 'GET',
    url: '/search',
    data: {
      code: code,
      name: name,
      company: company,
      grade: grade,
      page: currPage,
    },
    dataType: 'json',
    contentType: 'application/json; charset=utf-8'
  }).done(function (data) {

    //div 안의 element를 .empty()하고
    // 그 안에 채워넣기

    $("#card-body").empty();
    var content = data.content;
    var totalElements = data.totalElements;
    var pagesTotal = data.totalPages;

    $("#totalElements").text("검색된 마스크 개수 : " + totalElements + " 건");

    //만들기
    for (var i = 0; i < content.length; i++) {
      var name = content[i].name;
      var company = content[i].company;
      var grade = content[i].grade;
      var code = content[i].code;

      var table_body_element = "<tr><td>" + code + "</td><td>" + name
          + "</td><td>" + company + "</td><td>" + grade + "</td></tr>"

      var card_body_element = "      <div class=\"col-md-6 card mb-3 m-1 card-49\">\n"
          + "        <div class=\"row no-gutters\">\n"
          + "          <div class=\"col-md-4 card-img-middle\">\n"
          + "            <img\n"
          + "                src=\"https://image.shutterstock.com/image-photo/doctor-mask-corona-virus-protection-260nw-1631607358.jpg\"\n"
          + "                class=\"card-img\">\n"
          + "          </div>\n"
          + "          <div class=\"col-md-8\">\n"
          + "            <div class=\"card-body\">\n"
          + "              <h5 class=\"card-title\">" + name + "</h5>\n"
          + "              <p class=\"card-text\">" + code + "</p>\n"
          + "              <p class=\"card-text\">" + company + "</p>\n"
          + "              <p class=\"card-text\">" + grade + "</p>\n"
          + "\n"
          + "            </div>\n"
          + "          </div>\n"
          + "        </div>\n"
          + "      </div>"

      $("#card-body").append(card_body_element);

    }

    //nav 정리
    $("#page-nav").empty();
    $(document).ready(function () {
      var start = Math.floor(currPage / 5);
      var end = Math.floor((pagesTotal - 1) / 5);

      var k = start * 5;

      if (start < 1) {
        var previous = "<li class=\"page-item disabled\">\n"
            + "<span class=\"page-link\"><</span>\n"
            + "</li>"
      } else {
        var previous = "<li class=\"page-item\">\n"
            + "          <a class=\"page-link page-click\" id=" + (k - 1) + "><</a>\n"
            + "        </li>"
      }

      $("#page-nav").append(previous);

      if (end == start) {
        for (i = k; i < pagesTotal; i++) {
          var m = i + 1;
          if (currPage == i) {
            var element = "      <li class=\"page-item active\" aria-current=\"page\">\n"
                + "      <span class=\"page-link\">\n"
                + m + "\n"
                + "      </span>\n"
                + "        </li>"
          } else {
            var element = "<li class=\"page-item\">\n"
                + "<a class=\"page-link page-click\" id=" + i + ">\n"
                + m + "\n"
                + "</a>\n"
                + "</li>"
          }

          $(element).appendTo("#page-nav");
        }
        var endPage = " <li class=\"page-item disabled\">\n"
            + "          <span class=\"page-link\">></span>\n"
            + "        </li>"
        $(endPage).appendTo("#page-nav");
      } else {
        for (i = k; i < k + 5; i++) {
          var m = i + 1;
          if (currPage == i) {
            var element = "      <li class=\"page-item active\" aria-current=\"page\">\n"
                + "      <span class=\"page-link\">\n"
                + m + "\n"
                + "      </span>\n"
                + "        </li>"
          } else {
            var element = "<li class=\"page-item\">\n"
                + "<a class=\"page-link page-click\" id=" + i + ">\n"
                + m + "\n"
                + "</a>\n"
                + "</li>"
          }

          $(element).appendTo("#page-nav");
        }
        var endPage = " <li class=\"page-item\">\n"
            + "<a class=\"page-link page-click\" id=" + i + ">></a>\n"
            + "        </li>"
        $(endPage).appendTo("#page-nav");
      }
    });

  }).fail(function (error) {
    console.log("error");
    alert(error);
  });

});
