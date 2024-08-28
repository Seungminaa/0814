package com.mysite.securityExam;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class Customerservice implements UserDetailsService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

    public Customer create(Customer customer) {
    	customer.setCdate(LocalDateTime.now());
    	customer.setRole("ROLE_USER");
    	customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        // 스프링 시큐리티의 BCryptPasswordEncoder 클래스를 사용하여 암호화하여 비밀번호를 저장
        // BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        // user.setPassword(passwordEncoder.encode(password));
        this.customerRepository.save(customer);
        return customer;
    }
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

	        Optional<Customer> _siteUser = this.customerRepository.findByusername(username);
	        if (_siteUser.isEmpty()) {
	            throw new UsernameNotFoundException("사용자를 찾을수 없습니다.");
	        }
	        Customer customer = _siteUser.get();
	        List<GrantedAuthority> authorities = new ArrayList<>();
	        if ("admin".equals(username)) {
	            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
	        } else {
	            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
	        }
	        return new User(customer.getUsername(), customer.getPassword(), authorities);
	}

}
