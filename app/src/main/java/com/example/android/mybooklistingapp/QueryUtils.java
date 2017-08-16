package com.example.android.mybooklistingapp;

/*
  Created by Mervi on 26.6.2017.
 */

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

class QueryUtils {

    private QueryUtils() {
    }

    public static List<BookListing> extractBookListings(String json) {
        List<BookListing> bookListings = new ArrayList<>();

        try {
            JSONObject jsonResponse = new JSONObject(json);
            if (jsonResponse.getInt("totalItems") == 0) {
                return bookListings;

            }
            JSONArray jsonArray = jsonResponse.getJSONArray("items");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject bookListObject = jsonArray.getJSONObject(i);
                JSONObject bookListInfo = bookListObject.getJSONObject("volumeInfo");
                String bookListTitle = bookListInfo.getString("title");
                String authors = "";

                if (bookListInfo.has("authors")) {
                    JSONArray authorsArray = bookListInfo.getJSONArray("authors");
                    for (int j = 0; j < authorsArray.length(); j++) {
                        authors += (authorsArray.getString(j));
                    }
                } else {
                    authors = "Unknown Author";
                }

                BookListing bookListing = new BookListing(bookListTitle, authors);
                bookListings.add(bookListing);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return bookListings;
    }

    private static String formatAuthorsList(JSONArray authorsList) throws JSONException {
        String aList = null;

        if (authorsList.length() == 0) {
            return null;
        }

        for (int i = 0; i < authorsList.length(); i++) {
            if (i == 0) {
                aList = authorsList.getString(0);
            } else {
                aList += ", " + authorsList.getString(i);
            }
        }

        return aList;
    }
}