package dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @NoArgsConstructor
public class CustomerDto {
    private int customerNumber;
    private String customerName;
    private String firstName;
    private String lastName;

    public CustomerDto(String customerName, String firstName, String lastName) {
        this.customerName = customerName;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
