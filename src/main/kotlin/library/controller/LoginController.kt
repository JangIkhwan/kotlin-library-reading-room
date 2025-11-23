package library.controller

import library.controller.constant.Command
import library.model.Clock
import library.service.LoginService
import library.view.LoginAndSignupInputView
import library.view.LoginAndSignupOutputView

class LoginController(val inputView: LoginAndSignupInputView, val outputView: LoginAndSignupOutputView, val loginService: LoginService, val clock: Clock) : Controller{
    override fun run(): Command {
        outputView.printLoginBeginning(clock.getTime())
        val studentNumber = inputView.readLine("학번을 입력하세요 > ")
        val password = inputView.readLine("비밀번호를 입력하세요 > ")
        val currentTime = inputView.readLine("현재 시간을 입력하세요 > ")
        try{
            clock.updateTime(currentTime)
            if(loginService.login(studentNumber, password)){
                outputView.printLoginSucceed(loginService.getLoginedUserName())
                return Command.USER_PROMPT
            }
            outputView.printMessage("아이디나 비밀번호가 일치하지 않습니다")
        }
        catch (e : IllegalArgumentException){
            outputView.printError(e)
        }
        return Command.LOGIN_PROMPT
    }
}
