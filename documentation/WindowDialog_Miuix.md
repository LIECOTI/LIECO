# WindowDialog | Miuix

`WindowDialog` is a window-level dialog component. It renders using platform `Dialog` and does not require `Scaffold` or `MiuixPopupHost`. It supports large-screen optimized animations, system back gesture dismissal, and a composition local to request dismiss from inside content.

TIP

This component is independent of `Scaffold` and can be used in any composable scope.

## Import [​](https://compose-miuix-ui.github.io/miuix/components/windowdialog#import)

kotlin

```
import top.yukonga.miuix.kmp.window.WindowDialog
import top.yukonga.miuix.kmp.theme.LocalDismissState
```

## Basic Usage [​](https://compose-miuix-ui.github.io/miuix/components/windowdialog#basic-usage)

kotlin

```
var showDialog by remember { mutableStateOf(false) }

TextButton(
    text = "Open",
    onClick = { showDialog = true }
)

WindowDialog(
    title = "WindowDialog",
    summary = "A basic window-level dialog",
    show = showDialog,
    onDismissRequest = { showDialog = false }
) {
    val dismiss = LocalDismissState.current
    TextButton(
        text = "Confirm",
        onClick = { dismiss?.invoke() },
        modifier = Modifier.fillMaxWidth()
    )
}
```

## Properties [​](https://compose-miuix-ui.github.io/miuix/components/windowdialog#properties)

### WindowDialog Properties [​](https://compose-miuix-ui.github.io/miuix/components/windowdialog#windowdialog-properties)

| Property Name | Type | Description | Default Value | Required |
| --- | --- | --- | --- | --- |
| show | Boolean | Whether to show the dialog | \- | Yes |
| modifier | Modifier | Root content modifier | Modifier | No |
| title | String? | Dialog title | null | No |
| titleColor | Color | Title color | DialogDefaults.titleColor() | No |
| summary | String? | Dialog summary | null | No |
| summaryColor | Color | Summary color | DialogDefaults.summaryColor() | No |
| backgroundColor | Color | Dialog background color | DialogDefaults.backgroundColor() | No |
| enableWindowDim | Boolean | Whether to enable dimming layer | true | No |
| onDismissRequest | (() -> Unit)? | Called when the user requests dismissal (outside tap or back) | null | No |
| onDismissFinished | (() -> Unit)? | Invoked after the hide animation completes; not invoked if the hide is cancelled mid-flight (e.g., `show` toggled back to true) | null | No |
| outsideMargin | DpSize | Outer margin (window edges) | DialogDefaults.outsideMargin | No |
| insideMargin | DpSize | Inner padding for dialog content | DialogDefaults.insideMargin | No |
| defaultWindowInsetsPadding | Boolean | Apply default insets padding (IME, nav, caption) | true | No |
| content | @Composable () -> Unit | Dialog content | \- | Yes |

### DialogDefaults [​](https://compose-miuix-ui.github.io/miuix/components/windowdialog#dialogdefaults)

#### Properties [​](https://compose-miuix-ui.github.io/miuix/components/windowdialog#properties-1)

| Name | Type | Description |
| --- | --- | --- |
| outsideMargin | DpSize | Default outer margin for dialog |
| insideMargin | DpSize | Default inner padding for dialog |

#### Functions [​](https://compose-miuix-ui.github.io/miuix/components/windowdialog#functions)

| Name | Return Type | Description |
| --- | --- | --- |
| titleColor() | Color | Get default title color |
| summaryColor() | Color | Get default summary color |
| backgroundColor() | Color | Get default dialog background color |

### LocalDismissState [​](https://compose-miuix-ui.github.io/miuix/components/windowdialog#localdismissstate)

Provides a `(() -> Unit)?` function to close the current popup from within the content. This is a unified dismiss state provided by all overlay components.

kotlin

```
val dismiss = LocalDismissState.current
TextButton(
    text = "Close",
    onClick = { dismiss?.invoke() }
)
```

## Changelog[](https://compose-miuix-ui.github.io/miuix/components/windowdialog#changelog)

Last edited about 1 month ago

View full history

---
Source: [WindowDialog | Miuix](https://compose-miuix-ui.github.io/miuix/components/windowdialog)