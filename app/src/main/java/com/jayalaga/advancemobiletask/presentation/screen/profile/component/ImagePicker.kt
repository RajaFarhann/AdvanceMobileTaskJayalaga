package com.jayalaga.advancemobiletask.presentation.screen.profile.component

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.jayalaga.advancemobiletask.R

@Composable
fun ImagePickerGallery(){
    Box (){

        val imageUri = rememberSaveable {
            mutableStateOf("")
        }
        val painter = rememberAsyncImagePainter(
            imageUri.value.ifEmpty { R.drawable.person }
        )
        val launcher = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.GetContent()
        ) {uri: Uri? ->
            uri?.let { imageUri.value = it.toString() }
        }

        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
        ){
            Image(
                painter = painter,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(180.dp)
                    .background(Color.Gray)
                    .border(
                        width = 1.dp,
                        color = Color.White,
                        shape = CircleShape
                    )
            )
        }
        Box (
            modifier = Modifier.padding(top = 130.dp, start = 210.dp)
        ){
            Image(
                painter = painterResource(id = R.drawable.camera),
                contentDescription = "camera",
                modifier = Modifier
                    .clip(CircleShape)
                    .size(40.dp)
                    .padding(10.dp)
                    .clickable { launcher.launch("image/*") }
            )
        }
    }
}