import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.liecoti.app.App

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "LIECOTI"
    ) {
        App()
    }
}
