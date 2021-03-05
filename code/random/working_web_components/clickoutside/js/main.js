$(document).on('click', function(event) {
  if (!$(event.target).closest('#menucontainer').length) {
    alert();
  }
});