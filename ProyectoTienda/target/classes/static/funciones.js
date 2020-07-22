function eliminar(IdUsuario) {
	
	swal({
		  title: "Estás seguro de eliminar?",
		  text: "Una vez eliminado, No podrás recuperar este archivo!",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((OK) => {
		  if (OK) {
			  $.ajax({
				  url:"/eliminar/"+IdUsuario,
				  success: function (res) {
					  Console.log(res);
					
				},
			  })
		    swal("Hecho! Tu archivo fue eliminado con éxito!", {
		      icon: "success",
		    }).then((OK)=>{
		    if (OK)	{
		    	location.href="/AdminUserList";
		    }
		    });
		  } else {
		    swal("Tu archivo está seguro por ahora!");
		  }
		});
	
}
