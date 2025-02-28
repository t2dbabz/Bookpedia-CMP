package com.plcoding.bookpedia.book.presentation.book_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.plcoding.bookpedia.book.presentation.book_list.components.BookSearchBar
import com.plcoding.bookpedia.core.presentation.DarkBlue
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun BookListScreenRoot(
    viewModel: BookListViewModel = koinViewModel(),
    onBookClick: () -> Unit,
    modifier: Modifier = Modifier
){

    val state by viewModel.state.collectAsState()

    BookListScreen(state, onAction = { action ->
        when(action) {
            is BookListAction.OnBookClick -> BookListAction.OnBookClick(action.book)
            else ->Unit
        }
        viewModel.onAction(action)
    })
}

@Composable
private fun BookListScreen(state: BookListState, onAction: (BookListAction) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBlue)
            .statusBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BookSearchBar(
            searchQuery = state.searchQuery,
            onImeSearch = { onAction(BookListAction.OnSearchQueryChange(state.searchQuery)) },
            onSearchQuery = {onAction(BookListAction.OnSearchQueryChange(it))}
        )
    }
}