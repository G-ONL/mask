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

    console.log("name : "+name +" company : "+ company +" grade : "+ grade +" code : "+ code);
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
    }).fail(function (error) {
      console.log("error");
      alert(error);
    });
  }
}
index.init();