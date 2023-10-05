sealed class Result {
    data class Success(val message: String) : Result()
    data class Error(val error: String) : Result()
}

fun handleResult(result: Result) {
    when (result) {
        is Result.Success -> println("Success: ${result.message}")
        is Result.Error -> println("Error: ${result.error}")
    }
}

fun main() {
    val successResult = Result.Success("Data loaded successfully")
    val errorResult = Result.Error("Failed to load data")

    handleResult(successResult) // Output: Success: Data loaded successfully
    handleResult(errorResult)   // Output: Error: Failed to load data
}
