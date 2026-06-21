# TextField | Miuix

`TextField` is a basic input component in Miuix for receiving text input from users. The component provides rich customization options, supporting label animations, leading and trailing icons, and other features.

## Import [​](https://compose-miuix-ui.github.io/miuix/components/textfield#import)

kotlin

```
import top.yukonga.miuix.kmp.basic.TextField
```

## Basic Usage [​](https://compose-miuix-ui.github.io/miuix/components/textfield#basic-usage)

The TextField component can be used to get user input:

kotlin

```
var text by remember { mutableStateOf("") }

TextField(
    value = text,
    onValueChange = { text = it },
    label = "Username"
)
```

INFO

This TextField component now also supports the latest state-based version. Please refer to the [State-based](https://developer.android.com/develop/ui/compose/text/user-input?textfield=state-based) documentation for details.

## Input Types [​](https://compose-miuix-ui.github.io/miuix/components/textfield#input-types)

### TextField with Label [​](https://compose-miuix-ui.github.io/miuix/components/textfield#textfield-with-label)

The label automatically moves to the top when the input field gains focus or has content:

kotlin

```
var text by remember { mutableStateOf("") }

TextField(
    value = text,
    onValueChange = { text = it },
    label = "Email Address"
)
```

### Using Label as Placeholder [​](https://compose-miuix-ui.github.io/miuix/components/textfield#using-label-as-placeholder)

kotlin

```
var text by remember { mutableStateOf("") }

TextField(
    value = text,
    onValueChange = { text = it },
    label = "Please enter content",
    useLabelAsPlaceholder = true
)
```

## Component States [​](https://compose-miuix-ui.github.io/miuix/components/textfield#component-states)

### Disabled State [​](https://compose-miuix-ui.github.io/miuix/components/textfield#disabled-state)

kotlin

```
var text by remember { mutableStateOf("") }
TextField(
    value = text,
    onValueChange = { text = it },
    label = "Disabled Input Field",
    enabled = false
)
```

### Read-Only State [​](https://compose-miuix-ui.github.io/miuix/components/textfield#read-only-state)

kotlin

```
var text by remember { mutableStateOf("This is read-only content") }

TextField(
    value = text,
    onValueChange = { text = it },
    label = "Read-Only Input Field",
    readOnly = true
)
```

## Properties [​](https://compose-miuix-ui.github.io/miuix/components/textfield#properties)

### TextField Properties [​](https://compose-miuix-ui.github.io/miuix/components/textfield#textfield-properties)

| Property Name | Type | Description | Default Value | Required |
| --- | --- | --- | --- | --- |
| value | String or TextFieldValue | Text value of the input field | \- | Yes |
| onValueChange | (String) -> Unit or (TextFieldValue) -> Unit | Callback when text changes | \- | Yes |
| modifier | Modifier | Modifier applied to the input field | Modifier | No |
| insideMargin | DpSize | Internal padding of input field | TextFieldDefaults.InsideMargin | No |
| colors | TextFieldColors | Colors used by the field | TextFieldDefaults.textFieldColors() | No |
| cornerRadius | Dp | Corner radius | TextFieldDefaults.CornerRadius | No |
| label | String | Label text | "" | No |
| useLabelAsPlaceholder | Boolean | Use label as placeholder | false | No |
| enabled | Boolean | Whether input field is enabled | true | No |
| readOnly | Boolean | Whether input field is read-only | false | No |
| textStyle | TextStyle | Text style | MiuixTheme.textStyles.main | No |
| keyboardOptions | KeyboardOptions | Keyboard options | KeyboardOptions.Default | No |
| keyboardActions | KeyboardActions | Keyboard actions | KeyboardActions.Default | No |
| leadingIcon | @Composable (() -> Unit)? | Leading icon | null | No |
| trailingIcon | @Composable (() -> Unit)? | Trailing icon | null | No |
| singleLine | Boolean | Single line input | false | No |
| maxLines | Int | Maximum lines | If singleLine is true then 1, else Int.MAX\_VALUE | No |
| minLines | Int | Minimum lines | 1 | No |
| visualTransformation | VisualTransformation | Visual transformation | VisualTransformation.None | No |
| onTextLayout | (TextLayoutResult) -> Unit | Text layout callback | {} | No |
| interactionSource | MutableInteractionSource? | Interaction source | null | No |
| cursorBrush | Brush | Cursor brush | SolidColor(colors.borderColor) | No |

### TextField (state-based) Properties [​](https://compose-miuix-ui.github.io/miuix/components/textfield#textfield-state-based-properties)

| Property Name | Type | Description | Default Value | Required |
| --- | --- | --- | --- | --- |
| state | TextFieldState | State object holding text and selection | \- | Yes |
| modifier | Modifier | Modifier applied to the input field | Modifier | No |
| insideMargin | DpSize | Internal padding of input field | TextFieldDefaults.InsideMargin | No |
| colors | TextFieldColors | Colors used by the field | TextFieldDefaults.textFieldColors() | No |
| cornerRadius | Dp | Corner radius | TextFieldDefaults.CornerRadius | No |
| label | String | Label text | "" | No |
| useLabelAsPlaceholder | Boolean | Use label as placeholder | false | No |
| enabled | Boolean | Whether input field is enabled | true | No |
| readOnly | Boolean | Whether input field is read-only | false | No |
| inputTransformation | InputTransformation? | Input transformation | null | No |
| textStyle | TextStyle | Text style | MiuixTheme.textStyles.main | No |
| keyboardOptions | KeyboardOptions | Keyboard options | KeyboardOptions.Default | No |
| onKeyboardAction | KeyboardActionHandler? | Keyboard action handler | null | No |
| lineLimits | TextFieldLineLimits | Line limits | TextFieldLineLimits.Default | No |
| leadingIcon | @Composable (() -> Unit)? | Leading icon | null | No |
| trailingIcon | @Composable (() -> Unit)? | Trailing icon | null | No |
| onTextLayout | Density.(getResult: () -> TextLayoutResult?) -> Unit | Text layout callback with density receiver | null | No |
| interactionSource | MutableInteractionSource? | Interaction source | null | No |
| cursorBrush | Brush | Cursor brush | SolidColor(colors.borderColor) | No |
| outputTransformation | OutputTransformation? | Output transformation | null | No |
| scrollState | ScrollState | Scroll state | rememberScrollState() | No |

### TextFieldDefaults Object [​](https://compose-miuix-ui.github.io/miuix/components/textfield#textfielddefaults-object)

The TextFieldDefaults object provides default values for TextField components.

#### Constants [​](https://compose-miuix-ui.github.io/miuix/components/textfield#constants)

| Constant Name | Type | Description | Default Value |
| --- | --- | --- | --- |
| CornerRadius | Dp | Corner radius of the field | 16.dp |
| InsideMargin | DpSize | Internal padding of the field | DpSize(16.dp, 16.dp) |

#### `textFieldColors()` factory [​](https://compose-miuix-ui.github.io/miuix/components/textfield#textfieldcolors-factory)

Builds a \[TextFieldColors\] instance. Override any subset; unspecified params fall back to the Miuix theme defaults.

| Parameter | Type | Default |
| --- | --- | --- |
| backgroundColor | Color | MiuixTheme.colorScheme.secondaryContainer |
| labelColor | Color | MiuixTheme.colorScheme.onSecondaryContainer |
| borderColor | Color | MiuixTheme.colorScheme.primary |

## Advanced Usage [​](https://compose-miuix-ui.github.io/miuix/components/textfield#advanced-usage)

### TextField with Icons [​](https://compose-miuix-ui.github.io/miuix/components/textfield#textfield-with-icons)

kotlin

```
var text by remember { mutableStateOf("") }

TextField(
    value = text,
    onValueChange = { text = it },
    label = "Search",
    leadingIcon = {
        Icon(
            imageVector = MiuixIcons.Search,
            contentDescription = "Search Icon",
            modifier = Modifier.padding(horizontal = 12.dp)
        )
    }
)
```

### Password Input Field [​](https://compose-miuix-ui.github.io/miuix/components/textfield#password-input-field)

kotlin

```
var password by remember { mutableStateOf("") }
var passwordVisible by remember { mutableStateOf(false) }

TextField(
    value = password,
    onValueChange = { password = it },
    label = "Password",
    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
    trailingIcon = {
        IconButton(
            onClick = { passwordVisible = !passwordVisible },
            modifier = Modifier.padding(end = 12.dp)
        ) {
            Icon(
                imageVector = MiuixIcons.Rename,
                tint = if (passwordVisible) MiuixTheme.colorScheme.primary else MiuixTheme.colorScheme.onSecondaryContainer,
                contentDescription = if (passwordVisible) "Hide Password" else "Show Password"
            )
        }
    }
)
```

### Input Field with Validation [​](https://compose-miuix-ui.github.io/miuix/components/textfield#input-field-with-validation)

kotlin

```
var email by remember { mutableStateOf("") }
var isError by remember { mutableStateOf(false) }
val errorColor = Color.Red.copy(0.3f)
val emailPattern = remember { Regex("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+") }

Column {
    TextField(
        value = email,
        onValueChange = {
            email = it
            isError = email.isNotEmpty() && !emailPattern.matches(email)
        },
        label = "Email",
        colors = TextFieldDefaults.textFieldColors(
            labelColor = if (isError) errorColor else MiuixTheme.colorScheme.onSecondaryContainer,
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
    )
    if (isError) {
        Text(
            text = "Please enter a valid email address",
            color = errorColor,
            style = MiuixTheme.textStyles.body2,
            modifier = Modifier.padding(start = 16.dp, top = 4.dp)
        )
    }
}
```

### Custom Styles [​](https://compose-miuix-ui.github.io/miuix/components/textfield#custom-styles)

kotlin

```
var text by remember { mutableStateOf("") }

TextField(
    value = text,
    onValueChange = { text = it },
    label = "Custom Input Field",
    cornerRadius = 8.dp,
    colors = TextFieldDefaults.textFieldColors(
        backgroundColor = MiuixTheme.colorScheme.primary.copy(alpha = 0.1f),
    ),
    textStyle = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        color = MiuixTheme.colorScheme.primary
    )
)
```

### Using TextFieldValue [​](https://compose-miuix-ui.github.io/miuix/components/textfield#using-textfieldvalue)

When you need more fine-grained control over text selection and cursor position:

kotlin

```
var textFieldValue by remember { mutableStateOf(TextFieldValue("")) }

TextField(
    value = textFieldValue,
    onValueChange = { textFieldValue = it },
    label = "Advanced Input Control",
    // TextFieldValue provides control over text, selection range, and cursor position
)
```

## Changelog[](https://compose-miuix-ui.github.io/miuix/components/textfield#changelog)

Last edited 28 days ago

View full history

---
Source: [TextField | Miuix](https://compose-miuix-ui.github.io/miuix/components/textfield)