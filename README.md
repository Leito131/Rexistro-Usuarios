# Rexistro-Usuarios
Proxecto grupal contornos

Proxecto Junit5 + Jacoco

- Paulo Brea Couceiro
- Carlos Gude Crujeiras
- Diego Barreiro Liste
- Alexander Neira Lagos

Por grupos de máximo 5 persoas debedes deseñar unha aplicación para o manexo e rexistro de usuarios. Debedes estructurar a aplicación cun mínimo de 3 clases:

Unha clase Usuario que almacenará a información de cada un dos usuarios da nosa aplicación e deberá conter como mínimo os seguintes atributos:
email: debe cumplir o formato dunha dirección de correo electrónico válida.
contrasinal: debe ter unha lonxitude mínima de 8 caracteres, e incluir como mínimo un número, unha letra e un carácter especial. Non debemos almacenar o contrasinal en claro, senon un hash do introducido polo usuario (MessageDigest).
web: debe cumplir o formato dunha URL válida.
nacemento: debe ser unha data anterior á fecha actual.
Unha clase helper Validador para a validación de datos.
Unha clase principal que permitirá realizar operacións de rexistro, e manexo de usuarios. Deberá conter como mínimo o seguinte:
Un atributo Usuarios que conterá os usuarios rexistrados na nosa aplicación.
Un método main principal que despregará o menú coas diferentes operacións que se poden realizar.
Un método rexistrarUsuario() que permite rexistra un novo usuario na nosa aplicación (crealo e almacenalo). Debemos controlar que non se poidan rexistrar dous usuarios co mesmo email.
Un método borrarUsuario() que solicitará o email e o contrasinal do usuario a eliminar e o borrará só no caso de que ambos coincidan con algún do noso listado de usuarios, en caso contrario indicará o erro correspondente.
Un método comprobarDatos() que solicitará o email e o contrasinal do usuario e só no caso de que ambos coincidan con algún usuario do noso listado indicarémoslle todos os datos do mesmo. En caso contrario indicará o erro correspondente.
Un método buscarUsuarios(data_inicio, data_fin) que devolva un listado cos usuarios nacidos entre as fechas indicadas.
De xeito paralelo debedes programar unha batería de probar en JUnit5 para comprobar o correcto funcionamento da vosa aplicación. Para elo valorarase o uso dos diferentes tipos de tests vistos na clase: asercións de datos, de excepcións, probas parametrizadas...

Ademáis deberedes facer unha proba de cobertura con Jacoco intentando achegarvos o máximo posible a unha cobertura do voso SW do 100%.

Debedes realizar a entrega a través dun repositorio en GitHub. Podedes facelo privado e invitarme a colaborar (o meu usuario é bikthor), ou facelo público e entregar a URL do repositorio. No README.md do repo debedes indicar o nome completo de tódolos integrantes do grupo e calqueira guía/documentación básica que consideredes precisa para comprender a estruturación e funcionamento da vosa aplicación.
