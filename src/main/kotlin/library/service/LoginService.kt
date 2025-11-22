package library.service

import library.model.User
import library.repository.UserRepository

class LoginService (private val userRepository: UserRepository){
    var loginedUser: User? = null

    fun login(studentNumber: String, password: String): Boolean {
        val user = userRepository.findById(studentNumber)
        if(user == null){
            return false
        }
        if(user.hasSamePassword(password)){
            loginedUser = user
            return true
        }
        return false
    }

    fun getLoginedUserId(): String {
        if(loginedUser == null){
            throw IllegalArgumentException("[ERROR] 로그인한 사용자가 없습니다")
        }
        return loginedUser!!.id
    }

    fun getLoginedUserName(): String {
        if(loginedUser == null){
            throw IllegalArgumentException("[ERROR] 로그인한 사용자가 없습니다")
        }
        return loginedUser!!.name
    }
}
