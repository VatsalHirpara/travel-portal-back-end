package com.nagarro.training.travelportal.model;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDetails implements UserDetails {

	@Override
	public String toString() {
		return "MyUserDetails [userName=" + userName + ", password=" + password  + "]";
	}

	private static final long serialVersionUID = -1410602661036610351L;
	private int id;

	private String userName;
    private String password;
//    private List<GrantedAuthority> authorities;

    public MyUserDetails(User user) {
        this.userName = user.getEmail();
        this.password = user.getPassword();
        this.id = user.getId();
//        this.authorities = Arrays.stream(user.getRoles().split(","))
//                    .map(SimpleGrantedAuthority::new)
//                    .collect(Collectors.toList());
    }

    public int getId() {
    	return id;
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return authorities;
    	return new ArrayList<>();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
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