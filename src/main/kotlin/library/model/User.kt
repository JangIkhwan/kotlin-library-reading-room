package library.model

class User(val id: String, name: String, password: String) {
    init{
        validateName(name)
        validatePassword(password)
    }

    private fun validateName(name: String) {
        if(name.isEmpty() || name.isBlank()){
            throw IllegalArgumentException("[ERROR] 이름은 공백일 수 없습니다")
        }
    }

    private fun validatePassword(password: String) {
        val passwordRegex = Regex("^[0-9a-zA-Z]{4,8}$")
        if(!passwordRegex.matches(password)){
            throw IllegalArgumentException("[ERROR] 비밀번호는 영어대소문자와 숫자만 포함해야하며 길이는 4이상 8이하여야 합니다")
        }
    }
}
