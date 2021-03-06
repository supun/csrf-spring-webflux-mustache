package daggerok.security.userdetails;

import daggerok.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ReactiveRepositoryUserDetailsService implements ReactiveUserDetailsService {

  final UserRepository users;

  @Override public Mono<UserDetails> findByUsername(final String username) {

    return users.findByUsername(username)
                .map(CustomUserDetails::new);
  }
}
