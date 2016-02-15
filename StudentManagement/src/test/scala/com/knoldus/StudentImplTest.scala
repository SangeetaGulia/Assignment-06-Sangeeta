package com.knoldus

import org.scalatest.FunSuite
/**
  * Created by knodus on 12/2/16.
  */
class StudentImplTest extends FunSuite  {

  val stud=new StudentImpl
  test(" StudentImpl: getConnection "){
    val c=stud.getConnection()
    assert(c != null)
  }

  test("StudentImpl : insertRecord :Adding duplicate value"){
    val bigInt:BigInt=BigInt("982636754812")
    val result=stud.insertRecord(4,"anubhav",bigInt,"deepak@knoldus.in")
    assert(result === 0)
  }

  test("StudentImpl : insertRecord :Adding new row"){
    val bigInt:BigInt=BigInt("9726167548")
    val result=stud.insertRecord(5,"niki",bigInt,"niki@knoldus.in")
    assert(result===1)
  }

  test("StudentImpl : deleteRecord"){
    val result=stud.deleteRecord(5)
    assert(result===1)
  }

  test("StudentImpl : deleteRecord : Deleting non-existing tuple"){
    val result=stud.deleteRecord(7)
    assert(result===0)
  }


  /*
  test("StudentImpl : updatePhone"){
    val bigInt:BigInt=BigInt("9211840832")
    val result=stud.updatePhone(2,bigInt)
    assert(result===1)
  }
  */

  test("StudentImpl : updateEmail"){
        val result=stud.updateEmail(1,"sangita.gulia@knoldus.com")
    assert(result===1)
  }

  test("StudentImpl : updateName"){
    val result=stud.updateName(1,"sangeeta")
    assert(result===1)
  }
}
