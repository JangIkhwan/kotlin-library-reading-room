package library.controller

import library.controller.constant.Command
import library.model.ReadingRoom
import library.service.LoginService
import library.view.UserOutputView

class ShowSeatsController(val outputView: UserOutputView, val readingRoom: ReadingRoom, val loginService: LoginService) : Controller {
    override fun run() : Command{
        val seats = readingRoom.getSeats()
        outputView.printSeats(seats, loginService.getLoginedUserId())
        return Command.USER_PROMPT
    }
}