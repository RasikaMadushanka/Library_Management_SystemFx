package model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class bookRent_Dto {
    private String rentId;
    private String customerId;
    private String bookId;
    private String rentDate;
    private String dueDate;
    private String returnDate;
    private double bookPrice;
    private double fine;
    private String status;
}
