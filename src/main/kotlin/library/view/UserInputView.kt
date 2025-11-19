package library.view

import camp.nextstep.edu.missionutils.Console
import library.model.MenuOption
import library.model.SeatNumber

class UserInputView (val userInputParser : UserInputParser){
    fun printMenu(){
        println("사용자 프롬프트")
        println("1. 도서관 좌석 조회")
        println("2. 좌석 배정")
        println("3. 좌석 반납")
        println("4. 종료")
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

    fun getSeatToReserve(): SeatNumber {
        println("좌석 배정")
        while(true){
            print("좌석번호를 입력하세요> ")
            val number: String = Console.readLine()
            try{
                return SeatNumber(number.toInt())
            }
            catch (e : RuntimeException){
                println(e.message)
            }
        }
    }

    fun getReturnSeatIntention(seatNumber: SeatNumber): Boolean {
        println("좌석 반납")
        while(true){
            print("좌석을 반납하시겠습니까? (Y/n) > ")
            val input: String = Console.readLine()
            if(input == "Y"){
                return true
            }
            if(input == "n"){
                return false
            }
            println("[ERROR] Y 또는 n으로 입력해주세요")
        }
    }
}
