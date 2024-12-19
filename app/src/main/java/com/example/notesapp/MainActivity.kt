package com.example.notesapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.ComponentDialog
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.lifecycle.ViewModelProvider
import com.example.notesapp.Roomdb.Note
import com.example.notesapp.Roomdb.NoteViewModel
import com.example.notesapp.Roomdb.NoteViewModelFactory
import com.example.notesapp.Roomdb.NotesDB
import com.example.notesapp.Roomdb.NotesRepository
import com.example.notesapp.Screens.DisplayNoteslist
import com.example.notesapp.Screens.Displaydialouge
import com.example.notesapp.ui.theme.NotesAppTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController


class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        //Room DB
        val database = NotesDB.getInstance(applicationContext)

        //Repository
        val repository = NotesRepository(database.notesDao)

        //ViewModelFactory
        val viewModelFactory = NoteViewModelFactory(repository)

        //ViewModel
        val noteviewmodel = ViewModelProvider(this, viewModelFactory)[NoteViewModel::class.java]




        setContent {

            val statusBarColor = Color.Blue // Green color

            rememberSystemUiController().setStatusBarColor(statusBarColor)


            NotesAppTheme {

                Scaffold(floatingActionButton = { floatingactionbutn(viewModel = noteviewmodel) }) {

                    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "Welcome to Notes App",
                            modifier = Modifier.padding(42.dp),
                            fontSize = 32.sp,
                            textAlign = TextAlign.Center,
                            color = Color.Magenta,
                            fontWeight = FontWeight.ExtraBold
                        )

                        val notes by noteviewmodel.allNotes.observeAsState(emptyList())

                        DisplayNoteslist(notes = notes, viewModel = noteviewmodel)
                    }

                }


            }
        }
    }


}

@Composable
fun floatingactionbutn(viewModel: NoteViewModel) {

    var showdialouge by remember {
        mutableStateOf(false)
    }

    Displaydialouge(viewModel = viewModel, showDialog = showdialouge) {
        showdialouge = false
    }

    FloatingActionButton(onClick = {
        showdialouge = true
    }, containerColor = Color.Magenta, contentColor = Color.Blue) {

        Icon(imageVector = Icons.Filled.Add, contentDescription = "")
    }
}
