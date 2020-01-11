package com.peker.roomdatabase.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {

@Query("select * from user")
fun getAllData():List<User>

@Query("select * from user where id = :userId")
fun findById(userId:String):User

@Insert
fun addUser(user:User)

@Query("DELETE from user where id = :userId")
fun deleteUserById(userId:String)


}