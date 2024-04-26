Feature: Rutas

  @web
  Scenario: Contratar Seguro de Vida
    Given El usuario ingresa a la web de Klimber
    And Completa los campos de cotizacion del seguro de vida
    	| FechaDeNacimiento	| Provincia		| CodArea	| Celular | SumaAsegurada |
      | 17/05/1990				| Buenos Aires| 249	 		| 4281960 | 4520000   		|
    And Elije la cobertura adicional "ninguna"
    And Presiona sobre el boton Contratar
    And Completa el formulario Necesito conocerte un poco mas
    	| EnfermedadPrevia	| AsistenciaActividades	| Altura	| Peso | Covid19|
      | no								| no										| 175	 		| 67	 | no  		|
    And Presiona el boton Siguiente del paso 2
    And Completa sus datos personales
    	| Nombre	| Apellido	| DNI		| Sexo 			| Genero 		| EstadoCivil	|
    	| Nicolás	|	Rioseco		| auto	| Masculino | Masculino | Casada/o		|
    And Completa sus datos de contacto
    	| Email	| Contrasena	| Calle	| Numero	| CP	| Ciudad	|
    	| auto	| 123456789		| Dufau	| 1567		| 7000| Tandil	|
    And Presiona el boton Siguiente del paso 3
    And Completa el formulario de Datos Adicionales
    	| Nacionalidad	| LugarDeNacimiento | Ocupacion	| IIBB		| ConyugeNombre	| ConyugeDni	| Origen	|
    	| Argentina			| CABA							| Empleado	| 18000000| Flor					| 44444444		| Sueldo	|
    And Presiona el boton Siguiente del paso 4
    And Ingresa el numero de tarjeta "4970110000000062" 
    And Presiona el boton Siguiente del paso 5
    And Presiona el boton Siguiente del paso 6
   	And Visualiza el resumen de la cotizacion
   	And Acepta los TyC 
   	When Presiona el botón Siguiente
    Then Visualiza la pantalla de Finalizacion del tramite de Poliza
    
#cobertura adicional - opciones validas: ninguna, invalidez, accidente, enfermedad


	@api
  Scenario: Obtener de Spotify la información del artista y verificar el nombre
    Given El usuario obtiene el token de acceso
    When Solicita la informacion del artista utilizando el token obtenido
    Then Valida que el codigo de estado de la respuesta es 200
    And Valida que el nombre del artista es "Radiohead"

