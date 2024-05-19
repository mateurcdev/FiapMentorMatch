package com.example.fiapmentormatch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.fiapmentormatch.ui.theme.FiapMentorMatchTheme
import com.example.fiapmentormatch.view.AdvancedSearchView
import com.example.fiapmentormatch.view.LoginView
import com.example.fiapmentormatch.view.MainMenuView
import com.example.fiapmentormatch.view.MatchmakingView
import com.example.fiapmentormatch.view.TelaCadastroView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FiapMentorMatchTheme {
                var currentScreen by remember { mutableStateOf("login") }

                Surface {
                    when (currentScreen) {
                        "login" -> LoginView(
                            onLoginSuccess = { currentScreen = "menu" },
                            onNavigateToRegister = { currentScreen = "register" }
                        )
                        "register" -> TelaCadastroView(
                            onNavigateBack = { currentScreen = "login" },
                            onNavigateToMenu = { currentScreen = "menu" }
                        )
                        "menu" -> MainMenuView(
                            onMatchmaking = { currentScreen = "matchmaking" },
                            onAdvancedSearch = { currentScreen = "advanced_search" },
                            onLogout = { currentScreen = "login" }
                        )
                        "matchmaking" -> MatchmakingView(
                            onNavigateBack = { currentScreen = "menu" }
                        )
                        "advanced_search" -> AdvancedSearchView(
                            onNavigateBack = { currentScreen = "menu" }
                        )
                    }
                }
            }
        }
    }
}
