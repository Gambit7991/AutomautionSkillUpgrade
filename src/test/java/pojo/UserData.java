package pojo;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor @NoArgsConstructor
public class UserData {
    private String email ;
    private String password;
    private String name;

    public String toString(){
        return "LoginPojo properties : \n Login : %s,\n Password : %s,\n ";
    }

}
