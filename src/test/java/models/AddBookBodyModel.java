package models;

import lombok.Data;
import java.util.ArrayList;

@Data
public class AddBookBodyModel {
    public String userId;
    private ArrayList<IsbnModel> collectionOfIsbns;

    public void setIsbn(String value) {
        IsbnModel isbn = new IsbnModel();
        isbn.setIsbn(value);
        ArrayList<IsbnModel> isbnData = new ArrayList<>();
        isbnData.add(isbn);
        this.collectionOfIsbns = isbnData;
    }
}
