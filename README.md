# api-demo
api-demo es una API que sirve como soporte a la aplicación *[angular-arquitectura]: https://github.com/desarrolloti14/angular-arquitectura* la cual almacena comentarios que se enviá como petición. Esta pensado que api-demo y angular arquitectura sean una aplicación por si misma respetando el principio de micro-servicios.

## Tecnologías
- Spring Boot
    - Spring web
    - MySQL driver
    - JPA
    - Validators
    - Lombok

## Módulos
- Posts (api/demo/posts)
  - Crear Puedes crear un post 
  - Editar Puedes editar título y cuerpo del post (/{id})
  - Eliminar Puedes eliminar el post y sus respectivos comentarios (/{id})
- Comment (api/demo/comments)
  - Crear Puedes crear un comentario
  - Editar Puedes editar el comentario (/{id})
  - Eliminar Puedes eliminar el comentario
*Si tienes configurado spring con otro host debes modificar esa parte*
Las consultas de los comentarios se realizan tomando el ID de post para segmentarlos

## Pruebas
Las pruebas las puedes hacer con PostMan el cual nos permite realizar peticiones a api's para probar y/o testear, si quieres puedes descargar *[angular-arquitectura]: https://github.com/desarrolloti14/angular-arquitectura*, que como lo comente es la app que consume los datos de esta API, y asi ver como se puede aplicar en un caso real. 

## Escrito por 👨‍💻
*GitHub: [Moises Arrona](https://github.com/moisesarrona)*

## helps
- https://ozenero.com/resolve-json-infinite-recursion-problems-working-jackson