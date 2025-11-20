package library.controller

import library.model.ReadingRoom
import library.view.UserOutputView

class ShowSeatsController(val outputView: UserOutputView, val readingRoom: ReadingRoom) :
    Controller {
    override fun run() : String{
        val availablities = readingRoom.getSeatAvailabilities()
        outputView.printSeatAvailabilities(availablities)
        return "userPrompt"
    }
}