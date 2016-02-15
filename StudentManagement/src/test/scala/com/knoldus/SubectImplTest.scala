package com.knoldus
import org.scalatest.FunSuite
/**
  * Created by knodus on 12/2/16.
  */
class SubectImplTest extends FunSuite{

  val sub=new SubjectImpl
  test("SubjectImpl: getConnection"){
    val c=sub.getConnection()
    assert(c != null)
  }

  test("SubjectImpl : insertRecord :Adding duplicate value"){
    val result=sub.insertRecord(1,"scala")
    assert(result === 0)
  }

  test("SubjectImpl : insertRecord :Adding new row"){
        val result=sub.insertRecord(4,"C#")
    assert(result === 1)
  }

  test("SubjectImpl : deleteRecord"){
    val result=sub.deleteRecord(4)
    assert(result === 1)
  }
}
