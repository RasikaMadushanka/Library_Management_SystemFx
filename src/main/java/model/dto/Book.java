package model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Book {
    private  String book_Id;
    private String title;
    private String author;
    private String category;
    private String isbn;
    private String publisher;
    private String publish_year;
    private String description;
    private String language;
    private int copies;
    private String status;



}
