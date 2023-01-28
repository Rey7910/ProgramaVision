# PROGRAMAVISIÓN

## AUTOR:
- Rey7910

## Descripción.
Programavisión es un pequeño lenguaje de programación de dominio específico enfocado al aprendizaje e
introducción a la programación para las personas no videntes con la ayuda de un periférico de 6 teclas haciendo
de Progravisión, un lenguaje de programación cuyo alfabeto presenta únicamente seis símbolos para mayor facilidad
de adopción y desarrollo de curva de aprendizaje por parte de nuestra población objetivo, el lenguaje de
programación maneja los tipos de dato entero y flotante; cuenta con estructuras de decisión tales como if, else if y else,
así como estructuras cíclicas las cuales encontramos while y for.

En el desarrollo del lenguaje se contempla la integración del periférico de 2 x 3 teclas cuyo cáracter personalizado
viene en el siguiente orden

 - - -  - - -
|  +  |   |  |
|     |      |
 - - -  - - -
|  <  |   }  |
|     |      |   -------------> Periférico de 6 teclas con el cáracter correspondiente para una buena adopción del lenguaje
 - - -  - - -
|  .  |   -  |
|     |      |
 - - -  - - -

 De esta manera, conseguimos una analogía física al alfabeto braille que nuestro lenguaje va a aplicar para
 la declaración de variables y la asignación de valores numéricos.

 Por ejemplo.

 Si queremos declarar una variable entera 'a' con el valor de 1 y luego imprimirla, lo haremos de la siguiente manera

 Paso 1.
 Declaración de la variable: Para declarar una variable entera vamos a utilizar el token integer '.'
 A continuación, vamos a escribir el nombre de la variable utilizando los controladores de alfabeto de esta manera:

 El controlador de inicio de alfabeto es el token '++' y el token que designa el final es '<<'.
 Por lo tanto, para referirnos a una letra en específico del alfabeto lo haremos de la siguiente forma

 '++' (letra del alfabeto) '<<'

 En nuestro ejemplo, vamos a declarar la variable con nombre a, que en el sistema braille viene designado por el punto 1

  - - -  - - -
 |  1  |   4  |
 |     |      |
  - - -  - - -
 |  2  |   5  |
 |     |      |   -------------> Disposición de puntos en el sistema braille
  - - -  - - -
 |  3  |   6  |
 |     |      |
  - - -  - - -

 En nuestro lenguaje, el punto 1 del sistema braille viene designado por el caractér '+' en Programavisión, por ende, para declarar
 una variable de tipo entera de nombre 'a' lo codificamos de la siguiente manera

 . ++ + <<

 Paso 2: Asignar el valor de 1 a la variable.

 Para asignar un valor a nuestra variable usaremos la siguiente estructura:

 variable '<-<' valor

 donde el token '<-<' se refiere al token de asignación que comunmene designamos como '=' en muchos lenguajes,
 para codificar el valor de 1 usaremos los controladores de inicio de alfabeto braille para números donde
 '||' se refiere al inicio del alfabeto numérico mientras que '}}' refiere al fin del controlador del alfabeto numérico.

 Según el sistema numérico de braille, el número 1 viene designado por el punto 1 del sistema; por lo tanto, y al igual que
 la letra 'a', designamos el numero 1 con el cáracter '+' que es el equivalente al punto 1 del sistema braille en nuestro lenguaje.

 De esta forma, tenemos el siguiente código para asignar el valor de 1 a nuesra variable 'a'

 ++ + << <-< || + }}

 Paso 3: Impresión en consola.

 Por último, vamos a imprimir el valor de nuestra variable en consola mediante la sentencia de impresión, que en nuestro lenguaje
 viene designado por el token '<<<<<' y a continuación, colocamos el nombre de la variable a imprimir.

 Nuestro código final quedaría de la siguiente forma:

  . ++ + <<
  ++ + << <-< || + }}
  <<<<<  ++ + <<

  --------------------------------------

  Para ejecutar este pequeño código y los demás casos de prueba contenidos en la carpeta 'casos_proyecto',
  copiar los códigos en el archivo 'entrada.txt' contenido en la carpeta 'input' del proyecto.

  Además de la interpretación y compilación del código, proporcionamos la generación de un pseudocódigo equivalente
  al código ingresado de Programavisión para que sea posible observar con mayor facilidad (en términos visuales)
  las instrucciones ejecutadas en el compilador desarrollado


  Para consultar las demás funcionalidades implementadas y la gramática del lenguaje por favor dirigirse al archivo
  'MiLenguaje.g4' dentro de la carpeta 'grammar'


ATT. 

Rey7910




