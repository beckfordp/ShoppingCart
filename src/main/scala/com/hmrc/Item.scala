package com.hmrc

sealed abstract class Item(val price: Int)  extends Product with Serializable

object Item {
  final case object Apple extends Item(60)
  final case object Orange extends Item(25)
  final case object Banana extends Item(20)
}