object Chapter2Introduction {
  def main(args: Array[String]): Unit = {
    // val and var. val is similar to final while var can be reassigned.
    val notAssignableVariable = "a not assignable string"
    var assignableVariable = "assignable string"

    // this won't compile
    // notAssignableVariable = "assign a new value to it"

    // this will work
    assignableVariable = "assign a new value to it"

    // create a scala function
    // scala function requires declaring the data type of parameters, but it can infer the result type
    def getMax(a: Int, b: Int): Int = {
      if (a > b) {
        a
      } else {
        b
      }
    }
    print(s"the result of getMax(2, 3) is ${getMax(2, 3)}")

    // however if a function is recursive (like below), it can't infer the return type and we have to specify it
//    def fib(n: Int) = {
//      if (n == 1) 1
//      else if (n == 2) 2
//      else fib(n - 2) + fib(n - 1)
//    }

    // scala as a functional language has functions as first-class constructs
    // we can pass in function literal as an argument, for example
    val codes = Array("abc", "def", "yui")
    codes.foreach(code => println(code))
    // another shorthand for this is:
    codes.foreach(println)

    // scala also has for, but not an imperative one we seen in other language
    for (code <- codes)
      println(code)
  }
}
