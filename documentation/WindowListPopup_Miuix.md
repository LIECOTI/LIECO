# WindowListPopup | Miuix

[Skip to content](https://compose-miuix-ui.github.io/miuix/components/windowlistpopup#VPContent)

`WindowListPopup` is a popup list component that renders at the window level using `Dialog`. Unlike `OverlayListPopup`, it does not require a `Scaffold` or `MiuixPopupHost`.

## Import [​](https://compose-miuix-ui.github.io/miuix/components/windowlistpopup#import)

kotlin

```
import top.yukonga.miuix.kmp.window.WindowListPopup
import top.yukonga.miuix.kmp.basic.ListPopupColumn
```

## Basic Usage [​](https://compose-miuix-ui.github.io/miuix/components/windowlistpopup#basic-usage)

The WindowListPopup component can be used to create dropdown menus without `Scaffold`:

kotlin

```
var showPopup by remember { mutableStateOf(false) }
var selectedIndex by remember { mutableStateOf(0) }
val items = listOf("Option 1", "Option 2", "Option 3")

Box {
    TextButton(
        text = "Click to show menu",
        onClick = { showPopup = true }
    )
    WindowListPopup(
        show = showPopup,
        alignment = PopupPositionProvider.Align.Start,
        onDismissRequest = { showPopup = false }
    ) {
        val dismiss = LocalDismissState.current
        ListPopupColumn {
            items.forEachIndexed { index, string ->
                DropdownImpl(
                    text = string,
                    optionSize = items.size,
                    isSelected = selectedIndex == index,
                    index = index,
                    onSelectedIndexChange = {
                        selectedIndex = index
                        dismiss?.invoke()
                    }
                )
            }
        }
    }
}
```

## Properties [​](https://compose-miuix-ui.github.io/miuix/components/windowlistpopup#properties)

### WindowListPopup [​](https://compose-miuix-ui.github.io/miuix/components/windowlistpopup#windowlistpopup-1)

| Property Name | Type | Description | Default Value |
| --- | --- | --- | --- |
| show | Boolean | Whether to show the popup. | \- |
| popupModifier | Modifier | Modifier applied to the popup container. | Modifier |
| popupPositionProvider | PopupPositionProvider | Provides position calculation logic for the popup. | ListPopupDefaults.DropdownPositionProvider |
| alignment | PopupPositionProvider.Align | Specifies the alignment of the popup relative to the anchor. | PopupPositionProvider.Align.Start |
| enableWindowDim | Boolean | Whether to dim the background when popup is shown. | true |
| onDismissRequest | (() -> Unit)? | Called when the user requests dismissal (e.g., clicking outside) | null |
| onDismissFinished | (() -> Unit)? | Invoked after the hide animation completes; not invoked if the hide is cancelled mid-flight (e.g., `show` toggled back to true) | null |
| maxHeight | Dp? | Maximum height of the popup content. | null |
| minWidth | Dp | Minimum width of the popup content. | ListPopupDefaults.MinWidth |
| content | @Composable () -> Unit | The content to display inside the popup. | \- |

### ListPopupColumn [​](https://compose-miuix-ui.github.io/miuix/components/windowlistpopup#listpopupcolumn)

| Property Name | Type | Description | Default Value |
| --- | --- | --- | --- |
| content | @Composable () -> Unit | The list content to display inside the column. | \- |

### DropdownImpl [​](https://compose-miuix-ui.github.io/miuix/components/windowlistpopup#dropdownimpl)

`DropdownImpl` can be used as a standard row inside `ListPopupColumn`. Set `enabled = false` to disable a row; disabled rows are not clickable and use the disabled text color.

kotlin

```
DropdownImpl(
    text = "Disabled option",
    optionSize = items.size,
    isSelected = false,
    index = 1,
    enabled = false,
    onSelectedIndexChange = {}
)
```

| Property Name | Type | Description | Default Value |
| --- | --- | --- | --- |
| text | String | Text shown for the option | \- |
| optionSize | Int | Total number of options | \- |
| isSelected | Boolean | Whether this option is selected | \- |
| index | Int | Index of this option | \- |
| dropdownColors | DropdownColors | Color configuration for the option | DropdownDefaults.dropdownColors() |
| enabled | Boolean | Whether this option can be clicked | true |
| onSelectedIndexChange | (Int) -> Unit | Callback when this option is clicked | \- |

### PopupPositionProvider.Align [​](https://compose-miuix-ui.github.io/miuix/components/windowlistpopup#popuppositionprovider-align)

| Value | Description |
| --- | --- |
| Start | Aligns the popup to the start of the anchor. |
| End | Aligns the popup to the end of the anchor. |
| TopStart | Aligns the popup to the top-start of the anchor. |
| TopEnd | Aligns the popup to the top-end of the anchor. |
| BottomStart | Aligns the popup to the bottom-start of the anchor. |
| BottomEnd | Aligns the popup to the bottom-end of the anchor. |

### LocalDismissState [​](https://compose-miuix-ui.github.io/miuix/components/windowlistpopup#localdismissstate)

Provides a `(() -> Unit)?` function to dismiss the current popup from within its content. This is a unified dismiss state provided by all overlay components.

kotlin

```
val dismiss = LocalDismissState.current
TextButton(
    text = "Close",
    onClick = { dismiss?.invoke() }
)
```

## Changelog[](https://compose-miuix-ui.github.io/miuix/components/windowlistpopup#changelog)

Last edited about 1 month ago

View full history

---
Source: [WindowListPopup | Miuix](https://compose-miuix-ui.github.io/miuix/components/windowlistpopup)