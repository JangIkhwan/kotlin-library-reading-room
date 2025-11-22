package library.controller

import library.controller.constant.Command
import library.model.MenuOption
import library.view.UserInputView
import library.view.UserOutputView

class UserPromptController(val inputView: UserInputView, val outputView: UserOutputView) : Controller {
    var commandMap: MutableMap<MenuOption, Command>

    init{
        commandMap = mutableMapOf<MenuOption, Command>()
        commandMap.put(MenuOption(1), Command.SHOW_SEATS)
        commandMap.put(MenuOption(2), Command.RESERVE_SEAT)
        commandMap.put(MenuOption(3), Command.RETURN_SEAT)
        commandMap.put(MenuOption(4), Command.LOGIN_PROMPT)
    }

    override fun run(): Command {
        var option: MenuOption? = null;
        while(true){
            inputView.printMenu()
            option = inputView.getOption()
            if(commandMap.containsKey(option)){
                break
            }
            outputView.printMessage("[ERROR] 존재하지 않는 메뉴 번호입니다")
        }
        return commandMap.getOrDefault(option, Command.EXIT)
    }
}