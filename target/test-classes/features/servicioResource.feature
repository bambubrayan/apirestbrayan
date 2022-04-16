#language: es
  @todoslosservicios
Característica: Pruebas al servicio de recursos

  Escenario: Listar todos los recursos
    Dado listar recursos
    Cuando mostrar el listado de recursos
    Y validar codigo de respuesta de recurso "200"
    Entonces validar numero de recursos

  Escenario: Mostrar recurso
    Dado listar recurso con id "2"
    Cuando mostrar informacion del recurso
    Y validar codigo de respuesta de recurso "200"
    Entonces validar informacion de la consulta del recurso
      | nombre       | anio | color   | pantone |
      | fuchsia rose | 2001 | #C74375 | 17-2031 |

  Escenario: Recurso no encontrado
    Dado listar recurso con id "49"
    Entonces validar codigo de respuesta de recurso "404"