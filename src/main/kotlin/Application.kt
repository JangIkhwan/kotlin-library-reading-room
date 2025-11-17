package library

import camp.nextstep.edu.missionutils.Console


fun main() {
    printMenu()
    val option: Int = getOption()
    println(option)
}

fun printMenu(){
    println("사용자 프롬프트")
    println("1. 도서관 좌석 조회")
    println("2. 좌석 배정")
    println("3. 좌석 반납")
}

fun getOption(): Int{
    var option: Int
    while(true){
        print("선택하세요 > ")
        val input: String = Console.readLine()
        if(input.isEmpty()){
            println("[ERROR] 입력이 비어있을 수 없습니다")
            continue
        }
        try{
            option = input.toInt()
            if(option >= 1 && option <= 3){
                break
            }
            println("[ERROR] 존재하지 않는 메뉴 번호입니다")
        }
        catch (e: NumberFormatException){
            println("[ERROR] 메뉴 번호는 정수여야 합니다")
        }
    }
    return option
}