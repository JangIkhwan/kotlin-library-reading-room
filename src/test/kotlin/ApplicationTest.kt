package library

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ApplicationTest : NsTest() {
    @Test
    fun `사용자 메뉴 번호는 숫자여야 한다`(){
        assertSimpleTest {
            run("1", "4")
            assertThat(output()).contains("사용자 프롬프트",
                "1. 도서관 좌석 조회",
                "2. 좌석 배정",
                "3. 좌석 반납",
                "4. 종료")
        }
    }

    @Test
    fun `사용자 메뉴 번호가 숫자가 아니면 에러메시지가 출력된다`(){
        assertSimpleTest {
            runException("one")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `사용자 메뉴가 비어있으면 에러메시지가 출력된다`(){
        assertSimpleTest {
            runException("\n")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `사용자 메뉴 번호의 범위를 벗어나면 에러 메시지가 출력된다`(){
        assertSimpleTest {
            runException("-1")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    @Test
    fun `사용자 프롬프트에서 1번을 입력하면 열람실 좌석 현황을 출력한다`(){
        assertSimpleTest {
            run("1", "4")
            assertThat(output()).contains("열람실 좌석 현황")
        }
    }

    @Test
    fun `로그인 메뉴 번호는 숫자여야 한다`(){
        assertSimpleTest {
            run("1")
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