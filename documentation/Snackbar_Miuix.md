# Snackbar | Miuix

#! /usr/bin/env markdown

`Snackbar` is a lightweight feedback component in Miuix used to display brief messages at the bottom of the screen. It can optionally provide actions such as “Undo” and supports different display durations.

## Import [​](https://compose-miuix-ui.github.io/miuix/components/snackbar#import)

kotlin

```
import top.yukonga.miuix.kmp.basic.Snackbar
import top.yukonga.miuix.kmp.basic.SnackbarHost
import top.yukonga.miuix.kmp.basic.SnackbarHostState
import top.yukonga.miuix.kmp.basic.SnackbarDuration
import top.yukonga.miuix.kmp.basic.SnackbarResult
```

## Basic Usage [​](https://compose-miuix-ui.github.io/miuix/components/snackbar#basic-usage)

The Snackbar is usually used together with `Scaffold`. You create a `SnackbarHostState`, pass it to `SnackbarHost`, and then call `showSnackbar` to display messages:a

kotlin

```
val snackbarHostState = remember { SnackbarHostState() }
val scope = rememberCoroutineScope()

Scaffold(
    snackbarHost = {
        SnackbarHost(state = snackbarHostState)
    },
) { paddingValues ->
    Box(
        modifier = Modifier
            .padding(paddingValues),
    ) {
        TextButton(
            text = "Show message",
            onClick = {
                scope.launch {
                    snackbarHostState.showSnackbar("This is a short message")
                }
            },
        )
    }
}
```

## SnackbarHostState and showSnackbar [​](https://compose-miuix-ui.github.io/miuix/components/snackbar#snackbarhoststate-and-showsnackbar)

`SnackbarHostState` manages a queue of Snackbar messages.

### showSnackbar [​](https://compose-miuix-ui.github.io/miuix/components/snackbar#showsnackbar)

kotlin

```
suspend fun SnackbarHostState.showSnackbar(
    message: String,
    actionLabel: String? = null,
    withDismissAction: Boolean = false,
    duration: SnackbarDuration = SnackbarDuration.Short,
): SnackbarResult
```

| Parameter Name | Type | Description | Default Value | Required |
| --- | --- | --- | --- | --- |
| message | String | Text shown in the Snackbar | \- | Yes |
| actionLabel | String? | Optional label for the action button | null | No |
| withDismissAction | Boolean | Whether to show a dismiss icon | false | No |
| duration | SnackbarDuration | Duration that the Snackbar stays visible | SnackbarDuration.Short | No |

The return value `SnackbarResult` indicates whether the Snackbar was dismissed or the action was performed.

### Getting the oldest or newest Snackbar [​](https://compose-miuix-ui.github.io/miuix/components/snackbar#getting-the-oldest-or-newest-snackbar)

kotlin

```
suspend fun SnackbarHostState.newestSnackbarData(): SnackbarData?
suspend fun SnackbarHostState.oldestSnackbarData(): SnackbarData?
```

These helpers allow you to manually dismiss the newest or oldest visible Snackbar via `dismiss()` or `performAction()`.

## SnackbarHost [​](https://compose-miuix-ui.github.io/miuix/components/snackbar#snackbarhost)

`SnackbarHost` is responsible for rendering the Snackbars based on the given `SnackbarHostState`.

kotlin

```
@Composable
fun SnackbarHost(
    state: SnackbarHostState,
    modifier: Modifier = Modifier,
    canSwipeToDismiss: Boolean = true,
    content: @Composable (SnackbarData) -> Unit = { Snackbar(it) },
)
```

| Parameter Name | Type | Description | Default Value | Required |
| --- | --- | --- | --- | --- |
| state | SnackbarHostState | State that holds the Snackbar queue | \- | Yes |
| modifier | Modifier | Modifier applied to the host container | Modifier | No |
| canSwipeToDismiss | Boolean | Whether Snackbars can be dismissed by swipe | true | No |
| content | @Composable (SnackbarData) -> Unit | Custom content for each Snackbar item | `{ Snackbar(it) }` | No |

In most cases you can keep the default `content` which uses the built‑in `Snackbar` composable.

## Snackbar [​](https://compose-miuix-ui.github.io/miuix/components/snackbar#snackbar-1)

`Snackbar` defines the default visual style for messages.

kotlin

```
@Composable
fun Snackbar(
    data: SnackbarData,
    modifier: Modifier = Modifier,
    cornerRadius: Dp = SnackbarDefaults.CornerRadius,
    colors: SnackbarColors = SnackbarDefaults.snackbarColors(),
    insideMargin: PaddingValues = SnackbarDefaults.InsideMargin,
)
```

| Parameter Name | Type | Description | Default Value | Required |
| --- | --- | --- | --- | --- |
| data | SnackbarData | Data describing message and actions | \- | Yes |
| modifier | Modifier | Modifier applied to the Snackbar container | Modifier | No |
| cornerRadius | Dp | Corner radius of the Snackbar | SnackbarDefaults.CornerRadius | No |
| colors | SnackbarColors | Color configuration for the Snackbar | SnackbarDefaults.snackbarColors() | No |
| insideMargin | PaddingValues | Inner padding of the Snackbar content | SnackbarDefaults.InsideMargin | No |

### SnackbarColors and SnackbarDefaults [​](https://compose-miuix-ui.github.io/miuix/components/snackbar#snackbarcolors-and-snackbardefaults)

`SnackbarColors` defines the color set used by the Snackbar:

kotlin

```
data class SnackbarColors(
    val containerColor: Color,
    val contentColor: Color,
    val actionContentColor: Color,
    val dismissActionContentColor: Color,
)
```

You can create a color configuration via `SnackbarDefaults.snackbarColors`:

kotlin

```
val colors = SnackbarDefaults.snackbarColors(
    containerColor = MiuixTheme.colorScheme.surfaceContainerHighest,
    contentColor = MiuixTheme.colorScheme.onSurfaceContainer,
    actionContentColor = MiuixTheme.colorScheme.onSurfaceContainerHighest,
    dismissActionContentColor = MiuixTheme.colorScheme.onSurfaceContainerHighest,
)
```

#### Constants [​](https://compose-miuix-ui.github.io/miuix/components/snackbar#constants)

`SnackbarDefaults` also exposes the default corner radius and inside margin used by `Snackbar`:

| Constant Name | Type | Description | Default Value |
| --- | --- | --- | --- |
| CornerRadius | Dp | Default corner radius of the Snackbar | 12.dp |
| InsideMargin | PaddingValues | Default inner padding of the Snackbar | PaddingValues(horizontal = 12.dp, vertical = 8.dp) |

## SnackbarDuration and SnackbarResult [​](https://compose-miuix-ui.github.io/miuix/components/snackbar#snackbarduration-and-snackbarresult)

### SnackbarDuration [​](https://compose-miuix-ui.github.io/miuix/components/snackbar#snackbarduration)

`SnackbarDuration` controls how long the Snackbar stays visible:

kotlin

```
sealed interface SnackbarDuration {
    data object Short : SnackbarDuration
    data object Long : SnackbarDuration
    data object Indefinite : SnackbarDuration
    data class Custom(val durationMillis: Long) : SnackbarDuration
}
```

| Option | Description | Duration |
| --- | --- | --- |
| Short | Short message | About 4 seconds |
| Long | Longer message | About 10 seconds |
| Indefinite | Stays until dismissed or action fired | Until dismissed |
| Custom | Custom duration in milliseconds | User‑specified |

### SnackbarResult [​](https://compose-miuix-ui.github.io/miuix/components/snackbar#snackbarresult)

`SnackbarResult` describes how the Snackbar was completed:

kotlin

```
enum class SnackbarResult {
    Dismissed,
    ActionPerformed,
}
```

## Advanced Usage [​](https://compose-miuix-ui.github.io/miuix/components/snackbar#advanced-usage)

### Snackbar with action [​](https://compose-miuix-ui.github.io/miuix/components/snackbar#snackbar-with-action)

kotlin

```
val snackbarHostState = remember { SnackbarHostState() }
val scope = rememberCoroutineScope()

TextButton(
    text = "Show action",
    onClick = {
        scope.launch {
            val result = snackbarHostState.showSnackbar(
                message = "This message has an action",
                actionLabel = "Undo",
                duration = SnackbarDuration.Short,
            )
            when (result) {
                SnackbarResult.ActionPerformed -> { /* handle undo */ }
                SnackbarResult.Dismissed -> { /* handle timeout */ }
            }
        }
    },
)
```

### Dismissible and indefinite Snackbar [​](https://compose-miuix-ui.github.io/miuix/components/snackbar#dismissible-and-indefinite-snackbar)

kotlin

```
val snackbarHostState = remember { SnackbarHostState() }
val scope = rememberCoroutineScope()

TextButton(
    text = "Show indefinite",
    onClick = {
        scope.launch {
            snackbarHostState.showSnackbar(
                message = "Indefinite message, dismiss manually",
                withDismissAction = true,
                duration = SnackbarDuration.Indefinite,
            )
        }
    },
)

TextButton(
    text = "Dismiss oldest",
    onClick = {
        scope.launch {
            snackbarHostState.oldestSnackbarData()?.dismiss()
        }
    },
)
```

## Changelog[](https://compose-miuix-ui.github.io/miuix/components/snackbar#changelog)

Last edited 29 days ago

View full history

---
Source: [Snackbar | Miuix](https://compose-miuix-ui.github.io/miuix/components/snackbar)