package library.controller

import library.model.MenuOption
import library.model.ReadingRoom
import library.view.UserInputView
import library.view.UserOutputView

class UserPromptController(val inputView: UserInputView, val readingRoom: ReadingRoom, val outputView: UserOutputView) {
    fun run(){
        inputView.printMenu()
        val option: MenuOption = inputView.getOption()
        if(option == MenuOption(1)){
            val availablities = readingRoom.getSeatAvailabilities()
            outputView.printSeatAvailabilities(availablities)
        }
        if(option == MenuOption(2)){
            val seatNumber = inputView.getSeatToReserve()
            try{
                readingRoom.reserve(seatNumber)
                outputView.reserveSuccess()
            }
            catch (e : RuntimeException){
                outputView.printError(e)
            }
        }

    }
}