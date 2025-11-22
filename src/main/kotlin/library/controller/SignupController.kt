package library.controller

import library.controller.constant.Command
import library.model.CustomClock
import library.service.SignupService
import library.view.LoginAndSignupInputView
import library.view.LoginAndSignupOutputView

class SignupController(val inputView: LoginAndSignupInputView, val outputView: LoginAndSignupOutputView, val signupService: SignupService, val clock: CustomClock) : Controller{
    override fun run(): Command {
        outputView.printSignupBeginning(clock.getTime())
        val studentNumber: String = inputView.readLine("학번을 입력하세요 > ")
        val name: String = inputView.readLine("이름을 입력하세요 > ")
        val password: String = inputView.readLine("비밀번호를 입력하세요 > ")
        val currentTime: String = inputView.readLine("현재 시간을 입력하세요 > ")
        try{
            clock.updateTime(currentTime)
            signupService.signup(studentNumber, name, password)
            outputView.printMessage("회원가입에 성공했습니다")
        }
        catch (e : RuntimeException){
            outputView.printError(e)
        }
        return Command.LOGIN_PROMPT
    }
}
