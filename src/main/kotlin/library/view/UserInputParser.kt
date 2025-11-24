package library.view

import library.model.MenuOption
import library.model.SeatNumber

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

    fun parseSeatNumber(number: String): SeatNumber {
        var value: Int
        try{
             value = number.toInt()
        }
        catch (e: NumberFormatException){
            throw IllegalArgumentException("[ERROR] 좌석 번호는 정수여야 합니다")
        }
        return SeatNumber(value)
    }
}
