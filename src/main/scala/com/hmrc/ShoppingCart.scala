package com.hmrc

import com.hmrc.Item.{Apple, Orange}

case class ShoppingCart(items: List[Item] = Nil) {
  def total: Int = {

    val apples = items.filter(_ == Apple).sliding(1,2).flatten
    val oranges = items.filter(_ == Orange).sliding(2,3).flatten
    (apples ++ oranges).map(_.price).sum
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
