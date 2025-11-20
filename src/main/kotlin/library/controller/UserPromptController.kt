package library.controller

import library.model.MenuOption
import library.view.UserInputView

class UserPromptController(val inputView: UserInputView) : Controller {
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
        }
        return commandMap.getOrDefault(option, "exit")
    }
}