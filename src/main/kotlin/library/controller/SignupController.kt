package library.controller

import library.service.SignupService
import library.view.LoginAndSignupInputView
import library.view.LoginAndSignupOutputView

class SignupController(val inputView: LoginAndSignupInputView, val outputView: LoginAndSignupOutputView, val signupService: SignupService) : Controller{
    override fun run(): String {
        outputView.printMessage("회원가입을 진행합니다")
        val studentNumber: String = inputView.readLine("학번을 입력하세요 >")
        val name: String = inputView.readLine("이름을 입력하세요 >")
        val password: String = inputView.readLine("비밀번호를 입력하세요 >")
        try{
            signupService.signup(studentNumber, name, password)
            outputView.printMessage("회원가입에 성공했습니다")
        }
        catch (e : RuntimeException){
            outputView.printError(e)
        }
        return "loginPrompt"
    }
}
