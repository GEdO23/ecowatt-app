package br.com.ecowatt.models.device

internal object DeviceSampleData {

    private enum class DeviceLocations(val value: String) {
        LIVING_ROOM("Sala de Estar"),
        KITCHEN("Cozinha"),
        BEDROOM("Quarto")
    }

    private enum class DeviceTypes(val value: String) {
        ELETRO("Eletrodomésticos"),
        GAME("Videogames"),
        OTHERS("Outros")
    }

    private val device1 = Device(
        id = "0001",
        name = "Geladeira",
        location = DeviceLocations.KITCHEN.value,
        type = DeviceTypes.ELETRO.value,
        consumptionLimit = 250u,
        consumptions = emptyList()
    )

    private val device2 = Device(
        id = "0002",
        name = "Playstation 5",
        location = DeviceLocations.LIVING_ROOM.value,
        type = DeviceTypes.GAME.value,
        consumptionLimit = 180u,
        consumptions = emptyList()
    )

    private val device3 = Device(
        id = "0003",
        name = "Televisão de quarto",
        location = DeviceLocations.BEDROOM.value,
        type = DeviceTypes.OTHERS.value,
        consumptionLimit = 200u,
        consumptions = emptyList()
    )

    val devicesList: List<Device> = listOf(device1, device2, device3)
}