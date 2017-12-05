import scala.annotation.implicitNotFound

object ImplicitValues4 extends App {
  @implicitNotFound("Can't find implicit of type Multiplier in scope")
  class Multiplier(val value: Int) extends AnyVal

  @implicitNotFound("Can't found implicit of type divider in scope")
  class Divider(val value: Int) extends AnyVal

  implicit val defaultMultiplier = new Multiplier(2)
  implicit val defaultDivider = new Divider(2)

  def multiply(value: Int)(implicit multiplier: Multiplier): Int = value * multiplier.value
  def divide(value: Int)(implicit divider: Divider): Int = value * divider.value

  println(s"multiply(2)(3)=${multiply(2)(new Multiplier(4))}")
  println(s"multiply(5)=${multiply(4)}")

}
