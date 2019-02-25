package basics

fun main() {
    //Numbers
    val int = 123
    // Una variables de tipo Long requiere el sufijo L
    val long = 123456L
    val double = 12.34
    // Una variable de tipo Float require del sufijo F
    val float = 12.34F
    // Un hexadecimal requiere del prefijo 0x
    val hexadecimal = 0xAB
    // Un valor binario requiere el prefijo 0b
    val binary = 0b01010101


    // Binary operators
    val leftShift = 1 shl 2
    val rightShift = 1 shr 2
    val unsignedRightShift = 1 ushr 2

    val and = 1 and 0x00001111
    val or = 1 or 0x00001111
    val xor = 1 xor 0x00001111
    val inv = 1.inv()


    //Booleans
    val x = 1
    val y = 2
    val z = 2

    val isTrue = x < y && x < z
    val alsoTrue = x == y || y == z


    //Chars
    val aChar1: Char = 'A'
    val aChar2: Char = '\n'
    val aChar3: Char = '\u1234'


    //Strings
    // In an escaped string special characters should be escaped
    var string = "Kotlin is awesome! \n"
    // In a raw string no escaped need
    var rawString = """This is a raw string,
        can include all characters"""


    //Arrays
    val array = arrayOf(1, 2, 3)
    var perfectSquares = Array(10, { k -> k * k })
    // Usando una sintaxis de corchetes
    val element1 = array[0]
    val element2 = array[1]
    array[2] = 5
    array.get(0)
    array.get(1)

    // Clases especializadas para arrays de diferentes tipos de datos
    var array0 = IntArray(5)
    var array1 = DoubleArray(5)
    var array2 = FloatArray(5)
    var array3 = ByteArray(5)
    var array4 = LongArray(5)
    var array5 = CharArray(5)
    var array6 = BooleanArray(5)
    var array7 = ShortArray(5)
}