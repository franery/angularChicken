ChickenEscuelita

Primero levantar la base de datos , el script se encuentra en la carpeta src/main/resources/sqlScripts.
  Correr el script "database" y luego "dbDatos". 
  Actualizar usuario, contraseña y database_url en src/main/resources/database.properties para que coincidan con el servidor utilizado.
  Levantar el  servidor.
En eclipse  :
  Importar desde la carpeta ChickenEscuelita como Existing Maven Project.
  Añadir dependencias (Junit 4): En cualquiera de los test utilizar la opcion de "Fix project setup" y añadir JUnit library to the build path.
  Verificar en propiedades del proyecto que utilice jdk 1.7. (propiedades/Java/build path y Java/compiler)
  Correr en servidor tomcat 7. (Añadir en propiedades/runtime environments)
  
