// $(document).ready(function(){
//     $('form').submit(function(e) {
//         e.preventDefault();
//         var $form = $(this);
//
//         $.ajax({
//             type: "POST",
//             url: "mail.php",
//             data: $form.serialize()
//         }).done(function() {
//             $('#myModal').modal({
//                 show: true
//             })
//             $form[0].reset();
//         }).fail(function() {
//             alert("ошибка")
//         });
//
//     });
// });