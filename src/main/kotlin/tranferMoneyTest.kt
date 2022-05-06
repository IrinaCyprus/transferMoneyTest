const val MASTERCARD = "MasterCard"
const val MAESTRO = "Maestro"
const val VISA = "Visa"
const val MIR = "Мир"
const val VK = "VK pay"
const val maxLimitMastercardMaestro = 7_500_000
const val commissionMastercardMaestro = 0.006
const val addCommissionMasterMaestro = 2000
const val minCommissionVisaMir = 3500
const val commissionVisaMir = 0.0075

fun main() {
    println("Сумма перевода:")
    println(paymentSystem(MASTERCARD, 4_000_000))
    println(paymentSystem(MAESTRO, 7_900_000))
    println(paymentSystem(MASTERCARD, 8_000_000))
    println(paymentSystem(VISA, 8_000_000))
    println(paymentSystem(VISA, 10_000_000))
    println(paymentSystem(MIR, 5_000))
    println(paymentSystem(VK, 3000000))
}

fun paymentSystem(type: String, amount: Long): Any {
    return when (type) {
        MASTERCARD, MAESTRO ->
            if (amount > maxLimitMastercardMaestro) {
                (amount + (amount * commissionMastercardMaestro) + addCommissionMasterMaestro).toLong()
            } else {
                amount
            }
        VISA, MIR ->
            if (amount * commissionVisaMir > minCommissionVisaMir) {
                (amount + (amount * commissionVisaMir)).toLong()
            } else {
                minCommissionVisaMir
            }
        else -> amount
    }
}
