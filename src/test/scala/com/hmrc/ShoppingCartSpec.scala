package com.hmrc

import Item.{Apple, Banana, Orange}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class ShoppingCartSpec extends AnyFlatSpec with Matchers {
  it should "add items" in {
    val cart = ShoppingCart()
      .add(Apple)
      .add(Orange)
    
     cart.items should  be (List(Apple, Orange).reverse)
  }
  
  it should "add from list of item names"  in {
    val cart = ShoppingCart.fromItemNames(List("Apple", "Orange"))
    cart.items should be(List(Apple, Orange))
  }

  it should "calculate two for the price of one on Apples" in {
    val cart = ShoppingCart.fromItemNames(List("Apple", "Apple"))
    cart.total should be (60)
  }

  it should "calculate three for the price of two Oranges" in {
    val cart = ShoppingCart.fromItemNames(List("Orange", "Orange", "Orange"))
    cart.total should be (50)
  }

  it should "calculate the correct price for 4 Oranges" in {
    val cart = ShoppingCart.fromItemNames(List("Orange", "Orange", "Orange", "Orange"))
    cart.total should be (75)
  }

  it should "calculate the correct price for 5 Oranges" in {
    val cart = ShoppingCart.fromItemNames(List("Orange", "Orange", "Orange",
                                               "Orange", "Orange", "Orange"))
    cart.total should be (100)
  }

  it should "calculate the correct price for 3 Apples" in {
    val cart = ShoppingCart.fromItemNames(List("Apple", "Apple", "Apple"))
    cart.total should be (120)
  }

  it should "calculate the correct price for a mixed basket" in {
    val cart = ShoppingCart.fromItemNames(List("Apple", "Orange", "Orange",
                                               "Apple", "Orange", "Apple", "Orange"))
    cart.total should be (195)
  }

  it should "add Bananas" in {
    val cart = ShoppingCart.fromItemNames(List("Banana", "Banana"))
    cart.items should be(List(Banana, Banana))
  }

  it should "calculate two for the price of one on Banana" in {
    val cart = ShoppingCart.fromItemNames(List("Banana", "Banana"))
    cart.total should be (20)
  }

  it should "calculate min of Apples and bananas free if both present" in {
    val cart = ShoppingCart.fromItemNames(List("Banana", "Apple"))
    cart.total should be (60)
  }

  it should "calculate a mix basket of bananas and oranges" in {
    val cart = ShoppingCart.fromItemNames(List("Banana", "Banana", "Orange"))
    cart.total should be (45)
  }

  it should "calculate a mix basket of bananas, apples, and oranges" in {
    val cart = ShoppingCart.fromItemNames(List("Banana", "Banana", "Orange", "Apple"))
    cart.total should be (85)
  }

  it should "calculate a mix basket with bananas same price as apples" in {
    val cart = ShoppingCart.fromItemNames(List("Banana", "Banana", "Banana", "Banana",
                                               "Banana", "Banana", "Orange", "Apple"))
    cart.total should be (85)
  }

  it should "calculate a mix basket with bananas more expensive than apples" in {
    val cart = ShoppingCart.fromItemNames(List("Banana", "Banana", "Banana", "Banana",
                                               "Banana", "Banana", "Banana", "Orange",
                                               "Apple"))
    cart.total should be (105)
  }
}
