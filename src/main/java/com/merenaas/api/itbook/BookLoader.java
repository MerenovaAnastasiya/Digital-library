package com.merenaas.api.itbook;

import com.merenaas.models.Book;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.*;

@Data
public class BookLoader {
    private static final String newBooksURL = "https://api.itbook.store/1.0/new";
    private static final String oneBookSearchURL = "https://api.itbook.store/1.0/search/";
    private static List<Book> books = new ArrayList<>();

    public static List<Book> getAllBooks() {
        HttpGet request = new HttpGet(newBooksURL);
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            HttpResponse response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();
            Header[] contentTypeHeaders = response.getHeaders("Content-Type");
            if (contentTypeHeaders.length != 1) {
                throw new IllegalArgumentException();
            } else {
                if (contentTypeHeaders[0].getValue().equals("application/json")) {
                    String jsonString = EntityUtils.toString(entity);
                    try {
                        JSONObject jsonObject = (JSONObject) new JSONParser().parse(jsonString);
                        JSONArray booksArr = (JSONArray) jsonObject.get("books");
                        Iterator booksItr = booksArr.iterator();
                        while (booksItr.hasNext()) {
                            JSONObject bookJson = (JSONObject) booksItr.next();
                            Book book = createBookFromJson(bookJson);
                            books.add(book);
                        }
                        return books;
                    } catch (ParseException e) {

                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Book getBookByIsbn13(String isbn13){
        HttpGet request = new HttpGet(oneBookSearchURL+isbn13);
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            HttpResponse response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();
            Header[] contentTypeHeaders = response.getHeaders("Content-Type");
            if (contentTypeHeaders.length != 1) {
                throw new IllegalArgumentException();
            }
            else {
                if (contentTypeHeaders[0].getValue().equals("application/json")) {
                    String jsonString = EntityUtils.toString(entity);
                    try {
                        JSONObject jsonObject = (JSONObject) new JSONParser().parse(jsonString);
                        JSONArray booksArr = (JSONArray) jsonObject.get("books");
                        Book book = createBookFromJson((JSONObject) booksArr.get(0));
                        return book;
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Book createBookFromJson(JSONObject bookJson) {
        Book book = new Book();
        String bookName = (String) bookJson.get("title");
        String isbn13 = (String) bookJson.get("isbn13");
        String path = (String) bookJson.get("image");
        String description = (String) bookJson.get("subtitle");
        book.setBookName(bookName);
        book.setIsbn13(isbn13);
        book.setPath(path);
        book.setDescription(description);
        return book;
    }

}
