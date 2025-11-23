package library

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class ApplicationTest : NsTest() {
    @Test
    fun `사용자 메뉴에 접속이 된다`(){
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        val currentTime = LocalDateTime.now().plusHours(1).format(formatter)
        assertSimpleTest {
            run("2", "202512345", "1234", currentTime, "4", "3")
            assertThat(output()).contains("사용자 프롬프트",
                "1. 도서관 좌석 조회",
                "2. 좌석 배정",
                "3. 좌석 반납",
                "4. 종료")
        }
    }

    @Test
    fun `프롬프트에서 메뉴 번호가 숫자가 아니면 에러메시지가 출력된다`(){
        assertSimpleTest {
            runException("one")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `프롬프트에서 메뉴 번호 없이 엔터를 입력하면 에러메시지가 출력된다`(){
        assertSimpleTest {
            runException("\n")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `프롬프트에서 메뉴 번호의 범위를 벗어나면 에러 메시지가 출력된다`(){
        assertSimpleTest {
            runException("-1")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `사용자 프롬프트에서 1번을 입력하면 열람실 좌석 현황을 출력한다`(){
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        val currentTime = LocalDateTime.now().plusHours(1).format(formatter)
        assertSimpleTest {
            run("2", "202512345", "1234", currentTime, "1", "4", "3")
            assertThat(output()).contains("열람실 좌석 현황")
        }
    }

    @Test
    fun `로그인 프롬프트가 출력된다`(){
        assertSimpleTest {
            run("3")
            assertThat(output()).contains("로그인 프롬프트",
                "1. 회원가입",
                "2. 로그인",
                "3. 프로그램 종료")
        }
    }

    override fun runMain() {
        main()
    }

    companion object {
        private const val ERROR_MESSAGE: String = "[ERROR]"
    }

}