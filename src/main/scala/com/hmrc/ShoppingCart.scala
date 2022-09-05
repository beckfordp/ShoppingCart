package com.hmrc

import com.hmrc.Item.{Apple, Banana, Orange}

case class ShoppingCart(items: List[Item] = Nil) {
  def total: Int = {

    val apples = items.filter(_ == Apple).sliding(1,2).flatten
    val oranges = items.filter(_ == Orange).sliding(2,3).flatten
    val bananas = items.filter(_ == Banana).sliding(1,2).flatten
    Math.max(apples.map(_.price).sum, bananas.map(_.price).sum) + oranges.map(_.price).sum
  }

  def add(item: Item): ShoppingCart = ShoppingCart(item :: items)
}

object ShoppingCart {
  import Item._

  def fromItemNames(itemNames: List[String]): ShoppingCart = {
        ShoppingCart(itemNames.map(toItem(_)) )
  }

  private val toItem = Map(
    "Apple" -> Apple,
    "Orange" -> Orange,
    "Banana" -> Banana)
}
