# Pruebas Automatizadas

## Requisitos Previos

Antes de ejecutar las pruebas automatizadas, asegúrate de tener lo siguiente configurado en tu sistema:

- Java 11 o superior instalado. Puedes descargarlo desde [java.com](https://www.java.com/es/download/).
- Maven instalado y configurado correctamente. Puedes descargar Maven desde [maven.apache.org](https://maven.apache.org/download.cgi).
- Variables de entorno configuradas para Java y Maven:
  - Para Java, asegúrate de que la variable de entorno `JAVA_HOME` esté configurada y apunte al directorio de instalación de Java  y añade `%JAVA_HOME%\bin` al PATH del sistema.
  - Para Maven, configura la variable de entorno `MAVEN_HOME` para que apunte al directorio de instalación de Maven y añade `%MAVEN_HOME%\bin` al PATH del sistema.
- Clona este repositorio desde GitHub en tu máquina local utilizando el siguiente comando:

git clone <url_del_repositorio>



## Tecnologías y Herramientas Utilizadas

- JUnit 5.10.0: Framework de pruebas unitarias para Java.
- WebDriverManager: Herramienta para controlar el navegador web utilizado en las pruebas automatizadas.
- Rest-assured: Librería Java que simplifica las pruebas de API RESTful.
- ExtentReports: Biblioteca utilizada para generar informes detallados y visualmente atractivos de los resultados de las pruebas.
- AssertJ: Biblioteca de aserciones que proporciona una sintaxis más fluída y expresiva para las pruebas unitarias en Java.
- Cucumber: Framework de automatización de pruebas basado en el lenguaje natural, permite escribir escenarios de prueba en lenguaje Gherkin.
- PageFactory: Utilizado para implementar el patrón de diseño Page Object Model (POM), que ayuda a mantener un código más limpio y mantenible al separar las interacciones con los elementos de la página web en clases separadas.



## Estructura del Proyecto

Los Escenarios de prueba se encuentran en la carpeta `src/test/resources/features`. Puedes visualizar y editar los escenarios de prueba en este directorio.
Las Definiciones de los pasos de los escenarios se encuentran en la carpeta `src/test/java/steps`.
Los WebElements con los que interactuamos se encuentran dentro de las clases contenidas en la carpeta `src/test/java/pages`.
El Reporte de las pruebas se aloja en `reports/klimber-automation-report.html`.
Dentro de la carpeta `src/test/java/utils` se encuentran las clases que nos brindan los metodos necesarios para nuestras pruebas.


## Escenarios de Prueba

Este proyecto cuenta con 2 escenarios de prueba

- Contratar Seguro de Vida (TAG: @web)
- Obtener de Spotify la información del artista y verificar el nombre (TAG: @api)


## Trabajando con las Pruebas

### Limpieza y Compilación del Proyecto

Antes de ejecutar las pruebas, puedes limpiar y compilar el proyecto utilizando el siguiente comando:

mvn clean

Este comando eliminará cualquier archivo compilado previo y limpiará el proyecto antes de la compilación.


### Ejecución de Pruebas

1. Abre una terminal o línea de comandos.
2. Navega hasta el directorio raíz del proyecto.
3. Ejecuta el siguiente comando:

mvn test

Este comando iniciará la ejecución de todas las pruebas del proyecto. Asegúrate de que el proyecto se compile correctamente y de que no haya errores en la salida del comando.

Aclaración Importante para Escenario API:

La prueba api de Spotify necesita obtener un token, para esto es necesario setear las variable de entonrno SPOTIFY_CLIENT_ID, y SPOTIFY_CLIENT_SECRET. Se utiliza
variable de entorno para que no queden expuestos los datos del usuario. En este caso por se un proyecto de prueba los acerco para que se puede ejecutar el escenario.
Para setear las variables de entorno podemos hacerlo desde el CMD mediante los comandos: 

set SPOTIFY_CLIENT_ID=e0f59799c8bd4821b7b2a661e6cb4e96
set SPOTIFY_CLIENT_SECRET=92f991ed98344ce7a6184d9eb112be8c


### Ejecución de Pruebas con Tags


Para ejecutar pruebas específicas utilizando etiquetas (tags, opciones disponibles: @api y @web), puedes usar el siguiente comando:

mvn test -Dcucumber.filter.tags="@api"

Este comando ejecutará solo las pruebas que tengan la etiqueta `@api`. Ten en cuenta que este proyecto tiene dos escenarios de prueba etiquetados, por lo que este comando ejecutará esos escenarios.

Si deseas ejecutar otros escenarios etiquetados, simplemente cambia el valor de `@api` por el nombre de la etiqueta que desees utilizar.


### Visualizacion del Reporte

Luego de ejecutar nuestras pruebas podremos visualizar el reporte HTML. Para eso solo necesitamos abrir el archivo `reports/klimber-automation-report.html`



