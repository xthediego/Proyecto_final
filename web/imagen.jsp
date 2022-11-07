

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
        
        <title>JSP Page</title>
    </head>
    <body>
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>
        
        
        <h1><center>FORMULARIO IMAGEN</center> </h1> 

                <div class="container">

                    <form action="imgg" method="post" class="form-group"  enctype="multipart/form-data">

                        <label for="lbl_id" >id</label>
                        <input type="number" name="txt_id" id="txt_id" class="form-control"  value="0" readonly>

                        
                        <label for="lbl_nombre" >Nombre</label>
                        <div class="form-group">
                        <input type="text" name="name"  class="form-control"  placeholder="ingrese un nombre" required>
                        </div>
                        
                        <br>
                        
                        <label for="lbl_imagen" >Imagen</label>
                        <div class="form-group">
                        <input type="flie" name="file"  class="form-control"  placeholder="ingrese una imagen" required>
                        </div>
                          
                        <br>
                        
                        <div class="form-group text-center">
                            <button class="btn btn-success" name="action" value="add">Registrar imagen</button>
                        </div>
                        
                        

                    </form>
        
                    
                    
                    
    </body>
</html>
