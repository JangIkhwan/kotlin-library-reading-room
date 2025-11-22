package library.view

import camp.nextstep.edu.missionutils.Console
import library.model.MenuOption
import java.time.format.DateTimeFormatter

class LoginAndSignupInputView {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")

    fun getOption(): MenuOption {
        while(true){
            print("선택하세요 > ")
            val line = Console.readLine()
            try{
                val number = parseNumber(line)
                return MenuOption(number)
            }
            catch (e : RuntimeException){
                println(e.message)
            }
        }
    }

    private fun parseNumber(line: String): Int {
        try{
            return line.toInt()
        }
        catch (e : NumberFormatException){
            throw IllegalArgumentException("[ERROR] 숫자를 입력하세요")
        }
    }

    fun readLine(message: String): String {
        print(message)
        return Console.readLine()
    }
}
