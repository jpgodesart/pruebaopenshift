<%-- 

--%>
<form class="form-horizontal" action="#" id="formulario" name="formulario">
    <h2>Usupro</h2>
    <div class="control-group">
        <label class="control-label" for="inputId">Id:</label>
        <div class="controls">
            <input type="text" id="id" name="id" placeholder="id" />
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="id_usuario">Usuario: </label> 
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
        <label class="control-label" for="id_proyecto">Proyecto: </label> 
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
        <div class="controls">
            <button type="submit" id="submitForm" class="btn submitForm">Submit</button>
        </div>
    </div>
</form>
