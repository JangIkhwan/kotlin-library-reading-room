package library.view

class UserOutputView{
    fun printSeatAvailabilities(availabilities : Array<Boolean>){
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
}
