package io.khasang.enterprise.model;

import javax.persistence.*;
import java.util.HashSet;

@Entity
@Table(name = "client_role")
public class ClientRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @Column(name = "role", nullable = false, length = 45)
    private String role;

    public ClientRole() {
    }

    public Integer getClientRoleId() {
        return id;
    }

    public void setClientRoleId(Integer clientRoleId) {
        this.id = clientRoleId;
    }

    public Client getClient() {
        return this.client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}