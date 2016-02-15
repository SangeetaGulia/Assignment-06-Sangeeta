package com.knoldus
import org.scalatest.FunSuite
/**
  * Created by knodus on 12/2/16.
  */
class Student_SubjectImplTest extends FunSuite{

  val stud_sub=new Student_SubjectImpl
  test("SubjectImpl: getConnection"){
    val c=stud_sub.getConnection()
    assert(c!=null)
  }

  test("SubjectImpl : insertRecord :Adding duplicate value"){
    val result=stud_sub.insertRecord(1,1)
    assert(result===0)
  }

  test("SubjectImpl : insertRecord :Adding new row"){
    val result=stud_sub.insertRecord(1,3)
    assert(result===1)
  }

  test("SubjectImpl : deleteRecord"){
    val result=stud_sub.deleteRecord(1,3)
    assert(result===1)
  }

}
