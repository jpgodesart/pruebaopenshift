<%-- 
    Document   : form
    Created on : 29-ene-2014, 12:11:54
    Author     : al037684
--%>

<%@page import="java.text.SimpleDateFormat"%>

<form class="form-horizontal" action="#" id="formulario" name="formulario">
    <h2>Tarea</h2>

    <div class="control-group">
        <label class="control-label" for="inputId">Id:</label>
        <div class="controls">
            <input type="text" id="id" name="id" placeholder="id" />
        </div>
    </div>

    <div class="control-group">
        <label class="control-label"  for="inputNombre">Nombre: </label>
        <div class="controls">
            <input type="text" id="nombre" name="nombre" size="15" placeholder="nombre" />
        </div>
    </div>

    <div class="control-group">
        <label class="control-label"  for="inputDescripcion">Descripcion: </label>
        <div class="controls">
            <input type="text" id="descripcion" name="descripcion" size="15" placeholder="descripcion" />
        </div>
    </div>

    <div class="control-group">
        <label class="control-label" for="id_estado">Id estado: </label> 
        <div class="controls">           
            <input readonly="true" id="id_estado" class="input-mini"
                   name="id_estado" type="text" size="5" maxlength="5" />  
            <a class="btn btn-mini" id="id_estado_button" href="#"><i class="icon-search"></i></a>
        </div>
    </div>
    <div class="control-group">
        <div class="controls">
            <span id="id_estado_desc" class="alert alert-success"></span>                                       
        </div>
    </div> 

    <div class="control-group">
        <label class="control-label" for="id_proyecto">Id proyecto: </label> 
        <div class="controls">           
            <input readonly="true" id="id_proyecto" class="input-mini"
                   name="id_proyecto" type="text" size="5" maxlength="5" />  
            <a class="btn btn-mini" id="id_proyecto_button" href="#"><i class="icon-search"></i></a>
        </div>
    </div>
    <div class="control-group">
        <div class="controls">
            <span id="id_proyecto_desc" class="alert alert-success"></span>                                       
        </div>
    </div> 

    <div class="control-group">
        <label class="control-label" for="id_usuario">Id usuario: </label> 
        <div class="controls">           
            <input readonly="true" id="id_usuario" class="input-mini"
                   name="id_usuario" type="text" size="5" maxlength="5" />  
            <a class="btn btn-mini" id="id_usuario_button" href="#"><i class="icon-search"></i></a>
        </div>
    </div>
    <div class="control-group">
        <div class="controls">
            <span id="id_usuario_desc" class="alert alert-success"></span>                                       
        </div>
    </div> 


    <div class="control-group">
        <div class="controls">
            <button type="submit" id="submitForm" class="btn submitForm">Submit</button>
        </div>
    </div>
</form>

<script>
    $(function() {
        $("#datepicker").datepicker();
    });
</script>