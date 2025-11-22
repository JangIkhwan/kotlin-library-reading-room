package library.service

import library.model.User
import library.repository.UserRepository

class SignupService (val userRepository: UserRepository){
    fun signup(studentNumber: String, name: String, password: String) {
        validateStudentNumber(studentNumber)
        userRepository.save(User(studentNumber, name, password))
    }

    private fun validateStudentNumber(studentNumber: String) {
        val studentNumberRegex = Regex("^\\d{9}$")
        if(!studentNumberRegex.matches(studentNumber)){
            throw IllegalArgumentException("[ERROR] 아이디는 9자리 숫자여야 합니다")
        }
        if(userRepository.existsById(studentNumber)){
            throw IllegalArgumentException("[ERROR] 해당 학번은 이미 계정이 존재합니다")
        }
    }
}
