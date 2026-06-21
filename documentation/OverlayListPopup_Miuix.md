# OverlayListPopup | Miuix

`OverlayListPopup` is a popup list component in Miuix used to display a popup menu with multiple options. It provides a lightweight, floating temporary list suitable for various dropdown menus, context menus, and similar scenarios.

Prerequisite

This component depends on `Scaffold` providing `MiuixPopupHost` to render popup content. It must be used within `Scaffold`, otherwise popup content will not render correctly.

## Import [​](https://compose-miuix-ui.github.io/miuix/components/overlaylistpopup#import)

kotlin

```
import top.yukonga.miuix.kmp.overlay.OverlayListPopup
import top.yukonga.miuix.kmp.basic.ListPopupColumn
```

## Basic Usage [​](https://compose-miuix-ui.github.io/miuix/components/overlaylistpopup#basic-usage)

The OverlayListPopup component can be used to create simple dropdown menus:

kotlin

```
var showPopup by remember { mutableStateOf(false) }
var selectedIndex by remember { mutableStateOf(0) }
val items = listOf("Option 1", "Option 2", "Option 3")

Scaffold {
    Box {
        TextButton(
            text = "Click to show menu",
            onClick = { showPopup = true }
        )
        OverlayListPopup(
            show = showPopup,
            alignment = PopupPositionProvider.Align.Start,
            onDismissRequest = { showPopup = false } // Close the popup menu
        ) {
            ListPopupColumn {
                items.forEachIndexed { index, string ->
                    DropdownImpl(
                        text = string,
                        optionSize = items.size,
                        isSelected = selectedIndex == index,
                        index = index,
                        onSelectedIndexChange = {
                            selectedIndex = index
                            showPopup = false // Close the popup menu
                        }
                    )
                }
            }
        }
    }
}

## Component States

### Different Alignments

OverlayListPopup can be set with different alignment options:

```kotlin
var showPopup by remember { mutableStateOf(false) }

OverlayListPopup(
    show = showPopup,
    onDismissRequest = { showPopup = false }, // Close the popup menu
    alignment = PopupPositionProvider.Align.Start
) {
    ListPopupColumn {
        // Custom content
    }
}
```

### Disable Window Dimming [​](https://compose-miuix-ui.github.io/miuix/components/overlaylistpopup#disable-window-dimming)

kotlin

```
var showPopup by remember { mutableStateOf(false) }

OverlayListPopup(
    show = showPopup,
    onDismissRequest = { showPopup = false } // Close the popup menu
    enableWindowDim = false // Disable dimming layer
) {
    ListPopupColumn {
        // Custom content
    }
}
```

## Properties [​](https://compose-miuix-ui.github.io/miuix/components/overlaylistpopup#properties)

### OverlayListPopup [​](https://compose-miuix-ui.github.io/miuix/components/overlaylistpopup#overlaylistpopup-1)

| Property Name | Type | Description | Default Value |
| --- | --- | --- | --- |
| show | Boolean | Whether to show the popup. | \- |
| popupModifier | Modifier | Modifier applied to the popup container. | Modifier |
| popupPositionProvider | PopupPositionProvider | Provides position calculation logic for the popup. | ListPopupDefaults.DropdownPositionProvider |
| alignment | PopupPositionProvider.Align | Specifies the alignment of the popup relative to the anchor. | PopupPositionProvider.Align.Start |
| enableWindowDim | Boolean | Whether to dim the background when popup is shown. | true |
| onDismissRequest | (() -> Unit)? | Called when the user requests dismissal (e.g., clicking outside). | null |
| onDismissFinished | (() -> Unit)? | Invoked after the hide animation completes; not invoked if the hide is cancelled mid-flight (e.g., `show` toggled back to true) | null |
| maxHeight | Dp? | Maximum height of the popup content. | null |
| minWidth | Dp | Minimum width of the popup content. | ListPopupDefaults.MinWidth |
| renderInRootScaffold | Boolean | Whether to render the popup in the root (outermost) Scaffold. When true, the popup covers the full screen. When false, it renders within the current Scaffold's bounds with position compensation. | true |
| content | @Composable () -> Unit | The content to display inside the popup. | \- |

### ListPopupColumn [​](https://compose-miuix-ui.github.io/miuix/components/overlaylistpopup#listpopupcolumn)

| Property Name | Type | Description | Default Value |
| --- | --- | --- | --- |
| content | @Composable () -> Unit | The list content to display inside the column. | \- |

### DropdownImpl [​](https://compose-miuix-ui.github.io/miuix/components/overlaylistpopup#dropdownimpl)

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

### PopupPositionProvider.Align [​](https://compose-miuix-ui.github.io/miuix/components/overlaylistpopup#popuppositionprovider-align)

| Value | Description |
| --- | --- |
| Start | Aligns the popup to the start of the anchor. |
| End | Aligns the popup to the end of the anchor. |
| TopStart | Aligns the popup to the top-start of the anchor. |
| TopEnd | Aligns the popup to the top-end of the anchor. |
| BottomStart | Aligns the popup to the bottom-start of the anchor. |
| BottomEnd | Aligns the popup to the bottom-end of the anchor. |

## Changelog[](https://compose-miuix-ui.github.io/miuix/components/overlaylistpopup#changelog)

Last edited about 1 month ago

View full history

---
Source: [OverlayListPopup | Miuix](https://compose-miuix-ui.github.io/miuix/components/overlaylistpopup)