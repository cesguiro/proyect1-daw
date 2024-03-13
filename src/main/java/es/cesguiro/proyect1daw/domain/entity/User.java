package es.cesguiro.proyect1daw.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
 @NoArgsConstructor
public class User {

    public static final int USER_ID = 1;

    private static User user;
    private Integer id;
    private String userName;
    private String email;
    private boolean admin;
    private String deliveryAddress;

    public User(int userId) {
        this.id = userId;
    }

    /*public static User getUser() {
        if(user == null) {
            user = UserIoc.getUserRepository().getUser(USER_ID).orElseThrow(() -> new RuntimeException("User not found"));
        }
        return user;
    }*/


}
