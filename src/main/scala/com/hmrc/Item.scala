package com.hmrc

sealed abstract class Item(val price: Int)

object Item {
  final case object Apple extends Item(60)
  final case object Orange extends Item(25)
}