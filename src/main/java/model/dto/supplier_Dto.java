package model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class supplier_Dto {
    private String supplierId;
    private String supplierName;
    private String email;
    private String phone;
    private String address;
    private String company;
    private String date;
}
