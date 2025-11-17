package library

import library.model.MenuOption
import library.view.UserInputParser
import library.view.UserInputView


fun main() {
    val userInputView = UserInputView(UserInputParser())
    userInputView.printMenu()
    val option: MenuOption = userInputView.getOption()
}

