package com.example.android.mybooklistingapp;

/*
  Created by Mervi on 26.6.2017.
 */


class BookListing {

    private final String mBookTitle;
    private final String mAuthor;

    public BookListing(String bookTitle, String author) {
        this.mBookTitle = bookTitle;
        this.mAuthor = author;
    }

    public String getBookTitle() {
        return mBookTitle;
    }

    public String getAuthor() {
        return mAuthor;
    }

}