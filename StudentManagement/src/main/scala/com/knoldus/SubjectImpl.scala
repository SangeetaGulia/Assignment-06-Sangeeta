package com.knoldus

import java.sql.{Statement, DriverManager, Connection}

import org.slf4j.LoggerFactory

/**
  * Created by knodus on 12/2/16.
  */
class SubjectImpl {

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

  def insertRecord(id:Int,name:String): Int ={
    try {
      val conn = getConnection()
      val stat: Statement = conn.createStatement()
      val rs: Int = stat.executeUpdate("insert into subject values(" + id + ",'" + name + "');")
      conn.close()
      rs
    }
    catch{
      case ex:Exception =>
        val logger = LoggerFactory.getLogger(this.getClass())
        logger.info("Exception while inserting in subject table : " + ex)
        0
    }

  }

  def deleteRecord(id:Int): Int ={
    try {
      val conn = getConnection()
      val stat: Statement = conn.createStatement()
      val rs: Int = stat.executeUpdate("delete from subject where sub_id=" + id + ";")
      conn.close()
      rs
    }
    catch{
      case ex:Exception =>
        val logger = LoggerFactory.getLogger(this.getClass())
        logger.info("Exception while deletion in subject table : " + ex)
        0
    }

  }
}
