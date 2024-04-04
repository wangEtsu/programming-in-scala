object Chapter4ClassesAndObjects {
  def main(args: Array[String]): Unit = {
    // creating a scala class
    class CheckSumAccumulator {
      private var sum = 0
      // functional style want minimum side effect
      // if we look into the below class, we can see the add method is indeed creating side effect by changing sum
      def add(b: Byte): Unit = {
        sum += b // a slightly better way is to write it as "def add(b: Byte) = {sum += b}"
        // this is purely to make the method look more like a 'procedure' which indicates it is only executed for its side effect
      }

      // however, we have to notice that if we remove the equal sign, scala will use Unit as default.
      // this means even if the method return a string, the value will be lost
      def lostReturnString() { "the string will be lost" }

      def lostReturnString2(): Unit = { "this string will be lost too" }
      def returnString() = { "this string won't be lost" }
      def checkSum(): Int = ~(sum & 0xff) + 1
    }

    val csa = new CheckSumAccumulator()
    csa.add(123.toByte)
    println(s"return lost when no equal sign: ${csa.lostReturnString()}")

    // semicolon in scala: usually we don't need it unless multiple statement on same line
    val a = "3"; println("same line");

    // singleton object, companion object/class, standalone object
    // define a singleton object
    object CheckSumAccumulator {
      def printInformation(): Unit = { println("This is a singleton object") }
    }
    // singleton object is something scala use to host static method (there is no static class in scala)
    // similarly, we call it by the object name:
    CheckSumAccumulator.printInformation()

    // in the above case, the object has the same name as the class we defined at the top, so it's a companion object
    // also note that we can't pass in parameter to singleton object, cuz it can't be 'new'
//    object singletonObj {}
//    val singletonAccumulator = new singletonObj() // this won't work

    // scala actually import java.lang and scala package implicitly to a singleton object PreDef.
    // that's how we can use something like println()
    // check how below method is coming from scala.PreDef
    println("")

    // scala application uses singleton with main method as entry point
    // look at the obect of this file Chapter4ClassesAndObjects, it's a singleton object
    // we can also extend the singleton object to the App trait, even though it has some limitations
    object jobRunner extends App { println(":") }
  }
}
