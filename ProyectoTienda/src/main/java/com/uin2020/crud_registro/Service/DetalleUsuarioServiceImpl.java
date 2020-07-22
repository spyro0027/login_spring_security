package com.uin2020.crud_registro.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uin2020.crud_registro.Interfaces.IUsuarioLogin;
import com.uin2020.crud_registro.Modelo.Cargos;

@Service
@Transactional
public class DetalleUsuarioServiceImpl implements UserDetailsService {

	@Autowired
	IUsuarioLogin usuarioLogin;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		com.uin2020.crud_registro.Modelo.Usuario user = 
					usuarioLogin.findByUsername(username).orElseThrow (() -> new UsernameNotFoundException("Usuario inexistente"));
				
		List grantList = new ArrayList<>();
		for(Cargos cargo: user.getFkCargo()) {
			GrantedAuthority grantedAuthority= new SimpleGrantedAuthority(cargo.getCargo());
			grantList.add(grantedAuthority);
		}
		
		UserDetails us= (UserDetails) new User(username,user.getPassword(), grantList);
		
		return us;
	}

}
