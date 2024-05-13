package es.sotero.magic.entities;

import es.sotero.magic.utils.Role;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Entity
@RequiredArgsConstructor(access = AccessLevel.PUBLIC, staticName = "of")
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Table(name = "users", uniqueConstraints = {
		@UniqueConstraint(columnNames = "username"),
		@UniqueConstraint(columnNames = "email")
})
public class User implements UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@NonNull
	String username;

	@NonNull
	String password;

	@NonNull
	String email;

	@NonNull
	String firstName;

	@NonNull
	String lastName;

	@NonNull
	Role role;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority(role.name()));
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
