package com.knoldus
import org.slf4j.LoggerFactory

import java.sql._

/**
  * Created by knodus on 12/2/16.
  */
class StudentImpl{

  def getConnection():Connection={
      val url:String = "jdbc:mysql://localhost/student_data"
      Class.forName("com.mysql.jdbc.Driver")
    try {
      val conn: Connection = DriverManager.getConnection(url, "root", "knoldus")
      conn
    }
    catch{
      case ex:Exception =>
        val logger = LoggerFactory.getLogger(this.getClass())
        logger.info("Attempt to create connection Failed" + ex)
        null
    }

  }

  def insertRecord(id:Int,name:String,phone:BigInt,email:String): Int ={
    try {
      val conn = getConnection()
      val stat: Statement = conn.createStatement()
      val rs: Int = stat.executeUpdate("insert into student values(" + id + ",'" + name + "'," + phone + ",'" + email + "');")
      conn.close()
      rs
    }
    catch{
      case ex:Exception =>
        val logger = LoggerFactory.getLogger(this.getClass())
        logger.info("Exception while inserting : " + ex)
        0
    }

  }

  def deleteRecord(id:Int): Int ={
    try {
      val conn = getConnection()
      val stat: Statement = conn.createStatement()
      val rs: Int = stat.executeUpdate("delete from student where stud_id=" + id + ";")
      conn.close()
      rs
    }
    catch{
      case ex:Exception =>
        val logger = LoggerFactory.getLogger(this.getClass())
        logger.info("Exception while deletion : " + ex)
        0
    }

  }


  def updatePhone(id:Int,phone:BigInt): Int ={
    try {
      val conn = getConnection()
      val stat: Statement = conn.createStatement()
      val rs: Int = stat.executeUpdate("update student set phone_no=" + phone + " where stud_id=" + id + ";")
      conn.close()
      rs
    }
    catch{
      case ex:Exception =>
        val logger = LoggerFactory.getLogger(this.getClass())
        logger.info("Exception while updating Phone : " + ex)
        0
    }
  }

  def updateEmail(id:Int,email:String): Int ={
    try {
      val conn = getConnection()
      val stat: Statement = conn.createStatement()
      val rs: Int = stat.executeUpdate("update student set email='" + email + "' where stud_id=" + id + ";")
      conn.close()
      rs
    }
    catch{
      case ex:Exception =>
        val logger = LoggerFactory.getLogger(this.getClass())
        logger.info("Exception while updating Email : " + ex)
        0
    }
  }

  def updateName(id:Int,name:String): Int ={
    try{
    val conn=getConnection()
    val stat:Statement=conn.createStatement()
    val rs:Int= stat.executeUpdate("update student set stud_name='" + name + "' where stud_id=" + id + ";")
    conn.close()
    rs
  }
    catch{
      case ex:Exception =>
        val logger = LoggerFactory.getLogger(this.getClass())
        logger.info("Exception while updating Name : " + ex)
        0
    }
  }

}
