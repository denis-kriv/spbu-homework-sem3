package homeworks.semester3.homework1.task1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import homeworks.semester3.homework1.task1.models.Computer
import homeworks.semester3.homework1.task1.models.Network
import homeworks.semester3.homework1.task1.models.OperationSystem
import homeworks.semester3.homework1.task1.utils.Generator
import kotlin.random.Random

private object Constants {
    const val minSizeOfNetwork = 100
    const val maxSizeOfNetwork = 1000
    const val infectionProbability = 0.2
}

internal class NetworkTests {

    @Test
    fun initShouldThrowsCloneNotSupportedExceptionWhenListOfComputerNeighborsContainDuplicates() {
        val computers = MutableList(Random.nextInt(Constants.minSizeOfNetwork, Constants.maxSizeOfNetwork)) {
            val isInfected = Random.nextDouble() < Constants.infectionProbability
            val system = OperationSystem.values()[Random.nextInt(0, OperationSystem.values().size)]

            Computer(system, isInfected)
        }

        val computer = Computer(OperationSystem.Mac, true)

        assertThrows<CloneNotSupportedException> { Network(computers, listOf(listOf(0, 1, 0))) }
    }

    @Test
    fun initShouldThrowsIndexOutOfBoundsExceptionWhenListOfComputerNeighborsContainIndexesLargeNumbersOfComputers() {
        val computers = List(Random.nextInt(Constants.minSizeOfNetwork, Constants.maxSizeOfNetwork)) {
            val isInfected = Random.nextDouble() < Constants.infectionProbability
            val system = OperationSystem.values()[Random.nextInt(0, OperationSystem.values().size)]

            Computer(system, isInfected)
        }

        assertThrows<IndexOutOfBoundsException> { Network(computers, listOf(listOf(computers.size))) }
    }

    @Test
    fun initShouldThrowsIndexOutOfBoundsExceptionWhenListOfComputerNeighborsContainIndexesLessZero() {
        val computers = List(Random.nextInt(Constants.minSizeOfNetwork, Constants.maxSizeOfNetwork)) {
            val isInfected = Random.nextDouble() < Constants.infectionProbability
            val system = OperationSystem.values()[Random.nextInt(0, OperationSystem.values().size)]

            Computer(system, isInfected)
        }

        assertThrows<IndexOutOfBoundsException> { Network(computers, listOf(listOf(-1))) }
    }

    @Test
    fun initShouldThrowsUnsupportedOperationExceptionWhenListOfComputerNeighborsContainItself() {
        val computers = List(Random.nextInt(Constants.minSizeOfNetwork, Constants.maxSizeOfNetwork)) {
            val isInfected = Random.nextDouble() < Constants.infectionProbability
            val system = OperationSystem.values()[Random.nextInt(0, OperationSystem.values().size)]

            Computer(system, isInfected)
        }

        assertThrows<UnsupportedOperationException> { Network(computers, listOf(listOf(0))) }
    }

    @Test
    fun initShouldNotThrowsExceptionWhenDataIsCorrect() {
        assertDoesNotThrow { Generator().generate() }
    }

    @Test
    fun getStatisticsShouldReturnsRightValueWhenNetworkHasNotAnyComputers() {
        assertEquals("All computers are healthy", Network(listOf(), listOf()).getStatistics())
    }

    @Test
    fun getStatisticsShouldReturnsRightValueWhenNetworkHasNotAnyInfectedComputers() {
        val computers = List(Random.nextInt(Constants.minSizeOfNetwork, Constants.maxSizeOfNetwork)) {
            val isInfected = false
            val system = OperationSystem.values()[Random.nextInt(0, OperationSystem.values().size)]

            Computer(system, isInfected)
        }

        assertEquals("All computers are healthy", Network(computers, listOf()).getStatistics())
    }

    @Test
    fun getStatisticsShouldReturnsRightValueWhenNetworkHasNotAnyHealthComputers() {
        val computers = List(4) {
            val isInfected = true
            val system = OperationSystem.values()[Random.nextInt(0, OperationSystem.values().size)]

            Computer(system, isInfected)
        }

        assertEquals("Infected computers: 0 1 2 3 ", Network(computers, listOf()).getStatistics())
    }

    @Test
    fun getStatisticsShouldReturnsRightValue() {
        val computers = List(Random.nextInt(Constants.minSizeOfNetwork, Constants.maxSizeOfNetwork)) {
            val isInfected = it < 3
            val system = OperationSystem.values()[Random.nextInt(0, OperationSystem.values().size)]

            Computer(system, isInfected)
        }

        assertEquals("Infected computers: 0 1 2 ", Network(computers, listOf()).getStatistics())
    }

    @Test
    fun infectShouldWorksCorrectlyWhenNetworkHasNotAnyComputers() {
        assertDoesNotThrow { Network(listOf(), listOf()).infect() }
    }

    @Test
    fun infectShouldWorksCorrectlyWhenNetworkHasNotAnyInfectedComputers() {
        val computers = List(Random.nextInt(Constants.minSizeOfNetwork, Constants.maxSizeOfNetwork)) {
            val isInfected = false
            val system = OperationSystem.values()[Random.nextInt(0, OperationSystem.values().size)]

            Computer(system, isInfected)
        }

        val links = mutableListOf<List<Int>>()

        for (i in 0..computers.lastIndex) {
            val linksInfo = List(Random.nextInt(1, computers.lastIndex / 2)) {
                var index = Random.nextInt(0, computers.lastIndex)

                while (index == i) index = Random.nextInt(0, computers.lastIndex)

                index
            }

            links.add(i, linksInfo.distinct())
        }

        val network = Network(computers, links)

        for (i in 0..10000) {
            network.infect()
        }

        assertEquals("All computers are healthy", network.getStatistics())
    }

    @Test
    fun infectShouldWorksCorrectlyWhenNetworkHasNotAnyHealthComputers() {
        val computers = List(6) {
            val isInfected = true
            val system = OperationSystem.values()[Random.nextInt(0, OperationSystem.values().size)]

            Computer(system, isInfected)
        }
        val links = mutableListOf<List<Int>>()

        for (i in 0..computers.lastIndex) {
            val linksInfo = List(Random.nextInt(1, computers.lastIndex / 2)) {
                var index = Random.nextInt(0, computers.lastIndex)

                while (index == i) index = Random.nextInt(0, computers.lastIndex)

                index
            }

            links.add(i, linksInfo.distinct())
        }

        val network = Network(computers, links)

        for (i in 0..10000) {
            network.infect()
        }

        assertEquals("Infected computers: 0 1 2 3 4 5 ", network.getStatistics())
    }

    @Test
    fun infectShouldWorksCorrectlyWhenNetworkHasOneInfectedComputerAndItHasAllLinks() {
        val computers = List(6) {
            val isInfected = it == 0
            val system = OperationSystem.values()[Random.nextInt(0, OperationSystem.values().size)]

            Computer(system, isInfected)
        }
        val links = mutableListOf(listOf(1, 2, 3, 4, 5))

        for (i in 1..computers.lastIndex) {
            val linksInfo = List(Random.nextInt(1, computers.lastIndex / 2)) {
                var index = Random.nextInt(0, computers.lastIndex)

                while (index == i) index = Random.nextInt(0, computers.lastIndex)

                index
            }

            links.add(i, linksInfo.distinct())
        }

        val network = Network(computers, links)

        for (i in 0..10000) {
            network.infect()
        }

        assertEquals("Infected computers: 0 1 2 3 4 5 ", network.getStatistics())
    }

    @Test
    fun infectShouldWorksCorrectlyWhenNetworkHasTwoInfectedComputersAndLinksAreNotCross() {
        val computers = List(6) {
            val isInfected = it < 2
            val system = OperationSystem.values()[Random.nextInt(0, OperationSystem.values().size)]

            Computer(system, isInfected)
        }
        val links = mutableListOf(listOf(3, 4), listOf(5))

        for (i in 2..computers.lastIndex) {
            val linksInfo = List(Random.nextInt(1, computers.lastIndex / 2)) {
                var index = Random.nextInt(0, computers.lastIndex)

                while (index == i) index = Random.nextInt(0, computers.lastIndex)

                index
            }

            links.add(i, linksInfo.distinct())
        }

        val network = Network(computers, links)

        for (i in 0..10000) {
            network.infect()
        }

        assertEquals("Infected computers: 0 1 2 3 4 5 ", network.getStatistics())
    }

    @Test
    fun infectShouldWorksCorrectlyWhenNetworkHasManyInfectedComputers() {
        val computers = List(6) {
            val isInfected = it < 4
            val system = OperationSystem.values()[Random.nextInt(0, OperationSystem.values().size)]

            Computer(system, isInfected)
        }
        val links = mutableListOf(listOf(3, 4), listOf(5))

        for (i in 2..computers.lastIndex) {
            val linksInfo = List(Random.nextInt(1, computers.lastIndex / 2)) {
                var index = Random.nextInt(0, computers.lastIndex)

                while (index == i) index = Random.nextInt(0, computers.lastIndex)

                index
            }

            links.add(i, linksInfo.distinct())
        }

        val network = Network(computers, links)

        for (i in 0..10000) {
            network.infect()
        }

        assertEquals("Infected computers: 0 1 2 3 4 5 ", network.getStatistics())
    }

    @Test
    fun infectShouldWorksCorrectlyWhenNetworkHasOneInfectedComputer() {
        val computers = List(6) {
            val isInfected = it == 0
            val system = OperationSystem.values()[Random.nextInt(0, OperationSystem.values().size)]

            Computer(system, isInfected)
        }
        val links = mutableListOf(listOf(1))

        for (i in 1 until computers.lastIndex) {
            links.add(i, listOf(i - 1, i + 1))
        }

        links.add(listOf(0))

        val network = Network(computers, links)

        for (i in 0..10000) {
            network.infect()
        }

        assertEquals("Infected computers: 0 1 2 3 4 5 ", network.getStatistics())
    }

    @Test
    fun infectShouldWorksCorrectly() {
        val computers = List(6) {
            val isInfected = it == 0
            val system = OperationSystem.values()[Random.nextInt(0, OperationSystem.values().size)]

            Computer(system, isInfected)
        }

        val links = mutableListOf(listOf(1))

        for (i in 1 until computers.lastIndex) {
            links.add(i, listOf(i - 1, i + 1))
        }

        val network = Network(computers, links)

        while (!computers[1].isInfected()) network.infect()

        for (i in 0..computers.lastIndex) {
            assertEquals(i < 2, computers[i].isInfected())
        }
    }
}
