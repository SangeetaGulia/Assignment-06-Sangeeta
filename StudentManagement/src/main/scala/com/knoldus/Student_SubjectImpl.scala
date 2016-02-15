package com.knoldus
import java.sql.{Statement, DriverManager, Connection}
import org.slf4j.LoggerFactory

/**
  * Created by knodus on 12/2/16.
  */

class Student_SubjectImpl {

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

  def insertRecord(studid:Int,subid:Int): Int ={
    try {
      val conn = getConnection()
      val stat: Statement = conn.createStatement()
      val rs: Int = stat.executeUpdate("insert into student_subject values(" + studid + ",'" + subid + "');")
      conn.close()
      rs
    }
    catch{
      case ex:Exception =>
        val logger = LoggerFactory.getLogger(this.getClass())
        logger.info("Exception while inserting in student_subject table : " + ex)
        0
    }

  }

  def deleteRecord(studid:Int,subid:Int): Int ={
    try {
      val conn = getConnection()
      val stat: Statement = conn.createStatement()
      val rs: Int = stat.executeUpdate("delete from student_subject where stud_id=" + studid +" and sub_id=" + subid + ";")
      conn.close()
      rs
    }
    catch{
      case ex:Exception =>
        val logger = LoggerFactory.getLogger(this.getClass())
        logger.info("Exception while deletion in student_subject table : " + ex)
        0
    }

  }


}
