package com.plcoding.bookpedia

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.plcoding.bookpedia.book.domain.Book
import com.plcoding.bookpedia.book.presentation.book_list.BookListScreen
import com.plcoding.bookpedia.book.presentation.book_list.BookListState
import com.plcoding.bookpedia.book.presentation.book_list.components.BookSearchBar

@Preview
@Composable
private fun BookSearchBarPreview() {
    MaterialTheme {

        BookSearchBar("Kotlin", {}, {}, Modifier.fillMaxWidth())
    }
}
val books = (1..10).map {
    Book(
        id = it.toString(),
        title = "Book $it",
        imageUrl = "https://test.com",
        authors = listOf("Babatunde Owoleke"),
        description = "Description $it",
        languages = emptyList(),
        firstPublishYear = "2025",
        averageRating = 4.6754,
        ratingCount = 5,
        numPages = 100,
        numEditions = 4


    )
}
@Preview
@Composable
private fun BookListScreenPreview() {
    BookListScreen(state = BookListState(searchResults = books)) {

    }
}