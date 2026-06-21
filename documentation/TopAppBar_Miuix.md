# TopAppBar | Miuix

`TopAppBar` is a top application bar component in Miuix, used to provide navigation, title, and action buttons at the top of the interface. It supports both large title and regular modes, as well as dynamic effects during scrolling.

This component is typically used in conjunction with the `Scaffold` component to maintain consistent layout and behavior across different pages in the application.

## Import [​](https://compose-miuix-ui.github.io/miuix/components/topappbar#import)

kotlin

```
import top.yukonga.miuix.kmp.basic.TopAppBar
import top.yukonga.miuix.kmp.basic.SmallTopAppBar
import top.yukonga.miuix.kmp.basic.MiuixScrollBehavior
import top.yukonga.miuix.kmp.basic.rememberTopAppBarState
```

## Basic Usage [​](https://compose-miuix-ui.github.io/miuix/components/topappbar#basic-usage)

### Small TopAppBar [​](https://compose-miuix-ui.github.io/miuix/components/topappbar#small-topappbar)

kotlin

```
Scaffold(
    topBar = {
        SmallTopAppBar(
            title = "Title",
            navigationIcon = {
                IconButton(onClick = { /* Handle click event */ }) {
                    Icon(MiuixIcons.Back, contentDescription = "Back")
                }
            },
            actions = {
                IconButton(onClick = { /* Handle click event */ }) {
                    Icon(MiuixIcons.More, contentDescription = "More")
                }
            }
        )
    }
)
```

### Large TopAppBar [​](https://compose-miuix-ui.github.io/miuix/components/topappbar#large-topappbar)

kotlin

```
Scaffold(
    topBar = {
        TopAppBar(
            title = "Title",
            largeTitle = "Large Title", // If not specified, title value will be used
            navigationIcon = {
                IconButton(onClick = { /* Handle click event */ }) {
                    Icon(MiuixIcons.Back, contentDescription = "Back")
                }
            },
            actions = {
                IconButton(onClick = { /* Handle click event */ }) {
                    Icon(MiuixIcons.More, contentDescription = "More")
                }
            }
        )
    }
)
```

TopAppBar supports changing its display state when content scrolls:

kotlin

```
val scrollBehavior = MiuixScrollBehavior()

Scaffold(
    topBar = {
        TopAppBar(
            title = "Title",
            largeTitle = "Large Title", // If not specified, title value will be used
            scrollBehavior = scrollBehavior
        )
    }
) { paddingValues ->
    // Content area needs to consider padding
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            // If you want to add the overscroll effect, please add it before the scroll behavior
            .overScrollVertical()
            // Bind TopAppBar scroll behavior
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        contentPadding = PaddingValues(top = paddingValues.calculateTopPadding())
    ) {
        // List content
    }
}
```

## Custom Styles [​](https://compose-miuix-ui.github.io/miuix/components/topappbar#custom-styles)

### Custom Colors [​](https://compose-miuix-ui.github.io/miuix/components/topappbar#custom-colors)

kotlin

```
TopAppBar(
    title = "Title",
    color = MiuixTheme.colorScheme.primary,
    titleColor = MiuixTheme.colorScheme.onPrimary,
    largeTitleColor = MiuixTheme.colorScheme.onPrimary
)
```

### Custom Content Padding [​](https://compose-miuix-ui.github.io/miuix/components/topappbar#custom-content-padding)

kotlin

```
TopAppBar(
    title = "Title",
    titlePadding = 32.dp
)
```

### Custom Icon Padding [​](https://compose-miuix-ui.github.io/miuix/components/topappbar#custom-icon-padding)

kotlin

```
TopAppBar(
    title = "Title",
    navigationIconPadding = 12.dp,
    actionIconPadding = 12.dp
)
```

## Properties [​](https://compose-miuix-ui.github.io/miuix/components/topappbar#properties)

### TopAppBar Properties [​](https://compose-miuix-ui.github.io/miuix/components/topappbar#topappbar-properties)

| Property Name | Type | Description | Default Value | Required |
| --- | --- | --- | --- | --- |
| title | String | Top bar title | \- | Yes |
| modifier | Modifier | Modifier applied to the top bar | Modifier | No |
| color | Color | Top bar background color | MiuixTheme.colorScheme.surface | No |
| titleColor | Color | Color of the collapsed small title text | MiuixTheme.colorScheme.onSurface | No |
| largeTitle | String | Large title text | title | No |
| largeTitleColor | Color | Color of the expanded large title text | MiuixTheme.colorScheme.onSurface | No |
| subtitle | String | Subtitle text displayed below the title bar | "" | No |
| subtitleColor | Color | Color of the subtitle text | MiuixTheme.colorScheme.onSurfaceVariantSummary | No |
| navigationIcon | @Composable () -> Unit | Composable function for navigation icon area | {} | No |
| actions | @Composable RowScope.() -> Unit | Composable function for action buttons area | {} | No |
| scrollBehavior | ScrollBehavior? | Controls top bar scroll behavior | null | No |
| defaultWindowInsetsPadding | Boolean | Whether to apply default window insets padding | true | No |
| titlePadding | Dp | Horizontal content padding | TopAppBarDefaults.TitlePadding | No |
| navigationIconPadding | Dp | Start padding of the navigation icon | TopAppBarDefaults.NavigationIconPadding | No |
| actionIconPadding | Dp | End padding of the action icons | TopAppBarDefaults.ActionIconPadding | No |
| bottomContent | @Composable () -> Unit | Composable content displayed below the title bar area | {} | No |

### SmallTopAppBar Properties [​](https://compose-miuix-ui.github.io/miuix/components/topappbar#smalltopappbar-properties)

| Property Name | Type | Description | Default Value | Required |
| --- | --- | --- | --- | --- |
| title | String | Top bar title | \- | Yes |
| modifier | Modifier | Modifier applied to the top bar | Modifier | No |
| color | Color | Top bar background color | MiuixTheme.colorScheme.surface | No |
| titleColor | Color | Color of the title text | MiuixTheme.colorScheme.onSurface | No |
| subtitle | String | Subtitle text displayed below the title bar | "" | No |
| subtitleColor | Color | Color of the subtitle text | MiuixTheme.colorScheme.onSurfaceVariantSummary | No |
| navigationIcon | @Composable () -> Unit | Composable function for navigation icon area | {} | No |
| actions | @Composable RowScope.() -> Unit | Composable function for action buttons area | {} | No |
| scrollBehavior | ScrollBehavior? | Controls top bar scroll behavior | null | No |
| defaultWindowInsetsPadding | Boolean | Whether to apply default window insets padding | true | No |
| titlePadding | Dp | Horizontal content padding | TopAppBarDefaults.TitlePadding | No |
| navigationIconPadding | Dp | Start padding of the navigation icon | TopAppBarDefaults.NavigationIconPadding | No |
| actionIconPadding | Dp | End padding of the action icons | TopAppBarDefaults.ActionIconPadding | No |
| bottomContent | @Composable () -> Unit | Composable content displayed below the title bar area | {} | No |

### TopAppBarDefaults Object [​](https://compose-miuix-ui.github.io/miuix/components/topappbar#topappbardefaults-object)

The TopAppBarDefaults object provides default values for TopAppBar and SmallTopAppBar components.

#### Constants [​](https://compose-miuix-ui.github.io/miuix/components/topappbar#constants)

| Constant Name | Type | Description | Default Value |
| --- | --- | --- | --- |
| TitlePadding | Dp | Horizontal padding of the title and large title | 26.dp |
| NavigationIconPadding | Dp | Start padding of the navigation icon | 16.dp |
| ActionIconPadding | Dp | End padding of the action icons | 16.dp |
| CollapsedHeight | Dp | Collapsed height of the TopAppBar | 52.dp |
| SmallTopAppBarCenterHeight | Dp | Vertical center height for SmallTopAppBar layout | 50.dp |
| LargeTitleBottomPadding | Dp | Bottom padding below the large title when no subtitle is present | 4.dp |
| SubtitleBottomPadding | Dp | Bottom padding below the subtitle (both large and small) | 8.dp |

### ScrollBehavior [​](https://compose-miuix-ui.github.io/miuix/components/topappbar#scrollbehavior)

MiuixScrollBehavior is a configuration object used to control the scroll behavior of the top bar.

#### rememberTopAppBarState [​](https://compose-miuix-ui.github.io/miuix/components/topappbar#remembertopappbarstate)

Used to create and remember TopAppBarState:

kotlin

```
val scrollBehavior = MiuixScrollBehavior(
    state = rememberTopAppBarState(),
    snapAnimationSpec = spring(stiffness = 2500f),
    canScroll = { true }
)
```

| Parameter Name | Type | Default Value | Description |
| --- | --- | --- | --- |
| state | TopAppBarState | rememberTopAppBarState() | State object controlling scroll state |
| canScroll | () -> Boolean |  | Callback to control whether scrolling is allowed |
| snapAnimationSpec | AnimationSpec<Float>? | spring(stiffness = 2500f) | Defines snap animation after scrolling |
| flingAnimationSpec | DecayAnimationSpec<Float>? | rememberSplineBasedDecay() | Defines decay animation for fling |

## Advanced Usage [​](https://compose-miuix-ui.github.io/miuix/components/topappbar#advanced-usage)

### Handling Window Insets [​](https://compose-miuix-ui.github.io/miuix/components/topappbar#handling-window-insets)

kotlin

```
TopAppBar(
    title = "Title",
    largeTitle = "Large Title",
    defaultWindowInsetsPadding = false // Handle window insets manually
)
```

### Custom Scroll Behavior Animation [​](https://compose-miuix-ui.github.io/miuix/components/topappbar#custom-scroll-behavior-animation)

kotlin

```
var isScrollingEnabled by remember { mutableStateOf(true) }
val scrollBehavior = MiuixScrollBehavior(
    snapAnimationSpec = tween(durationMillis = 100),
    flingAnimationSpec = rememberSplineBasedDecay(),
    canScroll = { isScrollingEnabled } // Can dynamically control whether scrolling is allowed
)

TopAppBar(
    title = "Title",
    largeTitle = "Large Title",
    scrollBehavior = scrollBehavior
)
```

### Combining Large and Small Titles [​](https://compose-miuix-ui.github.io/miuix/components/topappbar#combining-large-and-small-titles)

kotlin

```
var useSmallTopBar by remember { mutableStateOf(false) }

Box(modifier = Modifier.fillMaxSize()) {
    if (useSmallTopBar) {
        SmallTopAppBar(
            title = "Compact Mode",
            navigationIcon = {
                IconButton(onClick = { useSmallTopBar = false }) {
                    Icon(
                        imageVector = MiuixIcons.Back,
                        contentDescription = "Switch to Large Title",
                        tint = MiuixTheme.colorScheme.onBackground
                    )
                }
            }
        )
    } else {
        TopAppBar(
            title = "Title",
            largeTitle = "Expanded Mode",
            navigationIcon = {
                IconButton(onClick = { useSmallTopBar = true }) {
                    Icon(
                        imageVector = MiuixIcons.Back,
                        contentDescription = "Switch to Small Title",
                        tint = MiuixTheme.colorScheme.onBackground
                    )
                }
            }
        )
    }
}
```

## Changelog[](https://compose-miuix-ui.github.io/miuix/components/topappbar#changelog)

Last edited about 2 months ago

View full history

---
Source: [TopAppBar | Miuix](https://compose-miuix-ui.github.io/miuix/components/topappbar)