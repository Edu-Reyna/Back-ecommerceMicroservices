package com.MGoldenPearl;

import com.MGoldenPearl.entities.*;
import com.MGoldenPearl.repositories.IPermissionRepository;
import com.MGoldenPearl.repositories.IRoleRepository;
import com.MGoldenPearl.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.Set;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceUserApplication.class, args);
	}

	@Bean
	public CommandLineRunner initDatabase(IPermissionRepository permissionRepository, IRoleRepository roleRepository, IUserRepository userRepository) {
		return args -> {

			PermissionEntity PermissionCreateProduct = PermissionEntity
					.builder()
					.permissionEnum(PermissionEnum.CREATE_PRODUCT)
					.build();
			PermissionEntity PermissionDeleteProduct = PermissionEntity
					.builder()
					.permissionEnum(PermissionEnum.DELETE_PRODUCT)
					.build();
			PermissionEntity PermissionUpdateProduct = PermissionEntity
					.builder()
					.permissionEnum(PermissionEnum.UPDATE_PRODUCT)
					.build();
			PermissionEntity PermissionCreateCategory = PermissionEntity
					.builder()
					.permissionEnum(PermissionEnum.CREATE_CATEGORY)
					.build();
			PermissionEntity PermissionDeleteCategory = PermissionEntity
					.builder()
					.permissionEnum(PermissionEnum.DELETE_CATEGORY)
					.build();
			PermissionEntity PermissionUpdateCategory = PermissionEntity
					.builder()
					.permissionEnum(PermissionEnum.UPDATE_CATEGORY)
					.build();
			PermissionEntity PermissionUpdateUser = PermissionEntity
					.builder()
					.permissionEnum(PermissionEnum.UPDATE_USER)
					.build();
			PermissionEntity PermissionDeleteUser = PermissionEntity
					.builder()
					.permissionEnum(PermissionEnum.DELETE_USER)
					.build();


			RoleEntity adminRole = RoleEntity
					.builder()
					.roleEnum(RoleEnum.ADMIN)
					.permission(
							Set.of(
									PermissionCreateProduct,
									PermissionDeleteProduct,
									PermissionUpdateProduct,
									PermissionCreateCategory,
									PermissionDeleteCategory,
									PermissionUpdateCategory,
									PermissionUpdateUser,
									PermissionDeleteUser
							)
					)
					.build();
			RoleEntity sellerRole = RoleEntity
					.builder()
					.roleEnum(RoleEnum.SELLER)
					.permission(
							Set.of(
									PermissionCreateProduct,
									PermissionDeleteProduct,
									PermissionUpdateProduct
							)
					)
					.build();
			RoleEntity customerRole = RoleEntity
					.builder()
					.roleEnum(RoleEnum.CLIENT)
					.permission(
							Set.of(
									PermissionUpdateUser,
									PermissionDeleteUser
							)
					)
					.build();

			UserEntity adminUser = UserEntity
					.builder()
					.name("admin")
					.password("admin123")
					.email("admin@gmail.com")
					.role(adminRole)
					.build();

			UserEntity sellerUser = UserEntity
					.builder()
					.name("seller")
					.password("seller123")
					.email("seller@gmail.com")
					.role(sellerRole)
					.build();

			UserEntity customerUser = UserEntity
					.builder()
					.name("customer")
					.password("customer123")
					.email("customer@gmail.com")
					.role(customerRole)
					.build();

			userRepository.saveAll(Set.of(adminUser, sellerUser, customerUser));
		};
	}

}
