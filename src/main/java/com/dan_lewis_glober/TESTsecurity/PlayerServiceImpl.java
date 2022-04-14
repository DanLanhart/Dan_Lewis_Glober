package com.dan_lewis_glober.TESTsecurity;

import com.dan_lewis_glober.TESTsecurity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    private PasswordEncoder passwordEncoder;

    @Override
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @Override
    public void savePlayer(Player player) {
        this.playerRepository.save(player);
    }

    @Override
    public Player getPlayerById(long id) {
        Optional<Player> optional = playerRepository.findById(id);
        Player player = null;
        if(optional.isPresent())    {
            player = optional.get();
        } else {
            throw new RuntimeException("Player not found for id: " + id);
        }
        return player;
    }

    @Override
    public void deletePlayerById(long id) {
        this.playerRepository.deleteById(id);
    }

    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
        this.passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    public Player findByEmail(String email) {
        return playerRepository.findByEmail(email);
    }

    public Player save(PlayerRegistrationDto registration) {
        Player player = new Player();
        player.setFirstName(registration.getFirstName());
        player.setUsername(registration.getUsername());
        player.setEmail(registration.getEmail());
        player.setPassword(passwordEncoder.encode(registration.getPassword()));
        player.setRoles(Arrays.asList(new Role("ROLE_USER")));
        return playerRepository.save(player);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Player player = playerRepository.findByEmail(email);
        if (player == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(player.getEmail(),
                player.getPassword(),
                mapRolesToAuthorities(player.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }
}
