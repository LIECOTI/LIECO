# Text | Miuix

`Text` component is a basic text component in Miuix, used to display text content. It supports customizing various text styles, alignment, and decoration effects.

## Import [​](https://compose-miuix-ui.github.io/miuix/components/text#import)

kotlin

```
import top.yukonga.miuix.kmp.basic.Text
```

## Basic Usage [​](https://compose-miuix-ui.github.io/miuix/components/text#basic-usage)

The simplest text display:

kotlin

```
Text("This is a basic text")
```

## Text Styles [​](https://compose-miuix-ui.github.io/miuix/components/text#text-styles)

Miuix provides multiple predefined text styles:

kotlin

```
Text(
    text = "Title Text",
    style = MiuixTheme.textStyles.headline1
)

Text(
    text = "Subtitle Text",
    style = MiuixTheme.textStyles.subtitle
)
Text(
    text = "Summary Text",
    style = MiuixTheme.textStyles.body2
)

Text(
    text = "Main Text",
    style = MiuixTheme.textStyles.main
)
```

## Text Color [​](https://compose-miuix-ui.github.io/miuix/components/text#text-color)

kotlin

```
Text(
    text = "Default Color Text",
    color = MiuixTheme.colorScheme.onBackground
)

Text(
    text = "Primary Color Text",
    color = MiuixTheme.colorScheme.primary
)

Text(
    text = "Secondary Text",
    color = MiuixTheme.colorScheme.onSurfaceContainerVariant
)
```

## Properties [​](https://compose-miuix-ui.github.io/miuix/components/text#properties)

### Text (String) Properties [​](https://compose-miuix-ui.github.io/miuix/components/text#text-string-properties)

| Property Name | Type | Description | Default Value | Required |
| --- | --- | --- | --- | --- |
| text | String | The text content to display | \- | Yes |
| modifier | Modifier | Modifiers applied to the text | Modifier | No |
| color | Color | Text color | Color.Unspecified | No |
| autoSize | TextAutoSize? | Auto-sizing behavior for text | null | No |
| fontSize | TextUnit | Text size | TextUnit.Unspecified | No |
| fontStyle | FontStyle? | Text font style (e.g., italic) | null | No |
| fontWeight | FontWeight? | Text font weight | null | No |
| fontFamily | FontFamily? | Text font family | null | No |
| letterSpacing | TextUnit | Letter spacing | TextUnit.Unspecified | No |
| textDecoration | TextDecoration? | Text decoration (e.g., underline) | null | No |
| textAlign | TextAlign? | Text alignment | null | No |
| lineHeight | TextUnit | Line height | TextUnit.Unspecified | No |
| overflow | TextOverflow | Text overflow handling | TextOverflow.Clip | No |
| softWrap | Boolean | Whether to wrap text automatically | true | No |
| maxLines | Int | Maximum number of lines | Int.MAX\_VALUE | No |
| minLines | Int | Minimum number of lines | 1 | No |
| onTextLayout | ((TextLayoutResult) -> Unit)? | Callback after layout | null | No |
| style | TextStyle | Text style | MiuixTheme.textStyles.main | No |

### Text (AnnotatedString) Properties [​](https://compose-miuix-ui.github.io/miuix/components/text#text-annotatedstring-properties)

| Property Name | Type | Description | Default Value | Required |
| --- | --- | --- | --- | --- |
| text | AnnotatedString | Rich text with annotations | \- | Yes |
| modifier | Modifier | Modifiers applied to the text | Modifier | No |
| color | Color | Text color | Color.Unspecified | No |
| autoSize | TextAutoSize? | Auto-sizing behavior for text | null | No |
| fontSize | TextUnit | Text size | TextUnit.Unspecified | No |
| fontStyle | FontStyle? | Text font style | null | No |
| fontWeight | FontWeight? | Text font weight | null | No |
| fontFamily | FontFamily? | Text font family | null | No |
| letterSpacing | TextUnit | Letter spacing | TextUnit.Unspecified | No |
| textDecoration | TextDecoration? | Text decoration | null | No |
| textAlign | TextAlign? | Text alignment | null | No |
| lineHeight | TextUnit | Line height | TextUnit.Unspecified | No |
| overflow | TextOverflow | Text overflow handling | TextOverflow.Clip | No |
| softWrap | Boolean | Whether to wrap text automatically | true | No |
| maxLines | Int | Maximum number of lines | Int.MAX\_VALUE | No |
| minLines | Int | Minimum number of lines | 1 | No |
| inlineContent | Map<String, InlineTextContent> | Mapping for inserting inline composables | mapOf() | No |
| onTextLayout | (TextLayoutResult) -> Unit | Callback after text layout is completed | {} | No |
| style | TextStyle | Text style | MiuixTheme.textStyles.main | No |

## Advanced Usage [​](https://compose-miuix-ui.github.io/miuix/components/text#advanced-usage)

### Multi-line Text Truncation [​](https://compose-miuix-ui.github.io/miuix/components/text#multi-line-text-truncation)

kotlin

```
Text(
    text = "This is a very long text that will be truncated and show ellipsis when there is not enough space. This is useful for displaying long content summaries.",
    maxLines = 2,
    overflow = TextOverflow.Ellipsis
)
```

### Text Decoration [​](https://compose-miuix-ui.github.io/miuix/components/text#text-decoration)

kotlin

```
Text(
    text = "Underlined Text",
    textDecoration = TextDecoration.Underline
)

Text(
    text = "Strikethrough Text",
    textDecoration = TextDecoration.LineThrough
)
```

### Rich Text Mixing [​](https://compose-miuix-ui.github.io/miuix/components/text#rich-text-mixing)

kotlin

```
Text(
    buildAnnotatedString {
        withStyle(style = SpanStyle(color = MiuixTheme.colorScheme.primary)) {
            append("Miuix ")
        }
        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
            append("UI Library")
        }
        append(", this is a piece of rich text")
    }
)
```

### Auto-sizing Text [​](https://compose-miuix-ui.github.io/miuix/components/text#auto-sizing-text)

Automatically fit text within available space using `TextAutoSize`:

kotlin

```
Text(
    text = "Adaptive text",
    autoSize = TextAutoSize.StepBased(
        minFontSize = 12.sp,
        maxFontSize = 17.sp,
        stepSize = 0.3.sp
    )
)
```

### Frequently Changing Color [​](https://compose-miuix-ui.github.io/miuix/components/text#frequently-changing-color)

Both `Text(String, ...)` and `Text(AnnotatedString, ...)` have a companion overload that takes a `ColorProducer` instead of a `Color`:

kotlin

```
fun Text(text: String, color: ColorProducer, modifier: Modifier = Modifier, ...)
fun Text(text: AnnotatedString, color: ColorProducer, modifier: Modifier = Modifier, ...)
```

All other parameters are identical to the tables above. The producer is read directly during draw, so when the text color changes on every frame (animations, scroll listeners, gesture-driven values), the `Text` itself is not recomposed:

kotlin

```
val scrollState = rememberScrollState()
Text(
    text = "Scroll-tinted text",
    color = {
        lerp(
            MiuixTheme.colorScheme.onSurface,
            MiuixTheme.colorScheme.primary,
            (scrollState.value / 500f).coerceIn(0f, 1f),
        )
    },
)
```

### Clickable Links [​](https://compose-miuix-ui.github.io/miuix/components/text#clickable-links)

Use `AnnotatedString` with `LinkAnnotation` to create clickable links:

kotlin

```
val annotated = buildAnnotatedString {
    append("Visit ")
    val start = length
    append("Miuix Docs")
    addLink(
        LinkAnnotation.Url(
            url = "https://compose-miuix-ui.github.io/miuix/",
            styles = TextLinkStyles(
                SpanStyle(color = MiuixTheme.colorScheme.primary, fontWeight = FontWeight.Bold)
            )
        ),
        start = start,
        end = length
    )
}

Text(text = annotated)
```

## Changelog[](https://compose-miuix-ui.github.io/miuix/components/text#changelog)

Last edited 28 days ago

View full history

---
Source: [Text | Miuix](https://compose-miuix-ui.github.io/miuix/components/text)