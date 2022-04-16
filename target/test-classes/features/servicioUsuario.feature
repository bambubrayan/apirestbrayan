#language: es
@todoslosservicios
Característica: Pruebas al servicio de usuario
  @metodoget
  Escenario: Listar todos los usuarios
    Dado listar usuarios
    Cuando mostrar el listado de usuarios
    Y validar codigo de respuesta "200"
    Entonces validar numero de registros

  @metodoget
  Escenario: Mostrar usuario
    Dado listar usuario con id "3"
    Cuando mostrar informacion del usuario
    Y validar codigo de respuesta "200"
    Entonces validar informacion de la consulta
      | email               | nombre | apellido |
      | emma.wong@reqres.in | Emma   | Wong     |

  @metodoget
  Escenario: Usuario no encontrado
    Dado listar usuario con id "49"
    Entonces validar codigo de respuesta "404"

  @metodopost
  Escenario: Crear usuario
    Dado que no existe usuario registrado
    Cuando registrar datos del usuario
      | nombre    | puesto | codigo |
      | Alexander | QA     | 201    |
    Entonces validar codigo de respuesta "201"
    Y mostrar los datos del registro

  @metodoput
  Escenario: Actualizar usuario
    Dado que el usuario este registrado
    Cuando actualizar datos del usuario
      | id | nombre    | puesto | codigo |
      | 124| Brayan    | Tester | 200    |
    Entonces validar codigo de respuesta "200"
    Y mostrar los datos del registro


  @metodopatch
  Escenario: Actualizar usuario con metodo Patch
    Dado que el usuario este registrado
    Cuando actualizar datos del usuario con patch
      | id | nombre    | puesto | codigo |
      | 122| Alexander    | Dev | 200    |
    Entonces validar codigo de respuesta "200"
    Y mostrar los datos del registro