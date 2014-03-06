<%-- 
    Document   : form
    Created on : 25-feb-2014, 19:02:06
    
--%>

<form class="form-horizontal" action="#" id="formulario" name="formulario">
    <h2>Proyecto</h2>
    <div class="control-group">
        <label class="control-label" for="inputId">Id:</label>
        <div class="controls">
            <input type="text" id="id" name="id" placeholder="id" />
        </div>
    </div>
    <div class="control-group">
        <label class="control-label"  for="inputNombre">Nombre:</label>
        <div class="controls">
            <input type="text" id="nombre" name="nombre" size="15" placeholder="nombre" />
        </div>
    </div>    
    <div class="control-group">
        <label class="control-label"  for="inputDescripcion">Descripción:</label>
        <div class="controls">
            <input type="text" id="descripcion" name="descripcion" size="15" placeholder="descripcion" />
        </div>
    </div>
    <div class="control-group">
        <div class="controls">
            <button type="submit" id="submitForm" class="btn submitForm">Submit</button>
        </div>
    </div>
</form>
