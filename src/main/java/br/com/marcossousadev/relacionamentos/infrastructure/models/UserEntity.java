package br.com.marcossousadev.relacionamentos.infrastructure.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Integer idade;

    @CreationTimestamp
    @Column(name = "data_criacao", nullable = false, updatable = false)
    private LocalDateTime dataCriacao;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL) // unique, apenas um usuário pode usar essa carteira
    @JoinColumn(name = "wallet_id", referencedColumnName = "id", unique = true)
    private WalletEntity wallet;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_documents_id", referencedColumnName = "id", unique = true)
    private UsersDocumentsEntity userDocuments;
}
