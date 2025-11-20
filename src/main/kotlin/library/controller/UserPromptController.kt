package library.controller

import library.model.MenuOption
import library.view.UserInputView
import library.view.UserOutputView

class UserPromptController(val inputView: UserInputView, val outputView: UserOutputView) : Controller {
    var commandMap: MutableMap<MenuOption, String>

    init{
        commandMap = mutableMapOf<MenuOption, String>()
        commandMap.put(MenuOption(1), "showSeat")
        commandMap.put(MenuOption(2), "reserveSeat")
        commandMap.put(MenuOption(3), "returnSeat")
        commandMap.put(MenuOption(4), "exit")
    }

    override fun run(): String {
        var option: MenuOption? = null;
        while(true){
            inputView.printMenu()
            option = inputView.getOption()
            if(commandMap.containsKey(option)){
                break
            }
            outputView.printMessage("[ERROR] 존재하지 않는 메뉴 번호입니다")
        }
        return commandMap.getOrDefault(option, "exit")
    }
}