import scala.collection.immutable.HashMap
import scala.collection.mutable

object Main {
  def main(args: Array[String]): Unit = {
    // scala map
    val cityToCapitals = Map("China" -> "Shanghai", "Japan" -> "Tokyo")
    println(cityToCapitals("China"))
    println(cityToCapitals.getClass.getName)

    // Scala support growing new types
    // in the following example, we can see the same method factorial() implemented in scala and in Java
    // scala allow us to use the BigInt type like a built-in type even thought it's still a library
    // while in the following java version we are seeing that we have to do a lot of extra work to use the BigInteger class
    // even though scala.math.BigInteger is based on the java library
    def factorial(x: BigInt): BigInt = if (x == 0) 1 else x * factorial(x - 1)
    println(factorial(30).getClass.getName)

    import java.math.BigInteger
    def factorialInJava(x: BigInteger): BigInteger = if (x == BigInteger.ZERO)
      BigInteger.ONE
    else x.multiply(factorialInJava(x.subtract(BigInteger.ONE)))

    // Scala is scalable because of it's OOP
    // Scala is purely Object-Oriented. Meaning that every value is an object, even 1, 2, 3.
    // And every operation is a method call, even +, -, *. /
    // even 1 + 1 is so:
    println(1 + 1)
    println(1.getClass.getName)

    // Apart from that Scala trait is similar to interfaces, but it's more pluggable?

    // Scala is also a functional language, it means two things:
    // 1. functions are first-class values
    // 2. operations of programs should map input values to new output values instead of changing data in place
    val testString = "it is huge"
    val newString = testString.replace("it is", "it's")
    println(s"Old string was not modified becasue it's immutable: $testString")
    println(s"New string is yield after the operation: $newString")

    // Scala implicit conversion
    // Scala allow setting up implicit conversion, for example when it doesn't find the toInt method of the
    // Java String class, it will convert it to a scala RichString class which has toInt
    // this enhanced Scala's interoperability with Java
    val testIntegerInString: java.lang.String = "9"
    print(testIntegerInString.toInt)

    // Scala is more concise than Java: Less code
    // For example when defining a class we can simply do it in one line of code, and it will create constructor for the class
    // With hostName and database set up as private parameter
    class Bootstraper(hostName: String, database: String)
    val OceanBootstrapper = new Bootstraper("abc.abc", "oceanData")

    // Scala is static typing language, it is not as flexible as dyanmic typing language such as python, it provide more safety
    // it also support type inference
    val aHashMap: Map[Integer, String] = new HashMap[Integer, String]()
    val aNewHashMap: Map[Integer, String] =
      new HashMap() // we can skip the repeating type declaration here
  }
}
