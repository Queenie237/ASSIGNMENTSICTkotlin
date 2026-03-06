// Exercise 2: Testing All NetworkState Instances

sealed class NetworkState {

    object Loading : NetworkState()

    data class Success(val data: String) : NetworkState()

    data class Error(val message: String) : NetworkState()
}

fun handleState(state: NetworkState) {
    when (state) {
        is NetworkState.Loading ->
            println("Loading...")

        is NetworkState.Success ->
            println("Success: ${state.data}")

        is NetworkState.Error ->
            println("Error: ${state.message}")
    }
}

fun main() {

    val states: List<NetworkState> = listOf(
        NetworkState.Loading,
        NetworkState.Success("User data loaded successfully"),
        NetworkState.Error("Network timeout occurred")
    )

    states.forEach { state ->
        handleState(state)
    }
}