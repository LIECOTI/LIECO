# WindowBottomSheet | Miuix

`WindowBottomSheet` is a window-level bottom sheet component. It renders using platform `Dialog` and does not require `Scaffold` or `MiuixPopupHost`. It supports large-screen optimized animations, system back gesture dismissal, and a composition local to request dismiss from inside content.

TIP

This component is independent of `Scaffold` and can be used in any composable scope.

## Import [​](https://compose-miuix-ui.github.io/miuix/components/windowbottomsheet#import)

kotlin

```
import top.yukonga.miuix.kmp.window.WindowBottomSheet
import top.yukonga.miuix.kmp.theme.LocalDismissState
```

## Basic Usage [​](https://compose-miuix-ui.github.io/miuix/components/windowbottomsheet#basic-usage)

`WindowBottomSheet` component provides basic bottom sheet functionality:

kotlin

```
var showBottomSheet by remember { mutableStateOf(false) }

// Can be used anywhere
TextButton(
    text = "Show Window Bottom Sheet",
    onClick = { showBottomSheet = true }
)

WindowBottomSheet(
    show = showBottomSheet,
    title = "Window Bottom Sheet Title",
    onDismissRequest = { showBottomSheet = false }
) {
    val dismiss = LocalDismissState.current
    Text(text = "This is the content of the window bottom sheet")
    TextButton(
        text = "Close",
        onClick = { dismiss?.invoke() }
    )
}
```

## Properties [​](https://compose-miuix-ui.github.io/miuix/components/windowbottomsheet#properties)

### WindowBottomSheet Properties [​](https://compose-miuix-ui.github.io/miuix/components/windowbottomsheet#windowbottomsheet-properties)

| Property Name | Type | Description | Default Value | Required |
| --- | --- | --- | --- | --- |
| show | Boolean | Whether to show the bottom sheet | \- | Yes |
| modifier | Modifier | Modifier applied to the bottom sheet | Modifier | No |
| title | String? | Bottom sheet title | null | No |
| startAction | @Composable (() -> Unit)? | Optional composable for start action (e.g., close button) | null | No |
| endAction | @Composable (() -> Unit)? | Optional composable for end action (e.g., submit button) | null | No |
| backgroundColor | Color | Bottom sheet background color | BottomSheetDefaults.backgroundColor() | No |
| enableWindowDim | Boolean | Whether to enable dimming layer | true | No |
| cornerRadius | Dp | Corner radius of the top corners | BottomSheetDefaults.cornerRadius | No |
| sheetMaxWidth | Dp | Maximum width of the bottom sheet | BottomSheetDefaults.maxWidth | No |
| onDismissRequest | (() -> Unit)? | Called when the user requests dismissal (outside tap or back) | null | No |
| onDismissFinished | (() -> Unit)? | Invoked after the hide animation completes; not invoked if the hide is cancelled mid-flight (e.g., `show` toggled back to true) | null | No |
| outsideMargin | DpSize | Bottom sheet external margin | BottomSheetDefaults.outsideMargin | No |
| insideMargin | DpSize | Bottom sheet internal content margin | BottomSheetDefaults.insideMargin | No |
| defaultWindowInsetsPadding | Boolean | Whether to apply default window insets padding | true | No |
| dragHandleColor | Color | Drag indicator color | BottomSheetDefaults.dragHandleColor() | No |
| allowDismiss | Boolean | Whether to allow dismissing the sheet via drag or back gesture | true | No |
| enableNestedScroll | Boolean | Whether to enable nested scrolling for the content | true | No |
| content | @Composable () -> Unit | Bottom sheet content | \- | Yes |

### BottomSheetDefaults Object [​](https://compose-miuix-ui.github.io/miuix/components/windowbottomsheet#bottomsheetdefaults-object)

The BottomSheetDefaults object provides default settings for the bottom sheet component.

#### BottomSheetDefaults Properties [​](https://compose-miuix-ui.github.io/miuix/components/windowbottomsheet#bottomsheetdefaults-properties)

| Property Name | Type | Description |
| --- | --- | --- |
| cornerRadius | Dp | Default corner radius (28.dp) |
| maxWidth | Dp | Default maximum width (640.dp) |
| outsideMargin | DpSize | Default bottom sheet external margin |
| insideMargin | DpSize | Default bottom sheet internal margin |

#### BottomSheetDefaults Functions [​](https://compose-miuix-ui.github.io/miuix/components/windowbottomsheet#bottomsheetdefaults-functions)

| Function Name | Return Type | Description |
| --- | --- | --- |
| backgroundColor() | Color | Get default background color |
| dragHandleColor() | Color | Get default drag indicator color |

## Advanced Usage [​](https://compose-miuix-ui.github.io/miuix/components/windowbottomsheet#advanced-usage)

### Action Buttons in Header [​](https://compose-miuix-ui.github.io/miuix/components/windowbottomsheet#action-buttons-in-header)

Use `startAction` and `endAction` to place buttons in the header area. `LocalDismissState` is provided in both action slots and the content slot:

kotlin

```
var showBottomSheet by remember { mutableStateOf(false) }

WindowBottomSheet(
    show = showBottomSheet,
    title = "Action Sheet",
    startAction = {
        val dismiss = LocalDismissState.current
        TextButton(
            text = "Cancel",
            onClick = { dismiss?.invoke() }
        )
    },
    endAction = {
        val dismiss = LocalDismissState.current
        TextButton(
            text = "Confirm",
            onClick = { dismiss?.invoke() }
        )
    },
    onDismissRequest = { showBottomSheet = false }
) {
    Text("Content with header action buttons")
}
```

### Dismissing from Content [​](https://compose-miuix-ui.github.io/miuix/components/windowbottomsheet#dismissing-from-content)

You can use `LocalDismissState` to dismiss the bottom sheet from within its content:

kotlin

```
WindowBottomSheet(
    show = showBottomSheet,
    title = "Dismiss Example",
    onDismissRequest = { showBottomSheet = false }
) {
    val dismiss = LocalDismissState.current

    TextButton(
        text = "Close Bottom Sheet",
        onClick = { dismiss?.invoke() }
    )
}
```

## Changelog[](https://compose-miuix-ui.github.io/miuix/components/windowbottomsheet#changelog)

Last edited about 1 month ago

View full history

---
Source: [WindowBottomSheet | Miuix](https://compose-miuix-ui.github.io/miuix/components/windowbottomsheet)