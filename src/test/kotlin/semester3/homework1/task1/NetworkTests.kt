package semester3.homework1.task1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import semester3.homework1.task1.models.Computer
import semester3.homework1.task1.models.Network
import semester3.homework1.task1.models.OperationSystem

internal class NetworkTests {

    @Test
    fun initShouldThrowsExceptionWhenSomeComputersHasInCorrectLinks() {
        val linksForHealthComputer1 = setOf(0, 1, 2, 3, 4, 5)
        val linksForHealthComputer2 = setOf(0, 1, 2, 3, 4)
        val linksForHealthComputer3 = setOf(0, 1, 2, 3)
        val linksForInfectedComputer1 = setOf(0, 1, 2)
        val linksForInfectedComputer2 = setOf(0, 1)
        val linksForInfectedComputer3 = setOf(0, 100)

        val healthComputer1 = Computer(
            OperationSystem.Windows,
            linksForHealthComputer1,
            false
        )
        val healthComputer2 = Computer(
            OperationSystem.Linux,
            linksForHealthComputer2,
            false
        )
        val healthComputer3 = Computer(
            OperationSystem.Mac,
            linksForHealthComputer3,
            false
        )
        val infectedComputer1 = Computer(
            OperationSystem.Windows,
            linksForInfectedComputer1,
            true
        )
        val infectedComputer2 = Computer(
            OperationSystem.Linux,
            linksForInfectedComputer2,
            true
        )
        val infectedComputer3 = Computer(
            OperationSystem.Mac,
            linksForInfectedComputer3,
            true
        )

        val computers = setOf(
            healthComputer1, healthComputer2, healthComputer3,
            infectedComputer1, infectedComputer2, infectedComputer3
        )

        assertThrows<IndexOutOfBoundsException> { Network(computers) }
    }

    @Test
    fun initShouldNotThrowsExceptionWhenDataIsCorrect() {
        val linksForHealthComputer1 = setOf(0, 1, 2, 3, 4, 5)
        val linksForHealthComputer2 = setOf(0, 1, 2, 3, 4)
        val linksForHealthComputer3 = setOf(0, 1, 2, 3)
        val linksForInfectedComputer1 = setOf(0, 1, 2)
        val linksForInfectedComputer2 = setOf(0, 1)
        val linksForInfectedComputer3 = setOf(0)

        val healthComputer1 = Computer(
            OperationSystem.Windows,
            linksForHealthComputer1,
            false
        )
        val healthComputer2 = Computer(
            OperationSystem.Linux,
            linksForHealthComputer2,
            false
        )
        val healthComputer3 = Computer(
            OperationSystem.Mac,
            linksForHealthComputer3,
            false
        )
        val infectedComputer1 = Computer(
            OperationSystem.Windows,
            linksForInfectedComputer1,
            true
        )
        val infectedComputer2 = Computer(
            OperationSystem.Linux,
            linksForInfectedComputer2,
            true
        )
        val infectedComputer3 = Computer(
            OperationSystem.Mac,
            linksForInfectedComputer3,
            true
        )

        val computers = setOf(
            healthComputer1, healthComputer2, healthComputer3,
            infectedComputer1, infectedComputer2, infectedComputer3
        )

        assertDoesNotThrow { Network(computers) }
    }

    @Test
    fun getStatisticsShouldReturnsRightValueWhenNetworkHasNotAnyComputers() {
        val computers = setOf<Computer>()

        val network = Network(computers)

        assertEquals(Pair(0, 0), network.getStatistics())
    }

    @Test
    fun getStatisticsShouldReturnsRightValueWhenNetworkHasNotAnyInfectedComputers() {
        val linksForHealthComputer1 = setOf<Int>()
        val linksForHealthComputer2 = setOf<Int>()
        val linksForHealthComputer3 = setOf<Int>()

        val healthComputer1 = Computer(
            OperationSystem.Windows,
            linksForHealthComputer1,
            false
        )
        val healthComputer2 = Computer(
            OperationSystem.Linux,
            linksForHealthComputer2,
            false
        )
        val healthComputer3 = Computer(
            OperationSystem.Mac,
            linksForHealthComputer3,
            false
        )

        val computers = setOf(healthComputer1, healthComputer2, healthComputer3)

        val network = Network(computers)

        assertEquals(Pair(3, 0), network.getStatistics())
    }

    @Test
    fun getStatisticsShouldReturnsRightValueWhenNetworkHasNotAnyHealthComputers() {
        val linksForInfectedComputer1 = setOf<Int>()
        val linksForInfectedComputer2 = setOf<Int>()
        val linksForInfectedComputer3 = setOf<Int>()

        val infectedComputer1 = Computer(
            OperationSystem.Windows,
            linksForInfectedComputer1,
            true
        )
        val infectedComputer2 = Computer(
            OperationSystem.Linux,
            linksForInfectedComputer2,
            true
        )
        val infectedComputer3 = Computer(
            OperationSystem.Mac,
            linksForInfectedComputer3,
            true
        )

        val computers = setOf(infectedComputer1, infectedComputer2, infectedComputer3)

        val network = Network(computers)

        assertEquals(Pair(0, 3), network.getStatistics())
    }

    @Test
    fun getStatisticsShouldReturnsRightValue() {
        val linksForHealthComputer1 = setOf<Int>()
        val linksForHealthComputer2 = setOf<Int>()
        val linksForHealthComputer3 = setOf<Int>()
        val linksForInfectedComputer1 = setOf<Int>()
        val linksForInfectedComputer2 = setOf<Int>()
        val linksForInfectedComputer3 = setOf<Int>()

        val healthComputer1 = Computer(
            OperationSystem.Windows,
            linksForHealthComputer1,
            false
        )
        val healthComputer2 = Computer(
            OperationSystem.Linux,
            linksForHealthComputer2,
            false
        )
        val healthComputer3 = Computer(
            OperationSystem.Mac,
            linksForHealthComputer3,
            false
        )
        val infectedComputer1 = Computer(
            OperationSystem.Windows,
            linksForInfectedComputer1,
            true
        )
        val infectedComputer2 = Computer(
            OperationSystem.Linux,
            linksForInfectedComputer2,
            true
        )
        val infectedComputer3 = Computer(
            OperationSystem.Mac,
            linksForInfectedComputer3,
            true
        )

        val computers = setOf(
            healthComputer1, healthComputer2, healthComputer3,
            infectedComputer1, infectedComputer2, infectedComputer3
        )

        val network = Network(computers)

        assertEquals(Pair(3, 3), network.getStatistics())
    }

    @Test
    fun infectShouldWhenNetworkHasNotAnyComputers() {
        val computers = setOf<Computer>()

        val network = Network(computers)

        network.infect()

        assertEquals(Pair(0, 0), network.getStatistics())
    }

    @Test
    fun infectShouldWorksCorrectlyWhenNetworkHasNotAnyInfectedComputers() {
        val linksForHealthComputer1 = setOf(0, 1, 2)
        val linksForHealthComputer2 = setOf(0, 1, 2)
        val linksForHealthComputer3 = setOf(0, 1, 2)

        val healthComputer1 = Computer(
            OperationSystem.Windows,
            linksForHealthComputer1,
            false
        )
        val healthComputer2 = Computer(
            OperationSystem.Linux,
            linksForHealthComputer2,
            false
        )
        val healthComputer3 = Computer(
            OperationSystem.Mac,
            linksForHealthComputer3,
            false
        )

        val computers = setOf(healthComputer1, healthComputer2, healthComputer3)

        val network = Network(computers)

        network.infect()

        assertEquals(Pair(3, 0), network.getStatistics())
    }

    @Test
    fun infectShouldWorksCorrectlyWhenNetworkHasNotAnyHealthComputers() {
        val linksForInfectedComputer1 = setOf(0, 1, 2)
        val linksForInfectedComputer2 = setOf(0, 1, 2)
        val linksForInfectedComputer3 = setOf(0, 1, 2)

        val infectedComputer1 = Computer(
            OperationSystem.Windows,
            linksForInfectedComputer1,
            true
        )
        val infectedComputer2 = Computer(
            OperationSystem.Linux,
            linksForInfectedComputer2,
            true
        )
        val infectedComputer3 = Computer(
            OperationSystem.Mac,
            linksForInfectedComputer3,
            true
        )

        val computers = setOf(infectedComputer1, infectedComputer2, infectedComputer3)

        val network = Network(computers)

        network.infect()

        assertEquals(Pair(0, 3), network.getStatistics())
    }

    @Test
    fun infectShouldWorksCorrectlyWhenNetworkHasOneInfectedComputerAndItHasAllLinks() {
        val linksForHealthComputer1 = setOf(0, 1, 2, 3)
        val linksForHealthComputer2 = setOf(0, 1, 2, 3)
        val linksForHealthComputer3 = setOf(0, 1, 2, 3)
        val linksForInfectedComputer1 = setOf(0, 1, 2, 3)

        val healthComputer1 = Computer(
            OperationSystem.Windows,
            linksForHealthComputer1,
            false
        )
        val healthComputer2 = Computer(
            OperationSystem.Linux,
            linksForHealthComputer2,
            false
        )
        val healthComputer3 = Computer(
            OperationSystem.Mac,
            linksForHealthComputer3,
            false
        )
        val infectedComputer1 = Computer(
            OperationSystem.Windows,
            linksForInfectedComputer1,
            true
        )

        val computers = setOf(healthComputer1, healthComputer2, healthComputer3, infectedComputer1)

        val network = Network(computers)

        for (i in 0..1000000) {
            network.infect()
        }

        assertEquals(Pair(0, 4), network.getStatistics())
    }

    @Test
    fun infectShouldWorksCorrectlyWhenNetworkHasTwoInfectedComputersAndLinksAreNotCross() {
        val linksForHealthComputer1 = setOf(3)
        val linksForHealthComputer2 = setOf(4)
        val linksForHealthComputer3 = setOf(4)
        val linksForInfectedComputer1 = setOf(0, 4)
        val linksForInfectedComputer2 = setOf(1, 2, 3)

        val healthComputer1 = Computer(
            OperationSystem.Windows,
            linksForHealthComputer1,
            false
        )
        val healthComputer2 = Computer(
            OperationSystem.Linux,
            linksForHealthComputer2,
            false
        )
        val healthComputer3 = Computer(
            OperationSystem.Mac,
            linksForHealthComputer3,
            false
        )
        val infectedComputer1 = Computer(
            OperationSystem.Windows,
            linksForInfectedComputer1,
            true
        )
        val infectedComputer2 = Computer(
            OperationSystem.Linux,
            linksForInfectedComputer2,
            true
        )

        val computers = setOf(healthComputer1, healthComputer2, healthComputer3, infectedComputer1, infectedComputer2)

        val network = Network(computers)

        for (i in 0..1000000) {
            network.infect()
        }

        assertEquals(Pair(0, 5), network.getStatistics())
    }

    @Test
    fun infectShouldWorksCorrectlyWhenNetworkHasManyInfectedComputers() {
        val linksForHealthComputer1 = setOf(1)
        val linksForHealthComputer2 = setOf(0, 2)
        val linksForHealthComputer3 = setOf(1, 3)
        val linksForHealthComputer4 = setOf(2, 4)
        val linksForHealthComputer5 = setOf(3, 5)
        val linksForHealthComputer6 = setOf(4, 6)
        val linksForInfectedComputer1 = setOf(5, 7)
        val linksForInfectedComputer2 = setOf(6, 8)
        val linksForInfectedComputer3 = setOf(7, 9)
        val linksForInfectedComputer4 = setOf(8, 10)
        val linksForInfectedComputer5 = setOf(9)

        val healthComputer1 = Computer(
            OperationSystem.Windows,
            linksForHealthComputer1,
            false
        )
        val healthComputer2 = Computer(
            OperationSystem.Linux,
            linksForHealthComputer2,
            false
        )
        val healthComputer3 = Computer(
            OperationSystem.Mac,
            linksForHealthComputer3,
            false
        )
        val healthComputer4 = Computer(
            OperationSystem.Windows,
            linksForHealthComputer4,
            false
        )
        val healthComputer5 = Computer(
            OperationSystem.Windows,
            linksForHealthComputer5,
            false
        )
        val healthComputer6 = Computer(
            OperationSystem.Windows,
            linksForHealthComputer6,
            false
        )
        val infectedComputer1 = Computer(
            OperationSystem.Windows,
            linksForInfectedComputer1,
            true
        )
        val infectedComputer2 = Computer(
            OperationSystem.Windows,
            linksForInfectedComputer2,
            true
        )
        val infectedComputer3 = Computer(
            OperationSystem.Windows,
            linksForInfectedComputer3,
            true
        )
        val infectedComputer4 = Computer(
            OperationSystem.Linux,
            linksForInfectedComputer4,
            true
        )
        val infectedComputer5 = Computer(
            OperationSystem.Mac,
            linksForInfectedComputer5,
            true
        )

        val computers = setOf(
            healthComputer1, healthComputer2, healthComputer3, healthComputer4, healthComputer5, healthComputer6,
            infectedComputer1, infectedComputer2, infectedComputer3, infectedComputer4, infectedComputer5
        )

        val network = Network(computers)

        for (i in 0..1000000) {
            network.infect()
        }

        assertEquals(Pair(0, 11), network.getStatistics())
    }

    @Test
    fun infectShouldWorksCorrectlyWhenNetworkHasOneInfectedComputer() {
        val linksForHealthComputer1 = setOf<Int>()
        val linksForHealthComputer2 = setOf(2)
        val linksForHealthComputer3 = setOf(1, 3)
        val linksForHealthComputer4 = setOf(2, 4)
        val linksForHealthComputer5 = setOf(3, 5)
        val linksForHealthComputer6 = setOf(4, 6)
        val linksForInfectedComputer1 = setOf(5, 7)
        val linksForInfectedComputer2 = setOf(6, 8)
        val linksForInfectedComputer3 = setOf(7, 9)
        val linksForInfectedComputer4 = setOf(8, 10)
        val linksForInfectedComputer5 = setOf(9)

        val healthComputer1 = Computer(
            OperationSystem.Windows,
            linksForHealthComputer1,
            false
        )
        val healthComputer2 = Computer(
            OperationSystem.Linux,
            linksForHealthComputer2,
            false
        )
        val healthComputer3 = Computer(
            OperationSystem.Mac,
            linksForHealthComputer3,
            false
        )
        val healthComputer4 = Computer(
            OperationSystem.Windows,
            linksForHealthComputer4,
            false
        )
        val healthComputer5 = Computer(
            OperationSystem.Windows,
            linksForHealthComputer5,
            false
        )
        val healthComputer6 = Computer(
            OperationSystem.Windows,
            linksForHealthComputer6,
            false
        )
        val infectedComputer1 = Computer(
            OperationSystem.Windows,
            linksForInfectedComputer1,
            true
        )
        val infectedComputer2 = Computer(
            OperationSystem.Windows,
            linksForInfectedComputer2,
            true
        )
        val infectedComputer3 = Computer(
            OperationSystem.Windows,
            linksForInfectedComputer3,
            true
        )
        val infectedComputer4 = Computer(
            OperationSystem.Linux,
            linksForInfectedComputer4,
            true
        )
        val infectedComputer5 = Computer(
            OperationSystem.Mac,
            linksForInfectedComputer5,
            true
        )

        val computers = setOf(
            healthComputer1, healthComputer2, healthComputer3, healthComputer4, healthComputer5, healthComputer6,
            infectedComputer1, infectedComputer2, infectedComputer3, infectedComputer4, infectedComputer5
        )

        val network = Network(computers)

        for (i in 0..1000000) {
            network.infect()
        }

        assertEquals(Pair(1, 10), network.getStatistics())
    }
}
