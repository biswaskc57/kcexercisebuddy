/* package ExerciseBuddy.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ExerciseBuddy.Repo.UserRepository;
import ExerciseBuddy.Domain.User;


/**
	 * This class is used by spring security to authenticate and authorize user
	 **/
	/*@Service
	public class UserDetailServiceImpl implements UserDetailsService  {
		private final UserRepository repository;

		@Autowired
		public UserDetailServiceImpl(UserRepository userRepository) {
			this.repository = userRepository;
		}

	    @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	    {   
	    	User currUser = repository.findByUsername(username);
	        UserDetails user = new org.springframework.security.core.userdetails.User(username, currUser.getPasswordHash(), 
	        		AuthorityUtils.createAuthorityList(currUser.getRole()));
	        return user;
	    }   
	}*/
