package library.controller

import library.controller.constant.Command
import library.model.MenuOption
import library.view.LoginAndSignupInputView
import library.view.LoginAndSignupOutputView

class LoginAndSignupPromptController(val inputView: LoginAndSignupInputView, val outputView: LoginAndSignupOutputView) : Controller{
    val commandMap: MutableMap<MenuOption, Command>

    init{
        commandMap = mutableMapOf()
        commandMap.put(MenuOption(1), Command.SIGNUP)
        commandMap.put(MenuOption(2), Command.LOGIN)
        commandMap.put(MenuOption(3), Command.EXIT)
    }

    override fun run(): Command {
        var option: MenuOption? = null
        while(true){
            outputView.printMenu()
            option = inputView.getOption()
            if(commandMap.containsKey(option)){
                break
            }
            outputView.printMessage("[ERROR] 존재하지 않는 메뉴 번호입니다");
        }
        return commandMap.getOrDefault(option, Command.EXIT)
    }
}