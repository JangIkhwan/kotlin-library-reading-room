package library.view

import library.model.MenuOption

class UserInputParser {
    fun parseMenuInput(menuInput: String): MenuOption{
        var value: Int
        try{
             value = menuInput.toInt()
        }
        catch (e: NumberFormatException){
            throw IllegalArgumentException("[ERROR] 메뉴 번호는 정수여야 합니다")
        }
        return MenuOption(value)
    }
}
