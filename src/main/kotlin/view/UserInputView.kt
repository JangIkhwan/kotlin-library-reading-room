package library.view

import camp.nextstep.edu.missionutils.Console
import library.model.MenuOption

class UserInputView (val userInputParser : UserInputParser){
    fun printMenu(){
        println("사용자 프롬프트")
        println("1. 도서관 좌석 조회")
        println("2. 좌석 배정")
        println("3. 좌석 반납")
    }

    fun getOption(): MenuOption{
        while(true){
            print("선택하세요 > ")
            val menuInput: String = Console.readLine()
            try{
                val option : MenuOption = userInputParser.parseMenuInput(menuInput);
                return option
            }
            catch(e : RuntimeException){
                println(e.message)
            }
        }
    }
}
