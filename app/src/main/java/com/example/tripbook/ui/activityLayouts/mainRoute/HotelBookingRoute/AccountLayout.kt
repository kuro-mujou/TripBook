package com.example.tripbook.ui.activityLayouts.mainRoute.HotelBookingRoute

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tripbook.database.model.Account
import com.example.tripbook.navigationControl.Layouts
import java.text.SimpleDateFormat
import java.util.Locale


@Composable
fun AccountLayout(
    data: Account,
    navController: NavController,
    onNameChanged: (String) -> Unit,
    onDayOfBirthChanged: (String) -> Unit,
    onPhoneChanged: (String) -> Unit,
    onStreetChanged: (String) -> Unit,
    onCityChanged: (String) -> Unit,
    onEmailChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onUpdateClicked: () -> Unit
) {
    var isEditing by remember { mutableStateOf(false) }
    var userDayOfBirth by remember { mutableStateOf("") }
    var showDatePicker by remember { mutableStateOf(false) }
    val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = {
                    navController.navigate(Layouts.SettingLayoutRoute.route)
                }
            ) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "")
            }
            Text(
                text = "Account",
                modifier = Modifier
                    .padding(start = 20.dp),
                style = TextStyle(
                    textDecoration = TextDecoration.Underline,
                    color = Color.Gray,
                    fontSize = 20.sp
                )
            )
        }
        HorizontalDivider()
        Text(
            modifier = Modifier.padding(top = 5.dp, bottom = 5.dp),
            text = "Basic Information"
        )
        HorizontalDivider()
        CustomItem(
            description = "Full Name",
            value = data.user?.user_name.toString(),
            onValueChange = onNameChanged
        )
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                modifier = Modifier
                    .padding(start = 10.dp)
                    .width(100.dp),
                text = "Day of birth"
            )
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = data.user?.user_DayOfBirth.toString(),
                onValueChange = { userDayOfBirth = onDayOfBirthChanged.toString() },
                textStyle = TextStyle(
                    fontSize = 16.sp,
                    color = Color.Black
                ),
                trailingIcon = {
                    IconButton(
                        modifier = Modifier
                            .weight(1f),
                        onClick = {
                            showDatePicker = true
                        }
                    ){
                        Icon(
                            imageVector = Icons.Default.CalendarToday,
                            contentDescription = "Location"
                        )
                    }
                },
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent
                ),
                singleLine = true,
                readOnly = true
            )

            if (showDatePicker) {
                ShowDatePickerDialog { newDate ->
                    userDayOfBirth = dateFormat.format(newDate).toString()
                    showDatePicker = false
                }
            }
        }
        CustomItem(
            description = "Phone",
            value = data.user?.user_Phone.toString(),
            onValueChange = onPhoneChanged
        )
        HorizontalDivider()
        Text(
            modifier = Modifier.padding(top = 5.dp, bottom = 5.dp),
            text = "Address"
        )
        HorizontalDivider()
        CustomItem(
            description = "Street",
            value = data.user?.user_Address?.street.toString(),
            onValueChange = onStreetChanged
        )
        CustomItem(
            description = "City",
            value = data.user?.user_Address?.city.toString(),
            onValueChange = onCityChanged
        )
        HorizontalDivider()
        Text(
            modifier = Modifier.padding(top = 5.dp, bottom = 5.dp),
            text = "Account"
        )
        HorizontalDivider()
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                modifier = Modifier
                    .padding(start = 10.dp)
                    .width(100.dp),
                text = "Email"
            )
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = data.email,
                onValueChange = onEmailChanged,
                readOnly = true,
                textStyle = TextStyle(
                    fontSize = 16.sp,
                    color = Color.Black
                ),
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent
                ),
                singleLine = true
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                modifier = Modifier
                    .padding(start = 10.dp)
                    .width(100.dp),
                text = "Password"
            )
            var passwordVisible by rememberSaveable { mutableStateOf(false) }
            TextField(
                modifier = Modifier.weight(1f),
                value = data.password,
                onValueChange = onPasswordChanged,

                textStyle = TextStyle(
                    fontSize = 16.sp,
                    color = Color.Black
                ),
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val image = if (passwordVisible)
                        Icons.Filled.Visibility
                    else Icons.Filled.VisibilityOff
                    val description = if (passwordVisible) "Hide password" else "Show password"

                    IconButton(onClick = {passwordVisible = !passwordVisible}){
                        Icon(imageVector  = image, description)
                    }
                },
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent
                ),
                singleLine = true
            )
            TextButton(
                onClick = { },
                modifier = Modifier.weight(0.5f)
            ) {
                Text(
                    text = "Change Password",
                    style = TextStyle(
                        textAlign = TextAlign.Center
                    )
                )
            }
        }
    }
}
@Composable
private fun CustomItem(
    description : String,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
){
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            modifier = modifier
                .padding(start = 10.dp)
                .width(100.dp),
            text = description
        )
        TextField(
            modifier = modifier.fillMaxWidth(),
            value = value,
            onValueChange = onValueChange,
            textStyle = TextStyle(
                fontSize = 16.sp,
                color = Color.Black
            ),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent
            ),
            singleLine = true
        )
    }
}