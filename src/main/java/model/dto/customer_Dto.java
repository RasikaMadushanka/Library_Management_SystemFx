package model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class customer_Dto {
    private String customer_id;
   private String full_name;
   private String phone;
    private String email;
    private String address;
    private String DATE;

}
