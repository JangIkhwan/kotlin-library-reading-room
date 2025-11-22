package library.controller

import library.controller.constant.Command
import library.model.ReadingRoom
import library.view.UserOutputView

class ShowSeatsController(val outputView: UserOutputView, val readingRoom: ReadingRoom) : Controller {
    override fun run() : Command{
        val availablities = readingRoom.getSeatAvailabilities()
        outputView.printSeatAvailabilities(availablities)
        return Command.USER_PROMPT
    }
}