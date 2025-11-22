package library.view

import library.model.CustomClock

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

    fun printSignupBeginning(time: String) {
        println("회원가입을 진행합니다")
        println("시스템이 기억하는 마지막 시간은 " + time + "입니다")
    }
}
