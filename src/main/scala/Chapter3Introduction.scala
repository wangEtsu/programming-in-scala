import scala.::

object Chapter3Introduction {
  def main(args: Array[String]): Unit = {
    print("Chapter 3: Next Step")
    // scala parameterize an object with type
    val exampleArray = Array[String]("a", "b", "c")
    // but the better way is to ignore it sometimes, because scala compiler can infer the data type of the element in array
    val inferredArray = Array("a", "b")
    print(inferredArray.getClass.getName)

    // now again exampleArray can't be reassigned
    // exampleArray = Array[String]("c", "d", "e") // this won't compile
    // however, the array it self is actually mutable, we can change the element in it
    exampleArray(0) = "Something"
    exampleArray(1) = "New"
    exampleArray(2) = "Inserted"
    exampleArray.foreach(println)

    // scala doesn't really have operator, they are actually all methods
    // in below example + is a method under Int class, and we can called it in either way as shown below
    println(s"The result of 1 + 2 is ${1 + 2}")
    println(s"The result of 1 + 2 is ${1.+(2)}")

    // similarly, how we access and update a scala array, is also by using methods
    // scala use these sort of syntax sugar, and compiler will transform the code
    println(s"the first element of example array is ${exampleArray(0)}")
    println(s"the first element of example array is ${exampleArray.apply(0)}")
    println(s"update the first element")
    exampleArray(0) = "Anything"
    exampleArray.update(0, "Anything")
    println(s"the first element of example array is ${exampleArray(0)}")

    // quick peek of scala lists
    // we need to know that lists is immutable, unlike arrays
    val mutableArray = Array[String]("str1", "str2")
    println(s"mutableArray starts with value ${mutableArray.mkString(",")}")
    mutableArray(0) = "strUpdated"
    println(
      s"mutableArray after update, new value is ${mutableArray.mkString(",")}"
    )

    val immutableList = List[String]("str1", "str2")
    println(s"immutableList starts with value ${immutableList.mkString(",")}")

    immutableList ::: List[String]("str3", "str4") // ::: append list together
    println(
      s"immutableList doesn't change after append operation ${immutableList.mkString(",")}"
    )

    // quick peek of scala tuple: immutable and can contain data of different type
    val firstTuple = ("str", 3, 4.toFloat)
    println(firstTuple._1)
    println(firstTuple._2)
    println(firstTuple._3)

    // note that scala tuple start from 1 instead of 0, this is simply a tradition pass from tuples in other statically typed languages
    // firstTuple._0 // this won't work

    // scala set can be mutable or immutable - decideds on which trait the set mixed in
    // by default the set is immutable
    val defaultImmutableSet = Set("str1", "str2")
    val newSet = defaultImmutableSet + "Something"
    println(
      s"the default immutableSet will not change it's value but will output a new set: ${defaultImmutableSet
        .mkString(",")}"
    )
    // mutable set
    import scala.collection.mutable.Set // import allow using simple name
    val mutableSet = Set("str1", "str2")
    mutableSet += "str3"
    println(
      s"mutable set can be added with new value: ${mutableSet.mkString(",")}"
    )

    // map work similarly
    // default map is immutable
    val defaultImmutableMap = Map(1 -> "str1", 2 -> "str2")
    println(defaultImmutableMap(1))
    // import to use mutable map
    import scala.collection.mutable.Map
    val mutableMap = Map(1 -> "str1")
    println(
      s"Mutable map can add new element on top of it: ${mutableMap.addOne((2, "str3")).mkString(",")}"
    )

    // imperative VS functional programming. Scala offers both option, but if we decided
    // to go functional we should avoid using var, and minimize the side effect function caused
    // the benefit is that it will make code less error-prone and more testable
    // for example imperative
    def imperativeWhileLoop(args: Array[String]): Unit = {
      var i = 0
      while (i < args.length) {
        print(args(i))
        i += 1
      }
    }

    // however we can make it purely functional by refactoring it to:
    def functionalWhileLoop(args: Array[String]): String = {
      args.mkString(",")
    } // the benefit of it: no side effect, output is in string instead of printing to stirng
    // no usage of var, cleaner and easier
    // eventually, use scala functional/imperative to suit the job

  }
}
