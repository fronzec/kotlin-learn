# Kotlin Basics

## Vals y Vars
Kotlin tiene dos keywords para declarar variables:`val` y `var`. `var` es una variable que puede mutar, es decir que el valor que almacena puede cambiar por otro y ser reasignado. Es el equivalente a declarar una variable en Java.

`var name = "Kotlin"`

`var` puede ser inicializado despues

```kotlin
var name:String
name = "Kotlin"
```

Variables definidas con `var` pueden ser reasignados, es decir que son mutables:

```kotlin
var name = "Kotlin"
name = "more Kotlin"
```

El keyword `val` es usado para declarar una variable de solo lectura. Este es el equivalente a declarar una variable `final` en Java. Un `val` debe ser inicilizado cuando es creado, ya que no puede ser cambiado despues:

`val name = "Kotlin"`

Una variable de solo lectura no significa que la instancia en si misma es automaticamente inmutable. La instancia aun puede permitir que sus variables miembro cambien via funciones o propiedades, pero la variable en si misma no puede cambiar su valor o ser resignada a otro valor.

## Type inference(inferencia de tipo)
En kotlin a diferencia de Java, el tipo de la variable no es necesario en su declaracion.
Incluso cuando Kotlin es una lenguaje fuertement tipado, no necesitamos declarar siempre explicitamente los tipos de datos. El compilador intenta deducir el tipo de una expresion por la informacion incluida en el. Un simple `val` es un caso facil para el compilador por que el tipo es claro desde el lado derecho. Este mecanismo es llamado `type inferencia`. Esto reduce el codigo repetitivo manteniendo el tipo de seguridad que esperamos de un lenguaje moderno.

La inferencia de tipo no solo es usada en valores y variables, tambien en closures en donde el tipo de los parametro es inferido usando la firma de la funcion, tambien es usado en las funciones single-line. Aunque a veces si es util incluir explicitamente el tipo de dato por ejemplo:`val explicitType:Number = 12.5`

## Tipos basicos en Kotlin
Un cambio importante de Java a Kotlin es que **todo es un objeto**. Por ejemplo en java tenemos los tipos primitivos como puede ser `boolean`, Java introduce wrappers para los tipos primitivos, por ejemplo la clase `java.lang.Boolean` sirve de envoltura para un `boolean`. Kotlin elimina esta necesidad del lenguaje promoviendo los datos primitivos a objetos.

Siempre que sea posible, el compilador Kotlin asignará tipos básicos a primitivas JVM por razones de rendimiento. Sin embargo, a veces los valores deben estar 'boxed', como cuando el tipo es nullable o cuando se usa en genéricos. El 'boxing' es la conversión de un tipo primitivo a un tipo de envoltorio que los tipos de lugar siempre que se requiere un objeto pero se presenta un primitivo. 

**Dos valores diferentes que están 'boxed' pueden no usar la misma instancia, por lo que la igualdad referencial no está garantizada en los valores encuadrados.**

### Numbers
Los tipos numeros built-in de Kotlin son los siguientes:

| Tipo        | Width           |
| ------------- |:-------------:|
| Long |  64 |
| Int  | 32  |
| Short  | 16  |
| Byte  | 8  |
| Double | 64  |
| Float  |  32 |

Para crear un número literal, podemos usar una de las siguientes maneras:
```kotlin
    val int = 123 
    val long = 123456L 
    val double = 12.34 
    val float = 12.34F 
    val hexadecimal = 0xAB 
    val binary = 0b01010101
```
Un valor de tipo Long requiere de un sufijo `L`

Un valor de tipo Float requiere de un sufijo `F`, Kotlin usa Double como el default para numeros de coma flotante e Int para numeros enteros.

Los tipos `exadecimal` y `binary` usan los prefijos `0x` y `0b` respectivamente.

Kotlin no soporta el casteo de tipos automatico de numeros, las conversiones deben ser invocadas explicitamente. Cada tipo tiene funciones para convertir a los otros tipos de datos, por ejemplo para convertir un Int a un tipo Long podemos hacerlo de la siguiente manera:

```kotlin
val int = 123 
val long = int.toLong()
```

```kotlin
val float = 12.34F 
val double = float.toDouble()
```
Los operadores binarios en kotlin son funciones pero pueden ser unvocadas como operadores, inverse no es un operador binario, es un operador unario y puede ser invocado con la sintaxis punto

```kotlin
val leftShift = 1 shl 2 
    val rightShift = 1 shr 2 
    val unsignedRightShift = 1 ushr 2 
 
    val and = 1 and 0x00001111 
    val or = 1 or 0x00001111 
    val xor = 1 xor 0x00001111 
    val inv = 1.inv()
```

### Booleanos
Los booleanos siguen siendo un estandar, y soportan las operaciones usuales como negacion, conjuncion y disyuncion. La conjuncion y disyuncion son evaluadas de manera tardia, es decir si la parte izquieda cumple con el criterio, entonces la parte derecha no sera evaluada.
```kotlin
val x = 1 
val y = 2 
val z = 2 
 
val isTrue = x < y && x < z 
val alsoTrue = x == y || y == z
```
### Chars
Los Chars representan un solo caracter A o z por ejemplo. Los chars tambien soportan el escape de de los siguientes caracteres: `\t`, `\b`, `\n`, `\r`, `'`, `"`, `\\`, y `\$`.

Todos los caracteres unicode pueden ser representados usando el codigo unicode, por ejemplo: `\u1234`

**Hay que hacer notar que el tipo `char` no es tratado como un número como lo hace Java**

### Strings
Como en Java, los strings son inmutables. Un string puede ser creado usando comillas dobles `""` o comillas triples `""""""`. Comillas dobles crean un string escapado, en un string de este tipo los caracteres especiales como los saltos de linea `\n` deben ser escapados.

`val string = "string with \n new line"`

Las comillas triples crean un string crudo. En un string crudo, no es necesario escapar nada y se pueden incluir todos los caracteres.

```kotlin
val rawString = """ 
raw string is super useful for strings that span many lines """
 ```
 
 Los strings proveen una funcion de iteracion(iterator) el cual puede ser usado en un `for loop`.
 
 
### Arrays
En kotlin podemos crear un `array` using la funcion de biblioteca `arrayOf()`

`val array = arrayOf(1, 2, 3)`

Alternativamente podemos crear un `array` de un tamaño inicial y una funcion, el cual es usado para generar cada elemento:

`var perfectSquares = Array(10, {k -> k * k})`

No como en Java, los arrays de Kotlin no son tratados de manera especial por el lenguaje, son collecciones regulares de clases. Las instancias de arrays proveen una funcion iterador y una funcion `size`, asi como `get` y `set`. Estas ultimas dos funciones tambien estan disponibles a travez de una sintaxis de parentesis`[]` como ocurre en lenguajes como es C.

```kotlin
val element1 = array[0]
val element2 = array[1] 
array[2] = 5
```
 
 **Para evitar el boxing de los tipos de datos que seran representados como tipos primitivos en la JVM, Kotlin proporciona clases de arrays alternativas que están especializadas para cada uno de los tipos primitivos. Esto permite que el código de rendimiento crítico utilice matrices de manera tan eficiente como lo harían en Java simple:**
 - `ByteArray`
 - `CharArray`
 - `ShortArray`
 - `IntArray`
 - `LongArray`
 - `BooleanArray`
 - `FloatArray`
 - `DoubleArray`