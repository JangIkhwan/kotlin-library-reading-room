package library.controller

import library.controller.constant.Command

interface Controller {
    fun run() : Command
}
