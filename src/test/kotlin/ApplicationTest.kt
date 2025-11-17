package library

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ApplicationTest : NsTest() {
    @Test
    fun `사용자 메뉴 번호는 숫자여야 한다`(){
        assertSimpleTest {
            run("1")
            assertThat(output()).doesNotContain(ERROR_MESSAGE)
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

    override fun runMain() {
        main()
    }

    companion object {
        private const val ERROR_MESSAGE: String = "[ERROR]"
    }

}