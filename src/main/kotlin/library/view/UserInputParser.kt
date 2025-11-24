package library.view

import library.library.model.vo.MenuOption
import library.library.model.vo.SeatNumber

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
