# TabRow | Miuix

`TabRow` is a navigation component in Miuix used to create horizontally scrollable tabs. It provides two variants: standard style and contour style, suitable for content categorization and navigation scenarios.

## Import [​](https://compose-miuix-ui.github.io/miuix/components/tabrow#import)

kotlin

```
import top.yukonga.miuix.kmp.basic.TabRow // Standard style
import top.yukonga.miuix.kmp.basic.TabRowWithContour // Contour style
```

## Basic Usage [​](https://compose-miuix-ui.github.io/miuix/components/tabrow#basic-usage)

### Standard Style [​](https://compose-miuix-ui.github.io/miuix/components/tabrow#standard-style)

kotlin

```
val tabs = listOf("Recommended", "Following", "Popular", "Featured")
var selectedTabIndex by remember { mutableStateOf(0) }

TabRow(
    tabs = tabs,
    selectedTabIndex = selectedTabIndex,
    onTabSelected = { selectedTabIndex = it }
)
```

### Contour Style [​](https://compose-miuix-ui.github.io/miuix/components/tabrow#contour-style)

kotlin

```
val tabs = listOf("All", "Photos", "Videos", "Documents")
var selectedTabIndex by remember { mutableStateOf(0) }

TabRowWithContour(
    tabs = tabs,
    selectedTabIndex = selectedTabIndex,
    onTabSelected = { selectedTabIndex = it }
)
```

### Preserve Scroll Position [​](https://compose-miuix-ui.github.io/miuix/components/tabrow#preserve-scroll-position)

kotlin

```
val tabs = listOf("Tab 1", "Tab 2", "Tab 3", "Tab 4", "Tab 5")
var selectedTabIndex by remember { mutableStateOf(3) }
val tabListState = rememberLazyListState()

TabRowWithContour(
    tabs = tabs,
    selectedTabIndex = selectedTabIndex,
    onTabSelected = { selectedTabIndex = it },
    listState = tabListState,
)
```

## Properties [​](https://compose-miuix-ui.github.io/miuix/components/tabrow#properties)

### TabRow Properties [​](https://compose-miuix-ui.github.io/miuix/components/tabrow#tabrow-properties)

| Property Name | Type | Description | Default Value | Required |
| --- | --- | --- | --- | --- |
| tabs | List<String> | List of tab texts | \- | Yes |
| selectedTabIndex | Int | Current selected tab index | \- | Yes |
| onTabSelected | (Int) -> Unit | Callback when tab is selected | \- | Yes |
| modifier | Modifier | Modifier for the tab row | Modifier | No |
| colors | TabRowColors | Color configuration | TabRowDefaults.tabRowColors() | No |
| minWidth | Dp | Minimum width of each tab | TabRowDefaults.TabRowMinWidth | No |
| maxWidth | Dp | Maximum width of each tab | TabRowDefaults.TabRowMaxWidth | No |
| height | Dp | Height of the tab row | TabRowDefaults.TabRowHeight | No |
| cornerRadius | Dp | Corner radius of tabs | TabRowDefaults.TabRowCornerRadius | No |
| itemSpacing | Dp | Spacing between tabs | 9.dp | No |
| contentAlignment | Alignment | Alignment of tab content | Alignment.Center | No |
| listState | LazyListState? | External scroll state for tabs | null | No |
| interactionSource | MutableInteractionSource? | Interaction source for tab items | null | No |
| indication | Indication? | Indication for tab items | null | No |

### TabRowWithContour Properties [​](https://compose-miuix-ui.github.io/miuix/components/tabrow#tabrowwithcontour-properties)

| Property Name | Type | Description | Default Value | Required |
| --- | --- | --- | --- | --- |
| tabs | List<String> | List of tab texts | \- | Yes |
| selectedTabIndex | Int | Current selected tab index | \- | Yes |
| onTabSelected | (Int) -> Unit | Callback when tab is selected | \- | Yes |
| modifier | Modifier | Modifier for the tab row | Modifier | No |
| colors | TabRowColors | Color configuration | TabRowDefaults.tabRowColors() | No |
| minWidth | Dp | Minimum width of each tab | TabRowDefaults.TabRowWithContourMinWidth | No |
| maxWidth | Dp | Maximum width of each tab | TabRowDefaults.TabRowWithContourMaxWidth | No |
| height | Dp | Height of the tab row | TabRowDefaults.TabRowWithContourHeight | No |
| cornerRadius | Dp | Corner radius of tabs | TabRowDefaults.TabRowWithContourCornerRadius | No |
| itemSpacing | Dp | Spacing between tabs | 5.dp | No |
| contentAlignment | Alignment | Alignment of tab content | Alignment.Center | No |
| listState | LazyListState? | External scroll state for tabs | null | No |
| interactionSource | MutableInteractionSource? | Interaction source for tab items | null | No |
| indication | Indication? | Indication for tab items | null | No |

### TabRowDefaults Object [​](https://compose-miuix-ui.github.io/miuix/components/tabrow#tabrowdefaults-object)

The TabRowDefaults object provides default configurations for the TabRow component.

#### Constants [​](https://compose-miuix-ui.github.io/miuix/components/tabrow#constants)

| Constant Name | Type | Value | Description |
| --- | --- | --- | --- |
| TabRowHeight | Dp | 42.dp | Default height of tab row for standard style |
| TabRowWithContourHeight | Dp | 45.dp | Default height of tab row for contour style |
| TabRowCornerRadius | Dp | 12.dp | Default corner radius for standard style |
| TabRowWithContourCornerRadius | Dp | 8.dp | Default corner radius for contour style |
| TabRowMinWidth | Dp | 76.dp | Min width of tabs for standard style |
| TabRowWithContourMinWidth | Dp | 62.dp | Min width of tabs for contour style |
| TabRowMaxWidth | Dp | 98.dp | Max width of tabs for standard style |
| TabRowWithContourMaxWidth | Dp | 84.dp | Max width of tabs for contour style |

#### Methods [​](https://compose-miuix-ui.github.io/miuix/components/tabrow#methods)

| Method Name | Type | Description |
| --- | --- | --- |
| tabRowColors() | TabRowColors | Create default color configuration |

### TabRowColors Class [​](https://compose-miuix-ui.github.io/miuix/components/tabrow#tabrowcolors-class)

| Property Name | Type | Description |
| --- | --- | --- |
| backgroundColor | Color | Default background color of tabs |
| contentColor | Color | Default content color of tabs |
| selectedBackgroundColor | Color | Background color of selected tab |
| selectedContentColor | Color | Content color of selected tab |

## Advanced Usage [​](https://compose-miuix-ui.github.io/miuix/components/tabrow#advanced-usage)

### Custom Colors [​](https://compose-miuix-ui.github.io/miuix/components/tabrow#custom-colors)

kotlin

```
val tabs = listOf("Latest", "Popular", "Following")
var selectedTabIndex by remember { mutableStateOf(0) }

TabRow(
    tabs = tabs,
    selectedTabIndex = selectedTabIndex,
    onTabSelected = { selectedTabIndex = it },
    colors = TabRowDefaults.tabRowColors(
        backgroundColor = Color.LightGray.copy(alpha = 0.5f),
        contentColor = Color.Gray,
        selectedBackgroundColor = MiuixTheme.colorScheme.primary,
        selectedContentColor = Color.White
    )
)
```

### Custom Dimensions [​](https://compose-miuix-ui.github.io/miuix/components/tabrow#custom-dimensions)

kotlin

```
val tabs = listOf("Short Videos", "Live", "Articles")
var selectedTabIndex by remember { mutableStateOf(0) }

TabRowWithContour(
    tabs = tabs,
    selectedTabIndex = selectedTabIndex,
    onTabSelected = { selectedTabIndex = it },
    minWidth = 100.dp,
    height = 50.dp,
    cornerRadius = 15.dp
)
```

### Using with Pager [​](https://compose-miuix-ui.github.io/miuix/components/tabrow#using-with-pager)

kotlin

```
val tabs = listOf("Page 1", "Page 2", "Page 3")
val pagerState = rememberPagerState { tabs.size }
var selectedTabIndex by remember { mutableStateOf(0) }

LaunchedEffect(pagerState.currentPage) {
    selectedTabIndex = pagerState.currentPage
}

LaunchedEffect(selectedTabIndex) {
    pagerState.animateScrollToPage(selectedTabIndex)
}

Surface {
    Column {
        TabRow(
            tabs = tabs,
            selectedTabIndex = selectedTabIndex,
            onTabSelected = { selectedTabIndex = it }
        )
        HorizontalPager(
            pagerState = pagerState,
            modifier = Modifier.fillMaxSize()
        ) { page ->
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text("Page Content ${page + 1}")
            }
        }
    }
}
```

## Changelog[](https://compose-miuix-ui.github.io/miuix/components/tabrow#changelog)

Last edited about 2 months ago

View full history

---
Source: [TabRow | Miuix](https://compose-miuix-ui.github.io/miuix/components/tabrow)