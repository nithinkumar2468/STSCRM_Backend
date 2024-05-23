/*
 * package com.infinite.crm.service;
 * 
 * import java.util.Collection; import java.util.HashSet; import java.util.Set;
 * import java.util.stream.Collectors;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.security.core.GrantedAuthority; import
 * org.springframework.security.core.authority.SimpleGrantedAuthority; import
 * org.springframework.security.core.userdetails.User; import
 * org.springframework.security.core.userdetails.UserDetails; import
 * org.springframework.security.core.userdetails.UserDetailsService; import
 * org.springframework.security.core.userdetails.UsernameNotFoundException;
 * import org.springframework.stereotype.Service;
 * 
 * import com.infinite.crm.model.Admin; import
 * com.infinite.crm.repository.AdminRepository;
 * 
 * @Service public class CustomUserDetailsService implements UserDetailsService{
 * 
 * @Autowired private AdminRepository repo;
 * 
 * @Override public UserDetails loadUserByUsername(String email) throws
 * UsernameNotFoundException { // TODO Auto-generated method stub Admin
 * user=repo.findByEmail(email);
 * 
 * Set<String> roles=new HashSet<String>(); roles.add("ROLE_ADMIN"); return new
 * User(user.getEmail(),user.getPassword(),userAuthorities(roles)); }
 * 
 * private Collection<? extends GrantedAuthority> userAuthorities(Set<String>
 * roles){ return roles.stream().map( role->new SimpleGrantedAuthority(role)
 * ).collect(Collectors.toList()); } }
 */