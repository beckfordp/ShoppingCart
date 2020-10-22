package com.hmrc

import Item.{Apple, Orange}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class ShoppingCartSpec extends AnyFlatSpec with Matchers {
  it should "add items" in {
    val cart = ShoppingCart()
      .add(Apple)
      .add(Orange)
    
     cart.items should  be (List(Apple, Orange).reverse)
  }

  it should "calculate total" in {
    val cart =  ShoppingCart()
      .add(Apple)
      .add(Apple)
      .add(Orange)
      .add(Apple)

    cart.total should be (205)
  }

  it should "add from list of item names"  in {
    val cart = ShoppingCart.fromItemNames(List("Apple", "Orange"))
    cart.items should be(List(Apple, Orange))
  }
}
