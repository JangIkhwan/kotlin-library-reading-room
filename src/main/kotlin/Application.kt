package library

import library.model.MenuOption
import library.view.UserInputParser
import library.view.UserInputView


fun main() {
    val seats : Array<Boolean> = Array<Boolean>(50) { false }

    val userInputView = UserInputView(UserInputParser())
    userInputView.printMenu()
    val option: MenuOption = userInputView.getOption()
    if(option.value == 1){
        printReadingRoom(seats)
    }
}

fun printReadingRoom(seats : Array<Boolean>){
    println("열람실 좌석 현황")
    for(i in 0..seats.size - 1){
        print("${i + 1}:")
        if(seats.get(i) == true){
            print("[X]  ")
        }
        if(seats.get(i) == false){
            print("[O]  ")
        }
        if((i + 1) % 10 == 0){
            println()
        }
    }
}

