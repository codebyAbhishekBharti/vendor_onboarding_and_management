package org.example.vendormanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private ObjectId id;
    private String name;
    private String email;
    private String password;
    private String vendorId; //links the user to a vendor
    private String roleId; //references a role


    public User(String name, String email, String password, String vendorId, String roleId) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.vendorId = vendorId;
        this.roleId = roleId;
    }
}
