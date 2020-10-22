package com.hmrc

import com.hmrc.Item.{Apple, Orange}

case class ShoppingCart(items: List[Item] = Nil) {
  def total: Int = {

    val apples = items.filter(_ == Apple).sliding(2,2).flatMap  {
      case List(Apple, Apple) => List(Apple)
      case apples => apples
    }

    val oranges = items.filter(_ == Orange).sliding(2,3).flatMap {
      case List(Orange, Orange, Orange) => List(Orange, Orange)
      case oranges => oranges
    }

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
