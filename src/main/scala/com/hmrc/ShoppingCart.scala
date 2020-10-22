package com.hmrc

case class ShoppingCart(items: List[Item] = Nil) {
  def total: Int = {
    items.map(_.price).sum
  }

  def add(item: Item): ShoppingCart = ShoppingCart(item :: items)
}

object ShoppingCart {
  import Item._

  def fromItemNames(itemNames: List[String]): ShoppingCart = {
        ShoppingCart(itemNames.map(toItem(_)) )
  }

  private val toItem = Map("Apple" -> Apple, "Orange" -> Orange)
}
