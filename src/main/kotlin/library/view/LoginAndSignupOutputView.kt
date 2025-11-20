package library.view

class LoginAndSignupOutputView {
    fun printMenu() {
        println("==== 열람실 좌석 배정 프로그램 ====")
        println("로그인 프롬프트")
        println("1. 회원가입")
        println("2. 로그인")
        println("3. 프로그램 종료")
    }

    fun printMessage(message: String) {
        println(message)
    }

    fun printError(e: RuntimeException) {
        println(e.message)
    }
}
