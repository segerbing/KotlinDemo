package kotlinInAction.chapter3

import java.lang.IllegalArgumentException

//局部函数

fun main(args: Array<String>) {
    saveUser_2(User(1, "11", ""))
}


class User(val id : Int, val name : String, val address : String)

fun  saveUser(user : User){
    if (user.name.isEmpty()){
        throw IllegalArgumentException(
                "Can't save user ${user.id}: empty Name")
    }

    if (user.address.isEmpty()){
        throw IllegalArgumentException(
                "Can't save user ${user.id}: empty Address")
    }

    //TODO 保存 user 到数据库
}

fun saveUser_2(user : User){
    //声明一个局部函数来验证所有字段
    fun validate(user : User,
                 value : String,
                 fieldName : String){
        if (value.isEmpty()){
            throw IllegalArgumentException(
                    "Can't save user ${user.id} : empty $fieldName"
            )
        }
    }

    //调用局部函数来验证特定字段
    validate(user, user.name, "Name")
    validate(user, user.address, "Address")

    //TODO 保存 user 到数据库
}

fun saveUser_3(user : User){
    //局部函数可以访问所在函数的所有参数和变量
    fun validate(value : String, fieldName : String){
        if (value.isEmpty()){
            throw IllegalArgumentException(
                    "Can't save user ${user.id} : empty $fieldName"
            )
        }
    }

    validate(user.name, "Name")
    validate(user.address, "Address")

    //TODO 保存 user 到数据库
}

//提取验证逻辑到 User 的扩展函数中
fun User.validateBeforSave(){
    fun validate(value : String, fieldName : String){
        if (value.isEmpty()){
            throw IllegalArgumentException(
                    "Can't save user $id : empty $fieldName" //可以直接访问 User 类的属性
            )
        }
    }

    validate(name, "Name")
    validate(address, "Address")
}

fun saveUser_4(user : User){
    user.validateBeforSave()

    //TODO 保存 user 到数据库
}