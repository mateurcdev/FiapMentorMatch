package com.example.fiapmentormatch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import com.example.fiapmentormatch.ui.theme.FiapMentorMatchTheme
import com.example.fiapmentormatch.view.TelaCadastroView


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FiapMentorMatchTheme {
                Surface {
                    TelaCadastroView()
                }
            }
        }
    }
}