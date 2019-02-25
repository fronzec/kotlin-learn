# Iniciando con Kotlin
Una forma rapida de instalar el compilador de kotlin es a travez de `sdkman`.

Usando la linea de comandos para compilar y ejecutar codigo en kotlin.

`kotlinc HelloWorld.kt -include-runtime -d HelloWorld.jar`
## Kotlin runtime
Cuando compilamos una clase y se produce el archivo JAR, le indicamos al compilador que incluya el runtime de Kotlin. Si compilamos una clase de kotlin sin incluir el runtime e intentamos ejecutarla obtendremos un error de `NoClassDefFoundError`. Esto es por que Kotlin con su propia biblioteca estandar de clases(Kotlin runtime), el cual es diferente del de la biblioteca de Java. Como resultado, necesitamos mezclarlo en el JAR final o proveerlo en el classpath:
`java -cp $KOTLIN_HOME/lib/kotlin-runtime.jar:HelloWorld.jar  HelloWorldKt`

Si se desarrolla una biblioteca para el uso exclusivo de otras bibliotecas o aplicaciones de Kotlin, entonces no necesitamos incluir el runtime de Kotlin. Alternativamente hay una forma más corta de hacer esto. Estos a travez de una bandera que es pasada al compilador de Kotlin:`kotlinc -include-runtime HelloWorld.kt -d HelloWorld`

## REPL
La mayoria de los lenguajes actuales proveen un shell interactivo, Kotlin no es la excepcion. Para esto esta el REPL(Read-Eval-Print-Loop bucle Lectura-Evaluación-Impresión, alto nivel interactivo o consola del lenguaje). Algunas personas prefieren probar facilmente sus metodos, pero siempre es preferible escribir test unitarios en vez de usar el REPL.

Se pueden agregar dependencias al classpath del REPL para tenerlos disponibles en nuestro espacio, por ejemplo, si quisieramos añadir la biblioteca **Joda**, necesitamos descargar el JAR y despues añadirla a nuestra instancia del shell:

`wget https://github.com/JodaOrg/joda-time/releases/download/v2.9.4/joda-time-2.9.4-dist.tar.gz`
`tar xvf joda-time-2.9.4-dist.tar.gz`

Añadimos la libreria a nuestra instancia, de esta manera podemos importar las clases de la biblioteca y usarlas:
```
kotlinc-jvm -cp joda-time-2.9.4/joda-time-2.9.4.jar
Welcome to Kotlin version 1.1-M04 (JRE 1.8.0_66-internal-b17)
Type :help for help, :quit for quit
>>> import org.joda.time.DateTime
>>> DateTime.now()
2016-08-25T22:53:41.017+01:00
```
## Kotlin para scripting
Kotlin tambien puede ser usado para correrse como un script. Una alternativa a `bash` o `perl` por mencionar algunos.

Por ejemplo el siguiente script borra todos los archivos que son mas viejos que el No. de dias que se pasa como argumento.
```
import java.io.File 
    val purgeTime = System.currentTimeMillis() - args[1].toLong() * 24  * 60 * 60 * 1000 
    val folders = File(args[0]).listFiles { file -> file.isFile } 
    folders ?.filter { 
      file -> file.lastModified() < purgeTime } 
    ?.forEach { 
      file -> println("Deleting ${file.absolutePath}") 
      file.delete() 
    }
```
El codigo contiene un caracter curioso, `?`, este caracter es conocido como **Operador de llamado seguro**, esto en pocas palabra evita el terrible error NullPointerException.

El script recibe dos argumentos: el directorio, y el numero de dias limite. Por cada archivo encontrado en el directorio, se verifica el momento en que fue modificado, si es menor que los dias limite que se paso por argumento, este sera eliminado.

Para poder correr el archivo com script Kotlin hace uso de la biblioteca `kotlin-script-runtime.jar`, y podemos ejecutarlo con el siguiente comando: `kotlinc -script delete.kts . 5`, en este caso le estamos indicando al script que busque en el directorio actual y con un limite de dias de 5.
## Kotlin y otras herramientas
- Kotlin puede ser usado con Gradle
- Kotlin puede ser usado co Maven
- Kotlin puede ser usado en Intellij
- Kotlin puede ser usado en Eclipse
- Kotlin puede ser usado en STS
- Kotlin puede ser mezclado en un proyecto con Java facilmente
