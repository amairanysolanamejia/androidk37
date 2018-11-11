# Prebe inscripciones

Desarrollar una aplicación que simule un sistema de inscripciones, de preferencia el de la facultad de ingeniería. Eso si, debe ser algo escolar, en otras palabras, solo se puede simular el sistema de inscripciones de alguna facultad, prepa o cch.

## Requerimentos funcionales

La aplicación deberá tener las siguientes funcionalidades

* Registro del usuario
  * Nombre
  * Carrera
  * Semestre

* Logeo de usuario
* Posibilidad de registrar materias de acuerdo al semestre, si es necesario para simplificar el problema pueden suponer que los alumnos siempre serán regulares. Debe de haber un cupo máximo de estudiantes en cada materia y grupo que se elija.
* Posibilidad para ver el horario conforme las materias que eligió.
* Posibilidad de tener altar y bajas (no hay fecha limite para altas y bajas, con el fin de simplificar el problema). 

## Requerimentos técnicos

Los siguientes elementos deben de estar presentes en el desarrollo de la aplicación.

- Uso de `fragments` a lo largo de la vista de las aplicaciones. ES ALTAMENTE RECOMENDABLE que los utilicen para poder hacer su aplicación responsiva.
- Uso y creación de un `webservice` para consumo de la aplicación. ES OBLIGATORIO ES PUNTO.					
- Uso y manejo de `archivos JSON`

### Recomendaciones

- Para este problema deben de diseñar primero un buen web service, y principalmente una base de datos a la cual se tiene que contectar.
- El diseño de su db debe de tener, las materias que hay por semestre, los profesores y los grupos disponibles y no disponibles. Para acabar, esta base de datos debe ser muy parecida a la de la facultad de ingeniería, se que no la conocen pero imagínensela con base en su experiencia utilizando dicho sistema.

## Especificaciones de la entrega

- El proyecto deberá ser subido en el repositorio de alguno de los integrantes del equipo.
- El proyecto deberá contar con un README.md en donde se especifique lo siguiente.
  - El nombre de la aplicación así como una breve descripción de lo que hace y como funciona.
  - Las tecnologías y sus versiones que se utilizaron para crear la aplicación. Asi como la última fecha en la que fue compilado el proyecto.
  - Sus correo para aclaraciones sobre el proyecto
  - Lo que ustedes creen que costaría su aplicación y el tiempo que se tardaron en desarrollarlo.
- **Deben incluir capturas  de pantalla por cada funcionalidad de la aplicación.** 

### IMPORTANTE

- No se permite el plagio.
- Se permite el uso de código libre, siempre en cuando hagan lo necesario para darle los créditos a quien le correspondan.
- Deben de tener un avance constante el la realización de su proyecto, es decir, deben tener commits por día de su proyecto.