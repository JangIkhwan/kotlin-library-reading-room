package library.view

class UserOutputView{
    fun printSeatAvailabilities(availabilities : List<Boolean>){
        println("열람실 좌석 현황")
        for(i in 0..availabilities.size - 1){
            print("${i + 1}:")
            if(availabilities.get(i) == true){
                print("[X]  ")
            }
            if(availabilities.get(i) == false){
                print("[O]  ")
            }
            if((i + 1) % 10 == 0){
                println()
            }
        }
    }

    fun reserveSuccess() {
        println("좌석 배정이 완료되었습니다")
    }

    fun printError(e: RuntimeException) {
        println(e.message)
    }

    fun printMessage(message: String) {
        println(message)
    }
}
