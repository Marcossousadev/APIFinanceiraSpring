package br.com.marcossousadev.relacionamentos.business;

import br.com.marcossousadev.relacionamentos.dtos.user.CreateUserDto;
import br.com.marcossousadev.relacionamentos.dtos.user.UserResponseDto;
import br.com.marcossousadev.relacionamentos.exceptions.BadRequestException;
import br.com.marcossousadev.relacionamentos.exceptions.NotFoundException;
import br.com.marcossousadev.relacionamentos.infrastructure.models.UserEntity;
import br.com.marcossousadev.relacionamentos.infrastructure.models.UsersDocumentsEntity;
import br.com.marcossousadev.relacionamentos.infrastructure.models.WalletEntity;
import br.com.marcossousadev.relacionamentos.infrastructure.repository.IUserRepository;
import br.com.marcossousadev.relacionamentos.infrastructure.repository.IUsersDocumentsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class UserService {
    private final IUserRepository userRepository;
    private final IUsersDocumentsRepository usersDocumentsRepository;
    public UserService(IUserRepository userRepository, IUsersDocumentsRepository usersDocumentsRepository) {
        this.userRepository = userRepository;
        this.usersDocumentsRepository = usersDocumentsRepository;
    }
    @Transactional
    public void createUser(CreateUserDto createUserDto){
        UserEntity user = userRepository.findByEmail(createUserDto.email()).orElse(null);
            if(createUserDto.cpf() != null) {
                boolean existsCpf = usersDocumentsRepository.findByCpf(createUserDto.cpf()).isPresent();
                if(existsCpf) {
                    throw new BadRequestException("Não foi possível concluir o cadastro com esse cpf");
                }
            }
            if(createUserDto.cnpj() != null) {
                boolean existsCnpj = usersDocumentsRepository.findByCnpj(createUserDto.cnpj()).isPresent();
                if(existsCnpj) {
                    throw new BadRequestException("Não foi possível concluir o cadastro com esse cnpj");
                }
            }
            if(user != null) {
                throw new BadRequestException("esse email já está em uso!");
            }

        WalletEntity walletUser = WalletEntity.builder().saldo(BigDecimal.valueOf(0)).build();
        UsersDocumentsEntity documentsUser = UsersDocumentsEntity.builder()
                .cnpj(createUserDto.cnpj() != null ? createUserDto.cnpj() : null)
                .cpf(createUserDto.cpf() != null ? createUserDto.cpf() : null)
                .build();

        UserEntity newUser = UserEntity.builder()
                .nome(createUserDto.nome())
                .email(createUserDto.email())
                .idade(createUserDto.idade())
                .build();

        newUser.setUserDocuments(documentsUser);
        newUser.setWallet(walletUser);
        userRepository.save(newUser);
    }

    public UserResponseDto getUserById(Long id) {
        UserEntity user = userRepository.findById(id).orElse(null);

        if (user == null) {
            throw new NotFoundException("Usuário não encontrado!");
        }

        UserResponseDto userResponse = UserResponseDto.builder()
                .nome(user.getNome())
                .email(user.getEmail())
                .idade(user.getIdade())
                .build();

        return userResponse;
    }
}
