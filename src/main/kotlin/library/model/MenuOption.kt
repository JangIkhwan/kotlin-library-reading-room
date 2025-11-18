package library.model

data class MenuOption(val value: Int){
    init{
        require(value >= 1 && value <= 3, { "[ERROR] 존재하지 않는 메뉴 번호입니다" })
    }
}