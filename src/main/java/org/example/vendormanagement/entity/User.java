package org.example.vendormanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Document(collection = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private ObjectId id;
    @NonNull
    private String name;
    @NonNull
    @Indexed(unique = true)
    private String email;
    @NonNull
    private String password;
    private String vendorId; //links the user to a vendor
    private String roleId; //references a role
    private Set<String> roles;

}
