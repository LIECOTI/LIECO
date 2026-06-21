import androidx.compose.ui.window.ComposeViewport
import com.liecoti.app.App
import kotlinx.browser.document

fun main() {
    ComposeViewport(document.body!!) {
        App()
    }
}
