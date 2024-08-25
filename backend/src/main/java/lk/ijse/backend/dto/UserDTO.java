package lk.ijse.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private String uid;
    private String email;
    private String givenName;
    private String middleName;
    private String name;
    private String familyName;
    private String nickname;
    private String phoneNumber;
    private String comment;
    private String picture;
    private String directory;
    private Map<String, Object> metadata;
    private List<String> tags;
    private boolean isSuspended;
    private boolean isBot;
}