import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun payments_system_for_masterCard_maestro_higher_max_limit() {

        val type = MASTERCARD; MAESTRO
        val amount = 7900000L
        val expectedAmount = 7949400L

        val actualAmount = paymentSystem(type, amount)

        assertEquals(expectedAmount, actualAmount)
    }

    @Test
    fun payments_system_for_masterCard_maestro_below_max_limit() {
        //arrange
        val type = MASTERCARD; MAESTRO
        val amount = 4_000_000L
        val expectedAmount = 4_000_000L
        //act
        val actualAmount = paymentSystem(type, amount)
        //assert
        assertEquals(expectedAmount, actualAmount)
    }

    @Test
    fun payments_system_for_visa_mir() {
        val type = VISA; MIR
        val amount = 8_000_000L
        val expectedAmount = 8_060_000L
        val actualAmount = paymentSystem(type, amount)

        assertEquals(expectedAmount, actualAmount)
    }

    @Test
    fun payments_system_for_visa_mir_min_commission() {
        val type = VISA; MIR
        val amount = 5_000
        val expectedAmount = 3500
        val actualAmount = paymentSystem(type, amount.toLong())

        assertEquals(expectedAmount, actualAmount)
    }
    @Test
    fun payments_system_vk(){
        val type = VK
        val amount = 3_000_000L
        val expectedAmount = 3_000_000L
        val actualAmount = paymentSystem(type, amount)
        assertEquals(expectedAmount, actualAmount)
    }
}