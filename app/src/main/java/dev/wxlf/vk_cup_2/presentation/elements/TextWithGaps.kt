package dev.wxlf.vk_cup_2.presentation.elements

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.flowlayout.FlowCrossAxisAlignment
import com.google.accompanist.flowlayout.FlowRow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextWithGaps(
    modifier: Modifier = Modifier,
    phrase: List<String>,
    words: List<String>,
    firstInput: Boolean,
    textSize: TextUnit = 16.sp
) {
    val focusManager = LocalFocusManager.current

    FlowRow(
        modifier = modifier,
        crossAxisAlignment = FlowCrossAxisAlignment.Center,
        mainAxisSpacing = 8.dp,
        crossAxisSpacing = 2.dp
    ) {
        if (firstInput) {
            val word = remember { mutableStateOf("") }
            val interactionSource = remember { MutableInteractionSource() }
            BasicTextField(
                value = word.value,
                onValueChange = { word.value = it },
                modifier = Modifier.width(textSize.value.dp * 4),
                visualTransformation = VisualTransformation.None,
                interactionSource = interactionSource,
                enabled = true,
                singleLine = true,
                textStyle = TextStyle(
                    color = MaterialTheme.colorScheme.onBackground,
                    fontSize = textSize,
                    textAlign = TextAlign.Center
                ),
                cursorBrush = SolidColor(MaterialTheme.colorScheme.primary),
                keyboardActions = KeyboardActions(onAny = {
                    focusManager.clearFocus()
                })
            ) { innerTextField ->
                TextFieldDefaults.TextFieldDecorationBox(
                    value = word.value,
                    visualTransformation = VisualTransformation.None,
                    innerTextField = innerTextField,
                    singleLine = true,
                    enabled = true,
                    interactionSource = interactionSource,
                    contentPadding = PaddingValues(2.dp),
                    isError = word.value != words[0]
                )
            }
        }
        phrase.forEachIndexed { index, s ->
            s.split(" ").forEach {
                Text(it, fontSize = textSize)
            }
            if (firstInput) {
                if (index + 1 in 0..words.lastIndex) {
                    val word = remember { mutableStateOf("") }
                    val interactionSource = remember { MutableInteractionSource() }
                    BasicTextField(
                        value = word.value,
                        onValueChange = { word.value = it },
                        modifier = Modifier.width(textSize.value.dp * 4),
                        visualTransformation = VisualTransformation.None,
                        interactionSource = interactionSource,
                        enabled = true,
                        singleLine = true,
                        textStyle = TextStyle(
                            color = MaterialTheme.colorScheme.onBackground,
                            fontSize = textSize,
                            textAlign = TextAlign.Center
                        ),
                        cursorBrush = SolidColor(MaterialTheme.colorScheme.primary),
                        keyboardActions = KeyboardActions(onAny = {
                            focusManager.clearFocus()
                        })
                    ) { innerTextField ->
                        TextFieldDefaults.TextFieldDecorationBox(
                            value = word.value,
                            visualTransformation = VisualTransformation.None,
                            innerTextField = innerTextField,
                            singleLine = true,
                            enabled = true,
                            interactionSource = interactionSource,
                            contentPadding = PaddingValues(2.dp),
                            isError = word.value != words[index + 1]
                        )
                    }
                }
            } else
                if (index in 0..words.lastIndex) {
                    val word = remember { mutableStateOf("") }
                    val interactionSource = remember { MutableInteractionSource() }
                    BasicTextField(
                        value = word.value,
                        onValueChange = { word.value = it },
                        modifier = Modifier.width(textSize.value.dp * 4),
                        visualTransformation = VisualTransformation.None,
                        interactionSource = interactionSource,
                        enabled = true,
                        singleLine = true,
                        textStyle = TextStyle(
                            color = MaterialTheme.colorScheme.onBackground,
                            fontSize = textSize,
                            textAlign = TextAlign.Center
                        ),
                        cursorBrush = SolidColor(MaterialTheme.colorScheme.primary),
                        keyboardActions = KeyboardActions(onAny = {
                            focusManager.clearFocus()
                        })
                    ) { innerTextField ->
                        TextFieldDefaults.TextFieldDecorationBox(
                            value = word.value,
                            visualTransformation = VisualTransformation.None,
                            innerTextField = innerTextField,
                            singleLine = true,
                            enabled = true,
                            interactionSource = interactionSource,
                            contentPadding = PaddingValues(2.dp),
                            isError = word.value != words[index]
                        )
                    }
                }
        }
    }
//    if (firstInput) {
//    val text = remember { mutableStateOf("TEST") }
//    TextField(
//        modifier = modifier.width(150.dp),
//        value = text.value,
//        onValueChange = {
//            text.value = it
//        },
//        singleLine = true,
//        colors = TextFieldDefaults.textFieldColors(containerColor = Color.Transparent),
//        keyboardActions = KeyboardActions(onAny = {
//            focusManager.clearFocus()
//        })
////        textStyle = LocalTextStyle.current.copy(fontSize = 12.sp),
//    )
}